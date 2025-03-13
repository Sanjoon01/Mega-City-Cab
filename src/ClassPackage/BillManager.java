package ClassPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillManager {

    public void addBill(Bill bill) {
        String query = "INSERT INTO bill (booking_id, base_fare, number_of_stops, total_stop_charges, tax_rate, tax_amount, total_amount, discount_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bill.getBookingId());
            stmt.setDouble(2, bill.getBaseFare());
            stmt.setInt(3, bill.getNumberOfStops());
            stmt.setDouble(4, bill.getTotalStopCharges());
            stmt.setDouble(5, bill.getTaxRate());
            stmt.setDouble(6, bill.getTaxAmount());
            stmt.setDouble(7, bill.getTotalAmount());
            stmt.setDouble(8, bill.getDiscountAmount());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Bill inserted successfully for Booking ID: " + bill.getBookingId());
            } else {
                System.out.println("Bill insertion failed for Booking ID: " + bill.getBookingId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getBookingTotalAmount(int bookingId) {
        String query = "SELECT total_amount FROM booking WHERE booking_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double amount = rs.getDouble("total_amount");
                System.out.println("Booking Total Amount for Booking ID " + bookingId + ": " + amount);
                return amount;
            } else {
                System.out.println("Warning: No total amount found for Booking ID: " + bookingId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1.0; // Return -1.0 instead of 0.0 to indicate an error
    }

    public Bill getBillByBookingId(int bookingId) {
        String query = "SELECT * FROM bill WHERE booking_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Bill bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setBookingId(rs.getInt("booking_id"));
                bill.setBaseFare(rs.getDouble("base_fare"));
                bill.setTaxRate(rs.getDouble("tax_rate"));
                bill.setTaxAmount(rs.getDouble("tax_amount"));
                bill.setDiscountAmount(rs.getDouble("discount_amount"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                System.out.println("Bill retrieved successfully for Booking ID: " + bookingId);
                return bill;
            } else {
                System.out.println("No bill found for Booking ID: " + bookingId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // No bill found
    }

    // Method to retrieve all bills from the database
    public List<Bill> getAllBills() {
        List<Bill> billList = new ArrayList<>();
        String query = "SELECT * FROM bill";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setBookingId(rs.getInt("booking_id"));
                bill.setBaseFare(rs.getDouble("base_fare"));
                bill.setTaxRate(rs.getDouble("tax_rate"));
                bill.setTaxAmount(rs.getDouble("tax_amount"));
                bill.setDiscountAmount(rs.getDouble("discount_amount"));// Corrected field
                bill.setTotalAmount(rs.getDouble("total_amount"));
                billList.add(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }
    
    public int getBillIdByBookingId(int bookingId) {
    String query = "SELECT bill_id FROM bill WHERE booking_id = ?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, bookingId);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return rs.getInt("bill_id"); // Return the bill ID if found
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return -1; // Return -1 if no bill found
}

    public Bill getBillDetails(int billId) {
    String query = "SELECT * FROM bill WHERE bill_id = ?";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, billId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Bill bill = new Bill();
            bill.setBillId(rs.getInt("bill_id"));
            bill.setBookingId(rs.getInt("booking_id"));
            bill.setBaseFare(rs.getDouble("base_fare"));
            bill.setNumberOfStops(rs.getInt("number_of_stops"));
            bill.setTotalStopCharges(rs.getDouble("total_stop_charges"));
            bill.setTaxRate(rs.getDouble("tax_rate"));
            bill.setTaxAmount(rs.getDouble("tax_amount"));
            bill.setDiscountAmount(rs.getDouble("discount_amount"));
            bill.setTotalAmount(rs.getDouble("total_amount"));

            return bill;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return null; // Return null if no bill found
}

}
