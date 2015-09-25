/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.AdminBll;
import common.Common;
import dto.AdminObj;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

/**
 *
 * @author NamPC
 */
public class AccountManagementPanel extends javax.swing.JPanel {

    AdminBll adminBll = new AdminBll();
    
    ArrayList<AdminObj> lstAdmin = new ArrayList<>();
    
    public AccountManagementPanel() {
        initComponents();
        
        bindingData();
    }
     
    private void bindingData(){
        lblMessage.setText("");
        lblResult.setText("");
        
        lstAdmin = adminBll.getAll();
        
        Vector cols = new Vector();
        cols.add("Username");
        cols.add("Full Name");
        cols.add("Birthday");
        cols.add("Email");
        
        Vector data = new Vector();
        for (AdminObj admin : lstAdmin) {
            Vector row = new Vector();
            row.add(admin.getUsername());
            row.add(admin.getFullName());
            row.add(admin.getBirthday());
            row.add(admin.getEmail());
            
            data.add(row);
        }
        
        DefaultTableModel tblModel = new DefaultTableModel(data, cols);
        tblAdmin.setModel(tblModel);
        bindingControl(0);
    }
    
    private void bindingControl(int index){
        if(index>=0 && index<lstAdmin.size()){
            AdminObj admin = lstAdmin.get(index);
            
            txtUsername.setText(admin.getUsername());
            txtPassword.setText(admin.getPassword());
            txtFullName.setText(admin.getFullName());
            txtBirthday.setText(admin.getBirthday());
            txtEmail.setText(admin.getEmail());
            
            tblAdmin.setRowSelectionInterval(index, index);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(699, 165));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin Information"));

        jLabel6.setText("Username:");

        jLabel5.setText("   Password:");

        jLabel9.setText("   Email:");

        jLabel10.setText("Birthday:");

        try{
            txtBirthday = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("MM/dd/yyyy")));
        } catch(Exception e){

        }

        jLabel1.setText("(mm/dd/yyyy)");

        jLabel11.setText("Full Name:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBirthday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFullName)
                            .addComponent(txtUsername))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword)
                    .addComponent(txtEmail))
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(164, 164, 164))
        );

        btnSave.setText("Add");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNew.setText("Clear");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 51, 51));
        lblMessage.setText("   ");

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblResult.setForeground(new java.awt.Color(51, 255, 51));
        lblResult.setText("   ");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnNew)
                    .addComponent(btnDelete)
                    .addComponent(lblMessage)
                    .addComponent(lblResult)
                    .addComponent(btnUpdate))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAdmin.setRowHeight(25);
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        lblMessage.setText("");
        lblResult.setText("");
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String birthday = txtBirthday.getText();

        boolean check = true;
        String message = "";
        if (username.isEmpty()) {
            check = false;
            message = "Username must isn't empty";
            txtUsername.requestFocus();
        }

        if (check && password.isEmpty()) {
            check = false;
            message = "Password must isn't empty";
            txtPassword.requestFocus();
        }
        
        if (check && fullName.isEmpty()) {
            check = false;
            message = "Full name must isn't empty";
            txtFullName.requestFocus();
        }

        if (check) {
            if (email.isEmpty()) {
                check = false;
                message = "Email must isn't empty";
                txtEmail.requestFocus();
            } else if (!Common.checkEmail(email)) {
                check = false;
                message = "Email format isn't false";
                txtEmail.requestFocus();
            }
        }

        if (check && birthday.isEmpty()) {
            check = false;
            message = "Birthday must isn't empty";
            txtBirthday.requestFocus();
        }

        if (check) {
            AdminObj admin = new AdminObj(username, password, fullName, birthday, email);
            boolean blnAdd = adminBll.insert(admin);
            if(blnAdd){
                lblResult.setText(Common.ADD_SUCCESS);
                bindingData();
            } else {
                lblMessage.setText(Common.ADD_SUCCESS);
            }
        } else {
            lblMessage.setText(message);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtUsername.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
        txtBirthday.setText("");
        txtFullName.setText("");
        txtUsername.requestFocus();
        lblMessage.setText("");
        lblResult.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        lblMessage.setText("");
        lblResult.setText("");
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String birthday = txtBirthday.getText();

        boolean check = true;
        String message = "";
        if (username.isEmpty()) {
            check = false;
            message = "Username must isn't empty";
            txtUsername.requestFocus();
        }

        if (check && password.isEmpty()) {
            check = false;
            message = "Password must isn't empty";
            txtPassword.requestFocus();
        }
        
        if (check && fullName.isEmpty()) {
            check = false;
            message = "Full name must isn't empty";
            txtFullName.requestFocus();
        }

        if (check) {
            if (email.isEmpty()) {
                check = false;
                message = "Email must isn't empty";
                txtEmail.requestFocus();
            } else if (!Common.checkEmail(email)) {
                check = false;
                message = "Email format isn't false";
                txtEmail.requestFocus();
            }
        }

        if (check && birthday.isEmpty()) {
            check = false;
            message = "Birthday must isn't empty";
            txtBirthday.requestFocus();
        }

        if (check) {
            AdminObj admin = new AdminObj(username, password, fullName, birthday, email);
            boolean blnUpdate = adminBll.update(admin);
            if(blnUpdate){
                lblResult.setText(Common.UPDATE_SUCCESS);
                bindingData();
            } else {
                lblMessage.setText(Common.UPDATE_FAIL);
            }
        } else {
            lblMessage.setText(message);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        lblMessage.setText("");
        lblResult.setText("");
        
        int select = JOptionPane.showConfirmDialog(null, "Are you sure delete admin?", "Delete Admin", JOptionPane.YES_NO_OPTION);
        if(select == JOptionPane.YES_OPTION){
            int row = tblAdmin.getSelectedRow();
            
            if(row>=0 && row<lstAdmin.size()){
                AdminObj adminObj = lstAdmin.get(row);
                boolean blnDel = adminBll.delete(adminObj.getUsername());
                if(blnDel){
                    lblResult.setText(Common.DELETE_SUCCESS);
                    bindingData();
                }else{
                    lblMessage.setText(Common.DELETE_FAIL);
                }
            } else{
                lblMessage.setText("You must select admin to delete");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        lblMessage.setText("");
        lblResult.setText("");
        bindingControl(tblAdmin.getSelectedRow());
    }//GEN-LAST:event_tblAdminMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JFormattedTextField txtBirthday;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
