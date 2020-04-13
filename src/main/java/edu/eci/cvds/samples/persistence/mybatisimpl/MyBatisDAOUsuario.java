/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public class MyBatisDAOUsuario implements DaoUsuario{
    
    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public Usuario consultarUsuario(String correo, String clave) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuario(correo,clave);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);
            
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuarios();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los usuarios:"+e.getLocalizedMessage(), e);
            
        }
    }

    @Override
    public void cambiarRol(String correo, Rol rol) throws PersistenceException {
        try{
            usuarioMapper.cambiarRol(correo,rol);
        }catch(Exception e){
            throw new PersistenceException("Error al cambiar el rol del usuario:"+correo+e.getLocalizedMessage(), e);
            
        }
    }
    
}
