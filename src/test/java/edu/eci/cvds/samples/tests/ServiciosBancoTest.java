/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.tests;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Administrador;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Proponente;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.Convertidor;
import edu.eci.cvds.samples.services.ExcepcionServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBanco;
import edu.eci.cvds.samples.services.ServiciosBancoFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
    private final  ServiciosBanco serviciosBanco;
    Proponente proponente;
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
            assertEquals(Rol.Administrador.toString(), usu.getClass().getSimpleName());

        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
     @Test
    public void AutenticacionProponente(){	    
        try {
            Usuario usu = serviciosBanco.consultarUsuario("alex.garci@yahoo.com", "1911");
            assertEquals(Rol.Proponente.toString(), usu.getClass().getSimpleName());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    @Test
    public void consultarUsuarios(){
        try {
            List<Usuario> usu = serviciosBanco.consultarUsuarios();
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    @Test
    public void cambiarRol(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("juan@gmail.com", "12345");
            serviciosBanco.cambiarRol(usu, Rol.Publico);
            usu = serviciosBanco.consultarUsuario("juan@gmail.com", "12345");
            assertEquals(Rol.Publico.toString(),usu.getClass().getSimpleName());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    @Test
    public void cambiarRol2(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("juan@gmail.com", "12345");
            serviciosBanco.cambiarRol(usu, Rol.Proponente);
            usu = serviciosBanco.consultarUsuario("juan@gmail.com", "12345");
            assertEquals(Rol.Proponente.toString(),usu.getClass().getSimpleName());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }	    
    /*
    @Test
    public void DebeRegistrarIniciativa(){
        proponente = new Proponente("alex.garci@yahoo.com", "alex22", "alex", "gordillo", true, "civl");
        Iniciativa nuevoRegistro = new Iniciativa(100, "test insercion", new java.sql.Date(new Date().getTime()), proponente.getCorreo(), "en espera de revision");
        try {
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    /*
    @Test
    public void NoDebeRegistrarIniciativa(){
        proponente = new Proponente("david@mail.com", "david21", "david", "cardona", true, "proyectos");
        Iniciativa nuevoRegistro = new Iniciativa(150, "test insercion", new java.sql.Date(new Date().getTime()), proponente.getCorreo(), "en espera de revision");
        try {
            serviciosBanco.registrarIniciativa(nuevoRegistro);
            assertTrue(true);
        }catch(Exception e){
            
        }
    /**
     * 
     * Existen iniciativas dadas palabras clave
     */
    @Test
     public void ConsultarIniciativas() {
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini="Cemento,Desarrollo";
            
              
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini);

           
            String fecha = "2000-10-20";
            String fecha2 = "2019-10-20";
            
            Date d1 = Date.valueOf(fecha2);
            Date d2 = Date.valueOf(fecha);
            
            Proponente proponente1= new Proponente("juan@gmail.com","Juanito","Juan","Perez",true,"Proponente");
            Proponente proponente2= new Proponente("alex.garci@yahoo.com","Alex22","Alex","Gordillo",true,"Proponente");
            
            Iniciativa a= new Iniciativa(2,"Construcción del bloque Z", d1,null,"En espera");
            Iniciativa b= new Iniciativa(1,"Optimizacion de Osiris", d2,null,"En espera");
            

            
            ArrayList<Iniciativa> ini2 = new ArrayList<>();
            
            ini2.add(b);
            ini2.add(a);
            
            
            List<Iniciativa> ini = serviciosBanco.consultarIniciativas(palabras);
            
            assertEquals(ini.toString(),ini2.toString());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
        /**
     * 
     * No existen iniciativas dadas palabras clave
     */
    @Test
     public void ConsultarIniciativas2() {
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini="Sostebinilidad,Humanistica";
            
            ArrayList<String> palabras = new ArrayList<>();
            palabras.add("Sostebinilidad");
            palabras.add("Humanistica");

            List<Iniciativa> ini = serviciosBanco.consultarIniciativas(palabras);
 
            assertEquals(0,ini.size());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }

    

}
