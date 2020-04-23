package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Rol;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andres Gonzalez
 */



@ManagedBean(name = "AsignacionPerfilBean")
@SessionScoped
public class AsignacionPerfilesBean implements Serializable {
    private ServiciosBanco serviciosBanco;
    private Usuario admin;
    private List<Usuario> usuarios;
    private Rol[] roles;
    
    public AsignacionPerfilesBean(){
        serviciosBanco=ServiciosBancoFactory.getInstance().getServiciosBanco();
        try {
            usuarios=serviciosBanco.consultarUsuarios();
            roles=Rol.values();
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(AsignacionPerfilesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cambiarRol(Usuario usu, String rol){
        
        Rol nuevo= Rol.valueOf(rol);
        try {
            serviciosBanco.cambiarRol(usu,nuevo);
            usuarios=serviciosBanco.consultarUsuarios();
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(AsignacionPerfilesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Rol[] getRoles() {
        return roles;
    }

    public void setRoles(Rol[] roles) {
        this.roles = roles;
    }
    
    
}
