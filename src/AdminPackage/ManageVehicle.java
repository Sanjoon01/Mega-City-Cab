package AdminPackage;

import ClassPackage.DatabaseConnection;
import ClassPackage.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageVehicle {

    // Add a new car only if registration number is unique
    public boolean addCar(Car car) {
        if (isRegistrationNumberExists(car.getRegistrationNumber())) {
            System.out.println("Car registration number already exists.");
            return false;
        }

        String query = "INSERT INTO Car (registration_number, model , availability) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, car.getRegistrationNumber());
            stmt.setString(2, car.getModel());
            stmt.setBoolean(3, car.isAvailability());

            stmt.executeUpdate();
            System.out.println("Car added successfully.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if car registration number already exists
    public boolean isRegistrationNumberExists(String registrationNumber) {
        String query = "SELECT car_id FROM Car WHERE registration_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, registrationNumber);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If a record exists, return true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   // Ensure these methods are public in ManageVehicle
public Car getCarById(int carId) {
    String query = "SELECT * FROM Car WHERE car_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, carId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Car(
                    rs.getInt("car_id"),
                    rs.getString("registration_number"),
                    rs.getString("model"),
                    rs.getBoolean("availability")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public void updateCar(Car car) {
    String query = "UPDATE Car SET model = ?, registration_number = ?, availability = ? WHERE car_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, car.getModel());
        stmt.setString(2, car.getRegistrationNumber());
        stmt.setBoolean(3, car.isAvailability());
        stmt.setInt(4, car.getCarId());

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Car updated successfully.");
        } else {
            System.out.println("Car not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Deactivate car (set availability to false)
    public void deactivateCar(int carId) {
        String query = "UPDATE Car SET availability = 1  WHERE car_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, carId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Car deactivated successfully.");
            } else {
                System.out.println("Car not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
