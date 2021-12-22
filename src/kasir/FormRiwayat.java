/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adan Nugraha
 */
public class FormRiwayat extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private ResultSet hasilTransaksi;
    private Connection koneksi; 
    private PreparedStatement psmt;
    private ResultSet rs;
    private String query, idTransaksi;
    /**
     * Creates new form FormRiwayat
     */
    Riwayat riwayat = new Riwayat();
    public FormRiwayat() {
        initComponents();
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        } 
        tampilTransaksi();
        loadIdTransaksi();
    }
    
    private void tampilTransaksi() {
        Object [] transaksi = {"ID Transaksi", "Waktu", "Total Bayar", "Uang Bayar", "Kembalian", "Pegawai"};
        tabmode = new DefaultTableModel(null, transaksi);
        tabelRiwayat.setModel(tabmode);
        try {
            hasilTransaksi = riwayat.tampilData();
            while (hasilTransaksi.next()) {
                riwayat.setIdtransaksi(hasilTransaksi.getString("id_transaksi"));
                riwayat.setWaktu(hasilTransaksi.getString("waktu_transaksi"));
                riwayat.setTotalBayar(hasilTransaksi.getString("total_pembayaran"));
                riwayat.setUangBayar(hasilTransaksi.getString("uang_bayar"));
                riwayat.setKembalian(hasilTransaksi.getString("kembalian"));
                riwayat.setPegawai(hasilTransaksi.getString("username_pegawai"));
                String[] dataTransaksi = {riwayat.getIdtransaksi(), riwayat.getWaktu(), riwayat.getTotalBayar(),
                                            riwayat.getUangBayar(), riwayat.getKembalian(), riwayat.getPegawai()};
                tabmode.addRow(dataTransaksi);
            }
        } catch (NumberFormatException | SQLException e) {
            
        }
        
    }
    
    private void loadIdTransaksi() {
        query = "SELECT * FROM transaksi";
        try {
            psmt = koneksi.prepareStatement(query);
            rs = psmt.executeQuery();
            while (rs.next()) {
                idTransaksi = rs.getString("id_transaksi");
                cmbIdTransaksi.addItem(idTransaksi);
            }
        } catch(SQLException e){ 
            System.out.println(e); 
        }
    }
    /**s
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        cmbIdTransaksi = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnDetail.setText("Cek Detail Transaksi");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        jLabel1.setText("Pilih ID Transaksi");

        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Waktu", "Total Bayar", "Uang Bayar", "Kembalian", "Pegawai"
            }
        ));
        tabelRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRiwayatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelRiwayat);

        cmbIdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKembali)
                        .addGap(45, 45, 45)
                        .addComponent(btnDetail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnKembali))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        FormDetailTransaksi formDetailTransaksi = new FormDetailTransaksi();
        dispose();
        formDetailTransaksi.setVisible(true);
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        FormSelamatDatang formSelamatDatang = new FormSelamatDatang();
        dispose();
        formSelamatDatang.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void tabelRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRiwayatMouseClicked
       
    }//GEN-LAST:event_tabelRiwayatMouseClicked

    private void cmbIdTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdTransaksiActionPerformed
        
    }//GEN-LAST:event_cmbIdTransaksiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> cmbIdTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelRiwayat;
    // End of variables declaration//GEN-END:variables
}