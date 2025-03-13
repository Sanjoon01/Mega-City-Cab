package UIPackage;

import ClassPackage.BillManager;
import ClassPackage.Booking;
import ClassPackage.BookingManager;
import ClassPackage.Car;
import ClassPackage.CarManager;
import ClassPackage.CustomerManager;
import ClassPackage.Driver;
import ClassPackage.DriverManager;
import ClassPackage.SearchWithPopup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;


public class BookingFrame extends javax.swing.JFrame {

    private int loggedInCustomerId;

    private SearchWithPopup searchWithPopup;
    private String stop1 = "";
    private String stop2 = "";
    private String stop3 = "";

    private JTextField stopField1;
    private JTextField stopField2;
    private JTextField stopField3;

    public String getStop1() {
        return stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public String getStop3() {
        return stop3;
    }

// Setters
    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public void setStop3(String stop3) {
        this.stop3 = stop3;
    }

    public BookingFrame(int customerId) {
        initComponents();

        this.loggedInCustomerId = customerId;

        stopField1 = new javax.swing.JTextField();
        stopField2 = new javax.swing.JTextField();
        stopField3 = new javax.swing.JTextField();

        loadVehicleData();
        loadDriverData();
        searchWithPopup = new SearchWithPopup(pickupField);
        searchWithPopup = new SearchWithPopup(dropField);

        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
        timeSpinner.setModel(model);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "hh:mm a");
        timeSpinner.setEditor(timeEditor);

        dropField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updatePrice();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                loadVehicleData();
                 loadDriverData();
            }
        });

    }

    private void loadVehicleData() {
        CarManager carManager = new CarManager();
        List<Car> cars = carManager.getAllCars();

        String selectedCar = (String) vehicleComboBox.getSelectedItem();

        vehicleComboBox.removeAllItems();
        vehicleComboBox.addItem("Select a Vehicle");

        for (Car car : cars) {
            vehicleComboBox.addItem(car.getModel());
        }

        if (selectedCar != null) {
            vehicleComboBox.setSelectedItem(selectedCar);
        }
    }

    private void loadDriverData() {
        DriverManager driverManager = new DriverManager();
        List<Driver> drivers = driverManager.getAllDrivers(); // ✅ Now returns a List<Driver>

        // Store the currently selected driver before clearing the combo box
        String selectedDriver = (String) driverComboBox.getSelectedItem();

        driverComboBox.removeAllItems();
        driverComboBox.addItem("Select a Driver");

        for (Driver d : drivers) { // ✅ Use correct variable name
            driverComboBox.addItem(d.getName());
        }

        // Restore previously selected driver
        if (selectedDriver != null) {
            driverComboBox.setSelectedItem(selectedDriver);
        }
    }

    // In BookingFrame:
    private void openAddStopsFrame() {
        AddstopsFrame addstopsFrame = new AddstopsFrame(this); // Pass BookingFrame reference
        addstopsFrame.setVisible(true);
        addstopsFrame.setLocationRelativeTo(this); // Center relative to BookingFrame
    }

    private void updatePrice() {
        double[] priceDetails = calculatePrice(); // Fix: Use double[] to store returned values
        double totalAmount = priceDetails[0]; // Extract total amount from the array
        priceField.setText(String.format("%.2f LKR", totalAmount)); // Format properly
    }

    public void updateStops(String[] stops, int additionalStops) {
        if (stops.length > 0) {
            setStop1(stops[0]);
        }
        if (stops.length > 1) {
            setStop2(stops[1]);
        }
        if (stops.length > 2) {
            setStop3(stops[2]);
        }

        updatePrice();
    }

    public double[] calculatePrice() {
        double basePrice = 1000;
        double additionalBasePrice = 0;
        double taxRate = 0.10;
        double discountRate = 0.02; // 2% discount

        String pickup = pickupField.getText().trim();
        String drop = dropField.getText().trim();

        if (!pickup.isEmpty() && !drop.isEmpty()) {
            additionalBasePrice = 500;
        }

        int additionalStops = 0;
        if (!stop1.isEmpty()) {
            additionalStops++;
        }
        if (!stop2.isEmpty()) {
            additionalStops++;
        }
        if (!stop3.isEmpty()) {
            additionalStops++;
        }

        double subtotal = basePrice + additionalBasePrice + (500 * additionalStops);
        double tax = subtotal * taxRate;
        double discount = (subtotal + tax) * discountRate; // Apply 2% discount
        double netTotal = (subtotal + tax) - discount; // Subtract discount

        return new double[]{netTotal, additionalStops, 500 * additionalStops};
    }

    private int getSelectedCarId() {
        CarManager carManager = new CarManager();
        String selectedCarModel = (String) vehicleComboBox.getSelectedItem();

        if (selectedCarModel == null || selectedCarModel.equals("Select a Vehicle")) {
            System.out.println("Error: No car selected or default option chosen!");
            return -1;
        }

        int carId = carManager.getCarIdByModel(selectedCarModel);
        System.out.println("Selected Car Model: " + selectedCarModel + ", Retrieved Car ID: " + carId);

        return carId;
    }

    private int getSelectedDriverId() {
        DriverManager driverManager = new DriverManager();
        String selectedDriverName = (String) driverComboBox.getSelectedItem();

        if (selectedDriverName == null || selectedDriverName.equals("Select a Driver")) {
            System.out.println("Error: No driver selected or default option chosen!");
            return -1;
        }

        int driverId = driverManager.getDriverIdByName(selectedDriverName);
        System.out.println("Selected Driver Name: " + selectedDriverName + ", Retrieved Driver ID: " + driverId);

        return driverId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pickupField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Addstopbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        stopLabel2 = new javax.swing.JLabel();
        dropField = new javax.swing.JTextField();
        stopLabel1 = new javax.swing.JLabel();
        dateCalender = new com.toedter.calendar.JCalendar();
        Confirmbtn = new javax.swing.JButton();
        timeSpinner = new javax.swing.JSpinner();
        driverComboBox = new javax.swing.JComboBox<>();
        stopLabel3 = new javax.swing.JLabel();
        stopLabel4 = new javax.swing.JLabel();
        vehicleComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Book A Trip");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 730));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Booking Details");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pick up");

        pickupField.setPreferredSize(new java.awt.Dimension(65, 25));
        pickupField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pickupFieldKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Drop");

        Addstopbtn.setBackground(new java.awt.Color(13, 71, 161));
        Addstopbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Addstopbtn.setForeground(new java.awt.Color(255, 255, 255));
        Addstopbtn.setText("Add Stops");
        Addstopbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Addstopbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Addstopbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Addstopbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddstopbtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Price");

        priceField.setPreferredSize(new java.awt.Dimension(65, 25));
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        stopLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel2.setText("Time");

        dropField.setPreferredSize(new java.awt.Dimension(65, 25));
        dropField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dropFieldKeyReleased(evt);
            }
        });

        stopLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel1.setText("Date");

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

        timeSpinner.setModel(new javax.swing.SpinnerDateModel());

        driverComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        driverComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverComboBoxActionPerformed(evt);
            }
        });

        stopLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel3.setText("Vehicle");

        stopLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel4.setText("Driver");

        vehicleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vehicleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(stopLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stopLabel2)
                                    .addComponent(stopLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(stopLabel4)))
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pickupField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                .addComponent(dropField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(dateCalender, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(Addstopbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pickupField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(stopLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Addstopbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateCalender, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(stopLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopLabel3)
                    .addComponent(vehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddstopbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddstopbtnActionPerformed
        openAddStopsFrame();

    }//GEN-LAST:event_AddstopbtnActionPerformed

    private void pickupFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pickupFieldKeyReleased
        searchWithPopup.showSuggestions();
    }//GEN-LAST:event_pickupFieldKeyReleased

    private void dropFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dropFieldKeyReleased
        searchWithPopup.showSuggestions();
    }//GEN-LAST:event_dropFieldKeyReleased

    private void ConfirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmbtnActionPerformed
       if (loggedInCustomerId == 0) {
            JOptionPane.showMessageDialog(this, "No logged-in customer ID found!", "Booking Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DriverManager driverManager = new DriverManager();
        CarManager carManager = new CarManager();
        BookingManager bookingManager = new BookingManager();
        BillManager billManager = new BillManager();
        CustomerManager customerManager = new CustomerManager();

        int carId = getSelectedCarId();
        int driverId = getSelectedDriverId();
        String pickup = pickupField.getText().trim();
        String drop = dropField.getText().trim();
        Date bookingDate = dateCalender.getDate();
        Date bookingTime = (Date) timeSpinner.getValue();

        if (carId == -1 || driverId == -1 || pickup.isEmpty() || drop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a valid car, driver, pickup, and drop location.", "Booking Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int stopCount = (!stop1.isEmpty() ? 1 : 0) + (!stop2.isEmpty() ? 1 : 0) + (!stop3.isEmpty() ? 1 : 0);
        double[] priceDetails = calculatePrice();
        double totalAmount = priceDetails[0];

        Booking booking = new Booking(0, loggedInCustomerId, carId, driverId, pickup, drop, new java.sql.Date(bookingDate.getTime()), new java.sql.Time(bookingTime.getTime()), totalAmount, "Confirmed");
        bookingManager.bookRide(booking, stopCount, 500);

        int bookingId = booking.getBookingId();
        JOptionPane.showMessageDialog(this, "Booking successful! Your Booking ID is: " + bookingId,"Success", JOptionPane.INFORMATION_MESSAGE);
        bookingManager.addStops(bookingId, stop1, stop2, stop3);

        String toEmail = customerManager.getCustomerEmailById(loggedInCustomerId);
        if (toEmail != null && !toEmail.isEmpty()) {
            bookingManager.sendEmailNotification(loggedInCustomerId, toEmail, "Booking Confirmation - Mega City Cab", pickup, drop, stopCount, new java.sql.Date(bookingDate.getTime()), new java.sql.Time(bookingTime.getTime()), totalAmount);
            System.out.println("Email notification sent successfully.");
        } else {
            System.out.println("Error: Customer email not found. Email notification not sent.");
        }
        this.dispose();
    }//GEN-LAST:event_ConfirmbtnActionPerformed

    private void vehicleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleComboBoxActionPerformed
        loadVehicleData();
    }//GEN-LAST:event_vehicleComboBoxActionPerformed

    private void driverComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverComboBoxActionPerformed
        loadDriverData();
    }//GEN-LAST:event_driverComboBoxActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        updatePrice();
    }//GEN-LAST:event_priceFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addstopbtn;
    private javax.swing.JButton Confirmbtn;
    private com.toedter.calendar.JCalendar dateCalender;
    private javax.swing.JComboBox<String> driverComboBox;
    private javax.swing.JTextField dropField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pickupField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel stopLabel1;
    private javax.swing.JLabel stopLabel2;
    private javax.swing.JLabel stopLabel3;
    private javax.swing.JLabel stopLabel4;
    private javax.swing.JSpinner timeSpinner;
    private javax.swing.JComboBox<String> vehicleComboBox;
    // End of variables declaration//GEN-END:variables
}
