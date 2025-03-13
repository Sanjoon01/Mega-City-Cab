package UIPackage;

import javax.swing.JOptionPane;
import ClassPackage.Customer;
import ClassPackage.User;
import ClassPackage.CustomerManager;
import ClassPackage.UserManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class DashboardFrame extends javax.swing.JFrame {

    private User loggedInUser;
    private Customer loggedInCustomer; // Store logged-in custome
    private String username;
    private int customerId; // ✅ Customer ID
    private int userId; // ✅ Associated User ID
    private int loggedInUserId;

    private JLabel imageLabel;
    private int currentIndex = 0;
    private String[] imageNames = {
        "welcome.jpg",
        "dashboard.jpg",
        "driver.jpg",
        "customer.jpg"

    };

    public DashboardFrame(String username, Customer loggedInCustomer) {
        initComponents();
        this.username = username;
        this.loggedInCustomer = loggedInCustomer;
        displayUsername();
        initSlideshow(); // Initialize slideshow functionality

    }

    public int getLoggedInCustomerId() {
        return loggedInCustomer != null ? loggedInCustomer.getCustomerId() : -1;
    }

    private void displayUsername() {
        usernameLabel.setText(username);
    }

   private void initSlideshow() {
    JPanel slideshowPanel = new JPanel();
    slideshowPanel.setLayout(new BorderLayout());
    
    imageLabel = new JLabel();
    imageLabel.setHorizontalAlignment(JLabel.CENTER);
    slideshowPanel.add(imageLabel, BorderLayout.CENTER);
    
    leftPanel.removeAll(); // Remove existing components
    leftPanel.setLayout(new BorderLayout());
    leftPanel.add(slideshowPanel, BorderLayout.CENTER);
    leftPanel.revalidate();
    leftPanel.repaint();

    Timer timer = new Timer(3000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentIndex = (currentIndex + 1) % imageNames.length;
            updateImage();
        }
    });
    timer.start();
    updateImage();
}


    private void updateImage() {
        // Load image from the Images package
        URL imageUrl = getClass().getResource("/Images/" + imageNames[currentIndex]);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            imageLabel.setIcon(icon);
        } else {
            System.err.println("Image not found: " + imageNames[currentIndex]);
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        Viewbtn = new javax.swing.JButton();
        bookingbtn = new javax.swing.JButton();
        Requestbtn = new javax.swing.JButton();
        Helpbtn = new javax.swing.JButton();
        Feedbackbtn = new javax.swing.JButton();
        Logoutbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega City Cab - Dashboard");
        setResizable(false);

        leftPanel.setBackground(new java.awt.Color(0, 0, 0));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("WELCOME BACK!");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usernameLabel.setPreferredSize(new java.awt.Dimension(250, 30));

        Viewbtn.setBackground(new java.awt.Color(13, 71, 161));
        Viewbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Viewbtn.setForeground(new java.awt.Color(255, 255, 255));
        Viewbtn.setText("View Profile");
        Viewbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Viewbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Viewbtn.setPreferredSize(new java.awt.Dimension(130, 25));
        Viewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewbtnActionPerformed(evt);
            }
        });

        bookingbtn.setBackground(new java.awt.Color(13, 71, 161));
        bookingbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        bookingbtn.setForeground(new java.awt.Color(255, 255, 255));
        bookingbtn.setText("Book A Trip");
        bookingbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbtnActionPerformed(evt);
            }
        });

        Requestbtn.setBackground(new java.awt.Color(13, 71, 161));
        Requestbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Requestbtn.setForeground(new java.awt.Color(255, 255, 255));
        Requestbtn.setText("Request");
        Requestbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Requestbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Requestbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Requestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestbtnActionPerformed(evt);
            }
        });

        Helpbtn.setBackground(new java.awt.Color(13, 71, 161));
        Helpbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Helpbtn.setForeground(new java.awt.Color(255, 255, 255));
        Helpbtn.setText("Help");
        Helpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpbtnActionPerformed(evt);
            }
        });

        Feedbackbtn.setBackground(new java.awt.Color(13, 71, 161));
        Feedbackbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Feedbackbtn.setForeground(new java.awt.Color(255, 255, 255));
        Feedbackbtn.setText("Feed Back");
        Feedbackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackbtnActionPerformed(evt);
            }
        });

        Logoutbtn.setBackground(new java.awt.Color(13, 71, 161));
        Logoutbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Logoutbtn.setForeground(new java.awt.Color(255, 255, 255));
        Logoutbtn.setText("Logout");
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Designed and Build By @Sanjoon Charles");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Requestbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Helpbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Feedbackbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Logoutbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookingbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Viewbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(46, 46, 46))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Viewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Requestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Helpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Feedbackbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ViewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewbtnActionPerformed
        // Fetch the logged-in user
        User loggedInUser = UserManager.getLoggedInUser();

        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loggedInUserId = loggedInUser.getUserId();

        // Retrieve the customer details associated with the logged-in user
        CustomerManager customerManager = new CustomerManager();
        Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUserId);

        if (loggedInCustomer != null) {
            // Open View Profile frame
            ViewprofileFrame viewprofile = new ViewprofileFrame(loggedInCustomer.getCustomerId(), loggedInUserId);
            viewprofile.setVisible(true);
            viewprofile.pack();
            viewprofile.setLocationRelativeTo(null);
        } else {
            // Show dialog if customer details are missing
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Customer details not found. Do you want to enter your details?",
                    "Profile Not Found",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                // Open Edit Profile frame to allow user to enter details
                EditFrame editProfile = new EditFrame(0, loggedInUserId, loggedInUserId); // Pass 0 as customerId since it's missing
                editProfile.setVisible(true);
                editProfile.pack();
                editProfile.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_ViewbtnActionPerformed

    private void bookingbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbtnActionPerformed
        // Fetch the logged-in user
        User loggedInUser = UserManager.getLoggedInUser();

        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loggedInUserId = loggedInUser.getUserId();

        // Retrieve customer details associated with the logged-in user
        CustomerManager customerManager = new CustomerManager();
        Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUserId);

        if (loggedInCustomer != null) {
            // Open BookingFrame if customer details exist
            BookingFrame bookingFrame = new BookingFrame(loggedInCustomer.getCustomerId());
            bookingFrame.setVisible(true);
            bookingFrame.pack();
            bookingFrame.setLocationRelativeTo(null);
        } else {
            // Show confirmation dialog if customer details are missing
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Customer details not found. Do you want to enter your details?",
                    "Profile Not Found",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                // Open EditFrame to allow user to enter details
                EditFrame editProfile = new EditFrame(0, loggedInUserId, loggedInUserId); // Pass 0 as customerId since it's missing
                editProfile.setVisible(true);
                editProfile.pack();
                editProfile.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_bookingbtnActionPerformed

    private void RequestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestbtnActionPerformed
        // Fetch the logged-in user
        User loggedInUser = UserManager.getLoggedInUser();

        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loggedInUserId = loggedInUser.getUserId();

        // Retrieve customer details associated with the logged-in user
        CustomerManager customerManager = new CustomerManager();
        Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUserId);

        if (loggedInCustomer != null) {
            // Open BookingFrame if customer details exist
            RequestFrame requestFrame = new RequestFrame(loggedInCustomer.getCustomerId());
            requestFrame.setVisible(true);
            requestFrame.pack();
            requestFrame.setLocationRelativeTo(null);
        } else {
            // Show confirmation dialog if customer details are missing
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Customer details not found. Do you want to enter your details?",
                    "Profile Not Found",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                // Open EditFrame to allow user to enter details
                EditFrame editProfile = new EditFrame(0, loggedInUserId, loggedInUserId); // Pass 0 as customerId since it's missing
                editProfile.setVisible(true);
                editProfile.pack();
                editProfile.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_RequestbtnActionPerformed

    private void HelpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpbtnActionPerformed
        // Fetch the logged-in user
        User loggedInUser = UserManager.getLoggedInUser();

        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loggedInUserId = loggedInUser.getUserId();

        // Retrieve customer details associated with the logged-in user
        CustomerManager customerManager = new CustomerManager();
        Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUserId);

        if (loggedInCustomer != null) {
            // Open BookingFrame if customer details exist
            HelpFrame helpFrame = new HelpFrame(username, loggedInCustomer, loggedInCustomer.getCustomerId());
            helpFrame.setVisible(true);
            helpFrame.pack();
            helpFrame.setLocationRelativeTo(null);

        } else {
            // Show confirmation dialog if customer details are missing
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Customer details not found. Do you want to enter your details?",
                    "Profile Not Found",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                // Open EditFrame to allow user to enter details
                EditFrame editProfile = new EditFrame(0, loggedInUserId, loggedInUserId); // Pass 0 as customerId since it's missing
                editProfile.setVisible(true);
                editProfile.pack();
                editProfile.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_HelpbtnActionPerformed

    private void FeedbackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackbtnActionPerformed
        // Fetch the logged-in user
        User loggedInUser = UserManager.getLoggedInUser();

        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loggedInUserId = loggedInUser.getUserId();

        // Retrieve customer details associated with the logged-in user
        CustomerManager customerManager = new CustomerManager();
        Customer loggedInCustomer = customerManager.getCustomerByUserId(loggedInUserId);

        if (loggedInCustomer != null) {
            // Open BookingFrame if customer details exist
            FeedbackFrame feedback = new FeedbackFrame(loggedInCustomer, loggedInCustomer.getCustomerId());
            feedback.setVisible(true);
            feedback.pack();
            feedback.setLocationRelativeTo(null);

        } else {
            // Show confirmation dialog if customer details are missing
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Customer details not found. Do you want to enter your details?",
                    "Profile Not Found",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.YES_OPTION) {
                // Open EditFrame to allow user to enter details
                EditFrame editProfile = new EditFrame(0, loggedInUserId, loggedInUserId); // Pass 0 as customerId since it's missing
                editProfile.setVisible(true);
                editProfile.pack();
                editProfile.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_FeedbackbtnActionPerformed

    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            LoginFrame login = new LoginFrame();
            login.setVisible(true);
            login.pack();
            login.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutbtnActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Feedbackbtn;
    private javax.swing.JButton Helpbtn;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JButton Requestbtn;
    private javax.swing.JButton Viewbtn;
    private javax.swing.JButton bookingbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

}
