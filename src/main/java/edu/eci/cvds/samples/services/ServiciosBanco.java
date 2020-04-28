/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.*;

import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Daniel Gomez
 * @version  2.0
 */
public interface ServiciosBanco {
    /**
     * Retorna el usuario segun sus credenciales
     * @param correo String  correo del usuario
     * @param clave String contraseña del usuario
     * @return Usuario usuario 
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract Usuario consultarUsuario(String correo) throws ExcepcionServiciosBanco;
    public abstract Iniciativa consultarIniciativa(int id) throws ExcepcionServiciosBanco;
    public abstract List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosBanco;
    public abstract void registrarIniciativa(Iniciativa in)throws ExcepcionServiciosBanco;
    public abstract void UpdateEstado(int id,String estado) throws ExcepcionServiciosBanco;



    
       /**
     * Retorna iniciativas que contenga palabras clave dadas
     * @param palabrasClave ArrayList  palabras clave 

     * @return un listado del detalle de las iniciativas que contengan las palabras clave
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    
    
    public abstract List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasClave)throws ExcepcionServiciosBanco;
    
    
    /**
     * 
     * @return Lista de usuarios
     * @throws ExcepcionServiciosBanco 
     */
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionServiciosBanco;
    /**
     * Cambia el rol del usuario
     * @param usuario Usuario
     * @param rol nuevo rol
     * @throws ExcepcionServiciosBanco 
     */
    public abstract void cambiarRol(Usuario usuario,Rol rol) throws ExcepcionServiciosBanco;
    /**
     * Registra los likes de cada iniciativa
     * @Param id identificador de iniciativa
     * @Param String correo del usuario
     * @throws ExcepcionServiciosBanco
     */
    public void registrarLike(int id, String correo) throws ExcepcionServiciosBanco ;

    public List<Like> consultarLikesIn(int id)  throws ExcepcionServiciosBanco;
    public Like consultarLikesInCor(int id,String corr)  throws ExcepcionServiciosBanco;

    public void deleteLikes(int id,String corr)  throws ExcepcionServiciosBanco;
}
