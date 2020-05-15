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
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;

@ManagedBean(name = "AgregarComentarioBean")
@SessionScoped

/**
 *
 * @author David Coronado
 */
public class AgregarComentarioBean implements Serializable{
    
    private  ServiciosBanco serviciosBanco;
    private String estado;
    private List<Iniciativa> ini;
    private Usuario publico;
    
    private Iniciativa  selectedIniciativa;
    
    public AgregarComentarioBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        Subject cor= SecurityUtils.getSubject();
        estado=null;
        try{
            ini = serviciosBanco.consultarIniciativas();
            publico=serviciosBanco.consultarUsuario(cor.getSession().getAttribute("Correo").toString());
            
            
        }catch(ExcepcionServiciosBanco ex){
             Logger.getLogger(AsignacionPerfilesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AgregarComentario(String comentario){

        if (selectedIniciativa==null){
            estado="Seleccione alguna iniciativa";    
        }
        else{
            try{
                ini=serviciosBanco.consultarIniciativas();
                serviciosBanco.agregarComentariosAIniciativa(selectedIniciativa.getId(),publico.getCorreo(),comentario);
                estado="Su comentario se agrego exitosamente";
                selectedIniciativa=null;
                ini=serviciosBanco.consultarIniciativas();
            }catch(ExcepcionServiciosBanco ex){
                estado="Error al agregar un comentario";
                Logger.getLogger(AsignacionPerfilesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Iniciativa> getIni() {
        return ini;
    }

    public void setIni(List<Iniciativa> ini) {
        this.ini = ini;
    }

    public Usuario getPublico() {
        return publico;
    }

    public void setPublico(Usuario publico) {
        this.publico = publico;
    }

    public Iniciativa getSelectedIniciativa() {
        return selectedIniciativa;
    }

    public void setSelectedIniciativa(Iniciativa selectedIniciativa) {
        this.selectedIniciativa = selectedIniciativa;
    }
    
    
}
