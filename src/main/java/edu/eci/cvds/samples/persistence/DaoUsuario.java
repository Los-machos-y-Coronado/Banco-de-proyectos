/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public interface DaoUsuario {
    /**
     * 
     * @param correo String correo del Usuario
     * @return Usuario correspondiente 
     * @throws edu.eci.cvds.samples.persistence.PersistenceException 
     */
    public Usuario consultarUsuario(String correo ) throws PersistenceException;
    
    /**
     * 
     * @return Lista de usuarios
     * @throws PersistenceException 
     */
    public List<Usuario> consultarUsuarios() throws PersistenceException;
    
    /**
     * Cambia el rol del usuario
     * @param usuario usuario
     * @param rol rol nuevo
     * @throws PersistenceException 
     */
    public void cambiarRol(Usuario usuario,Rol rol) throws PersistenceException;
    
    /**
     * Registrar un comentario a iniciativa
     * @param correo
     * @param idIniciativa
     * @param comentario 
     * @throws PersistenceException 
     */
    
    
    public void agregarComentarioAIniciativa(String correo,int idIniciativa,String comentario)throws PersistenceException;
;}
