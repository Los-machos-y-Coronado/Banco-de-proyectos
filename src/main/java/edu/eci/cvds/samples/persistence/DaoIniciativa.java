/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Iniciativa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Gomez
 */
public interface DaoIniciativa {

    /**
     *
     * @param id
     * @return
     */
    public Iniciativa consultarIniciativa(int id) throws PersistenceException;
    public List<Iniciativa> consultarIniciativas() throws PersistenceException;
    public void registrarIniciativa(Iniciativa in) throws  PersistenceException;
    public void UpdateEstado(int id,String estado) throws  PersistenceException;
    public List<Iniciativa> consultarIniciativas(ArrayList<String> palabrasclave) throws PersistenceException;
    public void registrarPalabrasClave(int id, ArrayList<String> palabras)throws PersistenceException;
}
