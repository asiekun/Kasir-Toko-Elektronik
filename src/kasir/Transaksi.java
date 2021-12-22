/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adan Nugraha
 */
public class Transaksi {
    private Connection koneksi; 
    private PreparedStatement psmt; 
    private Statement stat; 
    private ResultSet hasil;  
    private String query, namaBarang, hargaSatuan, jumlahBarang, totalHarga;
    
    
    public Transaksi() {
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(String hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    public ResultSet tampilData(){ 
        query = "SELECT * FROM transaksi_sementara"; 
        try {   
            stat = koneksi.createStatement(); 
            hasil = stat.executeQuery(query); 
        }catch (SQLException e){ 
        } 
        return hasil; 
    } 
    
    public void masukTransaksi(String username_pegawai, int total_pembayaran, int uang_dibayar, int kembalian, String id_transaksi){
        query = "INSERT INTO transaksi(username_pegawai, total_pembayaran, uang_dibayar, kembalian, id_transaksi) "
                + "VALUES (?,?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.setString(1,username_pegawai);
            psmt.setInt(2, total_pembayaran);
            psmt.setInt(3, uang_dibayar);
            psmt.setInt(4, kembalian);
            psmt.setString(5, id_transaksi);
            psmt.executeUpdate(); 
            psmt.close(); 
        } catch(SQLException e){ 
            System.out.println(e); 
        } 
        // Session.getUsername));
    }
    
    public void masukBarang(String id_transaksi, int jumlah_barang, int total_harga, String nama_barang){
        query = "INSERT INTO transaksi_barang(id_transaksi, jumlah_barang, total_harga, nama_barang) "
                + "VALUES(?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.setString(1,id_transaksi);
            psmt.setInt(2, jumlah_barang);
            psmt.setInt(3, total_harga);
            psmt.setString(4, nama_barang);
            psmt.executeUpdate(); 
            psmt.close(); 
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public void hapusDatabase() {
        query = "DELETE FROM transaksi_sementara";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.executeUpdate(); 
            psmt.close(); 
        }catch(SQLException e){ 
            System.out.println(e); 
        } 
    }
    
}
