/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public class ServiciosBancoImpl implements ServiciosBanco {
    
    @Inject
    private DaoUsuario daoUsuario;
    @Inject
    private DaoIniciativa daoIniciativa;

    @Override
    public Usuario consultarUsuario(String correo, String clave) throws ExcepcionServiciosBanco {
        try{
            return daoUsuario.consultarUsuario(correo,clave);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar el usuario "+correo,ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Iniciativa consultarIniciativa (int id) throws ExcepcionServiciosBanco{
        try{
            return daoIniciativa.consultarIniciativa(id);
        }catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("No se pudo consultar la iniciativa "+id,ex);
        }
    } 
  
    public List<Iniciativa> consultarIniciativas() throws ExcepcionServiciosBanco {
        try {
            return daoIniciativa.consultarIniciativas();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosBanco("No hay Iniciativas ", ex);
        }
    }

    public void registrarIniciativa(Iniciativa in) throws ExcepcionServiciosBanco{
        try{

            daoIniciativa.registrarIniciativa(in);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosBanco("no se pudo registrar ",ex);
        }
    }
}
