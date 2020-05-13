/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Estado;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.services.Convertidor;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import org.apache.shiro.config.Ini;
import org.primefaces.model.DualListModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        private Estado[] estados;
        private List<String> palabrasClave;
        private ArrayList<String> palabrasSeleccionadas;
        private DualListModel<String> palabras ;
        
    public ConsultarIniciativasBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        ini = new ArrayList<Iniciativa>();
        palabrasClave = new ArrayList<String>() ;
        palabrasSeleccionadas=new ArrayList<String>();
        try {
            ArrayList<Iniciativa> iniciativas =  (ArrayList)serviciosBanco.consultarIniciativas();
            for (Iniciativa i : iniciativas ){
                for (String palabra : i.getPalabrasClave()){
                    if(! (palabrasClave.contains(palabra))) {
                        palabrasClave.add(palabra);
                    }
                }

            }
            palabras=new DualListModel<String>(palabrasClave, palabrasSeleccionadas);

        } catch (ExcepcionServiciosBanco excepcionServiciosBanco) {
            excepcionServiciosBanco.printStackTrace();
        }
    }       

    public void consultarIniciativas(){
        palabrasSeleccionadas = (ArrayList)palabras.getTarget();
            if(palabrasSeleccionadas.size()==0){
                ini.clear();
                estado="No ingreso ninguna palabra";
            }else{
                try{
                    ini=serviciosBanco.consultarIniciativas(palabrasSeleccionadas);
                    estados=Estado.values();

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

    }
    
    public void consultarIniciativasPorEstado(String estado){
        try{
            ini=serviciosBanco.consultarIniciativasPorEstado(estado);
        }catch(ExcepcionServiciosBanco ex){
                this.estado="Error al consultar las iniciativas";
            } 
        if (ini.isEmpty()){
                this.estado="No se encontro ningun registro";
            }
            else{

                this.estado=null;
            }
    }

    public void limpiar(){
        this.estado=null;
        this.ini=new ArrayList<Iniciativa>();
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

    public Estado[] getEstados() {
        return estados;
    }

    public void setEstados(Estado[] estados) {
        this.estados = estados;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public ArrayList<String> getPalabrasSeleccionadas() {
        return palabrasSeleccionadas;
    }

    public void setPalabrasSeleccionadas(ArrayList<String> palabrasSeleccionadas) {
        this.palabrasSeleccionadas = palabrasSeleccionadas;
    }

    public DualListModel<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(DualListModel<String> palabras) {
        this.palabras = palabras;
    }
}
