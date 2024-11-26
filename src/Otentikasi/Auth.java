/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Otentikasi;
import Dashboard.Menu;
import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author hamud
 */
public class Auth extends javax.swing.JFrame {

    /**
     * Creates new form Auth
     */
    private Connection conn;
    static String nama="";
    public Auth() {
        initComponents();
        conn=Koneksi.getConnection();
        p_register.setVisible(false);
        p_login.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_register = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t_rgst_fn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_rgst_username = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        t_rgst_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rgstToLogin = new javax.swing.JLabel();
        btn_rgst_press = new javax.swing.JButton();
        t_rgst_pass2 = new javax.swing.JPasswordField();
        t_rgst_pass1 = new javax.swing.JPasswordField();
        p_login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_lgn_usernameemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_lgn_pass = new javax.swing.JPasswordField();
        lgnToRgst = new javax.swing.JLabel();
        btn_lgn_press = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p_register.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Full Name");

        t_rgst_fn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_rgst_fnMouseClicked(evt);
            }
        });
        t_rgst_fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rgst_fnActionPerformed(evt);
            }
        });
        t_rgst_fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_rgst_fnKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Username");

        t_rgst_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rgst_usernameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email");

        t_rgst_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rgst_emailActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Password");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Confirm Password");

        rgstToLogin.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rgstToLogin.setText("Already have an account? Login now!");
        rgstToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rgstToLoginMouseClicked(evt);
            }
        });

        btn_rgst_press.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_rgst_press.setText("REGISTER");
        btn_rgst_press.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rgst_pressActionPerformed(evt);
            }
        });

        t_rgst_pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rgst_pass2ActionPerformed(evt);
            }
        });

        t_rgst_pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rgst_pass1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_registerLayout = new javax.swing.GroupLayout(p_register);
        p_register.setLayout(p_registerLayout);
        p_registerLayout.setHorizontalGroup(
            p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_registerLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addGroup(p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_registerLayout.createSequentialGroup()
                        .addGroup(p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_registerLayout.createSequentialGroup()
                        .addGroup(p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rgstToLogin)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_registerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_rgst_press, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_registerLayout.createSequentialGroup()
                        .addGroup(p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_rgst_pass1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_rgst_pass2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_rgst_fn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_rgst_username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_rgst_email, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(308, 308, 308))))
        );
        p_registerLayout.setVerticalGroup(
            p_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_registerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_rgst_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_rgst_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_rgst_email, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_rgst_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_rgst_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rgstToLogin)
                .addGap(18, 18, 18)
                .addComponent(btn_rgst_press, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p_login.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Username/Email");

        t_lgn_usernameemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lgn_usernameemailActionPerformed(evt);
            }
        });
        t_lgn_usernameemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_lgn_usernameemailKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        t_lgn_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_lgn_passActionPerformed(evt);
            }
        });

        lgnToRgst.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lgnToRgst.setText("Yet to have an account? Register Now!");
        lgnToRgst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lgnToRgstMouseClicked(evt);
            }
        });

        btn_lgn_press.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_lgn_press.setText("LOGIN");
        btn_lgn_press.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lgn_pressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_loginLayout = new javax.swing.GroupLayout(p_login);
        p_login.setLayout(p_loginLayout);
        p_loginLayout.setHorizontalGroup(
            p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_loginLayout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t_lgn_usernameemail)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(t_lgn_pass)
                        .addComponent(jLabel3))
                    .addComponent(lgnToRgst))
                .addContainerGap(307, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_lgn_press, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(388, 388, 388))
        );
        p_loginLayout.setVerticalGroup(
            p_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_loginLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_lgn_usernameemail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_lgn_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lgnToRgst)
                .addGap(18, 18, 18)
                .addComponent(btn_lgn_press, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(p_register, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lgnToRgstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgnToRgstMouseClicked
        p_register.setVisible(true);
        p_login.setVisible(false);
    }//GEN-LAST:event_lgnToRgstMouseClicked

    private void rgstToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rgstToLoginMouseClicked
        p_register.setVisible(false);
        p_login.setVisible(true);
    }//GEN-LAST:event_rgstToLoginMouseClicked

    private void t_rgst_fnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_rgst_fnMouseClicked
        
    }//GEN-LAST:event_t_rgst_fnMouseClicked

    private void btn_lgn_pressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lgn_pressActionPerformed
        // TODO add your handling code here:
        String username = t_lgn_usernameemail.getText();
        String password = t_lgn_pass.getText();
        
        if(username.isEmpty()||password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String query = "Select * from user where username=? or email=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, username);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                if (password .equals(rs.getString("password"))) {
                    Menu mhs = new Menu();
                    mhs.setWelcomeName(username);
                    mhs.setBawahName(username);
                    mhs.setVisible(true);
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(rootPane, "Password Salah");
                    t_lgn_pass.setText("");
                    t_lgn_usernameemail.requestFocus();
                }
            }else {
                JOptionPane.showMessageDialog(rootPane, "User Tidak Ditemukan");
                t_lgn_usernameemail.setText("");
                t_lgn_pass.setText("");
                t_lgn_usernameemail.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal");
        }
    }//GEN-LAST:event_btn_lgn_pressActionPerformed
    private boolean isUsernameOrEmailExist(String username, String email) {
        String checkQuery = "SELECT COUNT(*) FROM user WHERE username = ? OR email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(checkQuery)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Jika ada hasil, berarti username atau email sudah ada
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    private void btn_rgst_pressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rgst_pressActionPerformed
        String fullname = t_rgst_fn.getText();
        String email = t_rgst_email.getText();
        String username = t_rgst_username.getText();
        String pass1 = t_rgst_pass1.getText();
        String pass2 = t_rgst_pass2.getText();

        if (fullname.isEmpty() || email.isEmpty() || username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(rootPane, "Password tidak sama");
            t_rgst_pass1.setText("");
            t_rgst_pass2.setText("");
            t_rgst_fn.requestFocus();
            return;
        }

        // Cek apakah username atau email sudah ada
        if (isUsernameOrEmailExist(username, email)) {
            JOptionPane.showMessageDialog(this, "Username atau Email sudah digunakan", "Validasi", JOptionPane.WARNING_MESSAGE);
            t_rgst_fn.requestFocus();
            t_rgst_fn.setText("");
            t_rgst_email.setText("");
            t_rgst_username.setText("");
            t_rgst_pass1.setText("");
            t_rgst_pass2.setText("");
            return;
        }

        String sql = "INSERT INTO user (nama, email, username, password) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fullname);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, pass1);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registrasi berhasil!");
                p_register.setVisible(false);
                p_login.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Registrasi gagal.", "Error", JOptionPane.ERROR_MESSAGE);
                t_rgst_fn.setText("");
                t_rgst_email.setText("");
                t_rgst_username.setText("");
                t_rgst_pass1.setText("");
                t_rgst_pass2.setText("");
                t_rgst_fn.requestFocus();
                
            }
            
            // Bersihkan form setelah registrasi
            t_rgst_fn.setText("");
            t_rgst_email.setText("");
            t_rgst_username.setText("");
            t_rgst_pass1.setText("");
            t_rgst_pass2.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            t_rgst_fn.requestFocus();
        }
    }//GEN-LAST:event_btn_rgst_pressActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void t_lgn_usernameemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_lgn_usernameemailKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            t_lgn_pass.requestFocus();
        }
    }//GEN-LAST:event_t_lgn_usernameemailKeyPressed

    private void t_lgn_usernameemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lgn_usernameemailActionPerformed
        // TODO add your handling code here:
        t_lgn_pass.requestFocus();
    }//GEN-LAST:event_t_lgn_usernameemailActionPerformed

    private void t_lgn_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_lgn_passActionPerformed
        // TODO add your handling code here:
        btn_lgn_press.doClick();
    }//GEN-LAST:event_t_lgn_passActionPerformed

    private void t_rgst_fnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_rgst_fnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rgst_fnKeyPressed

    private void t_rgst_fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rgst_fnActionPerformed
        // TODO add your handling code here:
        t_rgst_username.requestFocus();
    }//GEN-LAST:event_t_rgst_fnActionPerformed

    private void t_rgst_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rgst_usernameActionPerformed
        // TODO add your handling code here:
        t_rgst_email.requestFocus();
    }//GEN-LAST:event_t_rgst_usernameActionPerformed

    private void t_rgst_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rgst_emailActionPerformed
        // TODO add your handling code here:
        t_rgst_pass1.requestFocus();
    }//GEN-LAST:event_t_rgst_emailActionPerformed

    private void t_rgst_pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rgst_pass1ActionPerformed
        // TODO add your handling code here:
        t_rgst_pass2.requestFocus();
    }//GEN-LAST:event_t_rgst_pass1ActionPerformed

    private void t_rgst_pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rgst_pass2ActionPerformed
        // TODO add your handling code here:
        btn_rgst_press.doClick();
    }//GEN-LAST:event_t_rgst_pass2ActionPerformed

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
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Auth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Auth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lgn_press;
    private javax.swing.JButton btn_rgst_press;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lgnToRgst;
    private javax.swing.JPanel p_login;
    private javax.swing.JPanel p_register;
    private javax.swing.JLabel rgstToLogin;
    private javax.swing.JPasswordField t_lgn_pass;
    private javax.swing.JTextField t_lgn_usernameemail;
    private javax.swing.JTextField t_rgst_email;
    private javax.swing.JTextField t_rgst_fn;
    private javax.swing.JPasswordField t_rgst_pass1;
    private javax.swing.JPasswordField t_rgst_pass2;
    private javax.swing.JTextField t_rgst_username;
    // End of variables declaration//GEN-END:variables
}
