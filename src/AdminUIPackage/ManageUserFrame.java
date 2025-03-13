package AdminUIPackage;

import AdminPackage.ManageUsers;
import ClassPackage.DatabaseConnection;
import ClassPackage.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class ManageUserFrame extends javax.swing.JFrame {

    private ManageUsers manageUsers;

    public ManageUserFrame() {
        initComponents();
        manageUsers = new ManageUsers();
        loadUserIds();
        UserIdComboBox.addActionListener(evt -> UserIdComboBoxActionPerformed(evt));

        nameField.setEditable(false);
        emailField.setEditable(false);
        passwordField.setEditable(false);
    }

    private void loadUserIds() {
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT user_id FROM users"); ResultSet rs = stmt.executeQuery()) {

            java.util.List<Integer> userIds = new java.util.ArrayList<>();

            while (rs.next()) {
                userIds.add(rs.getInt("user_id")); // Store user IDs in a list
            }

            java.util.Collections.sort(userIds); // Sort the user IDs in ascending order

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Select a user ID"); // Add placeholder as the first item

            for (int id : userIds) {
                model.addElement(String.valueOf(id)); // Add sorted user IDs
            }

            UserIdComboBox.setModel(model); // Set the model to ComboBox
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UserIdComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        ShowPassword1 = new javax.swing.JCheckBox();
        deactivateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Users");
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Users");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("User ID");

        UserIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UserIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIdComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("E-Mail");

        emailField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("User Name");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Password");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        ShowPassword1.setBackground(new java.awt.Color(255, 255, 255));
        ShowPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ShowPassword1.setText("Show Password");
        ShowPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassword1ActionPerformed(evt);
            }
        });

        deactivateBtn.setBackground(new java.awt.Color(13, 71, 161));
        deactivateBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deactivateBtn.setForeground(new java.awt.Color(255, 255, 255));
        deactivateBtn.setText("Deactivate");
        deactivateBtn.setMaximumSize(new java.awt.Dimension(125, 25));
        deactivateBtn.setMinimumSize(new java.awt.Dimension(125, 25));
        deactivateBtn.setPreferredSize(new java.awt.Dimension(130, 25));
        deactivateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(deactivateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ShowPassword1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(UserIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(26, 26, 26)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(UserIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(ShowPassword1)
                .addGap(75, 75, 75)
                .addComponent(deactivateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
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

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed

    }//GEN-LAST:event_passwordFieldActionPerformed

    private void ShowPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassword1ActionPerformed
        if (ShowPassword1.isSelected()) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('\u2022'); // Hide password
        }
    }//GEN-LAST:event_ShowPassword1ActionPerformed

    private void deactivateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateBtnActionPerformed
        String selectedUserIdStr = (String) UserIdComboBox.getSelectedItem();

        if (selectedUserIdStr != null) {
            try {
                int userId = Integer.parseInt(selectedUserIdStr);

                int confirm = javax.swing.JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to deactivate this user?",
                        "Confirm Deactivation",
                        javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    boolean success = manageUsers.deactivateUser(userId);

                    if (success) {
                        javax.swing.JOptionPane.showMessageDialog(this, "User deactivated successfully!");
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Failed to deactivate user.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid user ID format.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a user ID.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deactivateBtnActionPerformed

    private void UserIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIdComboBoxActionPerformed
        Object selectedItem = UserIdComboBox.getSelectedItem(); // Get selected item safely

        if (selectedItem != null) {
            String selectedUserIdStr = selectedItem.toString().trim(); // Convert to string safely

            if (!selectedUserIdStr.equals("Select a user ID")) {
                try {
                    int selectedUserId = Integer.parseInt(selectedUserIdStr); // Convert to Integer
                    User user = manageUsers.getUserById(selectedUserId); // Fetch user details

                    if (user != null) {
                        nameField.setText(user.getName()); // Populate nameField
                        emailField.setText(user.getEmail()); // Populate emailField
                        passwordField.setText(user.getPassword()); // Populate passwordField
                    } else {
                        System.out.println("User not found.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid user ID format: " + selectedUserIdStr);
                }
            } else {
                // Clear fields when "Select a user ID" is chosen
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        }
    }//GEN-LAST:event_UserIdComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JCheckBox ShowPassword1;
    private javax.swing.JComboBox<String> UserIdComboBox;
    private javax.swing.JButton deactivateBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
