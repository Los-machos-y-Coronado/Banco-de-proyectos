/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.persistence.DaoIniciativa;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.mybatisimpl.mappers.IniciativaMapper;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gomez
 */
public class MyBatisDAOIniciativa implements DaoIniciativa{

    @Inject
    private IniciativaMapper iniciativaMapper;
    
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

    @Override
    public List<Area> iniciativasPorArea() throws PersistenceException {
        try{
            return iniciativaMapper.iniciativasPorArea();
        }catch (Exception e){
            throw new PersistenceException ("error al las Iniciativas por area",e);
        }
    }
    @Override
    public List<Iniciativa> iniciativasPorEstado(String estado) throws PersistenceException{
        try{
            return iniciativaMapper.iniciativasPorEstado(estado);
        } catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las iniciativas",e);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativaCor(String cor) throws PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativaCor(cor);
        }catch (Exception e){
            throw new PersistenceException ("error al las Iniciativas de "+cor,e);
        }
    }

    @Override
    public void updateDescripcion(String des, Date fecha, int id) throws PersistenceException {
        try {
             iniciativaMapper.updateDescripcion(des,fecha,id);
        }catch (Exception e){
            throw new PersistenceException ("error al actualizar BT Iniciativa "+id,e);
        }
    }

    @Override
    public void agruparIniciativa(Iniciativa iniciativa,int idGrupo) throws PersistenceException {
        try{
            iniciativaMapper.agruparIniciativa(iniciativa,idGrupo);
        }catch(Exception e){
            throw new PersistenceException("error al agrupar las iniciativas");
        }
    }

    @Override
    public int selectid() throws PersistenceException {
        try{
            return iniciativaMapper.selectid();
        }catch(Exception ex){
            throw new PersistenceException("error al consultar el id");
        }
    }

    @Override
    public List<Iniciativa> consultarRelacionados(Iniciativa iniciativa) throws PersistenceException {
        try{
            return iniciativaMapper.consultarRelacionados(iniciativa);
        }catch(Exception ex){
            throw new PersistenceException("error al consultar los relacionados");
        }
    }

}
