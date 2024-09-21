/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaarchivosjava;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class PruebaGestor {
     public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\pineresm\\Documents\\archivo.txt";
        GestorArchivos gestor = new GestorArchivos(ruta);
        
        gestor.escribir("AA");
        gestor.escribir("BB");
        gestor.escribir("CC");
        
        System.out.println("Mostrando datos...");
        ArrayList lista = (ArrayList) gestor.leer();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());            
        }
        
        gestor.actualizar("AA","AAA");
        
        System.out.println("\n\nMostrando datos...");
        lista = (ArrayList) gestor.leer();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());            
        }
        
        System.out.println("Eliminando datos: ");
        gestor.eliminar("AAA");
        
        System.out.println("\n\nMostrando datos...");
        lista = (ArrayList) gestor.leer();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());            
        }
        
        
    }
}
