package AdminPackage;

import ClassPackage.Booking;
import ClassPackage.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ManageBooking {

    public Booking getBookingById(int bookingId) {
        String query = "SELECT * FROM Booking WHERE booking_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("car_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup"),
                        rs.getString("drop_off"),
                        rs.getDate("booking_date"),
                        rs.getTime("booking_time"),
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBookingStatus(int bookingId, String newStatus) {
        String query = "UPDATE booking SET status = ? WHERE booking_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, bookingId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Booking status updated successfully.");

                // If status is "Cancel", send cancellation email
                if ("Cancel".equalsIgnoreCase(newStatus)) {
                    sendCancellationEmail(bookingId);
                }
            } else {
                System.out.println("Failed to update booking status.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

 public void sendCancellationEmail(int bookingId) {
    String query = "SELECT u.email, u.name, b.pickup, b.drop_off, b.booking_date, b.booking_time, b.total_amount "
                 + "FROM users u "
                 + "JOIN customer c ON u.user_id = c.user_id "
                 + "JOIN booking b ON c.customer_id = b.customer_id "
                 + "WHERE b.booking_id = ?";

    try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, bookingId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String toEmail = rs.getString("email");  // Getting email from users table
            String customerName = rs.getString("name");
            String pickup = rs.getString("pickup");
            String drop = rs.getString("drop_off");
            java.sql.Date bookingDate = rs.getDate("booking_date");
            java.sql.Time bookingTime = rs.getTime("booking_time");
            double totalAmount = rs.getDouble("total_amount");

            // Prepare the cancellation email
            String subject = "🚖 Mega City Cab - Booking Cancellation";
            String emailMessage = "Hi " + customerName + ",\n\n"
                    + "We regret to inform you that your booking has been cancelled.\n\n"
                    + "📍 Pickup Location: " + pickup + "\n"
                    + "📍 Drop-off Location: " + drop + "\n"
                    + "📅 Booking Date: " + bookingDate + "\n"
                    + "⏰ Booking Time: " + bookingTime + "\n"
                    + "💰 Total Amount: " + totalAmount + " LKR\n\n"
                    + "We apologize for any inconvenience caused. Please feel free to book again with Mega City Cab. 🚖\n\n"
                    + "📧 Email: megacitycab@gmail.com\n"
                    + "📞 +94 77 123 4567\n"
                    + "📍 123, Galle Road, Colombo - 05, Sri Lanka";

            sendEmail(toEmail, subject, emailMessage);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
  

    public String getCustomerNameByBookingId(int bookingId) {
    String query = "SELECT u.name " +
                   "FROM users u " +
                   "JOIN customer c ON u.user_id = c.user_id " +
                   "JOIN booking b ON c.customer_id = b.customer_id " +
                   "WHERE b.booking_id = ?";
    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, bookingId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("name");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "Unknown";
}


}
