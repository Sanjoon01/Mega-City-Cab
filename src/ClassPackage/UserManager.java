package ClassPackage;

import AdminPackage.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;

public class UserManager {

    private static User loggedInUser;

    public String signUp(User user, boolean isAdmin) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+(com|net|org)$";

        if (!Pattern.matches(emailPattern, user.getEmail())) {
            return "Invalid email format! Please enter a valid email.";
        }

        if (usernameExists(user.getName())) {
            return "Username already exists! Choose a different username.";
        }

        if (emailExists(user.getEmail())) {
            return "Email is already registered! Use a different email.";
        }

        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            sendEmailNotification(user.getName(), user.getEmail());
            return "User registered successfully!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred during registration. Please try again.";
        }
    }

    public boolean usernameExists(String name) {
        String query = "SELECT name FROM users WHERE name = ? "
                + "UNION SELECT username FROM admin WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a record exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean emailExists(String email) {
        String query = "SELECT email FROM users WHERE email = ? "
                + "UNION SELECT email FROM admin WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a record exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 public Object login(String email, String password) {
    String userQuery = "SELECT * FROM users WHERE email = ? AND status = 0"; // Only active users with status 0
    String adminQuery = "SELECT * FROM admin WHERE email = ?";

    try (Connection conn = DatabaseConnection.getConnection()) {
        // Check if the email belongs to an admin
        try (PreparedStatement adminStmt = conn.prepareStatement(adminQuery)) {
            adminStmt.setString(1, email);
            ResultSet adminRs = adminStmt.executeQuery();

            if (adminRs.next()) {
                String storedPassword = adminRs.getString("password");

                if (password.equals(storedPassword)) { // Replace with hashed password check
                    System.out.println("Admin login successful!");
                    Admin admin = new Admin(
                        adminRs.getInt("admin_id"),
                        adminRs.getString("username"),
                        adminRs.getString("email"),
                        adminRs.getString("password") // Include password here
                    );

                    // Set logged-in admin
                    loggedInUser = new User(admin.getAdminId(), admin.getUsername(), admin.getEmail(), admin.getPassword());
                    return admin;
                } else {
                    System.out.println("Invalid admin password.");
                    return null;
                }
            }
        }

        // If not an admin, check users table
        try (PreparedStatement userStmt = conn.prepareStatement(userQuery)) {
            userStmt.setString(1, email);
            ResultSet userRs = userStmt.executeQuery();

            if (userRs.next()) {
                String storedPassword = userRs.getString("password");

                if (password.equals(storedPassword)) { // Replace with hashed password check
                    int userId = userRs.getInt("user_id");
                    System.out.println("User found with ID: " + userId);
                    
                    User user = new User(
                        userId,
                        userRs.getString("name"),
                        userRs.getString("email"),
                        userRs.getString("password")
                    );

                    // Set logged-in user
                    loggedInUser = user;
                    return user;
                } else {
                    System.out.println("Invalid user password.");
                    return null;
                }
            } else {
                System.out.println("Email does not exist or user is deactivated.");
                return null;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

              

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    // Method to log out (optional)
    public static void logout() {
        loggedInUser = null;
    }

    public Customer getCustomerByName(String name) {
        String query = "SELECT c.customer_id, c.address, c.telephone, c.nic, c.profile_picture, "
                + "u.user_id, u.username, u.email, u.password "
                + "FROM customers c JOIN users u ON c.user_id = u.user_id WHERE u.username = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve profile_picture as byte[]
                byte[] profilePictureBytes = rs.getBytes("profile_picture");

                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );

                return new Customer(
                        rs.getInt("customer_id"),
                        user, // Passing the User object
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getString("nic"),
                        profilePictureBytes // Passing the byte[] for profile_picture
                );
            } else {
                System.out.println("Customer not found.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendEmailNotification(String name, String toEmail) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");  // Gmail SMTP server
            properties.put("mail.smtp.port", "587"); // SMTP port for STARTTLS
            properties.put("mail.smtp.auth", "true"); // Enable authentication
            properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

            // Create a session with the provided email credentials
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("megacitycab@gmail.com", "dyel bazj tkdm yany");
                }
            });

            // Create the email message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("megacitycab@gmail.com"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mimeMessage.setSubject("Welcome to Mega City Cab!");

            // Email body
            String message = "Hi " + name + ",\n\n"
                    + "Thank you for registering with Mega City Cab! We are excited to have you on board.\n\n"
                    + "You can now book rides easily and enjoy our services.\n\n"
                    + "If you have any questions, feel free to contact us.\n\n"
                    + "Best regards,\nMega City Cab Team\n\n"
                    + "📧 Email: megacitycab@gmail.com\n"
                    + "📞 +94 77 123 4567\n"
                    + "📍 123, Galle Road, Colombo - 05, Sri Lanka";

            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("Registration confirmation email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public int getUserIdByNameAndEmail(String name, String email) {
        String query = "SELECT user_id FROM users WHERE name = ? AND email = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCustomerId(int userId) {
        int customerId = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT customer_id FROM customer WHERE user_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                customerId = rs.getInt("customer_id");
            }

            System.out.println("Debug: Retrieved customer ID for user ID " + userId + ": " + customerId); // 🔍 Debugging
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return customerId;
    }

}
