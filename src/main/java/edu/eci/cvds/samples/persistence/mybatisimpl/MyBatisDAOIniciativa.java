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
 * @author Jairo Gomez
 */
public class MyBatisDAOIniciativa implements DaoIniciativa{

    @Inject
    IniciativaMapper iniciativaMapper;
    
    @Override
    public Iniciativa consultarIniciativa(int id) throws PersistenceException  {
        Iniciativa inConsultada=null;
         try{
            inConsultada= iniciativaMapper.consultarIniciativa(id);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);   
        }
        return inConsultada;
      
    }

    @Override
    public List<Iniciativa> consultarIniciativas() throws PersistenceException {
         List<Iniciativa> consultas= new  ArrayList<Iniciativa> (); ;
         try{
            consultas= iniciativaMapper.consultarIniciativas();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);   
        }
        return consultas;
      
    }
    
    
}
