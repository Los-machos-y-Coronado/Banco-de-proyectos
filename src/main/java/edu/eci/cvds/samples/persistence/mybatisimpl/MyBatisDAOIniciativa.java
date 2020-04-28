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
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gomez
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
         try{
             //System.out.println(iniciativaMapper.consultarIniciativas());
            return iniciativaMapper.consultarIniciativas();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);   
        }
      
    }

    @Override
    public void registrarIniciativa(Iniciativa in) throws PersistenceException {
        try{
            iniciativaMapper.registrarIniciativa(in);
        }catch (Exception e){
            throw new PersistenceException("error al registrar idea/Iniciativa",e);
        }
    }
    @Override
    public void registrarPalabrasClave(int id, ArrayList<String> palabras) throws PersistenceException{
        try{
            for (String pala : palabras){
                iniciativaMapper.registrarPalabraClave(id,pala);
            }
        }catch(Exception e){
            throw new PersistenceException ("al registrar palabra clave",e);
        }
    }



    @Override
    public void UpdateEstado(int id,String estado) throws PersistenceException {
        try{
            iniciativaMapper.updateEstado( id , estado);
        }catch (Exception e){
            throw new PersistenceException ("error al actualizar estado de idea/Iniciativa",e);
        }
    }
      
    @Override
    public List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave) throws PersistenceException {
        
        try {
            
            return iniciativaMapper.consultarIniciativasPalabra(palabrasclave);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los items con las palabras clave"+palabrasclave,e);
        }
    }

}
