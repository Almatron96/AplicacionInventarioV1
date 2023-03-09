/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Almatron
 */
public class Conexion {

    String url = "jdbc:postgresql://localhost:5432/EscuelaDeliaIbarraBD";
    String user = "postgres", pass = "123456789";
    Connection con;
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos. "+ e.getMessage());
        } 
        return con;
    }
    
    public void cerrarConexion() throws SQLException{
    con.close();
    }
}
