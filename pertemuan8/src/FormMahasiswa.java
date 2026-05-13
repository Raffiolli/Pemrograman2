/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Rafi
 */
public class FormMahasiswa extends JFrame {

    JLabel lblNama;
    JTextField txtNama;
    JButton btnTampil;
    JTextArea areaHasil;

    public FormMahasiswa() {

        setTitle("Aplikasi Data Mahasiswa");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblNama = new JLabel("Nama Mahasiswa");
        lblNama.setBounds(20, 20, 120, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(150, 20, 200, 25);
        add(txtNama);

        btnTampil = new JButton("Tampilkan");
        btnTampil.setBounds(150, 60, 120, 30);
        add(btnTampil);

        areaHasil = new JTextArea();
        areaHasil.setBounds(20, 110, 330, 100);
        add(areaHasil);

        btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = txtNama.getText();

                areaHasil.setText(
                    "=== DATA MAHASISWA ===\n" +
                    "Nama : " + nama + "\n" +
                    "Status : Aktif"
                );
            }
        });
    }
}
