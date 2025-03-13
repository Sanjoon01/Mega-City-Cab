package ClassPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarManager {

    

public static int getCarIdByModel(String model) {
    int carId = -1; // Default to -1 in case of error
    String query = "SELECT car_id FROM car WHERE model = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, model);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            carId = rs.getInt("car_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return carId;
}



 public List<String> getUnavailableCars() {
    List<String> cars = new ArrayList<>();
    String query = "SELECT model FROM car WHERE availability = 1";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            cars.add(rs.getString("model")); // Directly adding model name
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cars;
}

   // Get all cars
   public List<Car> getAllCars() {
    List<Car> cars = new ArrayList<>();
    String query = "SELECT car_id, registration_number, model, availability FROM car WHERE availability = 0";
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            cars.add(new Car(
                rs.getInt("car_id"),
                rs.getString("registration_number"),
                rs.getString("model"),
                rs.getBoolean("availability")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return cars;
}

}
