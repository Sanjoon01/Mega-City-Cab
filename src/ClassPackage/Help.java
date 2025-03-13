package ClassPackage;

public class Help {

    private int helpId; // Updated from 'id' to 'help_id'
    private int customerId;
    private String customerName;
    private int bookingId;// Updated from 'user_id' to 'customer_id'
    private String category;
    private String description;
    private String status;
    private String response;

    // Constructor
    public Help(int helpId, int customerId, int bookingID, String category, String description, String status, String response) {
        this.helpId = helpId;
        this.customerId = customerId;
        this.bookingId = bookingID;
        this.category = category;
        this.description = description;
        this.status = status;
        this.response = response;
    }

    // Getters and Setters
    public int getHelpId() {
        return helpId;
    }

    public void setHelpId(int helpId) {
        this.helpId = helpId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
