package AdminUIPackage;

import AdminPackage.ManageVehicle;
import ClassPackage.Car;
import ClassPackage.DatabaseConnection;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageVehicleFrame extends javax.swing.JFrame {

    public ManageVehicleFrame() {
        initComponents();
        loadCarIds();
        setupAvailabilityComboBox();
    }

    private void setupAvailabilityComboBox() {
        AvailabilityComboBox.removeAllItems();
        AvailabilityComboBox.addItem("1 - Not Available");
        AvailabilityComboBox.addItem("0 - Available");
    }

    private void loadCarIds() {
        VehicledComboBox.removeAllItems();

        // Add "Select an ID" at the first of the combo box
        VehicledComboBox.addItem("Select an ID");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT car_id FROM Car ORDER BY car_id ASC"); ResultSet rs = stmt.executeQuery()) {

            // Check if data is returned from the query
            if (!rs.isBeforeFirst()) {
                System.out.println("No cars found in the database.");
            }

            while (rs.next()) {
                // Adding car ID to combo box
                VehicledComboBox.addItem(String.valueOf(rs.getInt("car_id")));
            }

        } catch (SQLException e) {
            // Handle the exception and print stack trace
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading car IDs from the database", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VehicledComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        regnoField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modelField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AvailabilityComboBox = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Vehicle");
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Vehicle");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Vehicle ID");

        VehicledComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        VehicledComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehicledComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Reg No.");

        regnoField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regnoField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Model");

        modelField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelField.setPreferredSize(new java.awt.Dimension(65, 25));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VehicledComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(regnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AvailabilityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(VehicledComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AvailabilityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void VehicledComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehicledComboBoxActionPerformed
        String selectedId = (String) VehicledComboBox.getSelectedItem();

        // Check if the selected ID is "Select an ID"
        if (selectedId != null && !selectedId.equals("Select an ID")) {
            int carId = Integer.parseInt(selectedId);

            // Create instance of ManageVehicle
            ManageVehicle manageVehicle = new ManageVehicle();

            // Use the instance to call getCarById
            Car car = manageVehicle.getCarById(carId);

            if (car != null) {
                // Set values to fields based on car details
                modelField.setText(car.getModel());
                regnoField.setText(car.getRegistrationNumber());
                // Set the availability combo box according to the value retrieved
                AvailabilityComboBox.setSelectedIndex(car.isAvailability() ? 0 : 1); // 0 = Available, 1 = Not Available
            } else {
                // Handle case where car is not found
                JOptionPane.showMessageDialog(this, "Car not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle case where no valid car is selected
            modelField.setText("");
            regnoField.setText("");
            AvailabilityComboBox.setSelectedIndex(-1); // Reset availability combo box
        }
    }//GEN-LAST:event_VehicledComboBoxActionPerformed

    private void AvailabilityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailabilityComboBoxActionPerformed

    }//GEN-LAST:event_AvailabilityComboBoxActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
       String selectedId = (String) VehicledComboBox.getSelectedItem();
    if (selectedId == null) {
        JOptionPane.showMessageDialog(this, "Please select a car ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int carId = Integer.parseInt(selectedId);
    String model = modelField.getText().trim();
    String regNumber = regnoField.getText().trim();
    int availabilityIndex = AvailabilityComboBox.getSelectedIndex();
    boolean isAvailable = (availabilityIndex == 0); // 0 → Available, 1 → Not Available

    if (model.isEmpty() || regNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Create an instance of ManageVehicle
    ManageVehicle manageVehicle = new ManageVehicle();

    // Fetch car details from DB
    Car car = manageVehicle.getCarById(carId);
    if (car != null) {
        // Update car details
        car.setModel(model);
        car.setRegistrationNumber(regNumber);
        car.setAvailability(isAvailable);
        manageVehicle.updateCar(car);

        JOptionPane.showMessageDialog(this, "Car details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        loadCarIds(); // Refresh ComboBox after update
    } else {
        JOptionPane.showMessageDialog(this, "Car not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvailabilityComboBox;
    private javax.swing.JComboBox<String> VehicledComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField modelField;
    private javax.swing.JTextField regnoField;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
