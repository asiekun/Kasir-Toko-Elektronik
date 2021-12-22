/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Adan Nugraha
 */
public class FormTambahBarang extends javax.swing.JFrame {
    private Connection koneksi; 
    private PreparedStatement psmt;
    private ResultSet rs;
    private String query, harga;
    Hashtable<String, String> kamus = new Hashtable<String, String>();
    
    FormTransaksi formTransaksi = new FormTransaksi();
    TambahBarang tambahBarang = new TambahBarang();
    
    private void loadBarang() {
        query = "SELECT * FROM barang";
        try {
            psmt = koneksi.prepareStatement(query);
            rs = psmt.executeQuery();
            while (rs.next()) {
                String barang = rs.getString("nama");
                String harga = rs.getString("harga");
                kamus.put(barang, harga);
                cmbNamaBarang.addItem(barang);
            }
        } catch(SQLException e){ 
            System.out.println(e); 
        }
    }
    
    private String pilihBarang(String namaBarang) {
        String hargaBarang;
        hargaBarang = kamus.get( namaBarang);
        return hargaBarang;
    }
    
    /**
     * Creates new form FormTambahBarang
     */
    public FormTambahBarang() {
        initComponents();
        
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        } 
        
        loadBarang();
        harga = pilihBarang((String) cmbNamaBarang.getSelectedItem());
        txtHargaPerItem.setText(harga);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        cmbNamaBarang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        txtJumlah = new javax.swing.JTextField();
        txtHargaPerItem = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamaBarangActionPerformed(evt);
            }
        });

        jLabel1.setText("Pilih Barang");

        jLabel2.setText("Jumlah");

        jLabel3.setText("Harga Per Item");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambahkan");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });

        txtHargaPerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaPerItemActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Harga");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHitung))
                    .addComponent(txtHargaPerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btnKembali)
                        .addGap(73, 73, 73)
                        .addComponent(btnTambah))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnReset)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHargaPerItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHitung))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnTambah))
                .addGap(126, 126, 126))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
        formTransaksi.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void cmbNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamaBarangActionPerformed
        harga = pilihBarang((String) cmbNamaBarang.getSelectedItem());
        txtHargaPerItem.setText(harga);
    }//GEN-LAST:event_cmbNamaBarangActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtHargaPerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaPerItemActionPerformed
        
    }//GEN-LAST:event_txtHargaPerItemActionPerformed

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
        
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        String hargaPerItem = txtHargaPerItem.getText();
        String jumlahBarang = txtJumlah.getText();
        int totalHarga = Integer.parseInt(hargaPerItem) * Integer.parseInt(jumlahBarang);
        txtTotalHarga.setText(Integer.toString(totalHarga)); 
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtJumlah.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama = (String) cmbNamaBarang.getSelectedItem();
        int hargaSatuan = Integer.parseInt(txtHargaPerItem.getText());
        int jumlah = Integer.parseInt(txtJumlah.getText());
        int totalHarga = hargaSatuan * jumlah;
        tambahBarang.Tambahkan(nama, hargaSatuan, jumlah, totalHarga);
        dispose();
        formTransaksi.setVisible(true);
        formTransaksi.tampilDatabase();
    }//GEN-LAST:event_btnTambahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbNamaBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField txtHargaPerItem;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
