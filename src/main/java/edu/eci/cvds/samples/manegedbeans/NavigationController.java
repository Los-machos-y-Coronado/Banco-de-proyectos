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
}