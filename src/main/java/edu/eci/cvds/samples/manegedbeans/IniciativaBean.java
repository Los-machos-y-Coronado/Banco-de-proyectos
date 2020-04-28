/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Like;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private String estado;
    private String screenEstado = "";
    private Usuario proponente ;

    private String[] tipoEstado={"En espera de revision","En revisión","Propuesta","Solucionado"};
    private Iniciativa nuevoRegistro;
    private java.sql.Date fecha;
    private List<Iniciativa> iniciativas;
    private String palabrasClave="";
    private int id;
    private int numLikes;
    private String buttonLike;
    private Subject cor;


    public IniciativaBean() {
        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
        cor= SecurityUtils.getSubject();
        try {
            proponente=serviciosBanco.consultarUsuario(cor.getSession().getAttribute("Correo").toString());
            iniciativas = serviciosBanco.consultarIniciativas();
            id= iniciativas.size()+1;
        }catch (ExcepcionServiciosBanco ex){

        }
    }

    public void home() {

        screenEstado = "Ingrese sus Datos";
    }



    public void registrarIniciativa(String descripcion) throws ParseException {

        try {
            estado = "En espera de revisión";
            List palabrasclaveArr = new ArrayList<String>(Arrays.asList(palabrasClave.split(",")));
            Date utilDate = new Date();
            nuevoRegistro = new Iniciativa(id, descripcion, new java.sql.Date(utilDate.getTime()),estado,proponente,palabrasclaveArr);
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            iniciativas = serviciosBanco.consultarIniciativas();
            screenEstado = "registro exitoso";
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public String estadoLike(Iniciativa in){

        try {
            Like ver= null;
            ver = serviciosBanco.consultarLikesInCor(in.getId(),proponente.getCorreo());
            if(ver == null){
                buttonLike="Like";
            }else{

                buttonLike="Dislike";
            }
        } catch (ExcepcionServiciosBanco ex) {
            screenEstado="Error en consultar estado like";
        }

        return buttonLike;
    }
    public void registrarLike(Iniciativa in){
        try {
            Like ver=serviciosBanco.consultarLikesInCor(in.getId(),proponente.getCorreo());
            if(ver == null){
                serviciosBanco.registrarLike(in.getId(), proponente.getCorreo());
                buttonLike="Dislike";
            }else{
                serviciosBanco.deleteLikes(in.getId(), proponente.getCorreo());
                buttonLike="Like";
            }
        }catch (ExcepcionServiciosBanco ex){
            screenEstado="Error en Registrar Like";
        }
    }

    public void UpdateEstado (Iniciativa i,String xestado){
        try{
            this.estado=xestado;
            serviciosBanco.UpdateEstado(i.getId(),estado);
            screenEstado="actualizado";
            iniciativas = serviciosBanco.consultarIniciativas();
        }catch (Exception ex){
            screenEstado="Error en actualziar";

        }
    }

    public int numeroLikes(Iniciativa in){
        numLikes=0;
        try{
            List<Like> likes=serviciosBanco.consultarLikesIn(in.getId());
            numLikes=likes.size();

        }catch (Exception e){
            screenEstado="Error al saber likes";
        }
        return numLikes;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public String getButtonLike() {
        return buttonLike;
    }

    public void setButtonLike(String buttonLike) {
        this.buttonLike = buttonLike;
    }

    public String[] getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String[] tipoEstado) {
        this.tipoEstado = tipoEstado;
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

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
