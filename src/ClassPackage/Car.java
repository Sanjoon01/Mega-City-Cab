package ClassPackage;

public class Car {
    private int carId;
    private String registrationNumber;
    private String model;
    private boolean availability; // True = available, False = unavailable

    // Constructor
    public Car(int carId, String registrationNumber, String model, boolean availability) {
        this.carId = carId;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.availability = availability;
    }

    // Getters and Setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Car [carId=" + carId + ", registrationNumber=" + registrationNumber + ", model=" + model 
                + ", availability=" + (availability ? "Available" : "Unavailable") + "]";
    }
}
