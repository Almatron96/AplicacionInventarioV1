/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.Articulos;
import Modelos.Historial;
import Modelos.TipoArticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almatron
 */
public class controladorTipoArticulo {

    Conexion conectar = new Conexion();
    Connection con;

    public void insertarTipoArticulo(TipoArticulo tipoarticulo) {
        PreparedStatement ps;
        String consulta = "INSERT INTO tipoarticulo (tipoarticulo) VALUES (?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setString(1, tipoarticulo.getTipoArticulo());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<TipoArticulo> listarTipoArticulo() {
        TipoArticulo tipoArticulo;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<TipoArticulo> lista = new ArrayList<>();
        String consulta = "select * from tipoarticulo order by idtipoarticulo asc";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoArticulo = new TipoArticulo();
                tipoArticulo.setIdTipoArticulo(rs.getInt("idtipoarticulo"));
                tipoArticulo.setTipoArticulo(rs.getString("tipoarticulo"));
                lista.add(tipoArticulo);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public DefaultTableModel llenarTablaTipoArticulo(ArrayList<TipoArticulo> datos) {
        DefaultTableModel tabla = new DefaultTableModel();

        // ArrayList<Articulos> datos = new ArrayList<>();
        String[] fila = new String[2];
        tabla.addColumn("Id del artículo");
        tabla.addColumn("Tipo de artículo");
        for (int i = 0; i < datos.size(); i++) {
            fila[0] = datos.get(i).getIdTipoArticulo() + "";
            fila[1] = datos.get(i).getTipoArticulo();
            tabla.addRow(fila);
        }
        return tabla;
    }

    public int buscarUltimoID() {
        ResultSet rs;
        PreparedStatement ps;
        String consulta = """
                          select idtipoarticulo as id from articulos order by idtipoarticulo desc
                          limit 1;""";
        int id = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
        }
        return id;
    }

}
