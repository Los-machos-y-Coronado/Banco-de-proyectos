/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */

 
public class Iniciativa {
    private int id;
    private String descripcion;
    private Date fecha;
    private String correo;
    private String estado;
    private List palabrasClave;
    
    public Iniciativa (int id, String descripcion,Date fecha, String correo,List palabrasClave){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.correo=correo;
        this.estado="en espera de revision";
        this.palabrasClave = palabrasClave;
            
    }
    public Iniciativa (int id, String descripcion,Date fecha, String correo,String estado){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.correo=correo;
        this.estado=estado;
        this.palabrasClave = new ArrayList<String>();

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    
    
}
