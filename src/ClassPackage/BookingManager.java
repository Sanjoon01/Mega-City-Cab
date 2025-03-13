package ClassPackage;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class BookingManager {

 public int addBooking(Booking booking) {
    String query = "INSERT INTO booking (customer_id, car_id, driver_id, pickup, drop_off, booking_date, booking_time, total_amount, status) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    int generatedBookingId = -1;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, booking.getCustomerId());
        stmt.setInt(2, booking.getCarId());
        stmt.setInt(3, booking.getDriverId());
        stmt.setString(4, booking.getPickup());
        stmt.setString(5, booking.getDrop());
        stmt.setDate(6, new java.sql.Date(booking.getBookingDate().getTime()));
        stmt.setTimestamp(7, new java.sql.Timestamp(booking.getBookingTime().getTime()));
        stmt.setDouble(8, booking.getTotalAmount());
        stmt.setString(9, booking.getStatus());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedBookingId = rs.getInt(1);
                System.out.println("Booking inserted successfully! Booking ID: " + generatedBookingId);
            }
        } else {
            System.out.println("Booking insertion failed.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return generatedBookingId;
}

public int bookRide(Booking booking, int numberOfStops, double stopCharge) {
    int bookingId = addBooking(booking); 

    if (bookingId == -1) {
        System.out.println("Error: Booking creation failed. Cannot create bill.");
        return -1; 
    }

    booking.setBookingId(bookingId);
    
   Bill bill = new Bill(0, booking, numberOfStops);
    bill.setBookingId(bookingId); 
    
    BillManager billManager = new BillManager();
    billManager.addBill(bill);

    return bookingId; 
}

    
  public void addStops(int bookingId, String stop1, String stop2, String stop3) {
    String query = "INSERT INTO stops (booking_id, stop1, stop2, stop3) VALUES (?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, bookingId);
        stmt.setString(2, stop1);
        stmt.setString(3, stop2);
        stmt.setString(4, stop3);

        stmt.executeUpdate();
        System.out.println("Stops added successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

   public List<String> getStopsByBookingId(int bookingId) {
        List<String> stops = new ArrayList<>();
        String query = "SELECT stop1, stop2, stop3 FROM stops WHERE booking_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                if (rs.getString("stop1") != null) stops.add(rs.getString("stop1"));
                if (rs.getString("stop2") != null) stops.add(rs.getString("stop2"));
                if (rs.getString("stop3") != null) stops.add(rs.getString("stop3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stops;
    }
    
  public int addBookingAndGetId(Booking booking) {
    String query = "INSERT INTO Booking (customer_id, car_id, driver_id, pickup, drop_off, booking_date, booking_time, total_amount, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    int bookingId = -1;

    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, booking.getCustomerId());
        stmt.setInt(2, booking.getCarId());
        stmt.setInt(3, booking.getDriverId());
        stmt.setString(4, booking.getPickup());
        stmt.setString(5, booking.getDrop());
        stmt.setDate(6, new java.sql.Date(booking.getBookingDate().getTime()));
        stmt.setTime(7, new java.sql.Time(booking.getBookingTime().getTime())); // Ensure this is correct
        stmt.setDouble(8, booking.getTotalAmount());
        stmt.setString(9, booking.getStatus());

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                bookingId = generatedKeys.getInt(1);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bookingId; 
}

    public Booking getBookingById(int bookingId) {
        String query = "SELECT * FROM Booking WHERE booking_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("car_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup"),
                        rs.getString("drop_off"),
                        rs.getDate("booking_date"),
                        rs.getTime("booking_time"), 
                        rs.getDouble("total_amount"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isCarAvailable(int carId, Date bookingDate) {
        String query = "SELECT * FROM Booking WHERE car_id = ? AND booking_date = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, carId);
            stmt.setDate(2, new java.sql.Date(bookingDate.getTime()));
            ResultSet rs = stmt.executeQuery();

            return !rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true; 
    }

    public boolean isDriverAvailable(int driverId, Date bookingDate) {
        String query = "SELECT * FROM Booking WHERE driver_id = ? AND booking_date = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, driverId);
            stmt.setDate(2, new java.sql.Date(bookingDate.getTime()));
            ResultSet rs = stmt.executeQuery();

            return !rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true; 
    }

   

public void sendEmailNotification(int customerId, String toEmail, String subject, String pickup, String drop, int numberOfStops, java.sql.Date bookingDate, java.sql.Time bookingTime, double totalAmount) {
    try {
        String customerName = getCustomerNameById(customerId);

        if (customerName == null) {
            System.out.println("Customer not found!");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a"); 

        String formattedDate = dateFormat.format(bookingDate);
        String formattedTime = timeFormat.format(bookingTime);

        String emailMessage = "Hi " + customerName + ",\n\n"
                            + "Your booking has been successfully confirmed. Here are your details:\n\n"
                            + "📍 Pickup Location: " + pickup + "\n"
                            + "📍 Drop-off Location: " + drop + "\n"
                            + "🚗 Number of Stops: " + numberOfStops + "\n"
                            + "📅 Booking Date: " + formattedDate + "\n"
                            + "⏰ Booking Time: " + formattedTime + "\n"
                            + "💰 Total Amount: " + totalAmount + " LKR\n\n"
                            + "Thank you for choosing Mega City Cab! 🚖";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("megacitycab@gmail.com", "dyel bazj tkdm yany");
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("megacitycab@gmail.com"));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(emailMessage);

        Transport.send(mimeMessage);
        System.out.println("Email sent successfully!");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}

  private String getCustomerNameById(int customerId) {
    String query = "SELECT u.name FROM users u JOIN customer c ON u.user_id = c.user_id WHERE c.customer_id = ?";
    
    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("name"); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return null; 
}

    
   public Map<String, Integer> getTripsByCustomerId(int customerId) {
    Map<String, Integer> tripMap = new LinkedHashMap<>();

    String query = "SELECT booking_id, pickup, drop_off FROM booking WHERE customer_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int bookingId = rs.getInt("booking_id");
            String trip = rs.getString("pickup") + " TO " + rs.getString("drop_off");
            tripMap.put(trip, bookingId); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tripMap;
}

   public int getBookingIdByTrip(String trip, int customerId) {
    String query = "SELECT booking_id FROM booking WHERE customer_id = ? AND CONCAT(pickup, ' TO ', drop_off) = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, customerId);
        stmt.setString(2, trip);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("booking_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; 
}

}


