/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafi
 */
public class koneksi {
    
    try{
        Statement st = (Statement) conn.createStatement () ;
        ResultSet rs = st.executeQuery ("SELECT * FROM namaTabel");

    While (rs.next ()) {
        Object [] nmvardata=new Object[jml.kolom];
        nmvardata [0]=rs.getString("nmfield1");
        nmvardata [1]=rs.getString("nmfield2");
        nmvardata [2]=rs.getString(" ........ ") ;
        nmvardata [3]=rs.getString(" ........ ") ;
        nmvardata [4]=rs.getString(" ........ ") ;
        nmVarmodel.addRow (nmvardata) ;
        }
        rs.close ();
        conn.close ();
        }
catch (SQLException e) {
System.out.println("Data gagal disimpan" + e.getMessage());
}
catch (ClassNotFoundException e) {
System.out.println ("driver tidak ditemukan" );
}
}