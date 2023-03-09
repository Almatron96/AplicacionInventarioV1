/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.pnlUsuario;
import java.awt.Component;
import java.awt.Container;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Almatron
 */
public class funcionesAux {

    public void limpiarFormulario(Container container) {
        Component[] componentes = container.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
            } else if (componente instanceof JRadioButton) {
                ((JRadioButton) componente).setSelected(false);
            } else if (componente instanceof JTextArea) {
                ((JTextArea) (componente)).setText("");
            }
            else if (componente instanceof Container) {
                limpiarFormulario((Container) componente);
            }
        }
    }
    
    public boolean validarCorreo(String correo) {
    // Define una expresión regular que coincida con un formato de correo electrónico válido
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Compila la expresión regular en un objeto Pattern
    Pattern pattern = Pattern.compile(regex);

    // Compara el correo con la expresión regular utilizando un objeto Matcher
    Matcher matcher = pattern.matcher(correo);

    // Devuelve true si el correo coincide con la expresión regular, de lo contrario devuelve false
    return matcher.matches();
}
    
    public String [] condicionArticulo(){
        String [] condicion = {"Dañado", "Malo","Regular", "Bueno", "Muy Bueno", "Excelente"};
        return condicion;
    }
}
