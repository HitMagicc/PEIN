/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DetailedInfo;
import com.formdev.flatlaf.*;// Import Cupertino LAF
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Koneksi.Koneksi;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author hamud
 */
public class KategoriDetailed extends javax.swing.JFrame {

    /**
     * Creates new form KategoriDetailed
     */
    private Connection conn;
    private int kategoriId;
    public KategoriDetailed() {
        conn=Koneksi.getConnection();
        initComponents();
        btn_ubah_kategori.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        t_nama_kategori.setEditable(false);
        t_desc_kategori.setEditable(false);
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
        label_kategoriID = new javax.swing.JLabel();
        btn_c1_kembali = new javax.swing.JButton();
        btn_ubah_kategori = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        t_nama_kategori = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_desc_kategori = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btn_mode_ubah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label_kategoriID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_kategoriID.setText("Kategori ID:0");

        btn_c1_kembali.setText("Kembali");
        btn_c1_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_c1_kembaliMouseClicked(evt);
            }
        });
        btn_c1_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c1_kembaliActionPerformed(evt);
            }
        });

        btn_ubah_kategori.setBackground(new java.awt.Color(102, 102, 255));
        btn_ubah_kategori.setText("Konfirm Ubah");
        btn_ubah_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubah_kategoriActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Kategori");

        t_desc_kategori.setColumns(20);
        t_desc_kategori.setLineWrap(true);
        t_desc_kategori.setRows(5);
        jScrollPane1.setViewportView(t_desc_kategori);

        jLabel1.setText("Deskripsi Kategori: ");

        btn_mode_ubah.setBackground(new java.awt.Color(102, 102, 255));
        btn_mode_ubah.setText("Mode Ubah");
        btn_mode_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mode_ubahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btn_mode_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_ubah_kategori)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t_nama_kategori)
                        .addComponent(label_kategoriID, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                    .addComponent(btn_c1_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mode_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ubah_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label_kategoriID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_c1_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(36, 36, 36)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(t_nama_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(451, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_c1_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_c1_kembaliMouseClicked

    }//GEN-LAST:event_btn_c1_kembaliMouseClicked

    private void btn_c1_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_kembaliActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_c1_kembaliActionPerformed

    private void btn_ubah_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubah_kategoriActionPerformed
        int response  = JOptionPane.showConfirmDialog(this, "Seriusan mau update?", "Update Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            String nama = t_nama_kategori.getText();
            String desc = t_desc_kategori.getText();
            if (nama.isEmpty() || desc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom harus diisi", "Validasi", JOptionPane.ERROR_MESSAGE);
                return;
            }   
            int kategoriId = this.kategoriId;
            if(kategoriId==0){
                JOptionPane.showMessageDialog(this, "ID kategori tidak ditemukan", "Validasi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String query = "UPDATE kategori SET nama = ?, description = ? WHERE id = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, nama); // Set the updated name
                st.setString(2, desc); // Set the updated description
                st.setInt(3, kategoriId); // Specify the row to update based on ID

                int rowsUpdated = st.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
                    rubahModeEdit();
                    // Reload the updated data

                } else {
                    JOptionPane.showMessageDialog(this, "Data gagal diperbarui", "Error", JOptionPane.ERROR_MESSAGE);
                }
                st.close();
            } catch (Exception e) {
                Logger.getLogger(KategoriDetailed.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        

    }//GEN-LAST:event_btn_ubah_kategoriActionPerformed

    private void rubahModeEdit(){
        if(btn_ubah_kategori.isEnabled()==false){
            btn_ubah_kategori.setEnabled(true);
            t_nama_kategori.setEditable(true);
            t_desc_kategori.setEditable(true);
        }else{
            btn_ubah_kategori.setEnabled(false);
            t_nama_kategori.setEditable(false);
            t_desc_kategori.setEditable(false);
        }
    }
    private void btn_mode_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mode_ubahActionPerformed
        rubahModeEdit();
    }//GEN-LAST:event_btn_mode_ubahActionPerformed
    public void setKategoriField(int id, String nama, String desc){
        this.kategoriId=id;
        t_nama_kategori.setText(nama);
        t_desc_kategori.setText(desc);
        label_kategoriID.setText("Kategori ID: "+this.kategoriId);
        
    }
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
            java.util.logging.Logger.getLogger(KategoriDetailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KategoriDetailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KategoriDetailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KategoriDetailed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KategoriDetailed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_c1_kembali;
    private javax.swing.JButton btn_mode_ubah;
    private javax.swing.JButton btn_ubah_kategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_kategoriID;
    private javax.swing.JTextArea t_desc_kategori;
    private javax.swing.JTextField t_nama_kategori;
    // End of variables declaration//GEN-END:variables
}
