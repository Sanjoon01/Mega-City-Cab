package ClassPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HelpManager {
  

    // Constructor - Establish Database Connection
    public HelpManager() {
      
    }

    public boolean submitHelpRequest(int customerId, int bookingId, String category, String description) {
        String query = "INSERT INTO help (customer_id, booking_id, category, description, status, response) VALUES (?, ?, ?, ?, 'Pending', '')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, bookingId); // Add booking_id to query
            stmt.setString(3, category);
            stmt.setString(4, description);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all help topics
    public List<String> getHelpTopics() {
        List<String> topics = new ArrayList<>();
        topics.add("Trip Issues");
        topics.add("Vehicle Issues");
        topics.add("Driver Issues");
        topics.add("Billing Issues");
        topics.add("Payment Problems");
        topics.add("Account & Login Help");
        topics.add("Other Queries");
        return topics;
    }

   public List<Help> getCustomerHelpRequests(int customerId) {
        List<Help> helpList = new ArrayList<>();
        String query = "SELECT * FROM help WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                helpList.add(new Help(
                        rs.getInt("help_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("booking_id"), // Fetch booking_id
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("response")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return helpList;
    }

    // Fetch past trips and bills of a customer
    public List<String> getCustomerPastTrips(int customerId) {
        List<String> trips = new ArrayList<>();
        String query = "SELECT booking_id, date, amount FROM booking WHERE customer_id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                trips.add("Trip ID: " + rs.getInt("booking_id") + 
                          ", Date: " + rs.getString("date") + 
                          ", Amount: " + rs.getDouble("amount") + " LKR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trips;
    }
}
