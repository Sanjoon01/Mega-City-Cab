package AdminUIPackage;

import ClassPackage.DatabaseConnection;
import AdminPackage.ManageBooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManageBookingFrame extends javax.swing.JFrame {

    private ManageBooking manageBooking;

    public ManageBookingFrame() {
        initComponents();
        manageBooking = new ManageBooking(); // Initialize ManageBooking
        loadBookingIds();

        StatusComboBox.removeAllItems(); // Clear existing items
        StatusComboBox.addItem("Confirmed");
        StatusComboBox.addItem("Cancel");

        CustomerNameField.setEditable(false);
        PickupField.setEditable(false);
        DropoffField.setEditable(false);
        BookingDateField.setEditable(false);
        BookingTimeField.setEditable(false);
        TotalAmountField.setEditable(false);

    }

    private void loadBookingIds() {
        BookingIdComboBox.removeAllItems(); // Clear existing items
        BookingIdComboBox.addItem("Select a Booking ID"); // Default option

        String query = "SELECT booking_id FROM booking ORDER BY booking_id ASC"; // Order by booking_id in ascending order

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BookingIdComboBox.addItem(String.valueOf(rs.getInt("booking_id"))); // Add valid booking IDs in order
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading booking IDs.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadBookingDetails(int bookingId) {
        String query = "SELECT b.customer_id, b.pickup, b.drop_off, b.booking_date, b.booking_time, b.total_amount, b.status "
                + "FROM booking b WHERE b.booking_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String customerName = manageBooking.getCustomerNameByBookingId(customerId); // Call method from ManageBooking
                CustomerNameField.setText(customerName);
                PickupField.setText(rs.getString("pickup"));
                DropoffField.setText(rs.getString("drop_off"));
                BookingDateField.setText(rs.getString("booking_date"));
                BookingTimeField.setText(rs.getString("booking_time"));
                TotalAmountField.setText(String.valueOf(rs.getDouble("total_amount")));
                StatusComboBox.setSelectedItem(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        CustomerNameField.setText("");
        PickupField.setText("");
        DropoffField.setText("");
        BookingDateField.setText("");
        BookingTimeField.setText("");
        TotalAmountField.setText("");

        if (StatusComboBox.getItemCount() > 0) {
            StatusComboBox.setSelectedIndex(0); // Set to first valid item instead of -1
        }
    }
    private void sendCancellationEmail(int bookingId) {
    manageBooking.sendCancellationEmail(bookingId);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BookingIdComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        DropoffField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CustomerNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PickupField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BookingTimeField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BookingDateField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TotalAmountField = new javax.swing.JTextField();
        StatusComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Booking");
        setPreferredSize(new java.awt.Dimension(500, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 650));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Bookings");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Booking ID");

        BookingIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookingIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingIdComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");

        DropoffField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DropoffField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Pick Up");

        CustomerNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CustomerNameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Drop Off");

        PickupField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PickupField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Booking Date");

        BookingTimeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BookingTimeField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Booking Time");

        BookingDateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BookingDateField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total Amount");

        TotalAmountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TotalAmountField.setPreferredSize(new java.awt.Dimension(65, 25));

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        StatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Status");

        saveBtn.setBackground(new java.awt.Color(13, 71, 161));
        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setMaximumSize(new java.awt.Dimension(125, 25));
        saveBtn.setMinimumSize(new java.awt.Dimension(125, 25));
        saveBtn.setPreferredSize(new java.awt.Dimension(130, 25));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BookingDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PickupField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BookingIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DropoffField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotalAmountField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookingTimeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookingIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PickupField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DropoffField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookingDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookingTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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

    private void BookingIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingIdComboBoxActionPerformed
        Object selectedItem = BookingIdComboBox.getSelectedItem(); // Get selected item safely

        if (selectedItem == null) {
            return; // Exit the method if null to avoid NullPointerException
        }

        String selectedBookingId = selectedItem.toString().trim();

        if (selectedBookingId.isEmpty() || selectedBookingId.equals("Select a Booking ID")) {
            clearFields(); // Clear fields when no valid ID is selected
            return;
        }

        if (selectedBookingId.matches("\\d+")) {
            clearFields(); // Clear fields before loading new details
            int bookingId = Integer.parseInt(selectedBookingId);
            loadBookingDetails(bookingId);
        }
    }//GEN-LAST:event_BookingIdComboBoxActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // Get selected booking ID safely
        Object selectedItem = BookingIdComboBox.getSelectedItem();
        if (selectedItem == null || selectedItem.toString().equals("Select a Booking ID")) {
            JOptionPane.showMessageDialog(this, "Please select a valid Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedBookingId = selectedItem.toString().trim();
        if (!selectedBookingId.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookingId = Integer.parseInt(selectedBookingId);

        // Get the new status from StatusComboBox safely
        Object statusItem = StatusComboBox.getSelectedItem();
        if (statusItem == null) {
            JOptionPane.showMessageDialog(this, "Please select a booking status.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String newStatus = statusItem.toString();

        // If the user selects "Cancel", show a confirmation dialog
        if ("Cancel".equalsIgnoreCase(newStatus)) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to cancel the booking?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirm != JOptionPane.YES_OPTION) {
                return; // Stop the process if the user selects "No"
            }
             sendCancellationEmail(bookingId);
        }

        // Update the booking status only when Save is clicked
        manageBooking.updateBookingStatus(bookingId, newStatus);

        JOptionPane.showMessageDialog(this, "Booking status updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveBtnActionPerformed

    private void StatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookingDateField;
    private javax.swing.JComboBox<String> BookingIdComboBox;
    private javax.swing.JTextField BookingTimeField;
    private javax.swing.JTextField CustomerNameField;
    private javax.swing.JTextField DropoffField;
    private javax.swing.JTextField PickupField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JTextField TotalAmountField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
