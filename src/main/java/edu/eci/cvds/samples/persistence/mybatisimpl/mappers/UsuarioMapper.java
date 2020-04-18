/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl.mappers;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Andres Gonzalez
 */
public interface UsuarioMapper {
    /**
     * Consulta usuario dado
     * @param correo String correo del Usuario
     * @param clave  String clave del Usuario
     * @return Usuario correspondiente 
     */
    public Usuario consultarUsuario(@Param("corr")String correo, @Param("clusu")String clave);
    
    /**
     * Consulta todos los usuarios
     * @return Lista de todos los usuarios 
     */
    public List<Usuario> consultarUsuarios();
    /**
     * Cambia el rol del usuario determinado
     * @param usuario usuario
     * @param rol Nuevo rol
     */
    public void cambiarRol(@Param("usu")Usuario usuario,@Param("rol")Rol rol);
}
