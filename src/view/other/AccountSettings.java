/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.other;

import controller.employee.EmployeeController;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import main.MainGUI;

/**
 *
 * @author Mampitiya
 */
public class AccountSettings extends javax.swing.JDialog {

    private EmployeeController empController;
    /**
     * Creates new form AccountSettingss
     */
    public AccountSettings(java.awt.Frame parent, boolean modal) {        
        super(parent, modal);
        empController = new EmployeeController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pwPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        curPwTxt = new javax.swing.JPasswordField();
        newPwTxt = new javax.swing.JPasswordField();
        conPwTxt = new javax.swing.JPasswordField();
        detailLbl = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        clrBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Settings"));

        jLabel3.setText("Current Password: ");

        jLabel4.setText("New Password: ");

        jLabel5.setText("Confirm Password: ");

        conPwTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                conPwTxtCaretUpdate(evt);
            }
        });

        detailLbl.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pwPaneLayout = new javax.swing.GroupLayout(pwPane);
        pwPane.setLayout(pwPaneLayout);
        pwPaneLayout.setHorizontalGroup(
            pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pwPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pwPaneLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conPwTxt))
                    .addGroup(pwPaneLayout.createSequentialGroup()
                        .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newPwTxt)
                            .addComponent(curPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        pwPaneLayout.setVerticalGroup(
            pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pwPaneLayout.createSequentialGroup()
                .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(curPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pwPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(conPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveBtn.setText("Save");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        clrBtn.setText("Clear");
        clrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pwPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addGap(18, 18, 18)
                .addComponent(clrBtn)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pwPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(clrBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conPwTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_conPwTxtCaretUpdate
        char pw[] = curPwTxt.getPassword();
        char npw1[] = newPwTxt.getPassword();
        char npw2[] = conPwTxt.getPassword();

        if (Arrays.equals(pw, npw1) && Arrays.equals(pw, npw2)) {
            detailLbl.setText("You have not changed the password!");
        }
        if (!Arrays.equals(npw1, npw2)) {
            detailLbl.setText("Password mismatch!");
        } else {
            detailLbl.setText("Password matched");
            saveBtn.setEnabled(true); 
        }
    }//GEN-LAST:event_conPwTxtCaretUpdate

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (!detailLbl.getText().isEmpty()) {
            char npw1[] = newPwTxt.getPassword();
            try {
                int rst = empController.updatePassword(MainGUI.getUserName(), String.valueOf(npw1));
                if (rst == 1) {
                    JOptionPane.showMessageDialog(this, "Successfully Updated!");
                    clrBtnActionPerformed(evt);
                }
            } catch (ClassNotFoundException | SQLException ex) {
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrBtnActionPerformed
        curPwTxt.setText("");
        newPwTxt.setText("");
        conPwTxt.setText("");
        saveBtn.setEnabled(false);
    }//GEN-LAST:event_clrBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clrBtn;
    private javax.swing.JPasswordField conPwTxt;
    private javax.swing.JPasswordField curPwTxt;
    private javax.swing.JLabel detailLbl;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPwTxt;
    private javax.swing.JPanel pwPane;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
