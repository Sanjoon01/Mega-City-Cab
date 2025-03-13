package UIPackage;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ClassPackage.Customer;
import ClassPackage.User;
import ClassPackage.CustomerManager;
import ClassPackage.UserManager;
import ClassPackage.DatabaseConnection;

public class ViewprofileFrame extends javax.swing.JFrame {

    private int customerId; // Customer ID
    private int userId; // Associated User ID
    private int loggedInUserId; // Logged-in user ID
    private CustomerManager customerManager;
    private UserManager userManager;
    private Connection connection;
    private User loggedInUser;

    public ViewprofileFrame(int customerId, int loggedInUserId) {
        initComponents();
        this.customerId = customerId;
        this.loggedInUser = loggedInUser;
        this.loggedInUserId = loggedInUserId; // Initialize loggedInUserId properly
        customerManager = new CustomerManager();
        userManager = new UserManager();
        loggedInUser = getLoggedInUserFromSomewhere();
        connection = DatabaseConnection.getConnection();
        loadCustomerData(customerId);
        fetchUserDetails(userId);
    }

    public int getLoggedInUserId() {
        return loggedInUserId;
    }

    private User getLoggedInUserFromSomewhere() {
        return UserManager.getLoggedInUser();
    }

    private void loadCustomerData(int customerId) {
        Customer customer = customerManager.getCustomerById(customerId);

        if (customer != null) {
            User user = customer.getUser();

            if (user != null) {
                fetchUserDetails(user.getUserId());
            }

            addressField.setText(customer.getAddress());
            TelephoneField.setText(customer.getTelephone());
            nicField.setText(customer.getNic());

            nameField.setEditable(false);
            addressField.setEditable(false);
            TelephoneField.setEditable(false);
            emailField.setEditable(false);
            nicField.setEditable(false);

            this.userId = user.getUserId();
            System.out.println("Associated User ID: " + userId);

            // 🛠 Debugging the profile picture
            byte[] profilePictureBytes = customer.getprofile_picture();
            if (profilePictureBytes != null && profilePictureBytes.length > 0) {
                System.out.println("Retrieved profile picture: Image data present.");
            } else {
                System.out.println("Retrieved profile picture: No image data.");
            }

            if (customer.getprofile_picture() != null) {
                displayProfilePicture(customer.getprofile_picture()); // Pass byte[]
            } else {
                displayProfilePicture((byte[]) null); // Ensures empty image display
            }

        }
    }

    private void fetchUserDetails(int userId) {
        String query = "SELECT name, email FROM users WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Set name and email in the respective fields
                    nameField.setText(rs.getString("name"));
                    emailField.setText(rs.getString("email"));
                }
            } catch (SQLException e) {
                System.out.println("Error while fetching user data: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error preparing statement: " + e.getMessage());
        }
    }

    public void displayProfilePicture(int customerId) {
        String selectQuery = "SELECT profile_picture FROM customer WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(selectQuery)) {

            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    byte[] imgBytes = rs.getBytes("profile_picture");

                    if (imgBytes != null && imgBytes.length > 0) {
                        displayProfilePicture(imgBytes); // Pass byte array
                    } else {
                        System.out.println("No profile picture found in database.");
                        displayProfilePicture((byte[]) null); // Set to default
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayProfilePicture(Object imageSource) {
        if (imageSource instanceof byte[]) { // Case: Image from DB
            byte[] imgBytes = (byte[]) imageSource;

            if (imgBytes != null && imgBytes.length > 0) {
                ImageIcon imageIcon = new ImageIcon(imgBytes);
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(profilePictureLabel.getWidth(), profilePictureLabel.getHeight(), Image.SCALE_SMOOTH);
                profilePictureLabel.setIcon(new ImageIcon(scaledImage));
                profilePictureLabel.setText(""); // Clear label text
                System.out.println("Profile picture loaded from database.");
            } else {
                profilePictureLabel.setText("No Profile Picture");
                profilePictureLabel.setIcon(null);
                System.out.println("No profile picture found in the database.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profilePictureLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TelephoneField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        Editbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - View Profile");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 600));

        profilePictureLabel.setBackground(new java.awt.Color(153, 153, 153));
        profilePictureLabel.setText("No Profile Picture");
        profilePictureLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        profilePictureLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Name");

        emailField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Customer Details");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mobile");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("E-mail");

        TelephoneField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TelephoneField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TelephoneField.setPreferredSize(new java.awt.Dimension(65, 25));
        TelephoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelephoneFieldKeyTyped(evt);
            }
        });

        addressField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressField.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("NIC");

        nicField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Editbtn.setBackground(new java.awt.Color(13, 71, 161));
        Editbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Editbtn.setForeground(new java.awt.Color(255, 255, 255));
        Editbtn.setText("Edit");
        Editbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Editbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Editbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TelephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39)
                .addComponent(Editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TelephoneFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelephoneFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TelephoneFieldKeyTyped

    private void EditbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditbtnActionPerformed
        User loggedInUser = UserManager.getLoggedInUser(); // Fetch logged-in user
        EditFrame editFrame = new EditFrame(customerId, loggedInUser.getUserId(), loggedInUser.getUserId());
        editFrame.setVisible(true);
        editFrame.pack();
        editFrame.setLocationRelativeTo(null);
       this.dispose();

        editFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadCustomerData(customerId);
            }
        });
    }//GEN-LAST:event_EditbtnActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editbtn;
    private javax.swing.JTextField TelephoneField;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nicField;
    private javax.swing.JLabel profilePictureLabel;
    // End of variables declaration//GEN-END:variables
}
