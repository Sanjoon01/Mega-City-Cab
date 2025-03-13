package AdminUIPackage;


import ClassPackage.DatabaseConnection;
import ClassPackage.Driver;
import AdminPackage.ManageDrivers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ManageDriversFrame extends javax.swing.JFrame {
private ManageDrivers manageDrivers = new ManageDrivers();

    public ManageDriversFrame() {
        initComponents();
        loadDriverIds();
       setupAvailabilityComboBox();
        
    }
    
     private void setupAvailabilityComboBox() {
        AvailabilityComboBox.removeAllItems();
        AvailabilityComboBox.addItem("1 - Not Available");
        AvailabilityComboBox.addItem("0 - Available");
        
    }
     
private void loadDriverIds() {
    DriverIdComboBox.removeAllItems();
    
    // Add "Select an ID" at the first of the combo box
    DriverIdComboBox.addItem("Select an ID");

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT driver_id FROM Driver ORDER BY driver_id ASC");
         ResultSet rs = stmt.executeQuery()) {

        // Check if data is returned from the query
        if (!rs.isBeforeFirst()) {
            System.out.println("No drivers found in the database.");
        }

        while (rs.next()) {
            // Adding driver ID to combo box
            DriverIdComboBox.addItem(String.valueOf(rs.getInt("driver_id")));
        }

    } catch (SQLException e) {
        // Handle the exception and print stack trace
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading driver IDs from the database", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DriverIdComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        licenceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AvailabilityComboBox = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Drivers");
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Drivers");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Driver ID");

        DriverIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DriverIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DriverIdComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Name");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Licence No.");

        licenceField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        licenceField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Availability");

        AvailabilityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AvailabilityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailabilityComboBoxActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42)
                                .addComponent(DriverIdComboBox, 0, 248, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(licenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(AvailabilityComboBox, 0, 248, Short.MAX_VALUE))))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DriverIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(licenceField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AvailabilityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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

    private void DriverIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DriverIdComboBoxActionPerformed
    String selectedId = (String) DriverIdComboBox.getSelectedItem();
    
    // Check if the selected ID is "Select an ID"
    if (selectedId != null && !selectedId.equals("Select an ID")) {
        int driverId = Integer.parseInt(selectedId);
        
        // Create instance of ManageDrivers
        ManageDrivers manageDrivers = new ManageDrivers();
        
        // Use the instance to call getDriverById
        Driver driver = manageDrivers.getDriverById(driverId);
        
        if (driver != null) {
            // Set values to fields based on driver details
            nameField.setText(driver.getName());
            licenceField.setText(driver.getLicenseNumber());
            // Set the availability combo box according to the value retrieved
            AvailabilityComboBox.setSelectedIndex(driver.isAvailability() ? 0 : 1); // 0 = Available, 1 = Not Available
        } else {
            // Handle case where driver is not found
            JOptionPane.showMessageDialog(this, "Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Handle case where no valid driver is selected
        nameField.setText("");
        licenceField.setText("");
        AvailabilityComboBox.setSelectedIndex(-1); // Reset availability combo box
    }
    }//GEN-LAST:event_DriverIdComboBoxActionPerformed

    private void AvailabilityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailabilityComboBoxActionPerformed

    }//GEN-LAST:event_AvailabilityComboBoxActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
 String selectedId = (String) DriverIdComboBox.getSelectedItem();
    if (selectedId == null) {
        JOptionPane.showMessageDialog(this, "Please select a driver ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int driverId = Integer.parseInt(selectedId);
    String name = nameField.getText().trim();
    String licenseNumber = licenceField.getText().trim();
    int availabilityIndex = AvailabilityComboBox.getSelectedIndex();
    boolean isAvailable = (availabilityIndex == 0); // 0 → Available, 1 → Not Available

    if (name.isEmpty() || licenseNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch driver details from DB
    Driver driver = manageDrivers.getDriverById(driverId);
    if (driver != null) {
        // Update driver details
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driver.setAvailability(isAvailable);
        manageDrivers.updateDriver(driver);

        JOptionPane.showMessageDialog(this, "Driver details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadDriverIds(); // Refresh ComboBox after update
    } else {
        JOptionPane.showMessageDialog(this, "Driver not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvailabilityComboBox;
    private javax.swing.JComboBox<String> DriverIdComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField licenceField;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
