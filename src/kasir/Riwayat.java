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

/**
 *
 * @author Adan Nugraha
 */
public class Riwayat {
    private Connection koneksi; 
    private PreparedStatement psmt; 
    private Statement stat; 
    private ResultSet hasilTransaksi ,hasilDetail;
    private String query, idTransaksi, waktu, totalBayar, uangBayar, kembalian, pegawai,
            jumlahBarang, totalHarga, namaBarang;
    
    public Riwayat() {
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idtransaksi) {
        this.idTransaksi = idtransaksi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(String uangBayar) {
        this.uangBayar = uangBayar;
    }

    public String getKembalian() {
        return kembalian;
    }

    public void setKembalian(String kembalian) {
        this.kembalian = kembalian;
    }

    public String getPegawai() {
        return pegawai;
    }

    public void setPegawai(String pegawai) {
        this.pegawai = pegawai;
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

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    
    public ResultSet tampilData(){ 
        query = "SELECT * FROM transaksi"; 
        try {   
            stat = koneksi.createStatement(); 
            hasilTransaksi = stat.executeQuery(query); 
        }catch (SQLException e){ 
        } 
        return hasilTransaksi; 
    } 
    
    public ResultSet tampilDetail(String idTransaksi) {
        query = "SELECT * FROM transaksi_barang WHERE id_transaksi = ?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, idTransaksi);
            hasilDetail = psmt.executeQuery();
        } catch (SQLException e) {
        }
        return hasilDetail;
    }
}
