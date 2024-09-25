/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorPeliculas;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        int ide;
        String titulo, director, genero;
        int año;
        double precio;
        Scanner leer = new Scanner(System.in);
        int sw = 1;
        int op = 0;
        String ruta = "C:\\Users\\Dsilv\\OneDrive\\Documentos\\EstructurasRepo\\practicaArchivosJava\\src\\peliculas.txt";
        Archivo archivo = new Archivo(ruta);
        archivo.leerPeliculas();
        while (sw == 1) {
            System.out.println("--------SISTEMA GESTOR DE PELICULAS---------\n");
            System.out.print("""
                             (1)Registrar Pelicula
                             (2)Mostrar cantidad de peliculas segun año
                             (3)Peliculas de menor a mayor segun año
                             (4)Peliculas de mayor precio en un año
                             (5)Modificar Pelicula
                             (6)Eliminar Pelicula
                             (7)Salir...)
                             """);
            System.out.println("Ingrese una opción:");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese la informacion de la pelicula a registrar:");
                    System.out.print("ID:");
                    ide = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Titulo:");
                    titulo = leer.nextLine();

                    System.out.print("Director:");
                    director = leer.nextLine();

                    System.out.print("Genero:");
                    genero = leer.nextLine();

                    System.out.print("Año:");
                    año = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Precio:");
                    precio = leer.nextDouble();

                    archivo.registrarPelicula(ide, titulo, director, genero, año, precio);
                    break;
                case 2:
                    System.out.println("Ingrese el año a buscar:");
                    int añoBusq = leer.nextInt();
                    archivo.cantidadPeliculasAño(añoBusq);
                    break;
                case 3:
                    System.out.println("Ingrese el año a ordenar:");
                    int añoOrden = leer.nextInt();
                    archivo.ordenarSegunAño(añoOrden);
                    break;
                case 4:
                    System.out.println("Ingrese el año a buscar:");
                    int añoBusqM = leer.nextInt();
                    archivo.hayarMayorPrecio(añoBusqM);
                    break;
                case 5:
                    System.out.println("Ingrese el ID de la pelicula que desea modificar:");
                    int idmodificar = leer.nextInt();
                    archivo.mostrarPeliculaId(idmodificar);
                    System.out.println("Ingrese el nuevo ID:");
                    int nuevoid = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingrese el nuevo titulo:");
                    String nuevotitulo = leer.nextLine();
                    System.out.println("Ingrese el nuevo director:");
                    String nuevodirector = leer.nextLine();
                    System.out.println("Ingrese el nuevo genero:");
                    String nuevogenero = leer.nextLine();
                    System.out.println("Ingrese el nuevo año:");
                    int nuevoaño = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingrese el nuevo precio:");
                    double nuevoprecio = leer.nextDouble();
                    archivo.modificarPelicula(idmodificar, nuevoid, nuevotitulo, nuevodirector, nuevogenero, nuevoaño, nuevoprecio);

                    break;
                case 6:
                    System.out.println("Ingrese el ID de la pelicula que desea eliminar:");
                    int idEliminar = leer.nextInt();
                    archivo.eliminarPelicula(idEliminar);
                    break;
                case 7:
                    sw = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, Intente de nuevo.");
            }
        }

    }
}
