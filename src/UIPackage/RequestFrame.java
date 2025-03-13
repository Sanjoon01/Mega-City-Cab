package UIPackage;

import ClassPackage.CarManager;
import ClassPackage.DriverManager;
import ClassPackage.RequestManager;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class RequestFrame extends javax.swing.JFrame {

    private int loggedInCustomerId;


    public RequestFrame(int customerId) {
        initComponents();

        this.loggedInCustomerId = customerId;

        loadVehicleData();
        loadDriverData();

        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
        timeSpinner.setModel(model);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "hh:mm a");
        timeSpinner.setEditor(timeEditor);

this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
               loadVehicleData();
            }
        });

this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
               loadDriverData();
            }
        });
    }

    private void loadVehicleData() {
        CarManager carManager = new CarManager();
        List<String> cars = carManager.getUnavailableCars(); // Now returns List<String>

        String selectedCar = (String) vehicleComboBox.getSelectedItem();

        vehicleComboBox.removeAllItems();
        vehicleComboBox.addItem("Select a Vehicle");

        for (String car : cars) {
            vehicleComboBox.addItem(car);
        }

        if (selectedCar != null) {
            vehicleComboBox.setSelectedItem(selectedCar);
        }
    }

    private void loadDriverData() {
        DriverManager driverManager = new DriverManager();
        List<String> drivers = driverManager.getUnavailableDrivers(); // Now returns List<String>

        String selectedDriver = (String) driverComboBox.getSelectedItem();

        driverComboBox.removeAllItems();
        driverComboBox.addItem("Select a Driver");

        for (String driver : drivers) {
            driverComboBox.addItem(driver);
        }

        if (selectedDriver != null) {
            driverComboBox.setSelectedItem(selectedDriver);
        }
    }
    
  private int getSelectedCarId() {
    String selectedCarModel = (String) vehicleComboBox.getSelectedItem();
    System.out.println("Selected Car: " + selectedCarModel); // Debugging

    if ("Select a Vehicle".equals(selectedCarModel) || selectedCarModel == null) {
        return -1; // Invalid selection
    }

    int carId = CarManager.getCarIdByModel(selectedCarModel);
    System.out.println("Car ID fetched: " + carId); // Debugging
    return carId;
}

private int getSelectedDriverId() {
    String selectedDriverName = (String) driverComboBox.getSelectedItem();
    System.out.println("Selected Driver: " + selectedDriverName); // Debugging

    if ("Select a Driver".equals(selectedDriverName) || selectedDriverName == null) {
        return -1; // Invalid selection
    }

    int driverId = DriverManager.getDriverIdByName(selectedDriverName);
    System.out.println("Driver ID fetched: " + driverId); // Debugging
    return driverId;
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        stopLabel3 = new javax.swing.JLabel();
        vehicleComboBox = new javax.swing.JComboBox<>();
        stopLabel4 = new javax.swing.JLabel();
        driverComboBox = new javax.swing.JComboBox<>();
        stopLabel1 = new javax.swing.JLabel();
        dateCalender = new com.toedter.calendar.JCalendar();
        stopLabel2 = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();
        Confirmbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Book A Trip");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Request Form");

        stopLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel3.setText("Vehicle");

        vehicleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vehicleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleComboBoxActionPerformed(evt);
            }
        });

        stopLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel4.setText("Driver");

        driverComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        driverComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverComboBoxActionPerformed(evt);
            }
        });

        stopLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel1.setText("Date");

        stopLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel2.setText("Time");

        timeSpinner.setModel(new javax.swing.SpinnerDateModel());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stopLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(stopLabel1)
                                .addComponent(stopLabel4)
                                .addComponent(stopLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(dateCalender, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(stopLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(dateCalender, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel2))
                .addGap(26, 26, 26)
                .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void vehicleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleComboBoxActionPerformed
        loadVehicleData();
    }//GEN-LAST:event_vehicleComboBoxActionPerformed

    private void driverComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverComboBoxActionPerformed
        loadDriverData();
    }//GEN-LAST:event_driverComboBoxActionPerformed

    private void ConfirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmbtnActionPerformed
          if (loggedInCustomerId == 0) {
        System.out.println("Error: No logged-in customer ID found!");
        JOptionPane.showMessageDialog(this, "Error: No logged-in customer ID found!", "Request Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fetch selected vehicle and driver
    int carId = getSelectedCarId();
    int driverId = getSelectedDriverId();

    if (carId == -1 || driverId == -1) {
        JOptionPane.showMessageDialog(this, "Please select a valid car and driver!", "Request Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Get booking date and time from components
    Date bookingDate = dateCalender.getDate(); // Directly using dateCalender like in Booking Frame
    Date bookingTime = (Date) timeSpinner.getValue(); // Directly using timeSpinner

    if (bookingDate == null || bookingTime == null) {
        JOptionPane.showMessageDialog(this, "Please select a valid date and time.", "Request Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Insert request into database
    boolean success = RequestManager.insertRequest(loggedInCustomerId, carId, driverId, new java.sql.Date(bookingDate.getTime()), new java.sql.Time(bookingTime.getTime()));

    if (success) {
        JOptionPane.showMessageDialog(this, "Request submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Failed to submit request.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    this.dispose(); // Close the request frame
    }//GEN-LAST:event_ConfirmbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmbtn;
    private com.toedter.calendar.JCalendar dateCalender;
    private javax.swing.JComboBox<String> driverComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel stopLabel1;
    private javax.swing.JLabel stopLabel2;
    private javax.swing.JLabel stopLabel3;
    private javax.swing.JLabel stopLabel4;
    private javax.swing.JSpinner timeSpinner;
    private javax.swing.JComboBox<String> vehicleComboBox;
    // End of variables declaration//GEN-END:variables
}
