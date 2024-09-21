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
        while (sw == 1) {
            System.out.println("--------SISTEMA GESTOR DE PELICULAS---------\n");
            System.out.print("(1)Registrar Pelicula"
                    + "(2)Mostrar pelicula segun año"
                    + "(3)Peliculas de menor a mayor segun año"
                    + "(4)Peliculas de mayor precio en un año"
                    + "(5)Peliculas de un director (Rango De años)"
                    + "(6)Peliculas de un genero especifico"
                    + "(6)Salir...)");
            System.out.println("Ingrese una opción:");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese la informacion de la pelicula a registrar:");
                    System.out.println("ID:");
                    ide = leer.nextInt();
                    System.out.println("Titulo:");
                    titulo = leer.nextLine();
                    System.out.println("Director:");
                    director = leer.nextLine();
                    System.out.println("Genero:");
                    genero = leer.nextLine();
                    System.out.println("Año:");
                    año = leer.nextInt();
                    System.out.println("Precio:");
                    precio = leer.nextFloat;
            }
        }

    }
}
