/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Iniciativa;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andres Gonzalez
 */
public interface ServiciosBanco {
    /**
     * Retorna el usuario segun sus credenciales
     * @param correo String  correo del usuario
     * @param clave String contraseña del usuario
     * @return Usuario usuario
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract Usuario consultarUsuario(String correo, String clave) throws ExcepcionServiciosBanco;
    
       /**
     * Retorna iniciativas que contenga palabras clave dadas
     * @param palabrasClave ArrayList  palabras clave 

     * @return un listado del detalle de las iniciativas que contengan las palabras clave
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    
    
    public abstract List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasClave)throws ExcepcionServiciosBanco;
    
    
}
