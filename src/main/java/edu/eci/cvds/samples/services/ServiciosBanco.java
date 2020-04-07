/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

/**
 *
 * @author Andres Gonzalez
 */
public interface ServiciosBanco {
    /**
     * Retorna el usuario segun sus credenciales
     * @param nombre String nombre del usuario
     * @param clave String contraseña del usuario
     * @return Usuario usuario
     * @throws edu.eci.cvds.samples.services.ExcepcionServiciosBanco
     */
    public abstract Usuario consultarUsuario(String nombre, String clave) throws ExcepcionServiciosBanco;
}
