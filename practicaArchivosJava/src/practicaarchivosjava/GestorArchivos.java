/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaarchivosjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class GestorArchivos {

    private final String rutaArchivo;

    public GestorArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void escribir(String dato) throws IOException {
        try ( FileWriter fw = new FileWriter(rutaArchivo, true);  
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(dato + "\n");
        }
    }

    public ArrayList<String> leer() throws IOException {
        ArrayList<String> datos = new ArrayList<>();
        try ( FileReader fr = new FileReader(rutaArchivo);  
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
        }
        return datos;
    }

    public void actualizar(String datoAnterior, String datoNuevo) throws IOException {
        File archivo = new File(rutaArchivo);
        ArrayList<String> datos = leer();
        try ( FileWriter fw = new FileWriter(archivo, false);  BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : datos) {
                if (linea.equals(datoAnterior)) {
                    bw.write(datoNuevo);
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }
        }
    }

    public void eliminar(String datoEliminar) throws IOException {
        File archivo = new File(rutaArchivo);
        ArrayList<String> datos = leer();
        try ( FileWriter fw = new FileWriter(archivo, false);  BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : datos) {
                if (!linea.equals(datoEliminar)) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
        }
    }

}
