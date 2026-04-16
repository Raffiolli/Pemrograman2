/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Rafi
 */
public class Mainapp {
   static Connection conn = koneksi.getKoneksi();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n=== MENU CRUD MAHASISWA ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
            }

        } while (pilihan != 0);
    }

    // CREATE
    static void tambahData() {
        try {
            System.out.print("NIM: ");
            String nim = input.nextLine();
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("Jurusan: ");
            String jurusan = input.nextLine();
            System.out.print("Nilai: ");
            double nilai = input.nextDouble();

            String sql = "INSERT INTO mahasiswa VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, jurusan);
            ps.setDouble(4, nilai);

            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    static void tampilData() {
        try {
            String sql = "SELECT * FROM mahasiswa";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n=== DATA MAHASISWA ===");
            while (rs.next()) {
                System.out.println(
                        rs.getString("nim") + " | " +
                        rs.getString("nama") + " | " +
                        rs.getString("jurusan") + " | " +
                        rs.getDouble("nilai")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    static void updateData() {
        try {
            System.out.print("Masukkan NIM yang diupdate: ");
            String nim = input.nextLine();

            System.out.print("Nama baru: ");
            String nama = input.nextLine();
            System.out.print("Jurusan baru: ");
            String jurusan = input.nextLine();
            System.out.print("Nilai baru: ");
            double nilai = input.nextDouble();

            String sql = "UPDATE mahasiswa SET nama=?, jurusan=?, nilai=? WHERE nim=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, jurusan);
            ps.setDouble(3, nilai);
            ps.setString(4, nim);

            ps.executeUpdate();
            System.out.println("Data berhasil diupdate!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    static void hapusData() {
        try {
            System.out.print("Masukkan NIM yang dihapus: ");
            String nim = input.nextLine();

            String sql = "DELETE FROM mahasiswa WHERE nim=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nim);
            ps.executeUpdate();

            System.out.println("Data berhasil dihapus!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
