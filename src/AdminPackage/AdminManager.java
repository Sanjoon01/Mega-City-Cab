package AdminPackage;

import ClassPackage.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AdminManager {

   private static int loggedInAdminId = -1; // Default to -1 (no admin logged in)

 public Admin login(String email, String password) {
    String query = "SELECT admin_id, username, password FROM admin WHERE email = ? AND password = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int adminId = rs.getInt("admin_id");
            String username = rs.getString("username");
            String storedPassword = rs.getString("password"); // Retrieve password from DB

            loggedInAdminId = adminId; // ✅ Store logged-in admin ID correctly

            return new Admin(adminId, username, email, storedPassword); // Return admin object with password
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return null; // Return null if login fails
}



  public static int getLoggedInAdminId() {
    return loggedInAdminId;
}

  public static void setLoggedInAdminId(int adminId) {
    loggedInAdminId = adminId;
}


    public static void logout() {
        loggedInAdminId = -1; // Reset when the admin logs out
    }

   // Check if username is already taken
public boolean isUsernameTaken(String username) {
    String query = "SELECT admin_id FROM admin WHERE username = ? " +
                   "UNION SELECT user_id FROM users WHERE name = ?";
    return checkIfExists(query, username, username); // Use the two-parameter version
}

// Check if password is already used by another admin
public boolean isPasswordTaken(String password) {
    String query = "SELECT admin_id FROM admin WHERE password = ?";
    return checkIfExists(query, password); // Use the one-parameter version
}

// Check if email is already registered
public boolean isEmailTaken(String email) {
    String query = "SELECT admin_id FROM admin WHERE email = ? " +
                   "UNION SELECT user_id FROM users WHERE email = ?";
    return checkIfExists(query, email, email); // Use the two-parameter version
}

// General method to check if a value exists in the database with one parameter
private boolean checkIfExists(String query, String value) {
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, value); // Set the single parameter
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // If a record exists, return true
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

// General method to check if a value exists in the database with two parameters
private boolean checkIfExists(String query, String value1, String value2) {
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, value1);
        stmt.setString(2, value2);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // If a record exists, return true
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


  
    public boolean updateAdminInfo(int adminId, String newUsername, String newPassword, String newEmail) {
    if (isUsernameTaken(newUsername)) {
        JOptionPane.showMessageDialog(null, "Username is already taken by a user!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    if (isEmailTaken(newEmail)) {
        JOptionPane.showMessageDialog(null, "Email is already used by a user!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String query = "UPDATE admin SET username = ?, password = ?, email = ? WHERE admin_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, newUsername);
        stmt.setString(2, newPassword); // Ensure hashing before saving
        stmt.setString(3, newEmail);
        stmt.setInt(4, adminId);

        int rowsUpdated = stmt.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

   public List<Admin> getAllAdmins() {
    List<Admin> admins = new ArrayList<>();
    String query = "SELECT username, email, password FROM admin"; 

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");

            admins.add(new Admin(username, email, password)); // Constructor updated to match
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return admins;
}

   
}

