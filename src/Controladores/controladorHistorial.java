/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.Articulos;
import Modelos.Historial;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almatron
 */
public class controladorHistorial {
     Conexion conectar = new Conexion();
     Connection con;
    public void guardarHistorial(Historial historial){
      
    Timestamp fechaActual = new Timestamp(System.currentTimeMillis());  
    PreparedStatement ps;
    String consulta = "INSERT INTO historial (idusuario, tabla, iditem, operacion, fechamodificacion) " +
                      "VALUES (?, ?, ?, ?, ?)";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(consulta);
        ps.setInt(1, historial.getIdUsuario());
        ps.setString(2, historial.getTabla());
        ps.setInt(3, historial.getIdItem());
        ps.setString(4, historial.getOperacion());
        ps.setTimestamp(5, fechaActual);
        ps.executeUpdate();
        ps.close();
        con.close();
    } catch (Exception e) {
        System.out.println(fechaActual);
        System.out.println(e.getMessage());
    }
    }
    
    public ArrayList<Historial> listarHistorial() {
        Historial historial;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<Historial> lista = new ArrayList<>();
        String consulta = "select * from historial";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                historial = new Historial();
                historial.setIdHistorial(rs.getInt("idhistorial"));
                historial.setIdItem(rs.getInt("iditem"));
                historial.setIdUsuario(rs.getInt("idusuario"));
                historial.setTabla(rs.getString("tabla"));
                historial.setOperacion(rs.getString("operacion"));
                historial.setFechaModificacion(rs.getTimestamp("fechamodificacion"));
                lista.add(historial);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }
    public DefaultTableModel llenarTablaHistorial(ArrayList<Historial> datos) {
        DefaultTableModel tabla = new DefaultTableModel();

        // ArrayList<Articulos> datos = new ArrayList<>();
        String[] fila = new String[6];
        tabla.addColumn("Id");
        tabla.addColumn("idUsuario");
        tabla.addColumn("Tabla");
        tabla.addColumn("idItem");
        tabla.addColumn("Fecha Modificación");
        tabla.addColumn("Operación");
        for (int i = 0; i < datos.size(); i++) {
            fila[0] = datos.get(i).getIdHistorial()+ "";
            fila[1] = datos.get(i).getIdUsuario()+ "";
            fila[2] = datos.get(i).getTabla();
            fila[3] = datos.get(i).getIdItem()+ "";
            fila[4] = datos.get(i).getFechaModificacion().toString();
            fila[5] = datos.get(i).getOperacion();
            tabla.addRow(fila);
        }
        return tabla;
    }
}
