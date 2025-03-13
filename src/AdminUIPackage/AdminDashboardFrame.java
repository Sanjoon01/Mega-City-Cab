package AdminUIPackage;

import UIPackage.LoginFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AdminDashboardFrame extends javax.swing.JFrame {

    private JLabel imageLabel;
    private int currentIndex = 0;
    private String[] imageNames = {
        "welcome.jpg",
        "dashboard.jpg",
        "driver.jpg",
        "customer.jpg"

    };

    public AdminDashboardFrame(String adminUsername) {
        initComponents();
        initSlideshow(); // Initialize slideshow functionality
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        Viewbtn = new javax.swing.JButton();
        bookingbtn = new javax.swing.JButton();
        Requestbtn = new javax.swing.JButton();
        Helpbtn = new javax.swing.JButton();
        Entitesbtn = new javax.swing.JButton();
        Logoutbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega City Cab - Admin Dashboard");
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("WELCOME BACK!");

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("Admin");
        userLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userLabel.setPreferredSize(new java.awt.Dimension(250, 30));

        Viewbtn.setBackground(new java.awt.Color(13, 71, 161));
        Viewbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Viewbtn.setForeground(new java.awt.Color(255, 255, 255));
        Viewbtn.setText("Profile Info");
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
        bookingbtn.setText("Manage Booking");
        bookingbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingbtnActionPerformed(evt);
            }
        });

        Requestbtn.setBackground(new java.awt.Color(13, 71, 161));
        Requestbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Requestbtn.setForeground(new java.awt.Color(255, 255, 255));
        Requestbtn.setText("Manage Request");
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
        Helpbtn.setText("Manage Help");
        Helpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpbtnActionPerformed(evt);
            }
        });

        Entitesbtn.setBackground(new java.awt.Color(13, 71, 161));
        Entitesbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Entitesbtn.setForeground(new java.awt.Color(255, 255, 255));
        Entitesbtn.setText("Manage Entities");
        Entitesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntitesbtnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Entitesbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Viewbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookingbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(Requestbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Helpbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Viewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(Entitesbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Requestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Helpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ViewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewbtnActionPerformed
        ManageInfoFrame manageinfo = new ManageInfoFrame(); // Pass 0 as customerId since it's missing
        manageinfo.setVisible(true);
        manageinfo.pack();
        manageinfo.setLocationRelativeTo(null);
    }//GEN-LAST:event_ViewbtnActionPerformed

    private void bookingbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingbtnActionPerformed
        ManageBookingFrame booking = new ManageBookingFrame(); // Pass 0 as customerId since it's missing
        booking.setVisible(true);
        booking.pack();
        booking.setLocationRelativeTo(null);
    }//GEN-LAST:event_bookingbtnActionPerformed

    private void RequestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestbtnActionPerformed
        ManageRequestFrame requestdata = new ManageRequestFrame(); // Pass 0 as customerId since it's missing
        requestdata.setVisible(true);
        requestdata.pack();
        requestdata.setLocationRelativeTo(null);
    }//GEN-LAST:event_RequestbtnActionPerformed

    private void HelpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpbtnActionPerformed
        ManageHelpFrame help = new  ManageHelpFrame(); // Pass 0 as customerId since it's missing
        help.setVisible(true);
        help.pack();
        help.setLocationRelativeTo(null);
    }//GEN-LAST:event_HelpbtnActionPerformed

    private void EntitesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntitesbtnActionPerformed
        ManageEntitiesFrame entities = new ManageEntitiesFrame(); // Pass 0 as customerId since it's missing
        entities.setVisible(true);
        entities.pack();
        entities.setLocationRelativeTo(null);
    }//GEN-LAST:event_EntitesbtnActionPerformed

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
    private javax.swing.JButton Entitesbtn;
    private javax.swing.JButton Helpbtn;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JButton Requestbtn;
    private javax.swing.JButton Viewbtn;
    private javax.swing.JButton bookingbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
