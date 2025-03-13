package ClassPackage;

import java.util.Date;

public class Booking {

    private int bookingId;
    private int customerId;
    private int carId;
    private int driverId;
    private String pickup;
    private String drop_off;
    private Date bookingDate;
    private Date bookingTime;  // New field for booking time
    private double totalAmount;
    private String status;  // e.g., booked, completed, canceled

    // Constructor
    public Booking(int bookingId, int customerId, int carId, int driverId, String pickup, String drop_off, Date bookingDate, Date bookingTime, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.carId = carId;
        this.driverId = driverId;
        this.pickup = pickup;
        this.drop_off = drop_off;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }
    
     public String getDrop() {
        return drop_off;
    }

    public void setDrop(String drop_off) {
        this.drop_off = drop_off;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBookingTime() {  // New getter
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {  // New setter
        this.bookingTime = bookingTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method (optional, for easier printing)
    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Customer ID: " + customerId + ", Car ID: " + carId
                + ", Driver ID: " + driverId + ", Pickup: " + pickup + "Drop: " + drop_off + ", Booking Date: " + bookingDate
                + ", Booking Time: " + bookingTime + ", Total Amount: " + totalAmount + ", Status: " + status;
    }
}
