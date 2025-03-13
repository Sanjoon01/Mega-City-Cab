
package ClassPackage;

import java.sql.Date;
import java.sql.Time;

public class Request {
    private String customerName;
    private String vehicleModel;
    private String driverName;
    private Date bookingDate;
    private Time bookingTime;
    private String status;

    public Request(String customerName, String vehicleModel, String driverName, Date bookingDate, Time bookingTime, String status) {
        this.customerName = customerName;
        this.vehicleModel = vehicleModel;
        this.driverName = driverName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    public String getCustomerName() { 
        return customerName; 
    }
    public void setCustomerName(String customerName) {
    this.customerName = customerName;
}
    public String getVehicleModel() {
        return vehicleModel; 
    }
    public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
}
    public String getDriverName() {
        return driverName; 
    }
    public void setDriverName(String driverName) {
    this.driverName = driverName;
}
    public Date getBookingDate() {
        return bookingDate; 
    }
    public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
}
    public Time getBookingTime() {
        return bookingTime; 
    }
    public void setBookingTime(Time bookingTime) {
    this.bookingTime = bookingTime;
}
    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) {
    this.status = status;
}
}

