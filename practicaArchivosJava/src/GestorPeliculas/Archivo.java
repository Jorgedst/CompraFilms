/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GestorPeliculas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
                Pelicula pelicula = new Pelicula(ide, titulo, director, genero, año, precio);
                peliculas.add(pelicula);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer las peliculas..." + e.getMessage());
        }
        return peliculas;
    }

    public Boolean existeId(int ide) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIde() == ide) {
                return true;
            }
        }
        return false;
    }

    public void mostrarPeliculaId(int idmostrar) {
        try ( BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            for (Pelicula p : peliculas) {
                if (p.getIde() == idmostrar) {
                    System.out.println("ID:" + p.getIde() + ", Titulo:" + p.getTitulo() + ", Director:" + p.getDirector() + ", Genero:" + p.getGenero() + ", Año:" + p.getAño() + ", Precio:" + p.getPrecio());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registrarPelicula(int ide, String titulo, String director, String genero, int año, double precio) {
        if (existeId(ide) == true) {
            System.out.println("Ya existe una pelicula con ese ID...");
        } else {
            Pelicula pelicula = new Pelicula(ide, titulo, director, genero, año, precio);
            peliculas.add(pelicula);
            guardarPelicula(pelicula);
            System.out.println("Pelicula guardada...");
        }
    }

    public void guardarPelicula(Pelicula pelicula) {
        //BufferedWriter y FileWriter en try para asegurar de que cierre bufferedWriter y escriba en el archivo.
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(this.ruta, true))) {
            bw.write(pelicula.toString() + "\n");
            System.out.println("Guardando en archivo la pelicula: " + pelicula.toString());
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar la pelicula..." + e.getMessage());
        }
    }

    public int cantidadPeliculasAño(int añoBusq) {
        int cantidadPeliculas = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            for (Pelicula pelicula : peliculas) {
                if (pelicula.getAño() == añoBusq) {
                    cantidadPeliculas += 1;
                    System.out.println("ID:" + pelicula.getIde() + ", Titulo:" + pelicula.getTitulo() + ", Director:" + pelicula.getDirector()
                            + ", Genero:" + pelicula.getGenero() + ", Año:" + pelicula.getAño() + ", Precio:" + pelicula.getPrecio());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (cantidadPeliculas == 0) {
            System.out.println("No hay peliculas registradas de ese año.");
            return 0;
        } else {
            System.out.println("Cantidad de peliculas en "+añoBusq+": "+cantidadPeliculas);
            return cantidadPeliculas;
        }
    }

    public double hayarMayorPrecio(int añoBusq) {
        double mayorPrecio = 0;
        try ( BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            for (Pelicula pelicula : peliculas) {
                if (pelicula.getAño() == añoBusq) {
                    double precioPelicula = pelicula.getPrecio();
                    if (precioPelicula > mayorPrecio) {
                        mayorPrecio = precioPelicula;
                    }
                }
            }
            for (Pelicula p : peliculas) {
                if (p.getPrecio() == mayorPrecio) {
                    System.out.println("ID:" + p.getIde() + ", Titulo:" + p.getTitulo() + ", Director:" + p.getDirector() + ", Genero:" + p.getGenero() + ", Año:" + p.getAño() + ", Precio:" + p.getPrecio());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mayorPrecio;
    }

    public void modificarPelicula(int ide, int nuevoid, String nuevotitulo, String nuevodir, String nuevogen, int nuevoaño, double nuevoprecio) {
        if (existeId(nuevoid)) {
            System.out.println("El ID ingresado ya existe, intentelo nuevamente");
        } else {
            for (Pelicula pelicula : peliculas) {
                if (pelicula.getIde() == ide) {
                    pelicula.setIde(nuevoid);
                    pelicula.setTitulo(nuevotitulo);
                    pelicula.setDirector(nuevodir);
                    pelicula.setGenero(nuevogen);
                    pelicula.setAño(nuevoaño);
                    pelicula.setPrecio(nuevoprecio);
                }
            }
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
                for (Pelicula p : peliculas){
                    bw.write(p.toString()+"\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getRuta() {
        return ruta;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

}
