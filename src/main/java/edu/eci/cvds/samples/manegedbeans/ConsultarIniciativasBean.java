/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.services.Convertidor;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author David Coronado
 */
@ManagedBean(name = "ConsultarIniciativasBean")
@SessionScoped
public class ConsultarIniciativasBean implements Serializable {
        private final ServiciosBanco serviciosBanco;
        private String estado;
        private List<Iniciativa> ini;
        
        
    public ConsultarIniciativasBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
    }       

    public void consultarIniciativas(String palabras){

            try{
                Convertidor convertidor = new Convertidor();
                ini=serviciosBanco.consultarIniciativas(convertidor.convertirPalabras(palabras));

            }catch(ExcepcionServiciosBanco ex){
                estado="Error al consultar las iniciativas";
            }   
            if (ini.isEmpty()){
                estado="No se encontro ninguna iniciativa con esas palabras";
            }
            else{

                estado=null;
            }

        }
    public List<Iniciativa> getIni() {
            return ini;
    }

    public void setIni(List<Iniciativa> ini) {
            this.ini = ini;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
