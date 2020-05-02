/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.sql.Date;

/**
 *
 * @author Andres Gonzalez
 */
public class Comentario {
    private int id;
    private Date fecha;
    private String comentario;
    private Usuario usuario;
    
    public Comentario(){
        
    }
    
    public Comentario(int id, Date fecha, String comentario,Usuario usuario){
        this.id=id;
        this.usuario=usuario;
        this.fecha=fecha;
        this.comentario=comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Comentario{ " + "id= " + id + ", fecha= " + fecha + ", Comentario= " + comentario + ", Usuario= " + usuario + '}';
    }
}
