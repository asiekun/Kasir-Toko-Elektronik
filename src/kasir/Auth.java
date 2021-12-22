/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adan Nugraha
 */
public class Auth {
    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query,username,password,pesan;
    
    public Auth(){
        KoneksiDatabase connection = new KoneksiDatabase();
        try { 
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) { 
        this.password = password;
    }

    public String getPassword() { 
        return password;
    }

    public String cekLogin(String username, String password) { 
        query = "SELECT nama FROM pegawai WHERE username = ? AND password = md5(?)";
        System.out.println("Bisa 1!");
        try { 
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            dataUser = psmt.executeQuery();
            System.out.println("Bisa 2!");
            if (!dataUser.next()){
                pesan = "Gagal Login";
            } else {
                Session.setUsername(username);
                Session.setNama (dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF"); 
                query = "INSERT INTO log_login (username) VALUES (?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, username);
                    psmt.executeUpdate();
                    psmt.close();
                    System.out.println("Bisa 3!");
                } catch (SQLException e) {
                    pesan = "Gagal Simpan Log Login";
                }
            }
        } catch (SQLException e) {
            pesan = "Gagal Login, Query Error";
        }
    return pesan;
    }

    public void Logout(String username){
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE username=? ORDER BY id DESC LIMIT 1";
        try { 
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.executeUpdate();
            psmt.close();
            // memutus koneksi database
            koneksi.close();
            // hapus Session
            Session.setUsername(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch (SQLException e) { }
    }
}
