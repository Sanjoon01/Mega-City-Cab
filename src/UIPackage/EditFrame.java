package UIPackage;

import java.awt.Image;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import javax.swing.ImageIcon;
import ClassPackage.UserManager;
import ClassPackage.Customer;
import ClassPackage.CustomerManager;
import ClassPackage.DatabaseConnection;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditFrame extends javax.swing.JFrame {

    private int customerId;
    private int userId;
    private int loggedInUserId;
    private Connection connection;
    private String selectedImagePath;
    private CustomerManager customerManager;
    private String profilePicturePath = null;
    private Customer customer;  // Ensure this is properly initialized
    private File selectedImageFile = null;

    public EditFrame(int customerId, int userId, int loggedInUserId) {
        initComponents();
        this.customerId = customerId;
        this.customer = new Customer();
        this.userId = userId;  // Debugging line: print userId
        this.loggedInUserId = loggedInUserId;
        customerManager = new CustomerManager();
        connection = DatabaseConnection.getConnection();

        System.out.println("EditFrame initialized with userId: " + userId);  // Debugging line

        loadCustomerData(customerId);
        fetchUserDetails(userId);
        addUsernameValidation();
        addEmailValidation();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // </editor-fold>


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


    public int getLoggedInUserId() {
        return loggedInUserId;
    }

    private void loadCustomerData(int customerId) {
        Customer customer = customerManager.getCustomerById(customerId);

        if (customer != null) {
            // Set customer details
            addressField.setText(customer.getAddress());
            TelephoneField.setText(customer.getTelephone());
            nicField.setText(customer.getNic());

            nameField.setEditable(false);
            emailField.setEditable(false);

            updateUploadButtonText();

            byte[] profilePicture = customer.getprofile_picture(); // Assuming getProfilePicture() returns byte[]

            if (profilePicture != null && profilePicture.length > 0) {
                displayProfilePicture(profilePicture); // ✅ Call the correct method for byte[]
            } else {
                // Handle case where no profile picture is present
                profilePictureLabel.setIcon(null); // Clear the image
                profilePictureLabel.setText("No Profile Picture"); // Show default text
            }
        }
    }

    private void fetchUserDetails(int userId) {
        System.out.println("Fetching user details for userId: " + userId);  // Debugging line

        String query = "SELECT name, email FROM users WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));

                    // Make name and email fields non-editable
                    nameField.setEditable(false);
                    emailField.setEditable(false);
                } else {
                    System.out.println("User not found in database for userId: " + userId);  // Debugging line
                }
            } catch (SQLException e) {
                System.out.println("Error fetching user data: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error preparing statement: " + e.getMessage());
        }
    }

    /**
     *
     * @param customerId
     */
    private void updateUploadButtonText() {
        // Check if there is an image set in the profilePictureLabel
        if (profilePictureLabel.getIcon() != null) {
            // If the label has an icon (image), set the button text to "Remove"
            uploadBtn.setText("Remove");
        } else {
            // If the label does not have an icon (image), set the button text to "Upload"
            uploadBtn.setText("Upload");
        }

        // Ensure the button text is updated visually
        uploadBtn.revalidate();
        uploadBtn.repaint();
    }

    private void displayProfilePicture(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);

        // Resize image to fit label
        Image img = icon.getImage().getScaledInstance(profilePictureLabel.getWidth(), profilePictureLabel.getHeight(), Image.SCALE_SMOOTH);
        profilePictureLabel.setIcon(new ImageIcon(img));

        // Remove "No Profile Picture" text
        profilePictureLabel.setText("");
    }

    private void displayProfilePicture(byte[] imageData) {
        if (imageData != null && imageData.length > 0) {
            ImageIcon icon = new ImageIcon(imageData);

            // Resize image to fit label
            Image img = icon.getImage().getScaledInstance(profilePictureLabel.getWidth(), profilePictureLabel.getHeight(), Image.SCALE_SMOOTH);
            profilePictureLabel.setIcon(new ImageIcon(img));

            // Remove "No Profile Picture" text
            profilePictureLabel.setText("");
        } else {
            profilePictureLabel.setIcon(null);
            profilePictureLabel.setText("No Profile Picture");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        profilePictureLabel = new javax.swing.JLabel();
        uploadBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TelephoneField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        nameValidationLabel = new javax.swing.JLabel();
        emailValidationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Edit Profile");
        setPreferredSize(new java.awt.Dimension(400, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 650));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Edit Details");

        profilePictureLabel.setBackground(new java.awt.Color(153, 153, 153));
        profilePictureLabel.setText("No Profile Picture");
        profilePictureLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        profilePictureLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        uploadBtn.setBackground(new java.awt.Color(13, 71, 161));
        uploadBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("Upload");
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");

        addressField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mobile");

        TelephoneField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TelephoneField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TelephoneField.setPreferredSize(new java.awt.Dimension(65, 25));
        TelephoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelephoneFieldKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("E-mail");

        emailField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("NIC");

        nicField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nicField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nicFieldKeyTyped(evt);
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

        nameValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        emailValidationLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uploadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(profilePictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailField)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TelephoneField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameValidationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(nameValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TelephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailValidationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
        if (profilePictureLabel.getIcon() != null) {
            // If an image exists, ask for confirmation to remove
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Do you want to remove the current profile picture?",
                    "Confirm Remove", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Remove the image from profilePictureLabel
                profilePictureLabel.setIcon(null);
                selectedImageFile = null; // Clear the selected image reference

                // Set label text to indicate no profile picture
                profilePictureLabel.setText("No Profile Picture");

                // Update button text
                updateUploadButtonText();
            }
        } else {
            // Open file chooser to select an image
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a Profile Picture");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedImageFile = fileChooser.getSelectedFile(); // Store selected image file

                // Display the selected image in profilePictureLabel
                displayProfilePicture(selectedImageFile.getAbsolutePath());

                // Update button text
                updateUploadButtonText();
            }
        }
    }//GEN-LAST:event_uploadBtnActionPerformed

    private void TelephoneFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelephoneFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || TelephoneField.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_TelephoneFieldKeyTyped

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String newAddress = addressField.getText().trim();
        String newTelephone = TelephoneField.getText().trim();
        String newNic = nicField.getText().trim();

        if (newAddress.isEmpty() || newTelephone.isEmpty() || newNic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserManager userManager = new UserManager();
        int customerId = userManager.getCustomerId(loggedInUserId);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // **Check if NIC already exists for another customer**
            String checkNicQuery = "SELECT customer_id FROM customer WHERE nic = ? AND customer_id <> ?";
            stmt = conn.prepareStatement(checkNicQuery);
            stmt.setString(1, newNic);
            stmt.setInt(2, customerId > 0 ? customerId : -1); // Exclude the current customer if updating
            rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "This NIC already exists. Please use a different one.", "Duplicate NIC", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (customerId <= 0) {
                // INSERT new customer
                String insertCustomerQuery = "INSERT INTO customer (user_id, address, telephone, nic, profile_picture) VALUES (?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(insertCustomerQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, loggedInUserId);
                stmt.setString(2, newAddress);
                stmt.setString(3, newTelephone);
                stmt.setString(4, newNic);

                // If an image was selected, convert it to a byte array
                if (selectedImageFile != null) {
                    byte[] profilePictureData = Files.readAllBytes(selectedImageFile.toPath());
                    stmt.setBytes(5, profilePictureData);
                } else {
                    stmt.setNull(5, Types.BLOB);
                }

                int insertedRows = stmt.executeUpdate();
                if (insertedRows > 0) {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        customerId = generatedKeys.getInt(1);
                    }
                    System.out.println("New customer inserted with ID: " + customerId);
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(this, "Failed to create new customer!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                // UPDATE existing customer
                String updateCustomerQuery = "UPDATE customer SET address = ?, telephone = ?, nic = ?, profile_picture = ? WHERE customer_id = ?";
                stmt = conn.prepareStatement(updateCustomerQuery);
                stmt.setString(1, newAddress);
                stmt.setString(2, newTelephone);
                stmt.setString(3, newNic);

                // If an image was selected, update profile picture
                if (selectedImageFile != null) {
                    byte[] profilePictureData = Files.readAllBytes(selectedImageFile.toPath());
                    stmt.setBytes(4, profilePictureData);
                } else {
                    stmt.setNull(4, Types.BLOB);
                }

                stmt.setInt(5, customerId);

                int customerRowsUpdated = stmt.executeUpdate();
                System.out.println("Customer rows updated: " + customerRowsUpdated);
            }

            conn.commit(); // Commit transaction
            JOptionPane.showMessageDialog(this, "Customer details saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (SQLException | IOException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            // Check if error is due to duplicate NIC constraint
            if (e instanceof SQLIntegrityConstraintViolationException && e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "This NIC already exists. Please use a different one.", "Duplicate NIC", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void nicFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicFieldKeyTyped
        char c = evt.getKeyChar();
        String text = nicField.getText() + c;

        // Allow only numbers (0-9) and 'V' or 'X' (only for 9-digit NICs)
        if (!text.matches("^\\d{0,12}[VXvx]?$")) {
            evt.consume(); // Prevents invalid character entry
        }
    }//GEN-LAST:event_nicFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TelephoneField;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailValidationLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameValidationLabel;
    private javax.swing.JTextField nicField;
    private javax.swing.JLabel profilePictureLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables
}
