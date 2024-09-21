/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GestorPeliculas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Archivo {

    private final String ruta;
    ArrayList<Pelicula> peliculas;

    public Archivo(String ruta) {
        this.ruta = ruta;
        this.peliculas = new ArrayList<>();
    }
    
    public Boolean existeId(int ide){
        for (Pelicula pelicula : peliculas){
            if(pelicula.getIde() == ide){
                return true;
            }
        }
        return false;
    }
    
    public void registrarPelicula(int ide,String titulo, String director,String genero, int año,double precio){
        if (this.existeId(ide) == true){
            System.out.println("Ya existe una pelicula con ese ID...");
        }else{
            Pelicula pelicula = new Pelicula(ide,titulo,director,genero,año,precio);
            peliculas.add(pelicula);
            guardarPelicula();
            System.out.println("Pelicula guardada...");
        }
    }
    
    public void guardarPelicula(){
        try (FileWriter fw = new FileWriter(this.ruta,true)){
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Pelicula pelicula : peliculas){
                bw.write(pelicula.toString());
                bw.newLine();//Agregar una nueva linea
            }
        }catch(IOException e){
            System.out.println("Ocurrio un error al guardar la pelicula..."+ e.getMessage());
        }
    }
    
    public String getRuta() {
        return ruta;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    
    
    
    
}
