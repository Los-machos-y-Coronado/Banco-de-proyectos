/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author Andres Gonzalez
 */
public interface DaoUsuario {
    public Usuario consultarUsuario(String nombre, String clave) throws PersistenceException;
}
