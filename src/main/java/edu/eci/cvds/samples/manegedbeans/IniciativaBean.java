/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Proponente;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Jairo Gomez
 */


@ManagedBean (name = "inBean")
@SessionScoped

public class IniciativaBean implements Serializable{
    @Inject
    private ServiciosBanco serviciosBanco;
    private String estado = "En espera de revisión";
    private String screenEstado = "";
    private Proponente proponente = new Proponente("luis@mail.com", "luisja", "luis", "jaramillo", true, "planeacion");
    private Iniciativa nuevoRegistro;


    public void home(){
        System.out.println("estoy en home, conexion exitosa");
    }
    public void registrarIniciativa (String id,String descripcion, Date fecha) throws ParseException {
        System.out.println(id + descripcion  + fecha);
        Iniciativa nuevoRegistro = new Iniciativa(Integer.parseInt(id), descripcion, fecha, proponente.getArea(), new ArrayList<String>());
        try {

            serviciosBanco.registrarIniciativa(nuevoRegistro);

        } catch (Exception e) {
            screenEstado="Por favor revisar todos los campos";

        }
    }

    public ServiciosBanco getServiciosBanco() {
        return serviciosBanco;
    }

    public void setServiciosBanco(ServiciosBanco serviciosBanco) {
        this.serviciosBanco = serviciosBanco;
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

    public Proponente getProponente() {
        return proponente;
    }

    public void setProponente(Proponente proponente) {
        this.proponente = proponente;
    }

    public Iniciativa getNuevoRegistro() {
        return nuevoRegistro;
    }

    public void setNuevoRegistro(Iniciativa nuevoRegistro) {
        this.nuevoRegistro = nuevoRegistro;
    }
}
