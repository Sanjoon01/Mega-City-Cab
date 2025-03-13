package ClassPackage;

import java.sql.*;
import java.util.*;

public class DriverManager {

  
 public static int getDriverIdByName(String name) {
    int driverId = -1; // Default to -1 in case of error
    String query = "SELECT driver_id FROM driver WHERE name = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            driverId = rs.getInt("driver_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return driverId;
}

  
    // Get all drivers
  public List<Driver> getAllDrivers() {
    List<Driver> drivers = new ArrayList<>();
    String query = "SELECT driver_id, name, license_number, availability FROM driver WHERE availability = 0";

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            drivers.add(new Driver(
                rs.getInt("driver_id"),
                rs.getString("name"),
                rs.getString("license_number"),
                rs.getBoolean("availability")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return drivers; // ✅ Return the list of drivers
}


   
   public List<String> getUnavailableDrivers() {
    List<String> drivers = new ArrayList<>();
    String query = "SELECT name FROM driver WHERE availability = 1";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            drivers.add(rs.getString("name")); // Directly adding driver name
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return drivers;
}


}
