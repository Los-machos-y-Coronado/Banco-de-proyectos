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
    /**
     * Si existe el usuario
     */
    @Test
    public void consultarUsuario(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("anfegoca@gmail.com", "1234");
            assertEquals("anfegoca@gmail.com", usu.getCorreo());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
    /**
     * No existe el usuario
     */
    @Test
    public void consultarUsuario2(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("juanito@gmail.com", "1234");
            assertEquals(null, usu);
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
    /**
     * Clave incorrecta
     */
    @Test
    public void consultarUsuario3(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("anfegoca@gmail.com", "123455");
            assertEquals(null, usu);
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
}
