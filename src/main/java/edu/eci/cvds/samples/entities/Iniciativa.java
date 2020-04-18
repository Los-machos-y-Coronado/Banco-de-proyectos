/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author David Coronado
 */
public class Iniciativa {
    
    private int id;
    private String descripcion;
    private Date fecha;
    private String estado;
    private Proponente proponente;
    private String correo;
   
    private ArrayList<String> palabras;

    {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
      }
    public Iniciativa (int id, String descripcion,Date fecha, String correo,String estado){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.correo=correo;
        this.estado=estado;
        this.palabras = new ArrayList<String>();

    }
    public Iniciativa (int id, String descripcion,java.sql.Date fecha,String estado) {
        this.id =id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.palabras = new ArrayList<String>();
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

        public Proponente getProponente() {
            return proponente;
        }

        public void setProponente(Proponente proponente) {
            this.proponente = proponente;
        }

        public ArrayList<String> getPalabras() {
            return palabras;
        }

        public void setPalabras(ArrayList<String> palabras) {
            this.palabras = palabras;
        }
    
    


    @Override
    public String toString() {
        return "Iniciativa{" + "id "+id +", descripcion "+descripcion + "fecha " + fecha +  "estado " + estado + '}';
    }
   }
