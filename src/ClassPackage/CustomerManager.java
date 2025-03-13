package ClassPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class CustomerManager {

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (user_id, address, telephone, nic, profile_picture) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, customer.getUser().getUserId()); // Ensure user is linked
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getTelephone());
            stmt.setString(4, customer.getNic());
           stmt.setBytes(6, customer.getprofile_picture()); // Set as byte[]


            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        customer.setCustomerId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Customer getCustomerById(int customerId) {
        String sql = "SELECT c.customer_id, c.address, c.telephone, c.nic, c.profile_picture, "
                + "u.user_id, u.name, u.email, u.password "
                + "FROM customer c JOIN users u ON c.user_id = u.user_id WHERE c.customer_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password")
                    );

                    return new Customer(
                            rs.getInt("customer_id"),
                            user, // Linking User object
                            rs.getString("address"),
                            rs.getString("telephone"),
                            rs.getString("nic"),
                            rs.getBytes("profile_picture") // Retrieving LONGBLOB as byte[]
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getCustomerIdByName(String name) {
    String sql = "SELECT customer_id FROM customer c JOIN users u ON c.user_id = u.user_id WHERE u.name = ?";
    
    try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("customer_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; // Return -1 if customer not found
}


   public Customer getCustomerByUserId(int userId) {
    String query = "SELECT * FROM customer WHERE user_id = ?";

    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Retrieve profile_picture as byte[]
            byte[] profilePictureBytes = rs.getBytes("profile_picture");

            return new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("address"),
                    rs.getString("telephone"),
                    rs.getString("nic"),
                    profilePictureBytes // Pass the byte[] to the Customer object
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}


    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            return stmt.executeUpdate() > 0; // Returns true if deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateCustomer(Customer customer) {
        String query = "UPDATE Customer SET name = ?, address = ?, telephone = ?, nic = ?, email = ?, profileImagePath = ? WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getTelephone());
            stmt.setString(4, customer.getNic());
            stmt.setBytes(6, customer.getprofile_picture()); // Set as byte[]
            stmt.setInt(7, customer.getCustomerId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  public static boolean saveProfilePicture(int customerId, InputStream imageStream) {
    if (customerId == 0) {
        System.out.println("Error: Invalid customer ID! Cannot save profile picture.");
        return false;
    }

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DatabaseConnection.getConnection();
        String updateQuery = "UPDATE customer SET profile_picture = ? WHERE customer_id = ?";
        stmt = conn.prepareStatement(updateQuery);

        // Set the binary stream for image upload
        stmt.setBinaryStream(1, imageStream);
        stmt.setInt(2, customerId);

        int rowsAffected = stmt.executeUpdate();
        System.out.println("Rows affected by profile picture update: " + rowsAffected); // Debugging output

        return rowsAffected > 0;

    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error closing resources: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

    public static boolean removeProfilePicture(int customerId) {
        String query = "UPDATE customer SET profile_picture = NULL WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
           
        }
    }
    
 public String getCustomerEmailById(int customerId) {
    String email = null;
    String query = "SELECT u.email FROM users u JOIN customer c ON u.user_id = c.user_id WHERE c.customer_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            email = rs.getString("email");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return email; // Returns email if found, otherwise returns null
}



}
