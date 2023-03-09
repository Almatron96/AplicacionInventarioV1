/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import Modelos.TipoArticulo;
import Modelos.Usuario;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almatron
 */
public class controladorUsuario {

    public static String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña: " + e.getMessage());
        }
    }
    Conexion conectar = new Conexion();
    Connection con;

    public boolean login(String usuario, String password) throws SQLException {
        // Encriptar la contraseña ingresada por el usuario
        String encodedPassword = new String(password.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        String encryptedPassword = encrypt(encodedPassword);
        System.out.println(encryptedPassword);
        // Buscar el usuario en la base de datos
        PreparedStatement ps;
        ResultSet rs;
        con = conectar.getConnection();
        ps = con.prepareStatement("SELECT * FROM usuario WHERE nombredeusuario = ?");
        ps.setString(1, usuario);
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                // Comprobar si las contraseñas coinciden
                String storedPassword = rs.getString("contrasenia");
                return storedPassword.equals(encryptedPassword);
            } else {
                // No se encontró el usuario en la base de datos
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al realizar el inicio de sesión: " + e.getMessage());
        }
    }

    public Usuario buscarUsuario(String nombreDeUsuario) throws SQLException {
        Usuario usuario = null;
        String query = "SELECT * FROM usuario WHERE nombredeusuario = ?";
        PreparedStatement ps;
        ResultSet rs;
        con = conectar.getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, nombreDeUsuario);
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNombreDeUsuario(rs.getString("nombredeusuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setIdRol(rs.getInt("idrol"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public ArrayList<Usuario> listarUsuario() {
        Usuario usuario;
        ResultSet rs;
        PreparedStatement ps;
        ArrayList<Usuario> lista = new ArrayList<>();
        String consulta = "select * from usuario order by idusuario asc";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setIdRol(rs.getInt("idrol"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNombreDeUsuario(rs.getString("nombredeusuario"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                lista.add(usuario);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
        return lista;
    }

    public DefaultTableModel llenarTablaUsuario(ArrayList<Usuario> datos) {
        DefaultTableModel tabla = new DefaultTableModel();

        // ArrayList<Articulos> datos = new ArrayList<>();
        String[] fila = new String[7];
        tabla.addColumn("Id del usuario");
        tabla.addColumn("Rol del usuario");
        tabla.addColumn("Nombres");
        tabla.addColumn("Apellidos");
        tabla.addColumn("Nombre de usuario");
        tabla.addColumn("Correo");
        tabla.addColumn("Contraseña");
        for (int i = 0; i < datos.size(); i++) {
            fila[0] = datos.get(i).getIdUsuario()+ "";
            fila[1] = datos.get(i).getIdRol() +"";
            fila[2] = datos.get(i).getNombres();
            fila[3] = datos.get(i).getApellidos();
            fila[4] = datos.get(i).getCorreo();
            fila[5] = datos.get(i).getNombreDeUsuario();
            fila[6] = datos.get(i).getContrasenia();
            tabla.addRow(fila);
        }
        return tabla;
    }
}
