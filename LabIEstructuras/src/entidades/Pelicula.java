/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dtapiaj
 */
public class Pelicula {
    int ide;
    String titulo;
    String director;
    int año;
    String genero;
    double precio;

    public Pelicula(int ide, String titulo, String director, int año, String genero, double precio) {
        this.ide = ide;
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.genero = genero;
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return ide+","+titulo+","+director+","+año+","+genero+","+precio;
    }

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
