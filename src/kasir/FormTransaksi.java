/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adan Nugraha
 */
public class FormTransaksi extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private ResultSet hasil; 
    private int totalHarga = 0;
    private int uang, kembalian;
    private String idTransaksi = UUID.randomUUID().toString();
    /**
     * Creates new form FormTransaksi
     */
    Transaksi transaksi = new Transaksi();
    public FormTransaksi() {
        initComponents();
        tampilDatabase();
    }

    public void tampilDatabase(){
        Object [] baris = {"Nama Barang", "Harga Satuan", "Jumlah Barang", "Total Harga"}; 
        tabmode = new DefaultTableModel(null, baris);
        tabelBarang.setModel(tabmode);
        try {
            hasil = transaksi.tampilData();
            while (hasil.next()) {
                transaksi.setNamaBarang(hasil.getString("nama_barang"));
                transaksi.setHargaSatuan(hasil.getString("harga_satuan"));
                transaksi.setJumlahBarang(hasil.getString("jumlah_barang"));
                transaksi.setTotalHarga(hasil.getString("total_harga"));
                totalHarga = totalHarga + Integer.parseInt(hasil.getString("total_harga"));
                String[] data = {transaksi.getNamaBarang(), transaksi.getHargaSatuan(), transaksi.getJumlahBarang(), transaksi.getTotalHarga()};
                tabmode.addRow(data);
            }
            txtBayar.setText(Integer.toString(totalHarga));
        } catch (NumberFormatException | SQLException e) {
            
        }
    }
    
    public void hapusSemua(){
        // hapus semua data di jtable dan database
        int row = tabmode.getRowCount();
        for (int i = row - 1; i >= 0; i--) {
            tabmode.removeRow(i);
        }
        
        transaksi.hapusDatabase();
    }
    
    public void reset() {
        txtBayar.setText("");
        txtUang.setText("");
        txtKembalian.setText("");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtBayar = new javax.swing.JTextField();
        txtUang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        txtKembalian = new javax.swing.JTextField();
        btnCatat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        btnHitung = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asikeun Electronics");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel2.setText("Total yang harus dibayar");

        jLabel4.setText("Masukan Uang yang dibayarkan");

        jLabel5.setText("Kembalian");

        btnTambah.setText("Tambah Barang");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        txtKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembalianActionPerformed(evt);
            }
        });

        btnCatat.setText("Catat Transaksi");
        btnCatat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatatActionPerformed(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Harga Satuan", "Jumlah Barang", "Total Harga"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelBarang);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnReset)
                        .addGap(41, 41, 41)
                        .addComponent(btnKembali)
                        .addGap(36, 36, 36)
                        .addComponent(btnCatat))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(247, 247, 247)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBayar)
                            .addComponent(txtUang)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnHitung)))
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnHitung))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnReset)
                    .addComponent(btnCatat))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        FormSelamatDatang formSelamatDatang = new FormSelamatDatang();
        dispose();
        formSelamatDatang.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FormTambahBarang formTambahBarang = new FormTambahBarang();
        dispose();
        formTambahBarang.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        if (txtUang.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Uang yang dibayar belum diisi !");
            txtUang.requestFocus();
        } else {
            uang = Integer.parseInt(txtUang.getText());
            if (uang < totalHarga) {
            JOptionPane.showMessageDialog(null,  "Uang yang dibayarkan harus lebih dari total bayar !"   ,  "Informasi", 
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
            kembalian = uang - totalHarga; 
            txtKembalian.setText(Integer.toString(kembalian));
            }
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void txtKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKembalianActionPerformed

    private void btnCatatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatatActionPerformed
        uang = Integer.parseInt(txtUang.getText());
        kembalian = uang - totalHarga; 
        int row = tabmode.getRowCount();
        String username = Session.getUsername();
        transaksi.masukTransaksi(username, totalHarga, uang, kembalian, idTransaksi);
        for(int i = 0; i < row; i++) {
            String nama_barang = (String) tabelBarang.getValueAt(i, 0);
            String jumlah_barang = (String) tabelBarang.getValueAt(i, 2);
            String total_harga = (String) tabelBarang.getValueAt(i, 3);
            int jumlahBarang = Integer.parseInt(jumlah_barang);
            int total_Harga = Integer.parseInt(total_harga);
            transaksi.masukBarang(idTransaksi, jumlahBarang, total_Harga, nama_barang);
        }
        JOptionPane.showMessageDialog(null,  "Transaksi Berhasil Tercatat !"   ,  "Informasi", 
                  JOptionPane.INFORMATION_MESSAGE);
        hapusSemua();
        reset();
    }//GEN-LAST:event_btnCatatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        hapusSemua();
        reset();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatat;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtUang;
    // End of variables declaration//GEN-END:variables
}
