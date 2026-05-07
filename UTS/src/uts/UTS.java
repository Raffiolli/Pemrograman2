package uts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

class Produk {
    String nama;
    String kategori;
    int harga;

    public Produk(String nama, String kategori, int harga) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
    }
}

public class UTS extends JFrame {

    Stack<Produk> stackProduk = new Stack<>();

    JTextField txtNama, txtKategori, txtHarga, txtCari;
    JTable table;
    DefaultTableModel model;

    public UTS() {
        setTitle("Aplikasi Manajemen Produk");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2,5,5));

        panel.add(new JLabel("Nama Produk"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Kategori"));
        txtKategori = new JTextField();
        panel.add(txtKategori);

        panel.add(new JLabel("Harga"));
        txtHarga = new JTextField();
        panel.add(txtHarga);

        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus");

        panel.add(btnTambah);
        panel.add(btnHapus);

        panel.add(new JLabel("Cari Produk"));
        txtCari = new JTextField();
        panel.add(txtCari);

        model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Kategori");
        model.addColumn("Harga");

        table = new JTable(model);

        JScrollPane scroll = new JScrollPane(table);

        JPanel bawah = new JPanel();

        JButton btnSortHarga = new JButton("Sort Harga");
        JButton btnSortKategori = new JButton("Sort Kategori");
        JButton btnCari = new JButton("Cari");

        bawah.add(btnSortHarga);
        bawah.add(btnSortKategori);
        bawah.add(btnCari);

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bawah, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {
            try {
                String nama = txtNama.getText();
                String kategori = txtKategori.getText();
                int harga = Integer.parseInt(txtHarga.getText());

                Produk p = new Produk(nama, kategori, harga);
                stackProduk.push(p);

                tampilData();

                System.out.println("DEBUG: Produk ditambahkan");

                JOptionPane.showMessageDialog(null, "Produk berhasil ditambahkan");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Input salah");
            }
        });

        btnHapus.addActionListener(e -> {
            try {
                if(stackProduk.isEmpty()){
                    throw new Exception("Stok kosong");
                }

                stackProduk.pop();
                tampilData();

                JOptionPane.showMessageDialog(null, "Produk berhasil dihapus");

            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

        btnSortHarga.addActionListener(e -> {
            ArrayList<Produk> list = new ArrayList<>(stackProduk);

            Collections.sort(list, (a,b) -> a.harga - b.harga);

            tampilDataList(list);
        });

        btnSortKategori.addActionListener(e -> {
            ArrayList<Produk> list = new ArrayList<>(stackProduk);

            Collections.sort(list, (a,b) -> a.kategori.compareTo(b.kategori));

            tampilDataList(list);
        });

        btnCari.addActionListener(e -> {
            String cari = txtCari.getText().toLowerCase();

            model.setRowCount(0);

            for(Produk p : stackProduk){
                if(p.nama.toLowerCase().contains(cari)){
                    model.addRow(new Object[]{
                            p.nama,
                            p.kategori,
                            p.harga
                    });
                }
            }
        });
    }

    void tampilData(){
        model.setRowCount(0);

        for(Produk p : stackProduk){
            model.addRow(new Object[]{
                    p.nama,
                    p.kategori,
                    p.harga
            });
        }
    }

    void tampilDataList(ArrayList<Produk> list){
        model.setRowCount(0);

        for(Produk p : list){
            model.addRow(new Object[]{
                    p.nama,
                    p.kategori,
                    p.harga
            });
        }
    }

    public static void main(String[] args) {
        new UTS().setVisible(true);
    }
}
