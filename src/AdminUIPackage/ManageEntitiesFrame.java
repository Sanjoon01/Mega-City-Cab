package AdminUIPackage;

public class ManageEntitiesFrame extends javax.swing.JFrame {

    public ManageEntitiesFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Manageusersbtn = new javax.swing.JButton();
        Managevehiclebtn = new javax.swing.JButton();
        Managedriversebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Entities");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Hello!");

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("Admin");
        userLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userLabel.setPreferredSize(new java.awt.Dimension(250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Please Choose an Option");

        Manageusersbtn.setBackground(new java.awt.Color(13, 71, 161));
        Manageusersbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Manageusersbtn.setForeground(new java.awt.Color(255, 255, 255));
        Manageusersbtn.setText("Manage Users");
        Manageusersbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Manageusersbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Manageusersbtn.setPreferredSize(new java.awt.Dimension(130, 25));
        Manageusersbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageusersbtnActionPerformed(evt);
            }
        });

        Managevehiclebtn.setBackground(new java.awt.Color(13, 71, 161));
        Managevehiclebtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Managevehiclebtn.setForeground(new java.awt.Color(255, 255, 255));
        Managevehiclebtn.setText("Manage Vehicle");
        Managevehiclebtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Managevehiclebtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Managevehiclebtn.setPreferredSize(new java.awt.Dimension(130, 25));
        Managevehiclebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagevehiclebtnActionPerformed(evt);
            }
        });

        Managedriversebtn.setBackground(new java.awt.Color(13, 71, 161));
        Managedriversebtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Managedriversebtn.setForeground(new java.awt.Color(255, 255, 255));
        Managedriversebtn.setText("Manage Drivers");
        Managedriversebtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Managedriversebtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Managedriversebtn.setPreferredSize(new java.awt.Dimension(130, 25));
        Managedriversebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagedriversebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Managedriversebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Managevehiclebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Manageusersbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(Manageusersbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Managedriversebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Managevehiclebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
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

    private void ManageusersbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageusersbtnActionPerformed
        ManageUserFrame manageuser = new ManageUserFrame(); // Pass 0 as customerId since it's missing
        manageuser.setVisible(true);
        manageuser.pack();
        manageuser.setLocationRelativeTo(null);
    }//GEN-LAST:event_ManageusersbtnActionPerformed

    private void ManagevehiclebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagevehiclebtnActionPerformed
        AddVehicleFrame addvehicle = new  AddVehicleFrame();// Pass 0 as customerId since it's missing
        addvehicle.setVisible(true);
        addvehicle.pack();
       addvehicle.setLocationRelativeTo(null);
    }//GEN-LAST:event_ManagevehiclebtnActionPerformed

    private void ManagedriversebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagedriversebtnActionPerformed
        AddDriversFrame adddrivers = new AddDriversFrame ();// Pass 0 as customerId since it's missing
        adddrivers.setVisible(true);
        adddrivers.pack();
        adddrivers.setLocationRelativeTo(null);
    }//GEN-LAST:event_ManagedriversebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Managedriversebtn;
    private javax.swing.JButton Manageusersbtn;
    private javax.swing.JButton Managevehiclebtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
