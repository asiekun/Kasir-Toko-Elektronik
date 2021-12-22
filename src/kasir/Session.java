/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package kasir;

/**
 *
 * @author Adan Nugraha 202031242
 */
public class Session {
    private static String username, nama, StatusLogin;

    public static void setUsername(String username) {
        Session.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Session.nama = nama;
    }
    
    public static void setStatusLogin(String StatusLogin) {
        Session.StatusLogin = StatusLogin;
    }
    
    public static String getStatusLogin() {
        return StatusLogin;
    }
}