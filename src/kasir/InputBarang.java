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
public class InputBarang {
    private Connection koneksi;
    private PreparedStatement psmt;
    private String query, namaBarang;
    private int hargaPerItem;
    
    public InputBarang() {
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

    public int getHargaPerItem() {
        return hargaPerItem;
    }

    public void setHargaPerItem(int hargaPerItem) {
        this.hargaPerItem = hargaPerItem;
    }
    
    public void input(String namaBarang, int hargaPerItem) {
        query = "INSERT INTO barang (nama, harga) VALUES (?,?)";
        try {
            psmt = koneksi.prepareStatement(query); 
            psmt.setString(1,namaBarang); 
            psmt.setInt(2, hargaPerItem);
            psmt.executeUpdate(); 
            psmt.close(); 
        } catch(SQLException e){ 
            System.out.println(e); 
        } 
    }
}
