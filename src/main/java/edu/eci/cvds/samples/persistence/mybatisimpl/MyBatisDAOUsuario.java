/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.UsuarioMapper;

/**
 *
 * @author Andres Gonzalez
 */
public class MyBatisDAOUsuario implements DaoUsuario{
    
    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public Usuario consultarUsuario(String nombre, String clave) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuario(nombre,clave);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);
            
        }
    }
    
}
