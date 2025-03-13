package AdminUIPackage;

import AdminPackage.ManageHelp;
import ClassPackage.Help;
import java.util.List;
import javax.swing.JOptionPane;

public class ManageHelpFrame extends javax.swing.JFrame {

    public ManageHelpFrame() {
        initComponents();
        loadHelpRequests();

        CustomerNameField.setEditable(false);
        BookingIdComboBox.setEditable(false);
        issueComboBox.setEditable(false);
        descriptionTextArea.setEditable(false);

    }

    private void loadHelpRequests() {
        ManageHelp manageHelp = new ManageHelp();
        List<Help> helpList = manageHelp.getHelpRequestsWithCustomerName();

        BookingIdComboBox.removeAllItems();
        HelpIdComboBox.removeAllItems();

        BookingIdComboBox.addItem("Select a Booking ID");
        HelpIdComboBox.addItem("Select a Help ID");

        for (Help help : helpList) {
            BookingIdComboBox.addItem(String.valueOf(help.getBookingId()));
            HelpIdComboBox.addItem(String.valueOf(help.getHelpId()));
        }
    }

    private void loadIssueTopics() {
        if (issueComboBox.getItemCount() == 0) {
            issueComboBox.addItem("Select an Issue Type");
            issueComboBox.addItem("Billing");
            issueComboBox.addItem("Driver Issue");
            issueComboBox.addItem("App Issue");
            issueComboBox.addItem("Other");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CustomerNameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BookingIdComboBox = new javax.swing.JComboBox<>();
        HelpIdComboBox = new javax.swing.JComboBox<>();
        issueComboBox = new javax.swing.JComboBox<>();
        stopLabel4 = new javax.swing.JLabel();
        stopLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        Responsebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Feedback");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Help");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Customer");

        CustomerNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CustomerNameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Booking ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Help ID");

        BookingIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookingIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingIdComboBoxActionPerformed(evt);
            }
        });

        HelpIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        HelpIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpIdComboBoxActionPerformed(evt);
            }
        });

        issueComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        issueComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueComboBoxActionPerformed(evt);
            }
        });

        stopLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel4.setText("Issue");

        stopLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel5.setText("Description");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        Responsebtn.setBackground(new java.awt.Color(13, 71, 161));
        Responsebtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Responsebtn.setForeground(new java.awt.Color(255, 255, 255));
        Responsebtn.setText("Send Response");
        Responsebtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Responsebtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Responsebtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Responsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponsebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stopLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(stopLabel4)
                                    .addGap(58, 58, 58))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(issueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookingIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(HelpIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(Responsebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HelpIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookingIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopLabel4))
                .addGap(26, 26, 26)
                .addComponent(stopLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Responsebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
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
        if (BookingIdComboBox.getSelectedItem() == null) {
            return;
        }

        String selectedItem = (String) BookingIdComboBox.getSelectedItem();

        if (selectedItem.equals("Select a Booking ID")) {
            return;
        }

        try {
            int selectedBookingId = Integer.parseInt(selectedItem);

            ManageHelp manageHelp = new ManageHelp();
            List<Help> helpList = manageHelp.getHelpRequestsWithCustomerName();

            for (Help help : helpList) {
                if (help.getBookingId() == selectedBookingId) {
                    CustomerNameField.setText(help.getCustomerName());
                    issueComboBox.setSelectedItem(help.getCategory());
                    descriptionTextArea.setText(help.getDescription());
                    HelpIdComboBox.setSelectedItem(String.valueOf(help.getHelpId()));
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid Booking ID format: " + selectedItem);
        }
    }//GEN-LAST:event_BookingIdComboBoxActionPerformed

    private void HelpIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpIdComboBoxActionPerformed
        if (HelpIdComboBox.getItemCount() == 0 || "Select a Help ID".equals(HelpIdComboBox.getSelectedItem())) {
            loadIssueTopics();

            CustomerNameField.setText("");

            if (BookingIdComboBox.getItemCount() > 0) {
                BookingIdComboBox.setSelectedIndex(0);
            }

            if (issueComboBox.getItemCount() > 0) {
                issueComboBox.setSelectedIndex(0);
            }

            descriptionTextArea.setText("");
            return;
        }

        int selectedHelpId = Integer.parseInt((String) HelpIdComboBox.getSelectedItem());

        ManageHelp manageHelp = new ManageHelp();
        List<Help> helpList = manageHelp.getHelpRequestsWithCustomerName();

        for (Help help : helpList) {
            if (help.getHelpId() == selectedHelpId) {
                CustomerNameField.setText(help.getCustomerName());
                BookingIdComboBox.setSelectedItem(String.valueOf(help.getBookingId()));

                loadIssueTopics();

                String category = help.getCategory();
                boolean found = false;

                for (int i = 0; i < issueComboBox.getItemCount(); i++) {
                    if (issueComboBox.getItemAt(i).equals(category)) {
                        issueComboBox.setSelectedItem(category);
                        found = true;
                        break;
                    }
                }

                if (!found && category != null && !category.isEmpty()) {
                    issueComboBox.addItem(category);
                    issueComboBox.setSelectedItem(category);
                }

                descriptionTextArea.setText(help.getDescription());
                break;
            }
        }
    }//GEN-LAST:event_HelpIdComboBoxActionPerformed

    private void issueComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueComboBoxActionPerformed

    }//GEN-LAST:event_issueComboBoxActionPerformed

    private void ResponsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponsebtnActionPerformed
        if (HelpIdComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a Help Request ID!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int selectedHelpId = Integer.parseInt((String) HelpIdComboBox.getSelectedItem());

        ManageHelp manageHelp = new ManageHelp();
        manageHelp.sendHelpResponseEmail(selectedHelpId);

        JOptionPane.showMessageDialog(this, "Response email sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ResponsebtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookingIdComboBox;
    private javax.swing.JTextField CustomerNameField;
    private javax.swing.JComboBox<String> HelpIdComboBox;
    private javax.swing.JButton Responsebtn;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JComboBox<String> issueComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel stopLabel4;
    private javax.swing.JLabel stopLabel5;
    // End of variables declaration//GEN-END:variables
}
