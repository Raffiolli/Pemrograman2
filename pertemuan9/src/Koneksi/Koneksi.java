/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    public static Connection getKoneksi() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost/penjualan_barang";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, pass);

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }
}