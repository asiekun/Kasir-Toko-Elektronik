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
public class Register {
    private Connection koneksi; 
    private PreparedStatement psmt; 
    private String query, username, nama, password, konfirmasi, pesan;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKonfirmasi() {
        return konfirmasi;
    }

    public void setKonfirmasi(String konfirmasi) {
        this.konfirmasi = konfirmasi;
    }
    
    public Register() {
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }
    
    public String daftar(String username, String nama, String password) {
        query = "INSERT INTO pegawai(username, nama, password) VALUES (?,?,md5(?))";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, nama);
            psmt.setString(3, password);
            psmt.executeUpdate(); 
            psmt.close();
         
        } catch (SQLException e) {
            pesan = "Gagal Daftar, Query Error";
        }
        return pesan;
    }
}
