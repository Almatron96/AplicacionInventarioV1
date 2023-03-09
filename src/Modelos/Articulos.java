/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Almatron
 */
public class Articulos {
    
    private int idArticulo;
    
    private int idPersonaEncargada; //id persona que está a cargo del artículo
    
    private int idTipoArticulo; //tipo de artículo (pc, mesa, carro, moto,etc)
    
    private String marca;
    
    private String numeroSerie; //número de serie o código del artículo
    
    private String modelo;
    
    private String condicionArticulo; // condición del artículo (bueno, malo, nuevo,etc)

    public String getCondicionArticulo() {
        return condicionArticulo;
    }

    public void setCondicionArticulo(String condicionArticulo) {
        this.condicionArticulo = condicionArticulo;
    }
    
    private String descripcion;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdPersonaEncargada() {
        return idPersonaEncargada;
    }

    public void setIdPersonaEncargada(int idPersonaEncargada) {
        this.idPersonaEncargada = idPersonaEncargada;
    }

    public int getIdTipoArticulo() {
        return idTipoArticulo;
    }

    public void setIdTipoArticulo(int idTipoArticulo) {
        this.idTipoArticulo = idTipoArticulo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
