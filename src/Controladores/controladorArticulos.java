/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.Articulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almatron
 */
public class controladorArticulos {
    
      Conexion conectar = new Conexion();
      Connection con;

    public ArrayList<Articulos> listarArticulos() {
        Articulos articulos;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<Articulos> lista = new ArrayList<>();
        String consulta = "select * from articulos where estado = true order by idarticulo asc";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                articulos = new Articulos();
                articulos.setIdArticulo(rs.getInt("idarticulo"));
                articulos.setIdPersonaEncargada(rs.getInt("idpersonaencargada"));
                articulos.setIdTipoArticulo(rs.getInt("idtipoarticulo"));
                articulos.setMarca(rs.getString("marca"));
                articulos.setNumeroSerie(rs.getString("numeroserie"));
                articulos.setModelo(rs.getString("modelo"));
                articulos.setCondicionArticulo(rs.getString("condicionarticulo"));
                articulos.setDescripcion(rs.getString("descripcion"));
                lista.add(articulos);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public void insertarArticulo(Articulos articulo) {
    PreparedStatement ps;
    String consulta = "INSERT INTO articulos (idpersonaencargada, idtipoarticulo, marca, numeroserie, modelo, condicionarticulo, descripcion) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(consulta);
        ps.setInt(1, articulo.getIdPersonaEncargada());
        ps.setInt(2, articulo.getIdTipoArticulo());
        ps.setString(3, articulo.getMarca());
        ps.setString(4, articulo.getNumeroSerie());
        ps.setString(5, articulo.getModelo());
        ps.setString(6, articulo.getCondicionArticulo());
        ps.setString(7, articulo.getDescripcion());
        ps.executeUpdate();
        ps.close();
        con.close();
    } catch (Exception e) {
    }
}
    
    public void modificarArticulo(Articulos articulo) {
    PreparedStatement ps;
    String consulta = "UPDATE articulos SET idpersonaencargada = ?, idtipoarticulo = ?, marca = ?, numeroserie = ?, modelo = ?, condicionarticulo = ?, descripcion = ? " +
                      "WHERE idarticulo = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(consulta);
        ps.setInt(1, articulo.getIdPersonaEncargada());
        ps.setInt(2, articulo.getIdTipoArticulo());
        ps.setString(3, articulo.getMarca());
        ps.setString(4, articulo.getNumeroSerie());
        ps.setString(5, articulo.getModelo());
        ps.setString(6, articulo.getCondicionArticulo());
        ps.setString(7, articulo.getDescripcion());
        ps.setInt(8, articulo.getIdArticulo());
        ps.executeUpdate();
        ps.close();
        con.close();
    } catch (Exception e) {
    }
}
    
      public void eliminarArticulo(Articulos articulo) {
    PreparedStatement ps;
    String consulta = "UPDATE articulos SET estado = false where idarticulo = ?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(consulta);
        ps.setInt(1, articulo.getIdArticulo());
        ps.executeUpdate();
        ps.close();
        con.close();
    } catch (Exception e) {
    }
}
    
    public DefaultTableModel llenarTablaArticulos(ArrayList<Articulos> datos) {
        DefaultTableModel tabla = new DefaultTableModel();

        // ArrayList<Articulos> datos = new ArrayList<>();
        String[] fila = new String[10];
        tabla.addColumn("Id");
        tabla.addColumn("idTipoArticulo");
        tabla.addColumn("Tipo Articulo");
        tabla.addColumn("Marca");
        tabla.addColumn("Modelo");
        tabla.addColumn("Serie");
        tabla.addColumn("Condición");
        tabla.addColumn("idEncargado");
        tabla.addColumn("Encargado(a)");
        tabla.addColumn("Descripción");
        for (int i = 0; i < datos.size(); i++) {
            fila[0] = datos.get(i).getIdArticulo() + "";
            fila[1] = datos.get(i).getIdTipoArticulo() + "";
            fila[2] = buscarTipoArticulo(datos.get(i).getIdArticulo()); //asignar el tipo de artículo
            fila[3] = datos.get(i).getMarca();
            fila[4] = datos.get(i).getModelo();
            fila[5] = datos.get(i).getNumeroSerie();
            fila[6] = datos.get(i).getCondicionArticulo();
            fila[7] = datos.get(i).getIdPersonaEncargada() + "";
            fila[8] = buscarPersona(datos.get(i).getIdPersonaEncargada()); //asignar el nombre de la persona encargada
            fila[9] = datos.get(i).getDescripcion();
            tabla.addRow(fila);
        }
        return tabla;
    }


    public String buscarPersona(int id) {
        ResultSet rs;
        PreparedStatement ps;
        String consulta = "select nombredeusuario from usuario where idusuario = ?";
        String nombreDeUsuario = "";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreDeUsuario = rs.getString(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return nombreDeUsuario;
    }

    public String buscarTipoArticulo(int id) {
        ResultSet rs;
        PreparedStatement ps;
        String consulta = """
                          select tipoarticulo from tipoarticulo inner join articulos on
                          tipoarticulo.idtipoarticulo = articulos.idtipoarticulo
                          where articulos.idarticulo = ?""";
        String tipoArticulo = null; // para guardar el nombre del tipo de artículo
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipoArticulo = rs.getString(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return tipoArticulo;
    }
     public int buscarUltimoID() {
        ResultSet rs;
        PreparedStatement ps;
        String consulta = """
                          select idarticulo as id from articulos order by idarticulo desc
                          limit 1;""";
        int id=0;
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
