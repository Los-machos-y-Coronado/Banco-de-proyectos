/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.Convertidor;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Andres Gonzalez
 */

@ManagedBean(name = "AutenticacionBean")
@SessionScoped
public class AutenticacionBean {
    
    private final ServiciosBanco serviciosBanco;
    private String estado;
    private String rol;
    private Usuario usu;
    private List<Iniciativa> ini;
    
    public AutenticacionBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        estado = "Iniciar sesión";
        rol="Administrador";
    }
    
    public void autenticar(String correo,String clave,String rol){
        try{
            usu=serviciosBanco.consultarUsuario(correo, clave);
        }catch(ExcepcionServiciosBanco ex){
            estado="Correo o Clave incorrecta";
        }
        if(usu==null){
            estado="Correo o Clave incorrecta";
            
        }else{
            estado="Autenticado "+usu.getNombreUsuario();
        }
        
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
            
            estado="Si se encontraron iniciativas";
        }
        
    }
    public String getEstado() {
        return estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public List<Iniciativa> getIni() {
        return ini;
    }

    public void setIni(List<Iniciativa> ini) {
        this.ini = ini;
    }
    
}
