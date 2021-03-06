/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomisma;

import nomisma.mysql.first.MySQLAccess;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Chunmeista
 */
public class NomismaMenu extends javax.swing.JFrame {

    String username = "";
    private MySQLAccess dao;
    private int uid;
    
    /**
     * Creates new form NomismaWindow
     * 
     * @param login - User's username
     * @param dao - used for connecting the program to the back-end database
     * @param uid - user's id used for database queries
     */
    public NomismaMenu(String login, MySQLAccess dao, int uid) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.username = login;
        this.dao = dao;
        this.uid = uid;
        
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(0)));
        this.entertainment_val.setText("$" + Double.toString(logEntertainment(0)));
        this.food_val.setText("$" + Double.toString(logFood(0)));
        this.transport_val.setText("$" + Double.toString(logTransport(0)));
        this.room_val.setText("$" + Double.toString(logRoom(0)));
        this.emergency_val.setText("$" + Double.toString(logEmergency(0)));
        this.Account_Button.setText("Logout of " + this.username);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entertainment_button = new javax.swing.JButton();
        balance_input = new javax.swing.JTextField();
        food_button = new javax.swing.JButton();
        transport_button = new javax.swing.JButton();
        room_button = new javax.swing.JButton();
        emergency_button = new javax.swing.JButton();
        acct_bal = new javax.swing.JLabel();
        Account_Button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        entertainment_label = new javax.swing.JLabel();
        food_label = new javax.swing.JLabel();
        transport_label = new javax.swing.JLabel();
        room_label = new javax.swing.JLabel();
        emergency_label = new javax.swing.JLabel();
        emergency_val = new javax.swing.JLabel();
        room_val = new javax.swing.JLabel();
        transport_val = new javax.swing.JLabel();
        food_val = new javax.swing.JLabel();
        entertainment_val = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        entertainment_button.setBackground(new java.awt.Color(153, 204, 255));
        entertainment_button.setText("EN");
        entertainment_button.setToolTipText("Entertainment");
        entertainment_button.setBorder(null);
        entertainment_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        entertainment_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entertainment_buttonMouseClicked(evt);
            }
        });
        entertainment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entertainment_buttonActionPerformed(evt);
            }
        });

        balance_input.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        balance_input.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balance_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balance_inputActionPerformed(evt);
            }
        });

        food_button.setBackground(new java.awt.Color(153, 204, 255));
        food_button.setText("FO");
        food_button.setToolTipText("Food");
        food_button.setBorder(null);
        food_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                food_buttonMouseClicked(evt);
            }
        });

        transport_button.setBackground(new java.awt.Color(153, 204, 255));
        transport_button.setText("TR");
        transport_button.setToolTipText("Transport");
        transport_button.setBorder(null);
        transport_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transport_buttonMouseClicked(evt);
            }
        });

        room_button.setBackground(new java.awt.Color(153, 204, 255));
        room_button.setText("RO");
        room_button.setToolTipText("Room");
        room_button.setBorder(null);
        room_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                room_buttonMouseClicked(evt);
            }
        });

        emergency_button.setBackground(new java.awt.Color(153, 204, 255));
        emergency_button.setText("EM");
        emergency_button.setToolTipText("Emergency");
        emergency_button.setBorder(null);
        emergency_button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        emergency_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emergency_buttonMouseClicked(evt);
            }
        });

        acct_bal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        acct_bal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        acct_bal.setText("acct_bal");

        Account_Button.setBackground(new java.awt.Color(153, 204, 255));
        Account_Button.setText("Account_Button");
        Account_Button.setBorder(null);
        Account_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Account_ButtonMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        entertainment_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        entertainment_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        entertainment_label.setText("ENTERTAINMENT");

        food_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        food_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food_label.setText("FOOD");

        transport_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        transport_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        transport_label.setText("TRANSPORT");

        room_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        room_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        room_label.setText("ROOM");

        emergency_label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        emergency_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emergency_label.setText("EMERGENCY");

        emergency_val.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        emergency_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        emergency_val.setText("emergency_val");

        room_val.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        room_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        room_val.setText("room_val");

        transport_val.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        transport_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transport_val.setText("transport_val");

        food_val.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        food_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        food_val.setText("food_val");

        entertainment_val.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        entertainment_val.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        entertainment_val.setText("entertainment_val");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emergency_label, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(room_label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transport_label, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(food_label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entertainment_label, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transport_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(food_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(entertainment_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergency_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(room_val, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entertainment_label)
                    .addComponent(entertainment_val))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(food_label)
                    .addComponent(food_val))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transport_label)
                    .addComponent(transport_val))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room_label)
                    .addComponent(room_val))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergency_label)
                    .addComponent(emergency_val))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balance_input, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entertainment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(food_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transport_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(room_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emergency_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acct_bal, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Account_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Account_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acct_bal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(balance_input)
                        .addComponent(entertainment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(food_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transport_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(room_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emergency_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Account_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Account_ButtonMouseClicked
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_OPTION);
        if (choice == 0) {
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_Account_ButtonMouseClicked

    private void entertainment_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entertainment_buttonMouseClicked
        this.entertainment_val.setText("$" + Double.toString(logEntertainment(Double.parseDouble(balance_input.getText()))));
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(Double.parseDouble(balance_input.getText()))));
    }//GEN-LAST:event_entertainment_buttonMouseClicked

    private void food_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_food_buttonMouseClicked
        this.food_val.setText("$" + Double.toString(logFood(Double.parseDouble(balance_input.getText()))));
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(Double.parseDouble(balance_input.getText()))));
    }//GEN-LAST:event_food_buttonMouseClicked

    private void transport_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transport_buttonMouseClicked
        this.transport_val.setText("$" + Double.toString(logTransport(Double.parseDouble(balance_input.getText()))));
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(Double.parseDouble(balance_input.getText()))));
    }//GEN-LAST:event_transport_buttonMouseClicked

    private void room_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_buttonMouseClicked
        this.room_val.setText("$" + Double.toString(logRoom(Double.parseDouble(balance_input.getText()))));
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(Double.parseDouble(balance_input.getText()))));
    }//GEN-LAST:event_room_buttonMouseClicked

    private void emergency_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emergency_buttonMouseClicked
        this.emergency_val.setText("$" + Double.toString(logEmergency(Double.parseDouble(balance_input.getText()))));
        this.acct_bal.setText("Balance $" + Double.toString(checkBalance(Double.parseDouble(balance_input.getText()))));
    }//GEN-LAST:event_emergency_buttonMouseClicked

    private void entertainment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entertainment_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entertainment_buttonActionPerformed

    private void balance_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balance_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balance_inputActionPerformed

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
            java.util.logging.Logger.getLogger(NomismaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NomismaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NomismaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NomismaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double checkBalance(double cost) {
        double balance = 0;
        try {
            balance = dao.reduceBalance(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double logEntertainment(double cost) {
        double balance = 0;
        try {
            balance = dao.incEntertainment(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double logFood(double cost) {
        double balance = 0;
        try {
            balance = dao.incFood(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double logTransport(double cost) {
        double balance = 0;
        try {
            balance = dao.incTransport(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double logRoom(double cost) {
        double balance = 0;
        try {
            balance = dao.incRoom(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    /**
     * Changes values of the database and displays onto GUI
     * 
     * @param cost amount to change balance by
     * @return The value of the new balance
     */
    private double logEmergency(double cost) {
        double balance = 0;
        try {
            balance = dao.incEmergency(cost, uid);
            return balance;
        } catch (Exception ex) {
            Logger.getLogger(Nomisma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return balance;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account_Button;
    private javax.swing.JLabel acct_bal;
    private javax.swing.JTextField balance_input;
    private javax.swing.JButton emergency_button;
    private javax.swing.JLabel emergency_label;
    private javax.swing.JLabel emergency_val;
    private javax.swing.JButton entertainment_button;
    private javax.swing.JLabel entertainment_label;
    private javax.swing.JLabel entertainment_val;
    private javax.swing.JButton food_button;
    private javax.swing.JLabel food_label;
    private javax.swing.JLabel food_val;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton room_button;
    private javax.swing.JLabel room_label;
    private javax.swing.JLabel room_val;
    private javax.swing.JButton transport_button;
    private javax.swing.JLabel transport_label;
    private javax.swing.JLabel transport_val;
    // End of variables declaration//GEN-END:variables
}
