package com.rentcar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static final String DRIVER =
            "com.mysql.cj.jdbc.Driver";

    private static final String URL =
            "jdbc:mysql://localhost:3306/dbrentcar";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    private String pesanKesalahan;

    public String getPesanKesalahan() {
        return pesanKesalahan;
    }

    public Connection getConnection() {

        Connection connection = null;
        pesanKesalahan = "";

        try {

            Class.forName(DRIVER);

            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Koneksi berhasil");

        } catch (ClassNotFoundException ex) {

            pesanKesalahan =
                    "Driver MySQL tidak ditemukan : "
                    + ex.getMessage();

        } catch (SQLException ex) {

            pesanKesalahan =
                    "Koneksi gagal : "
                    + ex.getMessage();

        }

        return connection;
    }
}
