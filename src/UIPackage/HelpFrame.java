package UIPackage;

import ClassPackage.Bill;
import ClassPackage.BillManager;
import ClassPackage.Booking;
import ClassPackage.BookingManager;
import ClassPackage.Customer;
import ClassPackage.HelpManager;
import ClassPackage.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class HelpFrame extends javax.swing.JFrame {

    private User loggedInUser;
    private Customer loggedInCustomer; // Store logged-in custome
    private String username;
    private int customerId; // ✅ Customer ID
    private int userId; // ✅ Associated User ID
    private int loggedInUserId;
    private int loggedInCustomerId;
    private int selectedBookingId = -1; // Store the selected Booking ID
    private int selectedBillId = -1; // Store the selected Bill ID
    private BillManager billManager = new BillManager();

    public HelpFrame(String username, Customer loggedInCustomer, int customerId) {
        initComponents();
        this.loggedInCustomerId = customerId;
        this.username = username;
        this.loggedInCustomer = loggedInCustomer;
        displayUsername();
        loadHelpTopics();
        loadTripData();
         setupWordCount();
        updateWordCount();

        Receiptbtn.setVisible(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadHelpTopics();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadTripData();
            }
        });
    }

    public int getLoggedInCustomerId() {
        return loggedInCustomer != null ? loggedInCustomer.getCustomerId() : -1;
    }

    private void displayUsername() {
        usernameLabel.setText(username);
    }

    private void loadHelpTopics() {
        HelpManager helpManager = new HelpManager();
        List<String> topics = helpManager.getHelpTopics();

        String selectedTopic = (String) issueComboBox.getSelectedItem(); // Store current selection

        issueComboBox.removeAllItems(); // Clear existing items
        issueComboBox.addItem("Select an Issue"); // Default placeholder

        for (String topic : topics) {
            issueComboBox.addItem(topic); // Add topics to combo box
        }

        if (selectedTopic != null) {
            issueComboBox.setSelectedItem(selectedTopic); // Restore previous selection if available
        }
    }

    private Map<String, Integer> tripMap = new LinkedHashMap<>(); // Store trips & booking IDs

    private void loadTripData() {
        BookingManager bookingManager = new BookingManager();
        tripMap = (Map<String, Integer>) bookingManager.getTripsByCustomerId(loggedInCustomer.getCustomerId());

        String selectedTrip = (String) tripComboBox.getSelectedItem(); // Store previous selection

        tripComboBox.removeAllItems(); // Clear existing items
        tripComboBox.addItem("Select a Trip"); // Default option

        for (String trip : tripMap.keySet()) {
            tripComboBox.addItem(trip); // Add formatted trip details
        }

        if (selectedTrip != null) {
            tripComboBox.setSelectedItem(selectedTrip); // Restore previous selection if available
        }
    }
    
     private void setupWordCount() {
    wordCountLabel.setText("0/100"); // Initialize label

    descriptionTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            updateWordCount();
        }
    });
}

private void  updateWordCount() {
    String text = descriptionTextArea.getText();

    int charCount = text.length(); // Count all characters, including spaces

    // Limit to 100 characters
    if (charCount > 100) {
        text = text.substring(0, 100); // Trim text to 100 characters
       descriptionTextArea.setText(text);
        charCount = 100;

    }

    // Update label
    wordCountLabel.setText(charCount + "/100");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stopLabel3 = new javax.swing.JLabel();
        tripComboBox = new javax.swing.JComboBox<>();
        stopLabel4 = new javax.swing.JLabel();
        issueComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        stopLabel5 = new javax.swing.JLabel();
        Receiptbtn = new javax.swing.JButton();
        Confirmbtn = new javax.swing.JButton();
        wordCountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Help Manager");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Help Manager");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Hello!");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usernameLabel.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("How can we Help You?");

        stopLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel3.setText("Choose a trip");

        tripComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tripComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripComboBoxActionPerformed(evt);
            }
        });

        stopLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel4.setText("Select an issue");

        issueComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        issueComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueComboBoxActionPerformed(evt);
            }
        });

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        stopLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel5.setText("Description:");

        Receiptbtn.setBackground(new java.awt.Color(13, 71, 161));
        Receiptbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Receiptbtn.setForeground(new java.awt.Color(255, 255, 255));
        Receiptbtn.setText("View Receipt");
        Receiptbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Receiptbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Receiptbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Receiptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptbtnActionPerformed(evt);
            }
        });

        Confirmbtn.setBackground(new java.awt.Color(13, 71, 161));
        Confirmbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Confirmbtn.setForeground(new java.awt.Color(255, 255, 255));
        Confirmbtn.setText("Confirm");
        Confirmbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Confirmbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Confirmbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmbtnActionPerformed(evt);
            }
        });

        wordCountLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Receiptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopLabel3)
                            .addComponent(stopLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tripComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(issueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stopLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wordCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopLabel3)
                    .addComponent(tripComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Receiptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel4))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stopLabel5)
                    .addComponent(wordCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tripComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripComboBoxActionPerformed
       String selectedTrip = (String) tripComboBox.getSelectedItem();

    if (selectedTrip != null && !selectedTrip.equals("Select a Trip")) {
        selectedBookingId = tripMap.get(selectedTrip); // Retrieve the booking ID

        // ✅ Use BillManager to get the bill ID
        selectedBillId = billManager.getBillIdByBookingId(selectedBookingId); 

        Receiptbtn.setVisible(true);  // Show button if a trip is selected
    } else {
        selectedBookingId = -1;
        selectedBillId = -1;
        Receiptbtn.setVisible(false); // Hide button if no trip is selected
    }
    }//GEN-LAST:event_tripComboBoxActionPerformed

    private void issueComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueComboBoxActionPerformed
        loadHelpTopics();
    }//GEN-LAST:event_issueComboBoxActionPerformed

    private void ReceiptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptbtnActionPerformed
     // Get the selected trip from tripComboBox
    String selectedTrip = (String) tripComboBox.getSelectedItem();

    if (selectedTrip == null || selectedTrip.equals("Select a Trip")) {
        JOptionPane.showMessageDialog(this, "Please select a valid trip!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Retrieve the booking ID for the selected trip
    BookingManager bookingManager = new BookingManager();
    int selectedBookingId = bookingManager.getBookingIdByTrip(selectedTrip, loggedInCustomer.getCustomerId());

    if (selectedBookingId == -1) {
        JOptionPane.showMessageDialog(this, "No booking found for the selected trip!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Retrieve the Booking object
    Booking selectedBooking = bookingManager.getBookingById(selectedBookingId);
    if (selectedBooking == null) {
        JOptionPane.showMessageDialog(this, "Error fetching booking details!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Retrieve the bill ID using the booking ID
    BillManager billManager = new BillManager();
    int selectedBillId = billManager.getBillIdByBookingId(selectedBookingId);

    if (selectedBillId == -1) {
        JOptionPane.showMessageDialog(this, "No bill found for the selected booking!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch the Bill object
    Bill selectedBill = billManager.getBillDetails(selectedBillId);
    if (selectedBill == null) {
        JOptionPane.showMessageDialog(this, "Error fetching bill details!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Open ViewReceiptFrame with both the Bill and Booking objects
    ViewReceiptFrame receiptFrame = new ViewReceiptFrame(selectedBill, selectedBooking);
    receiptFrame.setVisible(true);
    receiptFrame.pack();
    receiptFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_ReceiptbtnActionPerformed

    private void ConfirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmbtnActionPerformed
         // Get the selected trip from tripComboBox
    String selectedTrip = (String) tripComboBox.getSelectedItem();

    if (selectedTrip == null || selectedTrip.equals("Select a Trip")) {
        JOptionPane.showMessageDialog(this, "Please select a valid trip!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Retrieve the booking ID for the selected trip
    BookingManager bookingManager = new BookingManager();
    int selectedBookingId = bookingManager.getBookingIdByTrip(selectedTrip, loggedInCustomer.getCustomerId());

    if (selectedBookingId == -1) {
        JOptionPane.showMessageDialog(this, "No booking found for the selected trip!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get category and description from user input
   String category = (String) issueComboBox.getSelectedItem(); // Assuming you have a field for category input
    String description = descriptionTextArea.getText().trim(); // Assuming you have a field for description input

    // Validate category and description
    if (category.isEmpty() || description.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Category and description cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Submit help request
    HelpManager helpManager = new HelpManager(); // Assuming you have a HelpManager class
    boolean isSubmitted = helpManager.submitHelpRequest(loggedInCustomer.getCustomerId(), selectedBookingId, category, description);

    if (isSubmitted) {
        JOptionPane.showMessageDialog(this, "Help request submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Error submitting help request. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ConfirmbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmbtn;
    private javax.swing.JButton Receiptbtn;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JComboBox<String> issueComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel stopLabel3;
    private javax.swing.JLabel stopLabel4;
    private javax.swing.JLabel stopLabel5;
    private javax.swing.JComboBox<String> tripComboBox;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel wordCountLabel;
    // End of variables declaration//GEN-END:variables
}
