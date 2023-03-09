/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.Articulos;
import Modelos.Rol;
import Modelos.TipoArticulo;
import Modelos.Usuario;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author Almatron
 */
public class llenarCombos {

    funcionesAux faAux = new funcionesAux();
    Conexion conectar = new Conexion();
    Connection con;

    public ArrayList<TipoArticulo> cmbTipoArticulo(JComboBox<TipoArticulo> comboBox) {
        TipoArticulo tipoArticulo;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<TipoArticulo> lista = new ArrayList<>();
        String consulta = "select * from tipoarticulo";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoArticulo = new TipoArticulo();
                tipoArticulo.setIdTipoArticulo(rs.getInt("idtipoarticulo"));
                tipoArticulo.setTipoArticulo(rs.getString("tipoarticulo"));
                lista.add(tipoArticulo);
                comboBox.addItem(tipoArticulo); //llenar combo con id y tipoarticulo
                //comboBox.addItem(new );
            }
            rs.close();
            ps.close();
            con.close();
            comboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    if (value instanceof TipoArticulo) {
                        value = ((TipoArticulo) value).getTipoArticulo();
                    }
                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
            });
        } catch (Exception e) {
        }
        return lista;
    }
    public ArrayList<Usuario> cmbPersonaEncargada(JComboBox<Usuario> comboBox) {
        Usuario usuario;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "select idusuario, nombredeusuario from usuario ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreDeUsuario(rs.getString("nombreDeUsuario"));
                lista.add(usuario);
                comboBox.addItem(usuario); //llenar combo con id y tipoarticulo
                //comboBox.addItem(new );
            }
            rs.close();
            ps.close();
            con.close();
            comboBox.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    if (value instanceof Usuario) {
                        value = ((Usuario) value).getNombreDeUsuario();
                    }
                    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
            });
        } catch (Exception e) {
        }
        return lista;
    }

    public void cmbCondicionArticulo(JComboBox<String> comboBox) {
        for (String condicion : faAux.condicionArticulo()) {
            comboBox.addItem(condicion);
        }
    }

//    public ArrayList<Usuario> cmbPersonaEncargada(JComboBox<String> comboBox) {
//        Usuario usuario;
//        ResultSet rs;
//        PreparedStatement ps;
//        ArrayList<Usuario> lista = new ArrayList<>();
//        String consulta = "select * from usuario";
//        try {
//            con = conectar.getConnection();
//            ps = con.prepareStatement(consulta);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                usuario = new Usuario();
//                usuario.setIdUsuario(rs.getInt("idusuario"));
//                usuario.setNombreDeUsuario(rs.getString("nombredeusuario"));
//                lista.add(usuario);
//                comboBox.addItem(usuario.getNombreDeUsuario());
//            }
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//        }
//        return lista;
//    }
}
