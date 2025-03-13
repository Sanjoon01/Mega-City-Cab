package UIPackage;

import ClassPackage.Customer;
import ClassPackage.Feedback;
import ClassPackage.FeedbackManager;
import javax.swing.*;

public class FeedbackFrame extends javax.swing.JFrame {

    private Customer loggedInCustomer;
    private int loggedInCustomerId;

    public FeedbackFrame(Customer loggedInCustomer, int customerId) {
        initComponents();
        this.loggedInCustomerId = customerId;
        this.loggedInCustomer = loggedInCustomer;

        setupWordCount();
        updateWordCount();
    }

    public int getLoggedInCustomerId() {
        return loggedInCustomer != null ? loggedInCustomer.getCustomerId() : -1;
    }

 private void setupWordCount() {
    wordCountLabel.setText("0/100"); // Initialize label

    feedbackTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            updateWordCount();
        }
    });
}

private void  updateWordCount() {
    String text = feedbackTextArea.getText();


    int charCount = text.length(); // Count all characters, including spaces


    // Limit to 100 characters
    if (charCount > 100) {
        text = text.substring(0, 100); // Trim text to 100 characters
        feedbackTextArea.setText(text);
        charCount = 100;

    }

    // Update label
    wordCountLabel.setText(charCount + "/100");

}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        feedbackPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        stopLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackTextArea = new javax.swing.JTextArea();
        Confirmbtn = new javax.swing.JButton();
        wordCountLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mega City Cab - Help Manager");
        setResizable(false);

        feedbackPanel.setBackground(new java.awt.Color(255, 255, 255));
        feedbackPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Feedback Form");

        stopLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopLabel3.setText("Provide a Feedback Below:");

        feedbackTextArea.setColumns(20);
        feedbackTextArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        feedbackTextArea.setRows(5);
        jScrollPane1.setViewportView(feedbackTextArea);

        Confirmbtn.setBackground(new java.awt.Color(13, 71, 161));
        Confirmbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        Confirmbtn.setForeground(new java.awt.Color(255, 255, 255));
        Confirmbtn.setText("Confirm");
        Confirmbtn.setMaximumSize(new java.awt.Dimension(125, 25));
        Confirmbtn.setMinimumSize(new java.awt.Dimension(125, 25));
        Confirmbtn.setPreferredSize(new java.awt.Dimension(125, 25));
        Confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmbtnActionPerformed(evt);
            }
        });

        wordCountLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout feedbackPanelLayout = new javax.swing.GroupLayout(feedbackPanel);
        feedbackPanel.setLayout(feedbackPanelLayout);
        feedbackPanelLayout.setHorizontalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addGroup(feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(feedbackPanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2))
                    .addGroup(feedbackPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(feedbackPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stopLabel3))
                    .addGroup(feedbackPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedbackPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(wordCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        feedbackPanelLayout.setVerticalGroup(
            feedbackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbackPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addComponent(stopLabel3)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wordCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(Confirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(feedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(feedbackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmbtnActionPerformed
        int customerId = getLoggedInCustomerId();
        String feedbackReport = feedbackTextArea.getText().trim();

        if (feedbackReport.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your feedback before submitting!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Feedback feedback = new Feedback(customerId, feedbackReport);
        FeedbackManager feedbackManager = new FeedbackManager();
        boolean success = feedbackManager.submitFeedback(feedback);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thank You For Your Kind Feedback!", "Success", JOptionPane.INFORMATION_MESSAGE);
            feedbackTextArea.setText("");
            
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit feedback. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ConfirmbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirmbtn;
    private javax.swing.JPanel feedbackPanel;
    private javax.swing.JTextArea feedbackTextArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel stopLabel3;
    private javax.swing.JLabel wordCountLabel;
    // End of variables declaration//GEN-END:variables
}
