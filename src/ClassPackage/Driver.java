package ClassPackage;

public class Driver {
    private int driverId;
    private String name;
    private String licenseNumber;
    private boolean availability; // true if available, false if not

    // Constructor
    public Driver(int driverId, String name, String licenseNumber, boolean availability) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.availability = availability;
    }

    // Getters and Setters
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // toString method
    @Override
    public String toString() {
        return "Driver ID: " + driverId + ", Name: " + name + ", License Number: " + licenseNumber + ", Availability: " + availability;
    }
}
