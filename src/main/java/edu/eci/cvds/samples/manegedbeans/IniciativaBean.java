/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jairo Gomez
 */

@ManagedBean(name = "AutenticacionBean")
@SessionScoped
public class IniciativaBean {
    
    private ServiciosBanco serviciosBanco;
    private String estado;
    private Usuario proponente;
    private List<Iniciativa> iniciativas;
    private Iniciativa iniciativa;
  
    
    public IniciativaBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        estado = "Iniciar sesión";
    }
    
    public void autenticar(int id){
        try{
            iniciativa=serviciosBanco.consultarIniciativa(id);
        }catch(ExcepcionServiciosBanco ex){
            estado="Correo o Clave incorrecta";
        }
        if(iniciativa==null){
            estado="no hay iniciativa";
        }else{
            estado="Autenticado";
        }
        
    }


}
