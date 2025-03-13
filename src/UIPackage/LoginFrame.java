package UIPackage;

import AdminPackage.Admin;
import AdminPackage.AdminManager;
import AdminUIPackage.AdminDashboardFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.regex.Pattern;
import ClassPackage.UserManager;
import ClassPackage.User;
import javax.swing.*;
import ClassPackage.Customer;
import ClassPackage.CustomerManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.*;

public class LoginFrame extends javax.swing.JFrame {

    private UserManager userManager;
    private String username;
    private int userId;

    public LoginFrame() {
        initComponents();

        userManager = new UserManager();
        addEmailValidation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JPasswordField();
        ShowPassword = new javax.swing.JCheckBox();
        Loginbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        signup = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailValidationLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        resetpasswordLabel = new javax.swing.JLabel();
        userguide = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega City Cab - Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("LOGIN");

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Password");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordLabelActionPerformed(evt);
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

        Loginbtn.setBackground(new java.awt.Color(13, 71, 161));
        Loginbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        Loginbtn.setText("LOGIN");
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("I Don't Have An Account");

        signup.setBackground(new java.awt.Color(13, 71, 161));
        signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signup.setForeground(new java.awt.Color(13, 71, 161));
        signup.setText("Sign Up");
        signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Copyright © 2025 Mega City Cab. All rights reserved.");

        emailValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Forget Your Password?");

        resetpasswordLabel.setBackground(new java.awt.Color(13, 71, 161));
        resetpasswordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resetpasswordLabel.setForeground(new java.awt.Color(13, 71, 161));
        resetpasswordLabel.setText("Reset Password");
        resetpasswordLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetpasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetpasswordLabelMouseClicked(evt);
            }
        });

        userguide.setBackground(new java.awt.Color(13, 71, 161));
        userguide.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userguide.setForeground(new java.awt.Color(13, 71, 161));
        userguide.setText("Download User Guide");
        userguide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userguide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userguideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(Loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signup)))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userguide)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetpasswordLabel))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(passwordLabel)
                                .addComponent(ShowPassword)
                                .addComponent(emailValidationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowPassword)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(resetpasswordLabel))
                .addGap(29, 29, 29)
                .addComponent(Loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(signup))
                .addGap(18, 18, 18)
                .addComponent(userguide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/megacitycab.jpg"))); // NOI18N
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
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

    private void passwordLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLabelActionPerformed

    }//GEN-LAST:event_passwordLabelActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        if (ShowPassword.isSelected()) {

            passwordLabel.setEchoChar((char) 0);
        } else {

            passwordLabel.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        SignupFrame signup = new SignupFrame();
        signup.setVisible(true);
        signup.pack();
        signup.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
        String email = emailTextField.getText().trim();
        String password = new String(passwordLabel.getPassword()).trim();

        AdminManager adminManager = new AdminManager();
        UserManager userManager = new UserManager();

        Admin loggedInAdmin = adminManager.login(email, password);

        if (loggedInAdmin != null) {
            System.out.println("Logged-in Admin ID: " + loggedInAdmin.getAdminId());

            AdminManager.setLoggedInAdminId(loggedInAdmin.getAdminId());

            AdminDashboardFrame adminDashboard = new AdminDashboardFrame(loggedInAdmin.getUsername());
            adminDashboard.setVisible(true);
            adminDashboard.pack();
            adminDashboard.setLocationRelativeTo(null);
            this.dispose();
            return;
        }

        User loggedInUser = (User) userManager.login(email, password);

        if (loggedInUser != null) {
            System.out.println("Logged-in User ID: " + loggedInUser.getUserId());

            CustomerManager customerManager = new CustomerManager();
            Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUser.getUserId());

            DashboardFrame dashboard = new DashboardFrame(loggedInUser.getName(), loggedInCustomer);
            dashboard.setVisible(true);
            dashboard.pack();
            dashboard.setLocationRelativeTo(null);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password or user is deactivated", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginbtnActionPerformed

    private void resetpasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetpasswordLabelMouseClicked
        PasswordResetFrame passwordreset = new PasswordResetFrame();
        passwordreset.setVisible(true);
        passwordreset.pack();
        passwordreset.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_resetpasswordLabelMouseClicked

    private void userguideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userguideMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save User Guide");
        fileChooser.setSelectedFile(new File("Mega City Cab.pdf"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File destinationFile = fileChooser.getSelectedFile();
        File sourceFile = new File("src/resources/Mega City Cab.pdf");

            try {
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(this, "User Guide downloaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error while downloading the file.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_userguideMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
                login.pack();
                login.setLocationRelativeTo(null);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Loginbtn;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel emailValidationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField passwordLabel;
    private javax.swing.JLabel resetpasswordLabel;
    private javax.swing.JLabel signup;
    private javax.swing.JLabel userguide;
    // End of variables declaration//GEN-END:variables
}
