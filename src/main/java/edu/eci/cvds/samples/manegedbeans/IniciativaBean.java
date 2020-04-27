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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    private String estado = "En espera de revisión";
    private String screenEstado = "";
    private Usuario actual;
    private Iniciativa nuevoRegistro;
    private java.sql.Date fecha;
    private List<Iniciativa> iniciativas;
    private String palabrasClave="";
    private int id;
    private Subject cor;

    public IniciativaBean() {

        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
        cor= SecurityUtils.getSubject();

        try {
            actual=serviciosBanco.consultarUsuario(cor.getSession().getAttribute("Correo").toString());
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

        try {
            List palabrasclaveArr = new ArrayList<>(Arrays.asList(palabrasClave.split(",")));
            Date utilDate = new Date();
            nuevoRegistro = new Iniciativa(id, descripcion, new java.sql.Date(utilDate.getTime()),estado,actual,palabrasclaveArr);
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            iniciativas = serviciosBanco.consultarIniciativas();
            screenEstado = "registro exitoso";
        } catch (ExcepcionServiciosBanco e) {
            e.printStackTrace();

        }
    }

    public void UpdateEstado (String id){
        try{
            serviciosBanco.UpdateEstado(Integer.parseInt(id) ,estado);
            screenEstado="actualizado";
            iniciativas = serviciosBanco.consultarIniciativas();
        }catch (ExcepcionServiciosBanco | NumberFormatException ex){
            screenEstado="Error en actualziar";

        }
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
}
