package ClassPackage;

public class Bill {

    private int billId;
    private int bookingId;
    private double baseFare = 1500; // Fixed base fare
    private int numberOfStops; // Number of stops
    private double taxRate = 10.0; // Tax rate can be changed
    private double taxAmount;
    private double discountRate = 2.0; // New 2% discount
    private double discountAmount;// Total tax amount
    private double totalAmount;
    private double totalStopCharges; // Field for total stop charges

    // Default Constructor
    public Bill() {
    }

    // Constructor using booking details
    public Bill(int billId, Booking booking, int numberOfStops) {
        this.billId = billId;
        this.bookingId = booking.getBookingId();
        this.numberOfStops = numberOfStops;
        this.totalStopCharges = calculateTotalStopCharges(); // Calculate total stop charges
        this.taxAmount = calculateTax();
        this.discountAmount = calculateDiscount();// Calculate tax based on base fare and stop charges
        this.totalAmount = calculateTotalAmount(); // Calculate total amount
    }

    // Method to calculate tax amount based on tax rate for base fare and stop charges
    private double calculateTax() {
        double baseFareTax = (taxRate / 100) * baseFare; // Tax on base fare
        double stopChargesTax = (taxRate / 100) * totalStopCharges; // Tax on total stop charges
        return baseFareTax + stopChargesTax; // Total tax amount
    }

    private double calculateDiscount() {
        double subtotal = baseFare + totalStopCharges + taxAmount;
        return (discountRate / 100) * subtotal;
    }

    private double calculateTotalAmount() {
        double subtotal = baseFare + totalStopCharges + taxAmount;
        return subtotal - discountAmount;
    }


    // Method to calculate total stop charges based on number of stops
    private double calculateTotalStopCharges() {
        return numberOfStops * 500; // Calculate total stop charges
    }

    // Method to generate a bill as a formatted string
    public String generateBill() {
        return "========== MEGA CITY CAB BILL ==========\n"
                + "Bill ID: " + billId + "\n"
                + "Booking ID: " + bookingId + "\n"
                + "Base Fare: LKR " + String.format("%.2f", baseFare) + "\n"
                + "Number of Stops: " + numberOfStops + "\n"
                + "Stop Charges: LKR " + String.format("%.2f", totalStopCharges) + "\n" // Use totalStopCharges
                + "Tax (" + taxRate + "%): LKR " + String.format("%.2f", taxAmount) + "\n"
                + "Discount (" + discountRate + "%): -LKR " + String.format("%.2f", discountAmount) + "\n"
                + "---------------------------------------\n"
                + "Total Amount (After Discount): LKR " + String.format("%.2f", totalAmount) + "\n"
                + "=======================================";
    }

    // Print the bill
    public void printBill() {
        System.out.println(generateBill());
    }

    // Getters
    public int getBillId() {
        return billId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTaxAmount() {
        return taxAmount; // Getter for total tax amount
    }

    public double getTotalAmount() {
        return totalAmount; // Getter for total amount
    }

    public double getTotalStopCharges() {
        return totalStopCharges; // Getter for total stop charges
    }

    // Setters
    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
        this.taxAmount = calculateTax(); // Recalculate tax
        this.totalAmount = calculateTotalAmount(); // Recalculate total
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
        this.totalStopCharges = calculateTotalStopCharges(); // Recalculate total stop charges
        this.taxAmount = calculateTax(); // Recalculate tax
        this.totalAmount = calculateTotalAmount(); // Recalculate total amount
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate; // Set new tax rate
        this.taxAmount = calculateTax(); // Recalculate tax with the new rate
        this.totalAmount = calculateTotalAmount(); // Recalculate total
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount; // Optional, generally managed by other methods
        this.totalAmount = calculateTotalAmount(); // Recalculate total
    }

      public double getDiscountRate() {
        return discountRate;
    }
      
    public double getDiscountAmount() {
        return discountAmount;
    }
    
 public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount; // Optional, generally managed by other methods
    }

    public void setTotalStopCharges(double totalStopCharges) {
        this.totalStopCharges = totalStopCharges; // Optional, generally managed by other methods
    }
}
