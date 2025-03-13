package UIPackage;

import ClassPackage.DatabaseConnection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import ClassPackage.ForgetPasswordManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PasswordResetFrame extends javax.swing.JFrame {

    private final ForgetPasswordManager passwordManager = new ForgetPasswordManager();
    private String userEmail; // Stores the user email after validation

    public PasswordResetFrame() {
        initComponents();
        addEmailValidation();
        addPasswordValidation();

        pinLabel.setVisible(false);
        pinField.setVisible(false);
        Submitbtn.setVisible(false);
        NewpwLabel.setVisible(false);
        passwordField.setVisible(false);
        resetBtn.setVisible(false);
        emailValidationLabel.setVisible(false);
        passwordValidationLabel.setVisible(false);
        ShowPassword.setVisible(false);
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailValidationLabel = new javax.swing.JLabel();
        Submitbtn = new javax.swing.JButton();
        pinLabel = new javax.swing.JLabel();
        pinField = new javax.swing.JTextField();
        Sendpinbtn = new javax.swing.JButton();
        NewpwLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordValidationLabel = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();
        ShowPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega City Cab - Password Reset");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resetpassword.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("Password Reset");

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email");

        emailValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        Submitbtn.setBackground(new java.awt.Color(13, 71, 161));
        Submitbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });

        pinLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pinLabel.setText("Enter the PIN");

        pinField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pinField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pinField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pinFieldKeyTyped(evt);
            }
        });

        Sendpinbtn.setBackground(new java.awt.Color(13, 71, 161));
        Sendpinbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Sendpinbtn.setForeground(new java.awt.Color(255, 255, 255));
        Sendpinbtn.setText("Send Pin");
        Sendpinbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendpinbtnActionPerformed(evt);
            }
        });

        NewpwLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NewpwLabel.setText("New Password");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        resetBtn.setBackground(new java.awt.Color(13, 71, 161));
        resetBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        ShowPassword.setBackground(new java.awt.Color(255, 255, 255));
        ShowPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ShowPassword.setText("Show Password");
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pinLabel)
                        .addGap(18, 18, 18)
                        .addComponent(pinField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewpwLabel)
                            .addComponent(emailLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(Sendpinbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ShowPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sendpinbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinLabel)
                    .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(NewpwLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShowPassword)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void addEmailValidation() {
        emailValidationLabel.setVisible(false);

        emailTextField.getDocument().addDocumentListener(new DocumentListener() {
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
        String email = emailTextField.getText().trim();

        if (email.isEmpty()) {
            emailValidationLabel.setVisible(false);
        } else if (!isValidEmail(email)) {
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
            return;
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
        passwordValidationLabel.setVisible(true);
    }


    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
        String userPin = pinField.getText().trim();

        if (passwordManager.verifyPin(userEmail, userPin)) {
            pinField.setEditable(false);
            Submitbtn.setEnabled(false);

            NewpwLabel.setVisible(true);
            passwordField.setVisible(true);
            resetBtn.setVisible(true);
            ShowPassword.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect PIN. Please try again.");
        }
    }//GEN-LAST:event_SubmitbtnActionPerformed

    private void SendpinbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendpinbtnActionPerformed
        userEmail = emailTextField.getText().trim();

        if (isValidEmail(userEmail)) {
            if (checkEmailExists(userEmail)) {
                passwordManager.sendResetPin(userEmail);

                emailTextField.setEditable(false);
                Sendpinbtn.setEnabled(false);
                emailValidationLabel.setVisible(false);

                pinLabel.setVisible(true);
                pinField.setVisible(true);
                Submitbtn.setVisible(true);
            } else {
                emailValidationLabel.setText("Email not registered. Please sign up.");
                emailValidationLabel.setVisible(true);
            }
        } else {
            emailValidationLabel.setText("Invalid email format.");
            emailValidationLabel.setVisible(true);
        }
    }//GEN-LAST:event_SendpinbtnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        String newPassword = new String(passwordField.getPassword());

        if (isValidPassword(newPassword)) {
            if (passwordManager.resetPassword(userEmail, newPassword)) {
                JOptionPane.showMessageDialog(this, "Password reset successful! You can now log in.");

                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                login.pack();
                login.setLocationRelativeTo(null);

                resetBtn.setEnabled(false);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error resetting password. Try again.");
            }
        } else {
            passwordValidationLabel.setText("Password must meet all security criteria.");
            passwordValidationLabel.setVisible(true);
            ShowPassword.setVisible(true);
        }

    }//GEN-LAST:event_resetBtnActionPerformed

    private void pinFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pinFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || pinField.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_pinFieldKeyTyped

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        if (ShowPassword.isSelected()) {

            passwordField.setEchoChar((char) 0);
        } else {

            passwordField.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_ShowPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordResetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordResetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordResetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordResetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordResetFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NewpwLabel;
    private javax.swing.JButton Sendpinbtn;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JButton Submitbtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel emailValidationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordValidationLabel;
    private javax.swing.JTextField pinField;
    private javax.swing.JLabel pinLabel;
    private javax.swing.JButton resetBtn;
    // End of variables declaration//GEN-END:variables

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+(com|net|org)$";
        return email.matches(emailPattern);
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }

        boolean hasLength = password.length() >= 8;
        boolean hasUppercase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowercase = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();

        return hasLength && hasUppercase && hasLowercase && hasNumber && hasSpecial;
    }

    private boolean checkEmailExists(String email) {
        String query = "SELECT email FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
