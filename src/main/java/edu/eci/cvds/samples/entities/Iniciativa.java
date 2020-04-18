/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author David Coronado
 */
public class Iniciativa {
    
    private int id;
    private String descripcion;
    private Date fecha;
    private String estado;
    
    private String correo;
   
    private List<String> palabrasClave;


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
    public Iniciativa (int id, String descripcion,java.sql.Date fecha,String estado) {
        this.id =id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.palabrasClave = new ArrayList<String>();
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

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }



        public List<String> getPalabras() {
            return palabrasClave;
        }

        public void setPalabras(List<String> palabras) {
            this.palabrasClave = palabras;
        }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    


    @Override
    public String toString() {
        return "Iniciativa{" + "id "+id +", descripcion "+descripcion + "fecha " + fecha +  "estado " + estado + '}';
    }
   }
