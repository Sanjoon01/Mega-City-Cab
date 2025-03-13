package AdminPackage;

import ClassPackage.DatabaseConnection;
import ClassPackage.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Corrected import

public class ManageUsers {
    
    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve created_at but don't store it in the User object
                    Timestamp createdAt = rs.getTimestamp("created_at");
                    // You can use createdAt for any purpose here, e.g., logging or display
                    if (createdAt != null) {
                        System.out.println("User created at: " + createdAt);
                    } else {
                        System.out.println("User created at: Not available");
                    }
                    
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
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

    public boolean deactivateUser(int userId) {
        String query = "UPDATE users SET status = 1 WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
}
