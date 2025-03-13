package ClassPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class RequestManager {
    public static boolean insertRequest(int customerId, int carId, int driverId, Date bookingDate, Time bookingTime) {
        String query = "INSERT INTO request (customer_id, car_id, driver_id, booking_date, booking_time, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            stmt.setInt(2, carId);
            stmt.setInt(3, driverId);
            stmt.setDate(4, bookingDate);
            stmt.setTime(5, bookingTime);
            stmt.setString(6, "pending"); // Always set status to "pending"

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
