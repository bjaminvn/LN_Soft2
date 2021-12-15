/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package com.hotelmanager.ui;

import com.hotelmanager.dao.UserDAO;
import com.hotelmanager.entity.User;
import com.hotelmanager.utils.Auth;
import com.hotelmanager.utils.MsgBox;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author longd
 */
public class loginJDialog extends java.awt.Dialog {
    UserDAO userDAO = new UserDAO();
    /**
     * Creates new form loginJDialog
     */
    public loginJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    void init(){
        setLocationRelativeTo(null);
    }
    
    void dangNhap(){
        String strMaNV = txtUsername.getText();
        String strMatKhau = new String(txtPassword.getPassword());
        User nv = userDAO.selectByID(txtUsername.getText());
        
        if (strMaNV.equals("")) {
            MsgBox.alert(this, "Tài khoản không được để trống!");
        }else{
            if (nv==null) {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            }else{
                if (strMatKhau.equals("")) {
                    MsgBox.alert(this, "Mật khẩu không được để trống");
                }else{
                    if (!nv.getMatKhau().equals(strMatKhau)) {
                        MsgBox.alert(this, "Sai mật khẩu!");
                    } else {
                        Auth.user = nv;
                        this.dispose();
                    }
                }
            }
        }
        }
    
    void signUp(){
        this.dispose();
        new signUpJdialog(new java.awt.Frame(), true).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @Override
    public void validate() {
        super.validate(); //To change body of generated methods, choose Tools | Templates.
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeft = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        pnlUsername = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        pnlPassword = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        pnlRmb = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        lblForgotPass = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        pnlSignUp = new javax.swing.JPanel();
        lblSignUp = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setTitle("LN Soft - Đăng nhập");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pnlLeft.setPreferredSize(new java.awt.Dimension(300, 0));

        pnlTitle.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Welcome Back");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );

        pnlLeft.add(pnlTitle);

        pnlInput.setPreferredSize(new java.awt.Dimension(400, 150));

        pnlUsername.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlUsername.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Username");
        pnlUsername.add(jLabel3, java.awt.BorderLayout.CENTER);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.setPreferredSize(new java.awt.Dimension(7, 25));
        pnlUsername.add(txtUsername, java.awt.BorderLayout.PAGE_END);

        pnlInput.add(pnlUsername);

        pnlPassword.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlPassword.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        pnlPassword.add(jLabel2, java.awt.BorderLayout.CENTER);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(7, 25));
        pnlPassword.add(txtPassword, java.awt.BorderLayout.PAGE_END);

        pnlInput.add(pnlPassword);

        pnlRmb.setPreferredSize(new java.awt.Dimension(250, 20));
        pnlRmb.setLayout(new java.awt.BorderLayout());

        jCheckBox1.setText("Remember me");
        pnlRmb.add(jCheckBox1, java.awt.BorderLayout.WEST);

        lblForgotPass.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        lblForgotPass.setForeground(new java.awt.Color(255, 102, 102));
        lblForgotPass.setText("Forgot your password?");
        lblForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgotPassMouseExited(evt);
            }
        });
        pnlRmb.add(lblForgotPass, java.awt.BorderLayout.EAST);

        pnlInput.add(pnlRmb);

        pnlLeft.add(pnlInput);

        pnlLogin.setPreferredSize(new java.awt.Dimension(400, 50));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setPreferredSize(new java.awt.Dimension(250, 25));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin);

        pnlLeft.add(pnlLogin);

        pnlSignUp.setPreferredSize(new java.awt.Dimension(400, 50));

        lblSignUp.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblSignUp.setText("Don't have an account yet? Sign up");
        lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignUpMouseExited(evt);
            }
        });
        pnlSignUp.add(lblSignUp);

        pnlLeft.add(pnlSignUp);

        add(pnlLeft, java.awt.BorderLayout.WEST);

        pnlRight.setBackground(new java.awt.Color(255, 255, 255));
        pnlRight.setPreferredSize(new java.awt.Dimension(400, 430));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hotelmanager/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        add(pnlRight, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void lblForgotPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseEntered
        lblForgotPass.setForeground(Color.decode("#f50808"));
    }//GEN-LAST:event_lblForgotPassMouseEntered

    private void lblForgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPassMouseExited
        lblForgotPass.setForeground(Color.decode("#ff6666"));
    }//GEN-LAST:event_lblForgotPassMouseExited

    private void lblSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseEntered
        lblSignUp.setForeground(Color.decode("#f50808"));
    }//GEN-LAST:event_lblSignUpMouseEntered

    private void lblSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseExited
        lblSignUp.setForeground(Color.black);
    }//GEN-LAST:event_lblSignUpMouseExited

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        dangNhap();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseClicked
        signUp();
    }//GEN-LAST:event_lblSignUpMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        try {
//            UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
//        } catch (ParseException ex) {
//            System.Logger
//        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginJDialog dialog = new loginJDialog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblForgotPass;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlPassword;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlRmb;
    private javax.swing.JPanel pnlSignUp;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}