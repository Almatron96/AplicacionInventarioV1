/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.Articulos;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Almatron
 */
public class llenarArticulos {

//    Conexion conectar = new Conexion();
//    Connection con;
//
//    public ArrayList<Articulos> listarArticulos() {
//        Articulos articulos;
//        ResultSet rs;
//        PreparedStatement ps;
//        ArrayList<Articulos> lista = new ArrayList<>();
//        String consulta = "select * from articulos";
//        try {
//            con = conectar.getConnection();
//            ps = con.prepareStatement(consulta);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                articulos = new Articulos();
//                articulos.setIdArticulo(rs.getInt("idarticulo"));
//                articulos.setIdPersonaEncargada(rs.getInt("idpersonaencargada"));
//                articulos.setIdTipoArticulo(rs.getInt("idtipoarticulo"));
//                articulos.setMarca(rs.getString("marca"));
//                articulos.setNumeroSerie(rs.getString("numeroserie"));
//                articulos.setModelo(rs.getString("modelo"));
//                articulos.setCondicionArticulo(rs.getString("condicionarticulo"));
//                articulos.setDescripcion(rs.getString("descripcion"));
//                lista.add(articulos);
//            }
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//        }
//        return lista;
//    }

}
