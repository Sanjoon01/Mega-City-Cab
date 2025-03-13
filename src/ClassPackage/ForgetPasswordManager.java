
package ClassPackage;

import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ForgetPasswordManager {
    
    private static final String EMAIL_SENDER = "megacitycab@gmail.com";
    private static final String EMAIL_PASSWORD = "dyel bazj tkdm yany"; 
    private static final Map<String, String> pinStorage = new HashMap<>(); 

    // Generate a random 6-digit PIN
    private String generatePin() {
        Random random = new Random();
        int pin = 100000 + random.nextInt(900000);
        return String.valueOf(pin);
    }

    public boolean sendResetPin(String email) {
        String pin = generatePin();
        pinStorage.put(email, pin); 

        String subject = "Mega City Cab - Password Reset PIN";
        String message = "Dear User,\n\n" +
                         "We received a request to reset your password.\n" +
                         "Your One-Time PIN (OTP) is: " + pin + "\n\n" +
                         "Please use this PIN to reset your password.\n" +
                         "If you did not request this, please ignore this email.\n\n" +
                         "Best Regards,\nMega City Cab Team\n\n" +
                         "📧 : megacitycab@gmail.com\n" +
                         "📞 : +94 76 123 4567\n" +
                         "📍 : 123, Main Street, Colombo, Sri Lanka";

        return sendEmail(email, subject, message);
    }

    public boolean verifyPin(String email, String userPin) {
        return pinStorage.containsKey(email) && pinStorage.get(email).equals(userPin);
    }

    public boolean resetPassword(String email, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                sendResetConfirmationEmail(email);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void sendResetConfirmationEmail(String email) {
        String subject = "Mega City Cab - Password Reset Successful";
        String message = "Dear User,\n\n" +
                         "Your password has been successfully reset.\n" +
                         "If you did not perform this action, please contact our support immediately.\n\n" +
                         "Best Regards,\nMega City Cab Team\n\n" +
                         "📧 : megacitycab@gmail.com\n" +
                         "📞 : +94 76 123 4567\n" +
                         "📍 : 123, Galle Road, Colombo - 05, Sri Lanka";

        sendEmail(email, subject, message);
    }

    private boolean sendEmail(String toEmail, String subject, String message) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_SENDER, EMAIL_PASSWORD);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(EMAIL_SENDER));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("Email sent successfully to " + toEmail);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
