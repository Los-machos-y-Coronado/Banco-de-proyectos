/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Jairo Gomez
 */


@ManagedBean (name = "inBean")
@SessionScoped

public class IniciativaBean implements Serializable {

    private ServiciosBanco serviciosBanco;
    private String estado = "En espera de revisión";
    private String screenEstado = "";
    private Usuario proponente = new Usuario("alex.garci@yahoo.com", "alex22", "alex", "gordillo", Rol.Proponente,true, "civl");
    private Usuario administrador = new Usuario("danipipe1703@gmail.com","DanielG","Daniel","Gomez",Rol.Administrador,true,null);
    private Iniciativa nuevoRegistro;
    private java.sql.Date fecha;
    private List<Iniciativa> iniciativas;

    public IniciativaBean() {
        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
        try {
            iniciativas = serviciosBanco.consultarIniciativas();
        }catch (ExcepcionServiciosBanco ex){

        }
    }

    public void home() {

        screenEstado = "reinicio";
    }

    public void registrarIniciativa(String id, String descripcion) throws ParseException {

        try {
            Date utilDate = new Date();
            nuevoRegistro = new Iniciativa(Integer.parseInt(id), descripcion, new java.sql.Date(utilDate.getTime()),estado,proponente,new ArrayList<String>());
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            iniciativas = serviciosBanco.consultarIniciativas();
            screenEstado = "registro exitoso";
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void UpdateEstado (String id){
        try{
            serviciosBanco.UpdateEstado(Integer.parseInt(id) ,estado);
            screenEstado="actualizado";
            iniciativas = serviciosBanco.consultarIniciativas();
        }catch (Exception ex){
            screenEstado="Error en actualziar";

        }
    }




    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }

    public String justNow() {
        Date now =new Date();
        fecha=new java.sql.Date(now.getTime());
        String justnow=fecha.toString();
        return  justnow;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getScreenEstado() {
        return screenEstado;
    }

    public void setScreenEstado(String screenEstado) {
        this.screenEstado = screenEstado;
    }

    public Usuario getProponente() {
        return proponente;
    }

    public void setProponente(Usuario proponente) {
        this.proponente = proponente;
    }

    public Iniciativa getNuevoRegistro() {
        return nuevoRegistro;
    }

    public void setNuevoRegistro(Iniciativa nuevoRegistro) {
        this.nuevoRegistro = nuevoRegistro;
    }
}