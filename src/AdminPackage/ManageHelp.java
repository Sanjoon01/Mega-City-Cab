package AdminPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ClassPackage.DatabaseConnection;
import ClassPackage.Help;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ManageHelp {

    public List<Help> getHelpRequestsWithCustomerName() {
        List<Help> helpList = new ArrayList<>();
        String query = "SELECT h.help_id, h.customer_id, h.booking_id, h.category, h.description, h.status, h.response, u.name " +
                       "FROM help h " +
                       "JOIN users u ON h.customer_id = u.user_id"; // Join to get customer name

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Help help = new Help(
                        rs.getInt("help_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("booking_id"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("response")
                );
                help.setCustomerName(rs.getString("name")); // Set customer name
                helpList.add(help);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return helpList;
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
            System.out.println("Help response email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendHelpResponseEmail(int helpId) {
        String query = "SELECT h.help_id, u.email, u.name, h.category, h.description, h.response " +
                       "FROM help h " +
                       "JOIN users u ON h.customer_id = u.user_id " +
                       "WHERE h.help_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, helpId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String toEmail = rs.getString("email"); // Get email directly from DB
                String customerName = rs.getString("name");
                String category = rs.getString("category");
                String description = rs.getString("description");
                String response = rs.getString("response");

                String subject = "🔔 Mega City Cab - Help Request Response";
                String emailMessage = "Dear " + customerName + ",\n\n"
                                    + "We have reviewed your help request regarding: " + category + ".\n\n"
                                    + "📜 Issue: " + description + "\n"
                                    + "💬 Response: " + response + "\n\n"
                                    + "If you need further assistance, feel free to contact us.\n\n"
                                    + "Best regards,\nMega City Cab Support Team 🚖\n\n"
                                    + "📧 Email: megacitycab@gmail.com\n"
                                    + "📞 +94 77 123 4567\n"
                                    + "📍 123, Galle Road, Colombo - 05, Sri Lanka";

                sendEmail(toEmail, subject, emailMessage);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
