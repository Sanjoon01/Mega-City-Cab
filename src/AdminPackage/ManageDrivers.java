package AdminPackage;

import ClassPackage.DatabaseConnection;
import ClassPackage.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageDrivers {
    
    // Add a new driver only if name and license are unique
    public boolean addDriver(Driver driver) {
        if (isNameExists(driver.getName())) {
            System.out.println("Driver name already exists.");
            return false;
        }
        if (isLicenseExists(driver.getLicenseNumber())) {
            System.out.println("License number already exists.");
            return false;
        }

        String query = "INSERT INTO Driver (name, license_number, availability) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getLicenseNumber());
            stmt.setBoolean(3, driver.isAvailability());

            stmt.executeUpdate();
            System.out.println("Driver added successfully.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Check if driver name already exists
    public boolean isNameExists(String name) {
        String query = "SELECT driver_id FROM Driver WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a record exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if license number already exists
    public boolean isLicenseExists(String licenseNumber) {
        String query = "SELECT driver_id FROM Driver WHERE license_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, licenseNumber);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a record exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

     // Get a driver by ID
    public Driver getDriverById(int driverId) {
        String query = "SELECT * FROM Driver WHERE driver_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, driverId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("license_number"),
                        rs.getBoolean("availability")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
 public void updateDriver(Driver driver) {
    String query = "UPDATE Driver SET name = ?, license_number = ?, availability = ? WHERE driver_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        System.out.println("Query: " + query);
        System.out.println("Driver ID: " + driver.getDriverId());
        System.out.println("Name: " + driver.getName());
        System.out.println("License Number: " + driver.getLicenseNumber());
        System.out.println("Availability: " + driver.isAvailability());

        // Set the parameters for the query
        stmt.setString(1, driver.getName());            // Update driver name
        stmt.setString(2, driver.getLicenseNumber());   // Update driver license number
        stmt.setBoolean(3, driver.isAvailability());    // Update driver availability
        stmt.setInt(4, driver.getDriverId());           // Specify which driver to update

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Driver updated successfully.");
        } else {
            System.out.println("Driver not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    // Deactivate driver
    public void deactivateDriver(int driverId) {
        String query = "UPDATE Driver SET availability = 1 WHERE driver_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, driverId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Driver deactivated successfully.");
            } else {
                System.out.println("Driver not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
