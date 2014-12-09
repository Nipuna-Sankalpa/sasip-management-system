/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.employee;

import controller.employee.EmployeeController;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.employee.Employee;
import utilities.ComboBoxUtility;

/**
 *
 * @author Mampitiya
 */
public class EditEmployee extends javax.swing.JInternalFrame {

    private EmployeeController empController;
    private String imagePath;

    /**
     * Creates new form EditEmployee
     *
     * @param employeeController
     */
    public EditEmployee(EmployeeController employeeController) {
        initComponents();
        imageLbl.setMaximumSize(new Dimension(128, 128));
        imageLbl.setPreferredSize(new Dimension(128, 128));
        imageLbl.setMinimumSize(new Dimension(128, 128));
        empController = employeeController;
        try {

            ComboBoxUtility.setComboItem(idCmbx, "Select employeeId from employee order by 1");
            JTextField textField = (JTextField) idCmbx.getEditor().getEditorComponent();
            new ComboBoxUtility().setSearchableCombo(idCmbx, textField, "No such employee..");

        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        lblDesignation = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelProfilePic = new javax.swing.JPanel();
        imageLbl = new javax.swing.JLabel();
        browseBtn = new javax.swing.JButton();
        idCmbx = new javax.swing.JComboBox();
        cmbxDesignation = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        accessLvlTxt = new javax.swing.JTextField();
        detailLbl2 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        firstNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameTxt = new javax.swing.JTextField();
        detailLbl1 = new javax.swing.JLabel();
        detailLbl3 = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblID.setText("Employee ID :");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("First Name :");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Address :");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddress.setRows(5);
        txtAddress.setWrapStyleWord(true);
        txtAddress.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtAddress);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblDesignation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDesignation.setText("Designation: ");

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMobile.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMobileCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Mobile No :");

        panelProfilePic.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        imageLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/employee_images/business_user.png"))); // NOI18N

        browseBtn.setText("Browse");
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProfilePicLayout = new javax.swing.GroupLayout(panelProfilePic);
        panelProfilePic.setLayout(panelProfilePicLayout);
        panelProfilePicLayout.setHorizontalGroup(
            panelProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfilePicLayout.createSequentialGroup()
                .addGroup(panelProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProfilePicLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(browseBtn))
                    .addGroup(panelProfilePicLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProfilePicLayout.setVerticalGroup(
            panelProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfilePicLayout.createSequentialGroup()
                .addComponent(imageLbl)
                .addGap(19, 19, 19)
                .addComponent(browseBtn))
        );

        idCmbx.setEditable(true);
        idCmbx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idCmbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCmbxActionPerformed(evt);
            }
        });

        cmbxDesignation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbxDesignation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Admin", "Cashier", "Card Marker", "Team Leader" }));
        cmbxDesignation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxDesignationItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Access Level: ");

        accessLvlTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        accessLvlTxt.setEnabled(false);

        detailLbl2.setForeground(new java.awt.Color(255, 0, 0));

        clearBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        firstNameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        firstNameTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                firstNameTxtCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Last Name: ");

        lastNameTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lastNameTxt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                lastNameTxtCaretUpdate(evt);
            }
        });

        detailLbl1.setForeground(new java.awt.Color(255, 0, 0));

        detailLbl3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblDesignation)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accessLvlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(detailLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addComponent(lblID))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addComponent(detailLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(idCmbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(detailLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(detailLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddress)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesignation)
                            .addComponent(cmbxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(accessLvlTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imagePath = file.getAbsolutePath();
            imageLbl.setIcon(new ImageIcon(imagePath));
            btnUpdate.setEnabled(true);
        }
    }//GEN-LAST:event_browseBtnActionPerformed

    private void cmbxDesignationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxDesignationItemStateChanged
        int index = cmbxDesignation.getSelectedIndex();
        accessLvlTxt.setText(index + "");
    }//GEN-LAST:event_cmbxDesignationItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id = idCmbx.getSelectedItem().toString();
        String firstName = firstNameTxt.getText();
        String lastName = lastNameTxt.getText();
        int accessLevel = Integer.parseInt(accessLvlTxt.getText());
        String designation = cmbxDesignation.getSelectedItem().toString();
        String mobile = txtMobile.getText();
        String address = txtAddress.getText();

        Employee employee = new Employee(accessLevel, address, designation, id, firstName, lastName, mobile, imagePath);
        try {
            int res = empController.updateEmployee(employee);
            if (res == 1) {
                JOptionPane.showMessageDialog(this, "Successfully Updated!");
                clearBtnActionPerformed(evt);
                btnUpdate.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Update! Check entered information again.");
            }
        } catch (SQLException | ClassNotFoundException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unfortunately an error occurred! \nRefresh and try again.");            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        idCmbx.setSelectedIndex(0);
        txtAddress.setText("");
        firstNameTxt.setText("");
        lastNameTxt.setText("");
        txtMobile.setText("");
        cmbxDesignation.setSelectedIndex(0);
        accessLvlTxt.setText("");
        imageLbl.setIcon(new ImageIcon(getClass().getResource("/resources/employee_images/business_user.png")));
    }//GEN-LAST:event_clearBtnActionPerformed

    private void firstNameTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_firstNameTxtCaretUpdate
        String name = firstNameTxt.getText();
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) & !Character.isSpaceChar(name.charAt(i))) {
                detailLbl1.setText("Invalid name");
                break;
            } else {
                detailLbl1.setText("");
            }
        }
    }//GEN-LAST:event_firstNameTxtCaretUpdate

    private void lastNameTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_lastNameTxtCaretUpdate
        String name = lastNameTxt.getText();
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) & !Character.isSpaceChar(name.charAt(i))) {
                detailLbl3.setText("Invalid name");
                break;
            } else {
                detailLbl3.setText("");
            }
        }
    }//GEN-LAST:event_lastNameTxtCaretUpdate

    private void txtMobileCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMobileCaretUpdate
        String tel = txtMobile.getText();
        boolean isLetter = false;
        for (int i = 0; i < tel.length(); i++) {
            if (!Character.isDigit(tel.charAt(i))) {
                isLetter = true;
                break;
            }
        }
        if (isLetter || tel.length() > 10) {
            detailLbl2.setText("Invalid number");
        } else {
            detailLbl2.setText("");
        }
    }//GEN-LAST:event_txtMobileCaretUpdate

    private void idCmbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCmbxActionPerformed
        String id = "";
        if (idCmbx.getSelectedItem()!=null && !id.equals("No such employee..") && idCmbx.getSelectedIndex() != 0) {
            try {
                id = idCmbx.getSelectedItem().toString();
                Employee employee = empController.searchEmployeeByID(id);
                firstNameTxt.setText(employee.getFirstName());
                lastNameTxt.setText(employee.getLastName());
                txtAddress.setText(employee.getAddress());
                txtMobile.setText(employee.getMobile());
                accessLvlTxt.setText(employee.getAccessLevel() + "");
                cmbxDesignation.setSelectedItem(employee.getDesignation());
                imageLbl.setIcon(employee.getImage());
                btnUpdate.setEnabled(true);
            } catch (SQLException | ClassNotFoundException ex) {
            }
        }

    }//GEN-LAST:event_idCmbxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessLvlTxt;
    private javax.swing.JButton browseBtn;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox cmbxDesignation;
    private javax.swing.JLabel detailLbl1;
    private javax.swing.JLabel detailLbl2;
    private javax.swing.JLabel detailLbl3;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JComboBox idCmbx;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel panelProfilePic;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtMobile;
    // End of variables declaration//GEN-END:variables
}
