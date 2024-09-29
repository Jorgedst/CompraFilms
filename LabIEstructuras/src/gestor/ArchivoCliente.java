/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import entidades.Cliente;
import entidades.Pelicula;
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
public class ArchivoCliente {
    private final String ruta;
    ArrayList<Cliente> clientes;

    public ArchivoCliente(String ruta) {
        this.ruta = ruta;
        this.clientes = new ArrayList<>();
    }
    
    public ArrayList<Cliente> leerClientes() {
        try ( BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(",");
                int idecliente = Integer.parseInt(elementos[0]);
                String nombre = elementos[1];
                String correo = elementos[2];
                String direccion = elementos[3];
                Cliente cliente = new Cliente(idecliente, nombre, correo, direccion);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al leer los clientes..." + e.getMessage());
        }
        return clientes;
    }
    
    public boolean existeId(int ide) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdecliente() == ide) {
                return true;
            }
        }
        return false;
    }
    
    public void registrarCliente(int ide, String nombre, String correo, String direccion) {
        if (existeId(ide) == true) {
            System.out.println("Ya existe un cliente con ese ID...");
        } else {
            Cliente cliente = new Cliente(ide, nombre, correo, direccion);
            clientes.add(cliente);
            guardarCliente(cliente);
            System.out.println("Cliente guardado.");
        }
    }
    public void guardarCliente(Cliente cliente) {
        //BufferedWriter y FileWriter en try para asegurar de que cierre bufferedWriter y escriba en el archivo.
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(this.ruta, true))) {
            bw.write(cliente.toString() + "\n");
            System.out.println("Guardando en archivo el cliente: " + cliente.toString());
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar el cliente..." + e.getMessage());
        }
    }
    
    public void actualizarCliente(int ide, String nuevonombre, String nuevocorreo, String nuevadireccion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdecliente()== ide) {
                cliente.setNombre(nuevonombre);
                cliente.setCorreo(nuevocorreo);
                cliente.setDireccion(nuevadireccion);
            }
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            for (Cliente c : clientes) {
                bw.write(c.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void eliminarCliente(int idElim) {
        Cliente clienteEliminar = null;
        for (Cliente cliente : clientes) {
            if (cliente.getIdecliente()== idElim) {
                clienteEliminar = cliente;
                break;
            }
        }
        if (clienteEliminar != null) {
            clientes.remove(clienteEliminar);
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            for (Cliente cliente : clientes) {
                bw.write(clientes.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getNombreCliente(int idCliente){
        for (Cliente cliente : clientes){
            if (cliente.getIdecliente() == idCliente){
                return cliente.getNombre();
            }
        }
        return null;
    }
}
