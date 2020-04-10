/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author Jairo Gomez
 */
public class Publico  extends Usuario {
    
    public Publico(String correo,String nombreUsuario, String nombre,String apellido,boolean estado) {
        super(correo, nombreUsuario, nombre, apellido, estado);
    }
    
}
