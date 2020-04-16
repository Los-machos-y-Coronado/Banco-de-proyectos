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

    private ServiciosBanco serviciosBanco;
    private String estado = "En espera de revisión";
    private String screenEstado = "";
    private Proponente proponente;
    private Iniciativa nuevoRegistro;

    public IniciativaBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        proponente = new Proponente("alex.garci@yahoo.com", "alex22", "alex", "gordillo", true, "civl");

    }
    public void home(){
        System.out.println("estoy en home, conexion exitosa");
        screenEstado="reinicio";
    }
    public void registrarIniciativa (String id,String descripcion) throws ParseException {
        Date utilDate = new Date();
        Iniciativa nuevoRegistro = new Iniciativa(Integer.parseInt(id), descripcion, new java.sql.Date(utilDate.getTime()), proponente.getCorreo(),estado);
        System.out.println(serviciosBanco);
        try {
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            screenEstado="registro exitoso";

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ServiciosBanco geterviciosBanco() {
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
