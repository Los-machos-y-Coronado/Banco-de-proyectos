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
    private List<Comentario> comentarios;

    public Iniciativa (int id, String descripcion,Date fecha, String estado,Usuario proponente, List palabrasClave, List comentarios){
        this.id=id;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.proponente=proponente;
        this.estado=Estado.EN_ESPERA.getName();
        this.palabrasClave = palabrasClave;
        this.comentarios=comentarios;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<String> getComentarios2(){
        
        ArrayList<String> comentarios2 = new ArrayList<>();
        
        comentarios.forEach((c) -> {
            comentarios2.add(c.getComentario());
        });
        
        return comentarios2;
    }



    @Override
    public String toString() {
        return "Iniciativa{" + "id= "+id +", descripcion= "+descripcion + ", fecha= " + fecha +  ", estado= " + estado + ", Proponente= " + proponente + ", Palabras= " + palabrasClave + "}";
    }
   }
