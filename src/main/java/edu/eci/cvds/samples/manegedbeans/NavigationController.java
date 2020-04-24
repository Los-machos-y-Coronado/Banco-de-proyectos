package edu.eci.cvds.samples.manegedbeans;

import java.io.Serializable;  

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped

public class NavigationController implements Serializable {

    public String paginaAtenticacion() {
        return "Autenticacion";
    }
    public String paginaInicio(){
        return "index";
    }
    public String paginAsignacionPerfiles(){
        return "AsignacionPerfiles";
    }
    public String paginaPerfil(){
        return "Perfil";
    }
    public String estadoIniciativa(){
        return "EstadoIniciativa";
    }
    public String iniciativas(){
        return "Riniciativas";
    }
    public String publico(){
        return "Publico";
    }
    public String getPageAdmin(){return "Perfiladmin";}
    public String getPageProp(){return "Perfilproponente";}
    public String getPagePublic(){return "PerfilPublico";}

    public String ConsultarIniciativas(){
        return "frontConsult";
    }
}