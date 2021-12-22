/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Adan Nugraha
 */
public class TambahBarang {
    private Connection koneksi; 
    private PreparedStatement psmt;
    private String query;
    
    public TambahBarang() {
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }      
    }
    
    // Kita ngambil nama barang dan harga per item
    public void Tambahkan(String namaBarang, int hargaPerItem, int jumlah, int totalHarga) {
        query = "INSERT INTO transaksi_sementara (nama_barang, harga_satuan, jumlah_barang, total_harga) VALUES (?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.setString(1,namaBarang); 
            psmt.setInt(2, hargaPerItem);
            psmt.setInt(3, jumlah);
            psmt.setInt(4, totalHarga);
            psmt.executeUpdate(); 
            psmt.close(); 
        } catch(SQLException e){ 
            System.out.println(e); 
        } 
    }
}
