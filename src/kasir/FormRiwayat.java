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
    public String idTerpilih;
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

    public String getIdTerpilih() {
        return idTerpilih;
    }

    public void setIdTerpilih(String idTerpilih) {
        this.idTerpilih = idTerpilih;
    }
    
    
    public void tampilTransaksi() {
        Object [] transaksi = {"ID Transaksi", "Waktu", "Total Bayar", "Uang Bayar", "Kembalian", "Pegawai"};
        tabmode = new DefaultTableModel(null, transaksi);
        tabelRiwayat.setModel(tabmode);
        try {
            hasilTransaksi = riwayat.tampilData();
            while (hasilTransaksi.next()) {
                riwayat.setIdTransaksi(hasilTransaksi.getString("id_transaksi"));
                riwayat.setWaktu(hasilTransaksi.getString("waktu_transaksi"));
                riwayat.setTotalBayar(hasilTransaksi.getString("total_pembayaran"));
                riwayat.setUangBayar(hasilTransaksi.getString("uang_dibayar"));
                riwayat.setKembalian(hasilTransaksi.getString("kembalian"));
                riwayat.setPegawai(hasilTransaksi.getString("username_pegawai"));
                String[] dataTransaksi = {riwayat.getIdTransaksi(), riwayat.getWaktu(), riwayat.getTotalBayar(),
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbIdTransaksi = new javax.swing.JComboBox<>();
        btnDetail = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 181, 218));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pilih ID Transaksi");

        cmbIdTransaksi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmbIdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdTransaksiActionPerformed(evt);
            }
        });

        btnDetail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDetail.setText("Cek Detail Transaksi");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnKembali.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnKembali)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDetail)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(cmbIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnKembali))
                .addContainerGap(279, Short.MAX_VALUE))
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

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        setIdTerpilih((String)cmbIdTransaksi.getSelectedItem());
        FormDetailTransaksi formDetailTransaksi = new FormDetailTransaksi(getIdTerpilih());
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelRiwayat;
    // End of variables declaration//GEN-END:variables
}
