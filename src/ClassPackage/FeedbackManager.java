package ClassPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackManager {
    public boolean submitFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (customer_id, feedback_report) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, feedback.getCustomerId());
            stmt.setString(2, feedback.getFeedbackReport());
            return stmt.executeUpdate() > 0; // Return true if at least one row was inserted
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if insertion failed
    }
}
