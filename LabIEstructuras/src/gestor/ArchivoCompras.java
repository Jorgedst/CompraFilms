/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import entidades.Cliente;
import entidades.Compra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dsilv
 */
public class ArchivoCompras {

    private final String rutaCompras;
    private final String rutaClientes;
    private final String rutaPeliculas;
    ArrayList<Compra> compras;

    public ArchivoCompras(String rutaCompras, String rutaClientes, String rutaPeliculas) {
        this.rutaCompras = rutaCompras;
        this.rutaClientes = rutaClientes;
        this.rutaPeliculas = rutaPeliculas;
        this.compras = new ArrayList<>();
    }

    public ArrayList<Compra> leerCompra() {
        try ( BufferedReader br = new BufferedReader(new FileReader(rutaCompras))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(",");
                int idcompra = Integer.parseInt(elementos[0]);
                int idecliente = Integer.parseInt(elementos[1]);
                int idpelicula = Integer.parseInt(elementos[2]);
                String fechaCompra = elementos[3];

                Compra compra = new Compra(idcompra, idecliente, idpelicula, fechaCompra);
                compras.add(compra);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer las compras..." + e.getMessage());
        }
        return compras;
    }

    public Boolean existeId(int ide) {
        for (Compra compra : compras) {
            if (compra.getIdecliente() == ide) {
                return true;
            }
        }
        return false;
    }

    public void registrarCompra(int ideCompra, int idCliente, int idPelicula, String fechaCompra) {
        ArchivoCliente archivoCliente = new ArchivoCliente(rutaCompras);
        ArchivoPelicula archivoPeliculas = new ArchivoPelicula(rutaCompras);

        ArrayList<Cliente> clientes = archivoCliente.leerClientes();
        if (existeId(ideCompra) == true) {
            System.out.println("Ya existe una compra con ese ID...");
        } else if (archivoCliente.existeId(idCliente) == false) {
            System.out.println("No existe un cliente con ese ID...");
        } else if(archivoPeliculas.existeId(idCliente)==false) {
            System.out.println("No existe una pelicula con es ID...");
        }else{
            Compra compra = new Compra(ideCompra, idCliente, idPelicula, fechaCompra);
            compras.add(compra);
            guardarCompra(compra);
            System.out.println("Compra guardada...");
        }
    }

    public void guardarCompra(Compra compra) {
        //BufferedWriter y FileWriter en try para asegurar de que cierre bufferedWriter y escriba en el archivo.
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(this.rutaCompras, true))) {
            bw.write(compra.toString() + "\n");
            System.out.println("Guardando en archivo la compra: " + compra.toString());
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar la compra..." + e.getMessage());
        }
    }

}
