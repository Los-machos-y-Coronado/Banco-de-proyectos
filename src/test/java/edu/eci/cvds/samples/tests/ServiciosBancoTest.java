/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.tests;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Andres Gonzalez
 */
public class ServiciosBancoTest {
    
    @Inject
    private ServiciosBanco serviciosBanco;
    public ServiciosBancoTest() {
        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
       
    }
    
    @Test
    public void consultarCliente(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("anfegoca", "1234");
            assertEquals("anfegoca", usu.getNombre());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
}
