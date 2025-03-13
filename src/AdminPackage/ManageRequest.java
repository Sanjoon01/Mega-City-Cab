package AdminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ClassPackage.DatabaseConnection;
import ClassPackage.Request;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ManageRequest {

    public static Request getRequestDetails(int requestId) {
        String query = "SELECT r.customer_id, u.name AS customer_name, c.registration_number AS vehicle_registration, d.name AS driver_name, "
                + "r.booking_date, r.booking_time, r.status "
                + "FROM request r "
                + "JOIN users u ON r.customer_id = u.user_id "
                + "JOIN car c ON r.car_id = c.car_id "
                + "JOIN driver d ON r.driver_id = d.driver_id "
                + "WHERE r.request_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, requestId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Request(
                        rs.getString("customer_name"),
                        rs.getString("vehicle_registration"), // Updated field
                        rs.getString("driver_name"),
                        rs.getDate("booking_date"),
                        rs.getTime("booking_time"),
                        rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void sendEmail(String toEmail, String subject, String messageContent) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("megacitycab@gmail.com", "dyel bazj tkdm yany");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("megacitycab@gmail.com"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(messageContent);

            Transport.send(mimeMessage);
            System.out.println("Cancellation email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

   public void sendRequestStatusEmail(int requestId, String status) {
    String query = "SELECT r.customer_id, u.email, u.name, c.registration_number, d.name AS driver_name, " +
                   "r.booking_date, r.booking_time " +
                   "FROM request r " +
                   "JOIN users u ON r.customer_id = u.user_id " +
                   "JOIN car c ON r.car_id = c.car_id " +
                   "JOIN driver d ON r.driver_id = d.driver_id " +
                   "WHERE r.request_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, requestId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String toEmail = rs.getString("email");
            String customerName = rs.getString("name");
            String registrationNumber = rs.getString("registration_number");
            String driverName = rs.getString("driver_name");
            java.sql.Date requestDate = rs.getDate("booking_date");
            java.sql.Time requestTime = rs.getTime("booking_time");

            String subject;
            String emailMessage;

            if ("Accept".equalsIgnoreCase(status)) {
                subject = "✅ Mega City Cab - Request Approved";
                emailMessage = "Dear " + customerName + ",\n\n"
                             + "Your cab request has been approved. Here are the details:\n\n"
                             + "🚗 Vehicle Registration: " + registrationNumber + "\n"
                             + "👨‍✈️ Driver: " + driverName + "\n"
                             + "📅 Request Date: " + requestDate + "\n"
                             + "⏰ Request Time: " + requestTime + "\n\n"
                             + "Your driver will be in touch with you shortly.\n"
                             + "Thank you for choosing Mega City Cab! 🚖\n\n"
                             + "📧 Email: megacitycab@gmail.com\n"
                             + "📞 +94 77 123 4567\n"
                             + "📍 123, Galle Road, Colombo - 05, Sri Lanka";

            } else if ("Reject".equalsIgnoreCase(status)) {
                subject = "❌ Mega City Cab - Request Rejected";
                emailMessage = "Dear " + customerName + ",\n\n"
                             + "Unfortunately, your cab request has been rejected.\n\n"
                             + "🚗 Vehicle Registration: " + registrationNumber + "\n"
                             + "👨‍✈️ Driver: " + driverName + "\n"
                             + "📅 Request Date: " + requestDate + "\n"
                             + "⏰ Request Time: " + requestTime + "\n\n"
                             + "We apologize for the inconvenience. Please try again or contact support.\n\n"
                             + "Thank you for understanding.\nMega City Cab Team 🚖\n\n"
                             + "📧 Email: megacitycab@gmail.com\n"
                             + "📞 +94 77 123 4567\n"
                             + "📍 123, Galle Road, Colombo - 05, Sri Lanka";

            } else {
                return; // No email for other statuses
            }

            sendEmail(toEmail, subject, emailMessage);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
