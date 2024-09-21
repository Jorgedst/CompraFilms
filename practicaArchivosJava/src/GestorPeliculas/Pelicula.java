/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorPeliculas;

/**
 *
 * @author PC
 */
public class Pelicula {
    int ide;
    String titulo, director,genero;
    int año;
    double precio;

    public Pelicula(int ide, String titulo, String director,String genero, int año, double precio) {
        this.ide = ide;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.año = año;
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return ide+","+titulo+","+director+","+genero+","+año+","+precio;
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
    
    public String getGenero(){
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
