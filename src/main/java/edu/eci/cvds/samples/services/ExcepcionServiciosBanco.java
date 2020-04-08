/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.persistence.PersistenceException;
/**
 *
 * @author Andres Gonzalez
 */

public class ExcepcionServiciosBanco extends Exception {

	public ExcepcionServiciosBanco(String string, PersistenceException ex) {
		super(string, ex);
	}

	public ExcepcionServiciosBanco(String string) {
		super(string);
	}

}
