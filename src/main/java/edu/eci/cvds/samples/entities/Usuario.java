/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 * @author Andres Gonzalez
 */
public class Usuario {
    private String correo;
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private Rol rol;
    private boolean estado;
    private String area;


    public Usuario (String correo, String nombreUsuario, String nombre, String apellido, Rol rol, boolean estado, String area) {
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.estado = estado;
        this.area = area;
        System.out.println(this+"JOHANN ES RE GURRERO");


    }
    public Usuario(){}
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Usuario{ " + "correo= " + correo + ", nombre Usuario= " + nombreUsuario + ", nombre= " + nombre + ", apellido= " + apellido + ", estado= " + estado + '}';
    }

}
