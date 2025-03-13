package ClassPackage;


public class Feedback {
     private int feedbackId;
    private int customerId;
    private String feedbackReport;

    // Constructor
    public Feedback(int customerId, String feedbackReport) {
        this.customerId = customerId;
        this.feedbackReport = feedbackReport;
    }

    // Getters
    public int getFeedbackId() {
        return feedbackId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFeedbackReport() {
        return feedbackReport;
    }

    // Setters (if needed)
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }
}

