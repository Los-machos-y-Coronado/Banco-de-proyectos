/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author Andres Gonzalez
 */
public class Usuario {
    private String nombre;
    private Rol rol;
    
    public Usuario(String nombre, Rol rol){
        this.nombre=nombre;
        this.rol=rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", rol=" + rol + '}';
    }
   
}
