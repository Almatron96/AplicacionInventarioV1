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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Almatron
 */
public class llenarTablas {

//    public DefaultTableModel llenarTablaArticulos(ArrayList<Articulos> datos) {
//        DefaultTableModel tabla = new DefaultTableModel();
//
//         ArrayList<Articulos> datos = new ArrayList<>();
//        String[] fila = new String[10];
//        tabla.addColumn("ID");
//        tabla.addColumn("idTipoArticulo");
//        tabla.addColumn("Tipo Articulo");
//        tabla.addColumn("Marca");
//        tabla.addColumn("Modelo");
//        tabla.addColumn("Serie");
//        tabla.addColumn("Condición");
//        tabla.addColumn("idEncargado");
//        tabla.addColumn("Encargado(a)");
//        tabla.addColumn("Descripción");
//        for (int i = 0; i < datos.size(); i++) {
//            fila[0] = datos.get(i).getIdArticulo() + "";
//            fila[1] = datos.get(i).getIdTipoArticulo() + "";
//            fila[2] = buscarTipoArticulo(datos.get(i).getIdArticulo()); //asignar el tipo de artículo
//            System.out.println(datos.get(i).getIdArticulo());
//            fila[3] = datos.get(i).getMarca();
//            fila[4] = datos.get(i).getModelo();
//            fila[5] = datos.get(i).getNumeroSerie();
//            fila[6] = datos.get(i).getCondicionArticulo();
//            fila[7] = datos.get(i).getIdPersonaEncargada() + "";
//            fila[8] = buscarPersona(datos.get(i).getIdPersonaEncargada()); //asignar el nombre de la persona encargada
//            fila[9] = datos.get(i).getDescripcion();
//            tabla.addRow(fila);
//        }
//        return tabla;
//    }
//
//    Conexion conectar = new Conexion();
//    Connection con;
//
//    public String buscarPersona(int id) {
//        ResultSet rs;
//        PreparedStatement ps;
//        String consulta = "select nombredeusuario from usuario where idusuario = ?";
//        String nombreDeUsuario = "";
//        try {
//            con = conectar.getConnection();
//            ps = con.prepareStatement(consulta);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                nombreDeUsuario = rs.getString(1);
//            }
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//        }
//        return nombreDeUsuario;
//    }
//
//    public String buscarTipoArticulo(int id) {
//        ResultSet rs;
//        PreparedStatement ps;
//        String consulta = """
//                          select tipoarticulo from tipoarticulo inner join articulos on
//                          tipoarticulo.idtipoarticulo = articulos.idtipoarticulo
//                          where articulos.idarticulo = ?""";
//        String tipoArticulo = null; // para guardar el nombre del tipo de artículo
//        try {
//            con = conectar.getConnection();
//            ps = con.prepareStatement(consulta);
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                tipoArticulo = rs.getString(1);
//            }
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//        }
//        return tipoArticulo;
//    }
}
