/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.manegedbeans;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Andres Gonzalez
 */

@ManagedBean(name = "AutenticacionBean")
@SessionScoped
public class AutenticacionBean {

    private ServiciosBanco serviciosBanco;
    private String estado;
    private String rol;
    private Usuario usu;

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

}