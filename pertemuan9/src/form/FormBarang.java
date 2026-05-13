/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import koneksi.Koneksi;
import java.sql.*;
import javax.swing.*;

public class FormBarang extends JFrame {

    JTextField txtKode, txtNama, txtHarga, txtStok;
    JButton btnSimpan;

    public FormBarang() {

        setTitle("Data Barang");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Kode Barang");
        l1.setBounds(20, 20, 100, 25);
        add(l1);

        txtKode = new JTextField();
        txtKode.setBounds(120, 20, 200, 25);
        add(txtKode);

        JLabel l2 = new JLabel("Nama Barang");
        l2.setBounds(20, 60, 100, 25);
        add(l2);

        txtNama = new JTextField();
        txtNama.setBounds(120, 60, 200, 25);
        add(txtNama);

        JLabel l3 = new JLabel("Harga");
        l3.setBounds(20, 100, 100, 25);
        add(l3);

        txtHarga = new JTextField();
        txtHarga.setBounds(120, 100, 200, 25);
        add(txtHarga);

        JLabel l4 = new JLabel("Stok");
        l4.setBounds(20, 140, 100, 25);
        add(l4);

        txtStok = new JTextField();
        txtStok.setBounds(120, 140, 200, 25);
        add(txtStok);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(120, 190, 100, 30);
        add(btnSimpan);

        btnSimpan.addActionListener(e -> simpanData());
    }

    private void simpanData() {

        try {

            String sql = "INSERT INTO barang VALUES(?,?,?, ?,?)";

            Connection conn = Koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtKode.getText());
            pst.setString(2, txtNama.getText());
            pst.setInt(3, Integer.parseInt(txtHarga.getText()));
            pst.setInt(4, Integer.parseInt(txtStok.getText()));
            pst.setString(5, "Umum");

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}