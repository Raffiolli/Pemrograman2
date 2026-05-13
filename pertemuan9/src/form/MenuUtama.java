/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import javax.swing.*;
import java.awt.event.*;

public class MenuUtama extends JFrame {

    JMenuBar menuBar;
    JMenu master, transaksi;
    JMenuItem barang, customer, supplier, penjualan;

    public MenuUtama() {

        setTitle("Aplikasi Penjualan Barang");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();

        master = new JMenu("Master Data");
        transaksi = new JMenu("Transaksi");

        barang = new JMenuItem("Data Barang");
        customer = new JMenuItem("Data Customer");
        supplier = new JMenuItem("Data Supplier");
        penjualan = new JMenuItem("Penjualan");

        master.add(barang);
        master.add(customer);
        master.add(supplier);

        transaksi.add(penjualan);

        menuBar.add(master);
        menuBar.add(transaksi);

        setJMenuBar(menuBar);

        barang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormBarang().setVisible(true);
            }
        });

        customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormCustomer().setVisible(true);
            }
        });

        supplier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormSupplier().setVisible(true);
            }
        });

        penjualan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormPenjualan().setVisible(true);
            }
        });
    }
}