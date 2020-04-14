/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public interface ServiciosBanco {
    /**
     * Retorna el usuario segun sus credenciales
     * @param nombre String correo del usuario
     * @param clave String contraseña del usuario
     * @return Usuario usuario
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract Usuario consultarUsuario(String correo, String clave) throws ExcepcionServiciosBanco;
    public  Iniciativa consultarIniciativa(int id) throws ExcepcionServiciosBanco;
    public  List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosBanco;
    
}
