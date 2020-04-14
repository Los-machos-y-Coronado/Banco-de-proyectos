/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.IniciativaMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Coronado
 */

public class MyBatisDAOIniciativa implements DaoIniciativa {
    
    @Inject
    IniciativaMapper iniciativaMapper;
    @Override
    public List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave) throws PersistenceException {
        
        try {
            
            return iniciativaMapper.consultarIniciativas(palabrasclave);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los items con las palabras clave"+palabrasclave,e);
        }
    }
    
    
}
