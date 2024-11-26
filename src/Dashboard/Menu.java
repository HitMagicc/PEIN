/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

import java.sql.*;
import Otentikasi.Auth;
import Koneksi.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DetailedInfo.*;
import com.formdev.flatlaf.*;// Import Cupertino LAF
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author hamud
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    
    private Connection conn;
    private int session=0;
    public Menu() {
        
        initComponents();
        conn=Koneksi.getConnection();
        //Visibility
        
        mainContent.setVisible(true);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        //getData
        getBarangData();
        getTransaksiData();
        getDashboardBarangData();
        getDashboardTransaksiData();
        loadDataToKategoriDropDown();
        getKategoriData();
    }
    public void setSession(int a){
        this.session=a;
    }
    public int getSession(){
        return this.session;
    }
    public void checkSession(){
        if(this.session==0){
            JOptionPane.showMessageDialog(this, "Anda harus login terlebih dahulu.", "Session Error", JOptionPane.ERROR_MESSAGE);
            Auth yaw = new Auth();
            yaw.setVisible(true);
            this.dispose();
        }
    }
    private void getBarangData(){
        
        DefaultTableModel barangModel = (DefaultTableModel) tbl_barang.getModel();
        barangModel.setRowCount(0); // Clear the table
        int i=1;
        try {
            String query = "SELECT barang.id AS id, barang.nama AS barang_name, client.nama AS client_name, barang.alamat_penerima AS alamat_tujuan " +
                           "FROM barang JOIN client ON barang.fk_client = client.id ";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id"); // Get the actual `barang.id` from the database
                String barangNama = rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String alamat = rs.getString("alamat_tujuan");

                // Include the actual ID as the first column (hidden later)
                Object rowData[] = {id, i++, barangNama, clientNama, alamat};
                barangModel.addRow(rowData);
            }
            rs.close();
            st.close();

            // Hide the `id` column after populating the table
            tbl_barang.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_barang.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_barang.getColumnModel().getColumn(0).setPreferredWidth(0);

        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    private void getTransaksiData(){
        DefaultTableModel transaksiModel = (DefaultTableModel) tbl_transaksi.getModel();
        transaksiModel.setRowCount(0);
        int i = 1;

        try {
            String query = "SELECT transaksi.id as t_id, barang.nama AS barang_name, client.nama AS client_name, transaksi.tanggal, transaksi.status " +
                           "FROM transaksi " +
                           "JOIN barang ON transaksi.fk_barang = barang.id " +
                           "JOIN client ON transaksi.fk_client = client.id";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("t_id");
                String barangNama = rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String tanggal = rs.getString("tanggal");
                String status = rs.getString("status");

                Object rowData[] = {id,i++, barangNama, clientNama, tanggal, status};
                transaksiModel.addRow(rowData);
            }
            rs.close();
            st.close();
            tbl_transaksi.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_transaksi.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_transaksi.getColumnModel().getColumn(0).setPreferredWidth(0);
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void getKategoriData(){
        DefaultTableModel kategoriModel = (DefaultTableModel) tbl_kategori.getModel();
        kategoriModel.setRowCount(0);
        
        int i=1;
        try {
            String query ="SELECT * FROM kategori";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String desc = rs.getString("description");
                
                Object rowData[]={id,i++, nama, desc};
                kategoriModel.addRow(rowData);
            }
            rs.close();
            st.close();
            tbl_kategori.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_kategori.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_kategori.getColumnModel().getColumn(0).setPreferredWidth(0);
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private void getDashboardBarangData(){
        DefaultTableModel barangModel = (DefaultTableModel) tbl_dashboard_barang.getModel();
        barangModel.setRowCount(0);
        int i=1;
        try {
            String query = "SELECT barang.id as id, barang.nama AS barang_name, client.nama AS client_name, barang.alamat_penerima AS alamat_tujuan FROM barang JOIN client ON barang.fk_client = client.id LIMIT 5";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String barangNama= rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String alamat = rs.getString("alamat_tujuan");
                
                Object rowData[]= {i++,barangNama, clientNama, alamat};
                barangModel.addRow(rowData);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    private void getDashboardTransaksiData(){
        DefaultTableModel transaksiModel = (DefaultTableModel) tbl_dashboard_transaksi.getModel();
        transaksiModel.setRowCount(0);
        int i = 1;

        try {
            String query = "SELECT barang.nama AS barang_name, client.nama AS client_name, transaksi.tanggal, transaksi.status " +
                           "FROM transaksi " +
                           "JOIN barang ON transaksi.fk_barang = barang.id " +
                           "JOIN client ON transaksi.fk_client = client.id LIMIT 5";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String barangNama = rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String tanggal = rs.getString("tanggal");
                String status = rs.getString("status");

                Object rowData[] = {i++, barangNama, clientNama, tanggal, status};
                transaksiModel.addRow(rowData);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        mainContainer = new javax.swing.JPanel();
        sideContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Dashboard1 = new javax.swing.JButton();
        btn_Dashboard2 = new javax.swing.JButton();
        btn_Dashboard3 = new javax.swing.JButton();
        btn_Dashboard4 = new javax.swing.JButton();
        btn_Dashboard5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Dashboard6 = new javax.swing.JButton();
        contentContainer = new javax.swing.JPanel();
        mainContent = new javax.swing.JPanel();
        t_welcome_name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dashboard_barang = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_dashboard_transaksi = new javax.swing.JTable();
        t_welcome_name1 = new javax.swing.JLabel();
        content1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_inputBarang_nama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        t_inputBarang_namaPenerima = new javax.swing.JTextField();
        t_inputBarang_alamat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t_inputBarang_alamatPenerima = new javax.swing.JTextField();
        t_inputBarang_noTelp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        t_inputBarang_noTelpPenerima = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t_inputBarang_namaBarang = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_inputBarang_descBarang = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        btn_input_barang = new javax.swing.JButton();
        btn_clear_input_barang = new javax.swing.JButton();
        btn_c1_kembali = new javax.swing.JButton();
        dd_inputBarang_kategori1 = new javax.swing.JComboBox<>();
        content2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();
        t_barang_search = new javax.swing.JTextField();
        content3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        t_transaksi_cari = new javax.swing.JTextField();
        content4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        t_kategori_input_desc = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        btn_input_kategori = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_c1_kembali1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        t_kategori_input_nama = new javax.swing.JTextField();
        content5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_kategori = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        t_kategori_cari = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setPreferredSize(new java.awt.Dimension(953, 600));

        sideContainer.setBackground(new java.awt.Color(255, 255, 255));
        sideContainer.setPreferredSize(new java.awt.Dimension(318, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hamud\\Downloads\\Group 3.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btn_Dashboard1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard1.setText("Input Barang");
        btn_Dashboard1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard1ActionPerformed(evt);
            }
        });

        btn_Dashboard2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard2.setText("List Barang");
        btn_Dashboard2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard2.setPreferredSize(new java.awt.Dimension(120, 23));
        btn_Dashboard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard2ActionPerformed(evt);
            }
        });

        btn_Dashboard3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard3.setText("List History");
        btn_Dashboard3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard3.setPreferredSize(new java.awt.Dimension(128, 23));
        btn_Dashboard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard3ActionPerformed(evt);
            }
        });

        btn_Dashboard4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard4.setText("Input Kategori");
        btn_Dashboard4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard4ActionPerformed(evt);
            }
        });

        btn_Dashboard5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard5.setText("List Kategori");
        btn_Dashboard5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nama User");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Log Out");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_Dashboard6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Dashboard6.setText("Refresh Table");
        btn_Dashboard6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Dashboard6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dashboard6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideContainerLayout = new javax.swing.GroupLayout(sideContainer);
        sideContainer.setLayout(sideContainerLayout);
        sideContainerLayout.setHorizontalGroup(
            sideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideContainerLayout.createSequentialGroup()
                .addGroup(sideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideContainerLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(sideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Dashboard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Dashboard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Dashboard3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(btn_Dashboard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Dashboard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sideContainerLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(btn_Dashboard6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(sideContainerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        sideContainerLayout.setVerticalGroup(
            sideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideContainerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(btn_Dashboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Dashboard6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(sideContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19))
        );

        mainContent.setBackground(new java.awt.Color(255, 255, 255));

        t_welcome_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_welcome_name.setText("Selamat Datang,");

        tbl_dashboard_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Nama Barang", "Pengirim", "Alamat Tujuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dashboard_barang.setToolTipText("");
        tbl_dashboard_barang.setColumnSelectionAllowed(true);
        tbl_dashboard_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_dashboard_barang.setDoubleBuffered(true);
        tbl_dashboard_barang.setEnabled(false);
        tbl_dashboard_barang.setRowHeight(35);
        tbl_dashboard_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dashboard_barangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbl_dashboard_barangMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dashboard_barang);
        tbl_dashboard_barang.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tbl_dashboard_barang.getColumnModel().getColumnCount() > 0) {
            tbl_dashboard_barang.getColumnModel().getColumn(0).setResizable(false);
            tbl_dashboard_barang.getColumnModel().getColumn(0).setPreferredWidth(3);
        }

        tbl_dashboard_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Pengirim", "Tanggal Masuk", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_dashboard_transaksi);
        if (tbl_dashboard_transaksi.getColumnModel().getColumnCount() > 0) {
            tbl_dashboard_transaksi.getColumnModel().getColumn(0).setResizable(false);
            tbl_dashboard_transaksi.getColumnModel().getColumn(0).setPreferredWidth(1);
            tbl_dashboard_transaksi.getColumnModel().getColumn(1).setResizable(false);
            tbl_dashboard_transaksi.getColumnModel().getColumn(2).setResizable(false);
            tbl_dashboard_transaksi.getColumnModel().getColumn(3).setResizable(false);
            tbl_dashboard_transaksi.getColumnModel().getColumn(4).setResizable(false);
            tbl_dashboard_transaksi.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        t_welcome_name1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_welcome_name1.setText("User");

        javax.swing.GroupLayout mainContentLayout = new javax.swing.GroupLayout(mainContent);
        mainContent.setLayout(mainContentLayout);
        mainContentLayout.setHorizontalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContentLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainContentLayout.createSequentialGroup()
                        .addComponent(t_welcome_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_welcome_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        mainContentLayout.setVerticalGroup(
            mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContentLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(mainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_welcome_name)
                    .addComponent(t_welcome_name1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        content1.setBackground(new java.awt.Color(255, 255, 255));
        content1.setPreferredSize(new java.awt.Dimension(635, 600));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Input Barang");

        jLabel7.setText("Nama");

        jLabel8.setText("Nama Penerima");

        t_inputBarang_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_inputBarang_alamatActionPerformed(evt);
            }
        });

        jLabel9.setText("Alamat");

        jLabel10.setText("Alamat Penerima");

        jLabel11.setText("No Telepon");

        jLabel12.setText("No Telepon Penerima");

        jLabel13.setText("Barang");

        t_inputBarang_namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_inputBarang_namaBarangActionPerformed(evt);
            }
        });

        jLabel14.setText("Deskripsi Barang");

        t_inputBarang_descBarang.setColumns(20);
        t_inputBarang_descBarang.setRows(5);
        jScrollPane4.setViewportView(t_inputBarang_descBarang);

        jLabel15.setText("Kategori");

        btn_input_barang.setText("Send");
        btn_input_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_input_barangMouseClicked(evt);
            }
        });
        btn_input_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_input_barangActionPerformed(evt);
            }
        });

        btn_clear_input_barang.setText("Clear");
        btn_clear_input_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear_input_barangActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout content1Layout = new javax.swing.GroupLayout(content1);
        content1.setLayout(content1Layout);
        content1Layout.setHorizontalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_inputBarang_namaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(t_inputBarang_nama)
                            .addComponent(t_inputBarang_noTelp)
                            .addComponent(t_inputBarang_alamat)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_inputBarang_namaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(t_inputBarang_alamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(t_inputBarang_noTelpPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(btn_c1_kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(content1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_clear_input_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btn_input_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(190, 479, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dd_inputBarang_kategori1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        content1Layout.setVerticalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_c1_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_namaPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_alamatPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_noTelpPenerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_inputBarang_noTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_inputBarang_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dd_inputBarang_kategori1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear_input_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        content2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("List Barang");

        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "No", "Nama", "Nama Pengirim", "Alamat Tujuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_barang.setRowHeight(35);
        tbl_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_barang);
        if (tbl_barang.getColumnModel().getColumnCount() > 0) {
            tbl_barang.getColumnModel().getColumn(0).setResizable(false);
            tbl_barang.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        t_barang_search.setText("Searching....");
        t_barang_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_barang_searchMouseClicked(evt);
            }
        });
        t_barang_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_barang_searchActionPerformed(evt);
            }
        });
        t_barang_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_barang_searchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout content2Layout = new javax.swing.GroupLayout(content2);
        content2.setLayout(content2Layout);
        content2Layout.setHorizontalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_barang_search, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addGap(65, 65, 65))
        );
        content2Layout.setVerticalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_barang_search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        content3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setText("List Transaksi");

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "No", "Nama", "Nama Pengirim", "Tanggal Masuk", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_transaksi.setRowHeight(35);
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_transaksi);

        t_transaksi_cari.setText("Searching....");
        t_transaksi_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_transaksi_cariMouseClicked(evt);
            }
        });
        t_transaksi_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_transaksi_cariActionPerformed(evt);
            }
        });
        t_transaksi_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_transaksi_cariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout content3Layout = new javax.swing.GroupLayout(content3);
        content3.setLayout(content3Layout);
        content3Layout.setHorizontalGroup(
            content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_transaksi_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6))
                .addGap(65, 65, 65))
        );
        content3Layout.setVerticalGroup(
            content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_transaksi_cari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        content4.setBackground(new java.awt.Color(255, 255, 255));

        t_kategori_input_desc.setColumns(20);
        t_kategori_input_desc.setRows(5);
        jScrollPane8.setViewportView(t_kategori_input_desc);

        jButton6.setText("Clear");

        btn_input_kategori.setText("Send");
        btn_input_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_input_kategoriActionPerformed(evt);
            }
        });

        jLabel19.setText("Deskripsi Barang");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setText("Input Kategori");

        btn_c1_kembali1.setText("Kembali");
        btn_c1_kembali1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_c1_kembali1MouseClicked(evt);
            }
        });
        btn_c1_kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_c1_kembali1ActionPerformed(evt);
            }
        });

        jLabel21.setText("Nama Kategori");

        t_kategori_input_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kategori_input_namaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout content4Layout = new javax.swing.GroupLayout(content4);
        content4.setLayout(content4Layout);
        content4Layout.setHorizontalGroup(
            content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(t_kategori_input_nama)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(content4Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(content4Layout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_c1_kembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(content4Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(btn_input_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(55, 55, 55)))
        );
        content4Layout.setVerticalGroup(
            content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content4Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_kategori_input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(content4Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_c1_kembali1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(460, 460, 460)
                    .addGroup(content4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_input_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        content5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_kategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "No", "Nama", "Deskripsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_kategori.setRowHeight(35);
        tbl_kategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kategoriMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_kategori);
        if (tbl_kategori.getColumnModel().getColumnCount() > 0) {
            tbl_kategori.getColumnModel().getColumn(0).setResizable(false);
            tbl_kategori.getColumnModel().getColumn(0).setPreferredWidth(1);
            tbl_kategori.getColumnModel().getColumn(1).setPreferredWidth(2);
            tbl_kategori.getColumnModel().getColumn(2).setResizable(false);
            tbl_kategori.getColumnModel().getColumn(2).setPreferredWidth(4);
        }

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText("List Kategori");

        t_kategori_cari.setText("Searching....");
        t_kategori_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_kategori_cariMouseClicked(evt);
            }
        });
        t_kategori_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kategori_cariActionPerformed(evt);
            }
        });
        t_kategori_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_kategori_cariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout content5Layout = new javax.swing.GroupLayout(content5);
        content5.setLayout(content5Layout);
        content5Layout.setHorizontalGroup(
            content5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(content5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content5Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_kategori_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addGap(65, 65, 65))
        );
        content5Layout.setVerticalGroup(
            content5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(content5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_kategori_cari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentContainerLayout = new javax.swing.GroupLayout(contentContainer);
        contentContainer.setLayout(contentContainerLayout);
        contentContainerLayout.setHorizontalGroup(
            contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentContainerLayout.setVerticalGroup(
            contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(content5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainContainerLayout = new javax.swing.GroupLayout(mainContainer);
        mainContainer.setLayout(mainContainerLayout);
        mainContainerLayout.setHorizontalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainerLayout.createSequentialGroup()
                .addComponent(sideContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(contentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainContainerLayout.setVerticalGroup(
            mainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sideContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Dashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard1ActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content1.setVisible(true);
    }//GEN-LAST:event_btn_Dashboard1ActionPerformed

    private void btn_Dashboard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard2ActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content2.setVisible(true);
    }//GEN-LAST:event_btn_Dashboard2ActionPerformed

    private void btn_Dashboard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard3ActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content3.setVisible(true);
        
    }//GEN-LAST:event_btn_Dashboard3ActionPerformed
    
    private void btn_Dashboard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard4ActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content4.setVisible(true);
    }//GEN-LAST:event_btn_Dashboard4ActionPerformed

    private void btn_Dashboard5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard5ActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content5.setVisible(true);
    }//GEN-LAST:event_btn_Dashboard5ActionPerformed

    private void t_inputBarang_namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_inputBarang_namaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_inputBarang_namaBarangActionPerformed

    private void btn_c1_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_kembaliActionPerformed
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        mainContent.setVisible(true);
    }//GEN-LAST:event_btn_c1_kembaliActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        mainContent.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void t_barang_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_barang_searchActionPerformed
        
    }//GEN-LAST:event_t_barang_searchActionPerformed

    private void btn_c1_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_c1_kembaliMouseClicked
        
    }//GEN-LAST:event_btn_c1_kembaliMouseClicked

    private void t_barang_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_barang_searchMouseClicked
        t_barang_search.setText("");
    }//GEN-LAST:event_t_barang_searchMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        int response  = JOptionPane.showConfirmDialog(this, "Seriusan mau logout?", "LogOut Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            setSession(0);
            Auth yaw = new Auth();
            yaw.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void t_inputBarang_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_inputBarang_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_inputBarang_alamatActionPerformed

    private void tbl_dashboard_barangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dashboard_barangMouseExited
        
//        this.dispose();
    }//GEN-LAST:event_tbl_dashboard_barangMouseExited

    private void tbl_dashboard_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dashboard_barangMouseClicked
        mainContent.setVisible(false);
        content1.setVisible(false);
        content2.setVisible(false);
        content3.setVisible(false);
        content4.setVisible(false);
        content5.setVisible(false);
        content2.setVisible(true);
        String[] tabelBarang = {"No", "Nama", "Kategori", "Pengirim"};
        DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
        model.setColumnIdentifiers(tabelBarang);
    }//GEN-LAST:event_tbl_dashboard_barangMouseClicked

    private void t_transaksi_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_transaksi_cariMouseClicked
        t_transaksi_cari.setText("");
    }//GEN-LAST:event_t_transaksi_cariMouseClicked

    private void t_transaksi_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_transaksi_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_transaksi_cariActionPerformed

    private void t_kategori_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_kategori_cariMouseClicked
        if(t_kategori_cari.getText().equals("Searching....")){
            t_kategori_cari.setText("");
        }
        
    }//GEN-LAST:event_t_kategori_cariMouseClicked

    private void t_kategori_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kategori_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kategori_cariActionPerformed

    private void btn_c1_kembali1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_c1_kembali1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_c1_kembali1MouseClicked

    private void btn_c1_kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_c1_kembali1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_c1_kembali1ActionPerformed

    private void t_kategori_input_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kategori_input_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kategori_input_namaActionPerformed

    private void t_barang_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_barang_searchKeyTyped
        DefaultTableModel barangModel = (DefaultTableModel) tbl_barang.getModel();
        barangModel.setRowCount(0); // Clear the table
        int i=1;
        String key = t_barang_search.getText(); // Get the search keyword
        try {
            String query = "SELECT barang.id AS id, barang.nama AS barang_name, client.nama AS client_name, barang.alamat_penerima AS alamat_tujuan " +
                           "FROM barang JOIN client ON barang.fk_client = client.id " +
                           "WHERE barang.id LIKE ? OR barang.nama LIKE ? OR client.nama LIKE ? OR barang.alamat_penerima LIKE ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + key + "%");
            st.setString(2, "%" + key + "%");
            st.setString(3, "%" + key + "%");
            st.setString(4, "%" + key + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id"); // Retrieve the actual `barang.id`
                String barangNama = rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String alamat = rs.getString("alamat_tujuan");

                // Add row data, including the hidden ID column
                Object rowData[] = {id,i++, barangNama, clientNama, alamat};
                barangModel.addRow(rowData);
            }
            rs.close();
            st.close();

            // Ensure the `id` column remains hidden
            tbl_barang.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_barang.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_barang.getColumnModel().getColumn(0).setPreferredWidth(0);

        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_barang_searchKeyTyped

    private void inputPengirim(String nama, String alamat,String noTelp){
        String sql = "INSERT INTO client (nama, alamat, no_telp) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, alamat);
            ps.setString(3, noTelp);
            
            int rowsAffected= ps.executeUpdate();
            
            if(rowsAffected>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                
                getBarangData();
            }
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    private void btn_input_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_input_barangMouseClicked
        
        
        
    }//GEN-LAST:event_btn_input_barangMouseClicked
    
    private int inputClient(String nama, String alamat, String notelp) {
        String insertClientSQL = "INSERT INTO client(nama, alamat, no_telp) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertClientSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nama);
            ps.setString(2, alamat);
            ps.setString(3, notelp);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                getBarangData();
                return rs.getInt(1); // Return generated ID
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    private int searchKategoriId(String name) {
        String query = "SELECT id FROM kategori WHERE nama = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
            rs.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null,e);
        }
         return 0;   
    }
    private int inputBarang(String nama, int fk_kat, int fk_c, String desc, String nama_penerima, String alamat_penerima, String notelp_penerima) {
        String insertBarangSQL = "INSERT INTO barang (nama, fk_kategori, fk_client, description, nama_penerima, alamat_penerima, notelp_penerima) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertBarangSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nama);
            ps.setInt(2, fk_kat); // ID kategori
            ps.setInt(3, fk_c);   // ID client
            ps.setString(4, desc);
            ps.setString(5, nama_penerima);
            ps.setString(6, alamat_penerima);
            ps.setString(7, notelp_penerima);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Return generated ID
            }
            rs.close();
            getBarangData();
        } catch (SQLException e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    private void clearInputFields() {
        t_inputBarang_nama.setText("");
        t_inputBarang_alamat.setText("");
        t_inputBarang_noTelp.setText("");
        t_inputBarang_namaPenerima.setText("");
        t_inputBarang_alamatPenerima.setText("");
        t_inputBarang_noTelpPenerima.setText("");
        t_inputBarang_namaBarang.setText("");
        t_inputBarang_descBarang.setText("");
        dd_inputBarang_kategori1.setSelectedIndex(0); // Reset dropdown to first item
    }
    private void inputTransaksi(int fk_barang, int fk_client){
        String insertTransaksiSQL = "INSERT INTO transaksi (fk_barang, fk_client, tanggal, status) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insertTransaksiSQL);
            ps.setInt(1, fk_barang); // ID barang
            ps.setInt(2, fk_client); // ID client
            ps.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Tanggal saat ini
            ps.setString(4, "masuk"); // Status transaksi
            int rowsAffected = ps.executeUpdate();
    
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                getTransaksiData();
                clearInputFields();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        } catch (Exception e) {
        }
    }
    private void btn_input_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_input_barangActionPerformed
        String namaPengirim = t_inputBarang_nama.getText();
        String alamatPengirim = t_inputBarang_alamat.getText();
        String noTelp = t_inputBarang_noTelp.getText();

        if (namaPengirim.isEmpty() || alamatPengirim.isEmpty() || noTelp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi data pengirim!");
            return;
        }

        String namaPenerima = t_inputBarang_namaPenerima.getText();
        String alamatPenerima = t_inputBarang_alamatPenerima.getText();
        String noTelpPenerima = t_inputBarang_noTelpPenerima.getText();

        if (namaPenerima.isEmpty() || alamatPenerima.isEmpty() || noTelpPenerima.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi data penerima!");
            return;
        }

        String barang = t_inputBarang_namaBarang.getText();
        String desc = t_inputBarang_descBarang.getText();
        String kategori = dd_inputBarang_kategori1.getSelectedItem().toString();

        if (barang.isEmpty() || kategori.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi data barang!");
            return;
        }

        // Input client
        int idClient = inputClient(namaPengirim, alamatPengirim, noTelp);
        if (idClient == 0) {
            JOptionPane.showMessageDialog(this, "Gagal memasukkan data client!");
            return;
        }

        // Cari ID kategori
        int idKategori = searchKategoriId(kategori);
        if (idKategori == 0) {
            JOptionPane.showMessageDialog(this, "Kategori tidak ditemukan!");
            return;
        }

        // Input barang
        int idBarang = inputBarang(barang, idKategori, idClient, desc, namaPenerima, alamatPenerima, noTelpPenerima);
        if (idBarang == 0) {
            JOptionPane.showMessageDialog(this, "Gagal memasukkan data barang!");
            return;
        }

        // Input transaksi
        inputTransaksi(idBarang, idClient);


    }//GEN-LAST:event_btn_input_barangActionPerformed

    private void btn_input_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_input_kategoriActionPerformed
        String nama = t_kategori_input_nama.getText();
        String desc = t_kategori_input_desc.getText();
        
        if(nama.isEmpty()||desc.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi", "validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String query = "INSERT INTO kategori (nama,description) values (?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nama);
            st.setString(2, desc);
            
            
            int rowInserted  =st.executeUpdate();
            if(rowInserted>0){
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                
                getKategoriData();
                loadDataToKategoriDropDown();
            }
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null,e);
        }
    }//GEN-LAST:event_btn_input_kategoriActionPerformed

    private void btn_clear_input_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear_input_barangActionPerformed
        t_inputBarang_nama.setText("");
        t_inputBarang_alamat.setText("");
        t_inputBarang_noTelp.setText("");
        t_inputBarang_namaPenerima.setText("");
        t_inputBarang_alamatPenerima.setText("");
        t_inputBarang_noTelpPenerima.setText("");
        t_inputBarang_namaBarang.setText("");
        t_inputBarang_descBarang.setText("");
        dd_inputBarang_kategori1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clear_input_barangActionPerformed

    private void t_transaksi_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_transaksi_cariKeyTyped
        DefaultTableModel transaksiModel = (DefaultTableModel) tbl_transaksi.getModel();
        transaksiModel.setRowCount(0); // Clear the table
        int i = 1;
        String key = t_transaksi_cari.getText(); // Get the search keyword

        try {
            // Query to filter transactions based on search criteria
            String query = "SELECT transaksi.id as t_id,barang.nama AS barang_name, client.nama AS client_name, transaksi.tanggal, transaksi.status " +
                           "FROM transaksi " +
                           "JOIN barang ON transaksi.fk_barang = barang.id " +
                           "JOIN client ON transaksi.fk_client = client.id " +
                           "WHERE barang.nama LIKE ? OR client.nama LIKE ? OR transaksi.tanggal LIKE ? OR transaksi.status LIKE ?";
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, "%" + key + "%"); // Search by barang name
            st.setString(2, "%" + key + "%"); // Search by client name
            st.setString(3, "%" + key + "%"); // Search by transaction date
            st.setString(4, "%" + key + "%"); // Search by transaction status
            ResultSet rs = st.executeQuery();

            // Populate the table with filtered results
            while (rs.next()) {
                int id = rs.getInt("t_id");
                String barangNama = rs.getString("barang_name");
                String clientNama = rs.getString("client_name");
                String tanggal = rs.getString("tanggal");
                String status = rs.getString("status");

                Object rowData[] = {id,i++, barangNama, clientNama, tanggal, status};
                transaksiModel.addRow(rowData);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_transaksi_cariKeyTyped

    private void t_kategori_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_kategori_cariKeyTyped
        DefaultTableModel kategoriModel = (DefaultTableModel) tbl_kategori.getModel();
        kategoriModel.setRowCount(0); // Clear the table

        String key = t_kategori_cari.getText(); // Get the search keyword

        try {
            // Query to filter categories based on the search key
            String query = "SELECT * FROM kategori WHERE nama LIKE ? OR description LIKE ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + key + "%"); // Search in the "nama" column
            st.setString(2, "%" + key + "%"); // Search in the "description" column
            ResultSet rs = st.executeQuery();

            int i = 1; // Counter for the row index
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String desc = rs.getString("description");

                // Add the filtered rows to the table
                Object rowData[] = {id,i++, nama, desc};
                kategoriModel.addRow(rowData);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_kategori_cariKeyTyped

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        int selectedRow = tbl_barang.getSelectedRow();
        if (selectedRow != -1) {
            int barangId = Integer.parseInt(tbl_barang.getValueAt(selectedRow, 0).toString());
            try {
                String query = "SELECT client.id as idPengirim,barang.nama AS barang_name, barang.description,kategori.id as idKategori, kategori.nama AS kategori_name, " +
                               "client.nama AS nama_pengirim, client.alamat AS alamat_pengirim, client.no_telp AS no_telp_pengirim, " +
                               "barang.nama_penerima, barang.alamat_penerima, barang.notelp_penerima " +
                               "FROM barang " +
                               "JOIN kategori ON barang.fk_kategori = kategori.id " +
                               "JOIN client ON barang.fk_client = client.id " +
                               "WHERE barang.id = ?";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, barangId);
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    int idKategori = rs.getInt("idKategori");
                    int idPengirim = rs.getInt("idPengirim");
                    String namaPengirim = rs.getString("nama_pengirim");
                    String alamatPengirim = rs.getString("alamat_pengirim");
                    String noTelpPengirim = rs.getString("no_telp_pengirim");
                    String namaPenerima = rs.getString("nama_penerima");
                    String alamatPenerima = rs.getString("alamat_penerima");
                    String noTelpPenerima = rs.getString("notelp_penerima");
                    String namaBarang = rs.getString("barang_name");
                    String desc = rs.getString("description");
                    String kategori = rs.getString("kategori_name");

                    // Open the BarangDetailed frame
                    BarangDetailed barangDetails = new BarangDetailed();
                    barangDetails.setBarangDetails(idPengirim,barangId,idKategori, namaPengirim, alamatPengirim, noTelpPengirim,
                                                   namaPenerima, alamatPenerima, noTelpPenerima,
                                                   namaBarang, desc, kategori);
                    barangDetails.setVisible(true);
                }
                rs.close();
                st.close();
            } catch (Exception e) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        int selectedRow = tbl_transaksi.getSelectedRow();
        if(selectedRow!=-1){
            int transaksiId = Integer.parseInt(tbl_transaksi.getValueAt(selectedRow, 0).toString());
            try {
                String query = "SELECT transaksi.id AS transaksi_id, transaksi.tanggal as tanggal, transaksi.status as status, client.id as clientId,client.nama AS client_nama,client.no_telp AS clientTelp,barang.id as barangId, barang.nama AS barang_nama, barang.alamat_penerima AS barang_alamat FROM proyekpbo.transaksi JOIN proyekpbo.client ON transaksi.fk_client = client.id JOIN proyekpbo.barang ON transaksi.fk_barang = barang.id WHERE transaksi.id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, transaksiId);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int idClient = rs.getInt("clientId");
                    int idbarang = rs.getInt("barangId");
                    String tanggal = rs.getString("tanggal");
                    String status = rs.getString("status");
                    String clientNama = rs.getString("client_nama");
                    String barangNama = rs.getString("barang_nama");
                    String clientTelp = rs.getString("clientTelp");
                    String barangAlamat = rs.getString("barang_alamat");
                    TransaksiDetailed transaksi = new TransaksiDetailed();
                    transaksi.setTransaksiDetails(idClient,idbarang,transaksiId, barangNama, clientNama, clientTelp, status, tanggal, barangAlamat);
                    transaksi.setVisible(true);
                }
                ps.close();
                rs.close();
            } catch (Exception e) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btn_Dashboard6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dashboard6ActionPerformed
        getBarangData();
        getTransaksiData();
        getDashboardBarangData();
        getDashboardTransaksiData();
        loadDataToKategoriDropDown();
        getKategoriData();
        JOptionPane.showMessageDialog(this, "Table telah di-update!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_Dashboard6ActionPerformed

    private void tbl_kategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kategoriMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_kategori.getSelectedRow();
        if(selectedRow!=-1){
            int kategoriId = Integer.parseInt(tbl_kategori.getValueAt(selectedRow, 0).toString());
            try {
                String query = "Select * from kategori where id =?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, kategoriId);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    int id = rs.getInt("id");
                    String nama = rs.getString("nama");
                    String desc = rs.getString("description");
                    KategoriDetailed kategori = new KategoriDetailed();
                    kategori.setKategoriField(id, nama, desc);
                    kategori.setVisible(true);
                }
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_tbl_kategoriMouseClicked
    public void loadDataToKategoriDropDown(){
        dd_inputBarang_kategori1.removeAllItems();
        try {
            String sql = "SELECT id, nama FROM kategori"; // Query mengambil data produk
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Tambahkan data ke JComboBox
            while (rs.next()) {
                
                String type = rs.getString("nama");
                dd_inputBarang_kategori1.addItem(type); // Tambahkan objek Product
            }
        } catch (Exception e) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void setWelcomeName(String name) {
        t_welcome_name1.setText(name);
        String[] tabelBarang = {"No", "Nama", "Kategori", "Pengirim"};
        String[] tabelTransaksi = {"No","Barang", "Pengirim", "Tanggal","Status"};
        DefaultTableModel model = (DefaultTableModel) tbl_dashboard_barang.getModel();
        DefaultTableModel modelTransaksi = (DefaultTableModel) tbl_dashboard_transaksi.getModel();
        model.setColumnIdentifiers(tabelBarang);
        modelTransaksi.setColumnIdentifiers(tabelTransaksi);
    }
    public void setBawahName(String name) {
        jLabel2.setText(name);
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
            // Set FlatLaf Light look and feel
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true); // Make the Swing window visible
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dashboard1;
    private javax.swing.JButton btn_Dashboard2;
    private javax.swing.JButton btn_Dashboard3;
    private javax.swing.JButton btn_Dashboard4;
    private javax.swing.JButton btn_Dashboard5;
    private javax.swing.JButton btn_Dashboard6;
    private javax.swing.JButton btn_c1_kembali;
    private javax.swing.JButton btn_c1_kembali1;
    private javax.swing.JButton btn_clear_input_barang;
    private javax.swing.JButton btn_input_barang;
    private javax.swing.JButton btn_input_kategori;
    private javax.swing.JPanel content1;
    private javax.swing.JPanel content2;
    private javax.swing.JPanel content3;
    private javax.swing.JPanel content4;
    private javax.swing.JPanel content5;
    private javax.swing.JPanel contentContainer;
    private javax.swing.JComboBox<String> dd_inputBarang_kategori1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel mainContent;
    private javax.swing.JPanel sideContainer;
    private javax.swing.JTextField t_barang_search;
    private javax.swing.JTextField t_inputBarang_alamat;
    private javax.swing.JTextField t_inputBarang_alamatPenerima;
    private javax.swing.JTextArea t_inputBarang_descBarang;
    private javax.swing.JTextField t_inputBarang_nama;
    private javax.swing.JTextField t_inputBarang_namaBarang;
    private javax.swing.JTextField t_inputBarang_namaPenerima;
    private javax.swing.JTextField t_inputBarang_noTelp;
    private javax.swing.JTextField t_inputBarang_noTelpPenerima;
    private javax.swing.JTextField t_kategori_cari;
    private javax.swing.JTextArea t_kategori_input_desc;
    private javax.swing.JTextField t_kategori_input_nama;
    private javax.swing.JTextField t_transaksi_cari;
    private javax.swing.JLabel t_welcome_name;
    private javax.swing.JLabel t_welcome_name1;
    private javax.swing.JTable tbl_barang;
    private javax.swing.JTable tbl_dashboard_barang;
    private javax.swing.JTable tbl_dashboard_transaksi;
    private javax.swing.JTable tbl_kategori;
    private javax.swing.JTable tbl_transaksi;
    // End of variables declaration//GEN-END:variables
}
