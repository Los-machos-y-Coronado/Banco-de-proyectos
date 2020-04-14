/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.DaoUsuario;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import java.util.ArrayList;
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
    
    @Override
    public  List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave)throws ExcepcionServiciosBanco{
        try{
            return daoIniciativa.consultarIniciativas(palabrasclave);
        }
        catch(PersistenceException ex){
            throw new ExcepcionServiciosBanco("Error al consultar las iniciativas con las palabras clave"+palabrasclave,ex);
        }
    }
    

    
}
