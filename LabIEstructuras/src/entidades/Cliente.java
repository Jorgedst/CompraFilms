/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Dtapiaj
 */public class Cliente {
    int idecliente;
    String nombre;
    String correo;
    String direccion;

    public Cliente(int idecliente, String nombre, String correo, String direccion) {
        this.idecliente = idecliente;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getIdecliente() {
        return idecliente;
    }

    public void setIdecliente(int idecliente) {
        this.idecliente = idecliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override 
    public String toString(){
        return idecliente+","+nombre+","+correo+","+direccion;
    }
            
}