
package UIPackage;

import ClassPackage.Bill;
import ClassPackage.Booking;
import ClassPackage.BookingManager;
import UIPackage.ViewStopsFrame;
import java.util.List;


public class ViewReceiptFrame extends javax.swing.JFrame {
    
 private Booking booking;
   
    public ViewReceiptFrame(Bill bill, Booking booking) {
        initComponents();
        this.booking = booking;
        loadBillDetails(bill);
    }
    
    
  private void loadBillDetails(Bill bill) {
    basefareField.setEditable(false);  
    noofstopsField.setEditable(false);  
    stopschargeField.setEditable(false); 
    taxrateField.setEditable(false); 
    taxamountField.setEditable(false);  
    discountField.setEditable(false);  
    totalField.setEditable(false);  

    basefareField.setText(String.format("%.2f LKR", bill.getBaseFare()));
    noofstopsField.setText(String.valueOf(bill.getNumberOfStops()));
    stopschargeField.setText(String.format("%.2f LKR", bill.getTotalStopCharges()));
    taxrateField.setText(String.format("%.2f%%", bill.getTaxRate()));
    taxamountField.setText(String.format("%.2f LKR", bill.getTaxAmount()));
    discountField.setText(String.format("%.2f LKR", bill.getDiscountAmount()));
    totalField.setText(String.format("%.2f LKR", bill.getTotalAmount()));
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        basefareField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        noofstopsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        taxrateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        stopschargeField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        taxamountField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        stopsbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - View Receipt");
        setPreferredSize(new java.awt.Dimension(400, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 650));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Receipt Details");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Base Fare");

        basefareField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        basefareField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("No.of.Stops");

        noofstopsField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noofstopsField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Stops Charge");

        taxrateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taxrateField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tax Rate %");

        stopschargeField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stopschargeField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tax Amount");

        discountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discountField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Discount");

        taxamountField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taxamountField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Total Amount");

        totalField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalField.setPreferredSize(new java.awt.Dimension(65, 25));

        stopsbtn.setBackground(new java.awt.Color(13, 71, 161));
        stopsbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        stopsbtn.setForeground(new java.awt.Color(255, 255, 255));
        stopsbtn.setText("View Stops");
        stopsbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        stopsbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        stopsbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        stopsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopsbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(taxrateField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(stopschargeField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(discountField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(taxamountField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(totalField, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(basefareField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(noofstopsField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stopsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basefareField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(noofstopsField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stopschargeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(taxrateField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(taxamountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(stopsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stopsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopsbtnActionPerformed
   // Retrieve pickup and drop-off from the Booking object
    String pickup = booking.getPickup(); 
    String dropOff = booking.getDrop(); 

    // Fetch stops using BookingManager
    BookingManager bookingManager = new BookingManager();
    List<String> stops = bookingManager.getStopsByBookingId(booking.getBookingId());

    // Assign stops with proper null handling
    String stop1 = stops.size() > 0 ? stops.get(0) : ""; 
    String stop2 = stops.size() > 1 ? stops.get(1) : ""; 
    String stop3 = stops.size() > 2 ? stops.get(2) : ""; 

    // Open ViewStopsFrame
    ViewStopsFrame stopsFrame = new ViewStopsFrame(pickup, dropOff, stop1, stop2, stop3);
    stopsFrame.setVisible(true);
    stopsFrame.pack();
    stopsFrame.setLocationRelativeTo(null); 
    }//GEN-LAST:event_stopsbtnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField basefareField;
    private javax.swing.JTextField discountField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField noofstopsField;
    private javax.swing.JButton stopsbtn;
    private javax.swing.JTextField stopschargeField;
    private javax.swing.JTextField taxamountField;
    private javax.swing.JTextField taxrateField;
    private javax.swing.JTextField totalField;
    // End of variables declaration//GEN-END:variables
}
