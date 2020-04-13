/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Iniciativa;
import java.util.List;

/**
 *
 * @author David Coronado
 */
public interface DaoIniciativa {
    public List<Iniciativa> consultarIniciativas(String palabrasclave) throws PersistenceException;
}