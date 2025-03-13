package UIPackage;

import ClassPackage.SearchWithPopup;

public class AddstopsFrame extends javax.swing.JFrame {

    private int stopCount = 0;
    private SearchWithPopup searchWithPopup;
    private BookingFrame bookingFrame;

    public AddstopsFrame(BookingFrame bookingFrame) {
        initComponents();

        this.bookingFrame = bookingFrame;

        stopField1.setText(bookingFrame.getStop1());
        stopField2.setText(bookingFrame.getStop2());
        stopField3.setText(bookingFrame.getStop3());

        searchWithPopup = new SearchWithPopup(stopField1);
        searchWithPopup = new SearchWithPopup(stopField2);
        searchWithPopup = new SearchWithPopup(stopField3);

    }

    public int getStopCount() {
        return stopCount;
    }
    
    public String[] getStops() {
    return new String[]{
        stopField1.getText().trim(),
        stopField2.getText().trim(),
        stopField3.getText().trim()
    };
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stopField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        stopField2 = new javax.swing.JTextField();
        stopField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Confirmbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Add Stops");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Add Stops");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Stop 1");

        stopField1.setPreferredSize(new java.awt.Dimension(65, 25));
        stopField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stopField1KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Stop 2");

        stopField2.setPreferredSize(new java.awt.Dimension(65, 25));
        stopField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stopField2KeyReleased(evt);
            }
        });

        stopField3.setPreferredSize(new java.awt.Dimension(65, 25));
        stopField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stopField3KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Stop 3");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("*You can spend up to 5 Minutes at a stop ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("*If time exceeded standard waiting charges will apply");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(stopField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stopField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stopField3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(stopField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stopField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stopField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(39, 39, 39))
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

    private void stopField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stopField1KeyReleased
        searchWithPopup.showSuggestions();
    }//GEN-LAST:event_stopField1KeyReleased

    private void stopField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stopField2KeyReleased
        searchWithPopup.showSuggestions();
    }//GEN-LAST:event_stopField2KeyReleased

    private void stopField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stopField3KeyReleased
        searchWithPopup.showSuggestions();
    }//GEN-LAST:event_stopField3KeyReleased

    private void ConfirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmbtnActionPerformed
       int stopCount = 0; 
    if (!stopField1.getText().trim().isEmpty()) stopCount++;
    if (!stopField2.getText().trim().isEmpty()) stopCount++;
    if (!stopField3.getText().trim().isEmpty()) stopCount++;

    if (bookingFrame != null) { 
        String[] stops = getStops(); 
        bookingFrame.updateStops(stops, stopCount); // Send stops to BookingFrame

        // Store the stops in BookingFrame
        bookingFrame.setStop1(stops[0]); 
        bookingFrame.setStop2(stops[1]); 
        bookingFrame.setStop3(stops[2]); 
    } else {
        System.out.println("Error: BookingFrame reference is null!");
    }

    this.dispose(); // Close AddstopsFrame
    }//GEN-LAST:event_ConfirmbtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField stopField1;
    private javax.swing.JTextField stopField2;
    private javax.swing.JTextField stopField3;
    // End of variables declaration//GEN-END:variables
}
