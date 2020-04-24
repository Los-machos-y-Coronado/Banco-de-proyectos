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
    private Usuario proponente;
    private List<String> palabrasClave;


    public Iniciativa (int id, String descripcion,Date fecha, String estado,Usuario proponente, List palabrasClave){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.proponente=proponente;
        this.estado="En espera";
        this.palabrasClave = palabrasClave;

    }

    public Iniciativa(){}

    public Usuario getProponente() {
        return proponente;
    }

    public void setProponente(Usuario proponente) {
        this.proponente = proponente;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
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

    public Usuario getCorreo() {
        return proponente;
    }

    public void setCorreo(Usuario correo) {
        this.proponente = correo;
    }




    @Override
    public String toString() {
        return "Iniciativa{" + "id= "+id +", descripcion= "+descripcion + ", fecha= " + fecha +  ", estado= " + estado + ", Proponente= " + proponente + ", Palabras= " + palabrasClave + "}";
    }
   }
