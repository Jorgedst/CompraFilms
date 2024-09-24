/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import entidades.Pelicula;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dtapiaj
 */
public class ArchivoPelicula {

    private final String ruta;
    ArrayList<Pelicula> peliculas;

    public ArchivoPelicula(String ruta) {
        this.ruta = ruta;
        this.peliculas = new ArrayList<>();
    }

    //Leer peliculas
    public ArrayList<Pelicula> leerPeliculas() {
        try ( BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(",");
                int ide = Integer.parseInt(elementos[0]);
                String titulo = elementos[1];
                String director = elementos[2];
                String genero = elementos[3];
                int año = Integer.parseInt(elementos[4]);
                double precio = Double.parseDouble(elementos[5]);
                Pelicula pelicula = new Pelicula(ide, titulo, director, año, genero, precio);
                peliculas.add(pelicula);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer las peliculas..." + e.getMessage());
        }
        return peliculas;
    }

    //Existe Id
    public Boolean existeId(int ide) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIde() == ide) {
                return true;
            }
        }
        return false;
    }

    //Registrar pelicula
    public void registrarPelicula(int ide, String titulo, String director, int año, String genero, double precio) {
        if (existeId(ide) == true) {
            System.out.println("Ya existe una pelicula con ese ID...");
        } else {
            Pelicula pelicula = new Pelicula(ide, titulo, director, año, genero, precio);
            peliculas.add(pelicula);
            guardarPelicula(pelicula);
            System.out.println("Pelicula guardada...");
        }
    }

    //Guardar pelicula
    public void guardarPelicula(Pelicula pelicula) {
        //BufferedWriter y FileWriter en try para asegurar de que cierre bufferedWriter y escriba en el archivo.
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(this.ruta, true))) {
            bw.write(pelicula.toString() + "\n");
            System.out.println("Guardando en archivo la pelicula: " + pelicula.toString());
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar la pelicula..." + e.getMessage());
        }
    }
    
//Actualizar Pelicula
    public void actualizarPelicula(int ide, String nuevotitulo, String nuevodir, int nuevoaño, String nuevogen, double nuevoprecio) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIde() == ide) {
                pelicula.setTitulo(nuevotitulo);
                pelicula.setDirector(nuevodir);
                pelicula.setAño(nuevoaño);
                pelicula.setGenero(nuevogen);
                pelicula.setPrecio(nuevoprecio);
            }
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            for (Pelicula p : peliculas) {
                bw.write(p.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    //EliminarPelicula
    public void eliminarPelicula(int idElim) {
        Pelicula peliculaEliminar = null;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIde() == idElim) {
                peliculaEliminar = pelicula;
                break;
            }
        }
        if (peliculaEliminar != null) {
            peliculas.remove(peliculaEliminar);
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            for (Pelicula pelicula : peliculas) {
                bw.write(pelicula.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
