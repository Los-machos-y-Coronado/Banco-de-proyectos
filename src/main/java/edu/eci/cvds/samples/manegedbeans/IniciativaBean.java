/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;
import edu.eci.cvds.samples.entities.Estado;
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
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    private Estado[] tipoEstado;
    private Usuario actual;
    private Iniciativa nuevoRegistro;
    private java.sql.Date fecha;

    private List<Iniciativa> iniciativas;
    private List<Iniciativa> iniciativasGroup;
    private String palabrasClave="";
    private int id;
    private int numLikes;
    private String buttonLike;
    private String icon;
    private Subject cor;
    private List<Iniciativa> selectedIni;



    public IniciativaBean() {

        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
        cor= SecurityUtils.getSubject();
        tipoEstado=Estado.values();

        try {
            proponente=serviciosBanco.consultarUsuario(cor.getSession().getAttribute("Correo").toString());
            iniciativas = serviciosBanco.consultarIniciativas();
            id= iniciativas.size()+1;
        }catch (ExcepcionServiciosBanco ex){
            System.out.println("EXCEPTION");
        }
    }

    public void home() {

        screenEstado = "Ingrese sus Datos";
    }



    public void registrarIniciativa(String descripcion) throws ParseException {
        screenEstado = "Favor diligenciar todos los campos";
        try {
            estado = "En espera de revisión";

            List palabrasclaveArr = new ArrayList<>(Arrays.asList(palabrasClave.split(",")));


            Date utilDate = new Date();
            nuevoRegistro = new Iniciativa(id, descripcion, new java.sql.Date(utilDate.getTime()),estado,proponente,palabrasclaveArr,null);
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            iniciativas = serviciosBanco.consultarIniciativas();
            id= iniciativas.size()+1;
            palabrasClave="";
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
                icon="pi pi-thumbs-up";
                buttonLike="Like";
            }else{
                icon="pi pi-thumbs-down";
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
                icon="pi pi-thumbs-down";
            }else{
                serviciosBanco.deleteLikes(in.getId(), proponente.getCorreo());
                buttonLike="Like";
                icon="pi pi-thumbs-up";
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
        }catch (ExcepcionServiciosBanco | NumberFormatException ex){
            screenEstado="Error en actualziar";

        }
    }

    public void updateDescripcion (Iniciativa i,String desc){
        try{
            Date utilDate = new Date();
            serviciosBanco.updateDescripcion(desc,new java.sql.Date(utilDate.getTime()),i.getId());
            screenEstado="actualizado";
            iniciativas = serviciosBanco.consultarIniciativas();
        }catch (ExcepcionServiciosBanco | NumberFormatException ex){
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

    public void agruparIniciativas(){
        try{
            
            serviciosBanco.agruparIniciativas(selectedIni);
   
        }catch (ExcepcionServiciosBanco ex){
            screenEstado="error en agrupacion";
        }
    }
    public void consultarRelacionados(Iniciativa ini){
        try {
            iniciativasGroup=serviciosBanco.consultarRelacionados(ini);
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(IniciativaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Iniciativa> consultarMisniciativas () {
        List<Iniciativa> misIni = new ArrayList<Iniciativa>();
        for (Iniciativa i : iniciativas) {
            if (i.getProponente().getCorreo().equals(proponente.getCorreo()))
            {
                misIni.add(i);
            }
        }
        return misIni;
    }

    public Usuario getProponente() {
        return proponente;
    }

    public void setProponente(Usuario proponente) {
        this.proponente = proponente;
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

    public Estado[] getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(Estado[] tipoEstado) {
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

    public Usuario getActual() {
        return actual;
    }

    public void setActual(Usuario actual) {
        this.actual = actual;
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

    public List<Iniciativa> getIniciativasGroup() {
        return iniciativasGroup;
    }

    public void setIniciativasGroup(List<Iniciativa> iniciativasGroup) {
        this.iniciativasGroup = iniciativasGroup;
    }

    public List<Iniciativa> getSelectedIni() {
        return selectedIni;
    }

    public void setSelectedIni(List<Iniciativa> selectedIni) {
        this.selectedIni = selectedIni;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
