package AdminUIPackage;

import AdminPackage.Admin;
import AdminPackage.AdminManager;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ManageInfoFrame extends javax.swing.JFrame {

    public ManageInfoFrame() {
        initComponents();
        addUsernameValidation();
        addEmailValidation();
        addPasswordValidation();
        loadAdminData(); 

    }
    
    private void loadAdminData() {
    AdminManager adminManager = new AdminManager();
    List<Admin> admins = adminManager.getAllAdmins(); 

    if (!admins.isEmpty()) {
        Admin admin = admins.get(0); // Assuming only one admin (modify if needed)

        nameField.setText(admin.getUsername());
        emailField.setText(admin.getEmail());
        passwordField.setText(admin.getPassword());

    } else {
        JOptionPane.showMessageDialog(this, "No admin data found.", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}

private void addUsernameValidation() {
        nameValidationLabel.setVisible(false);

        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateUsername();
            }
        });
    }

    private void validateUsername() {
        String username = nameField.getText().trim();
        String usernamePattern = "^(?!.*[_.\\s]{2})(?![_\\.\\s])[a-zA-Z0-9 ._]{4,20}(?<![_\\.\\s])$";

        if (username.isEmpty()) {
            nameValidationLabel.setVisible(false);
        } else if (!Pattern.matches(usernamePattern, username)) {
            nameValidationLabel.setText("Invalid username! (4-20 chars, letters, numbers, space, _ , . only!)");
            nameValidationLabel.setVisible(true);
        } else {
            nameValidationLabel.setVisible(false);
        }
    }
    
    private void addEmailValidation() {
        emailValidationLabel.setVisible(false);

        emailField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
        });
    }

    private void validateEmail() {
        String email = emailField.getText().trim();
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+(com|net|org)$";

        if (email.isEmpty()) {
            emailValidationLabel.setVisible(false);
        } else if (!Pattern.matches(emailPattern, email)) {
            emailValidationLabel.setText("Enter a valid email address (example@gmail.com)");
            emailValidationLabel.setVisible(true);
        } else {
            emailValidationLabel.setVisible(false);
        }
    }

    private void addPasswordValidation() {

        passwordValidationLabel.setVisible(false);

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePasswordValidation();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePasswordValidation();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePasswordValidation();
            }
        });
    }

    private void updatePasswordValidation() {
        String passwordText = new String(passwordField.getPassword()).trim();

        if (passwordText.isEmpty()) {
            passwordValidationLabel.setVisible(false);
        } else {
            passwordValidationLabel.setVisible(true);
        }

        boolean hasLength = passwordText.length() >= 8;
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(passwordText).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(passwordText).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(passwordText).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(passwordText).find();

        String validationText = "<html>"
                + "<font color='" + (hasLength ? "green" : "red") + "'>• At least 8 characters</font><br>"
                + "<font color='" + (hasUppercase ? "green" : "red") + "'>• At least one uppercase letter (A-Z)</font><br>"
                + "<font color='" + (hasLowercase ? "green" : "red") + "'>• At least one lowercase letter (a-z)</font><br>"
                + "<font color='" + (hasNumber ? "green" : "red") + "'>• At least one number (0-9)</font><br>"
                + "<font color='" + (hasSpecial ? "green" : "red") + "'>• At least one special character (!@#$%^&*)</font><br>"
                + "</html>";

        passwordValidationLabel.setText(validationText);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        nameValidationLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        emailValidationLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordValidationLabel = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        ShowPassword1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Manage Info");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Info");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("E-Mail");

        emailField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailField.setPreferredSize(new java.awt.Dimension(65, 25));

        nameValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("User Name");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setPreferredSize(new java.awt.Dimension(65, 25));

        emailValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Password");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
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

        ShowPassword1.setBackground(new java.awt.Color(255, 255, 255));
        ShowPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ShowPassword1.setText("Show Password");
        ShowPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassword1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(emailValidationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowPassword1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameValidationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nameValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPassword1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    int adminId = AdminManager.getLoggedInAdminId(); // Get logged-in admin ID
    if (adminId == -1) {
        JOptionPane.showMessageDialog(this, "No admin is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String newUsername = nameField.getText().trim();
    String newPassword = new String(passwordField.getPassword()).trim();
    String newEmail = emailField.getText().trim();

    // Validate inputs
    if (newUsername.isEmpty() || newPassword.isEmpty() || newEmail.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled!", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    AdminManager adminManager = new AdminManager();

    // Check for duplicates
    if (adminManager.isUsernameTaken(newUsername)) {
        JOptionPane.showMessageDialog(this, "This username is already taken. Please choose another.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (adminManager.isPasswordTaken(newPassword)) {
        JOptionPane.showMessageDialog(this, "This password is already in use. Choose a different one.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (adminManager.isEmailTaken(newEmail)) {
        JOptionPane.showMessageDialog(this, "This email is already registered. Use another email.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Call the update method
    boolean success = adminManager.updateAdminInfo(adminId, newUsername, newPassword, newEmail);

    if (success) {
        JOptionPane.showMessageDialog(this, "Admin info updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to update admin info!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void ShowPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassword1ActionPerformed
        if (ShowPassword1.isSelected()) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('\u2022'); // Hide password
        }
    }//GEN-LAST:event_ShowPassword1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ShowPassword1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailValidationLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameValidationLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordValidationLabel;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
