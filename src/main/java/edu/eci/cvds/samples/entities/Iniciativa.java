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
    private String area;
    private List palabrasClave;
    
    public Iniciativa (int id, String descripcion,Date fecha, String area,List palabrasClave){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.area=area;
        this.palabrasClave = palabrasClave;
            
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
    
    
    
}
