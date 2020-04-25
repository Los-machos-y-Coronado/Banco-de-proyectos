/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.tests;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.Iniciativa;
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
  
    public ServiciosBancoTest() {

        serviciosBanco = ServiciosBancoFactory.getInstance().getServiciosBanco();
        
        
    }
    /**
     * Si existe el usuario
     */
    
    @Test

    public void consultarUsuario(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("anfegoca@gmail.com");

            assertEquals(Rol.Administrador, usu.getRol());

        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
    
     @Test
    public void AutenticacionProponente(){	    
        try {
            Usuario usu = serviciosBanco.consultarUsuario("alex.garci@yahoo.com");
            assertEquals(Rol.Proponente, usu.getRol());
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
            Usuario usu = serviciosBanco.consultarUsuario("juan@gmail.com");
            serviciosBanco.cambiarRol(usu, Rol.Publico);
            usu = serviciosBanco.consultarUsuario("juan@gmail.com");
            assertEquals(Rol.Publico,usu.getRol());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    
    @Test
    public void cambiarRol2(){
        try {
            Usuario usu = serviciosBanco.consultarUsuario("juan@gmail.com");
            serviciosBanco.cambiarRol(usu, Rol.Proponente);
            usu = serviciosBanco.consultarUsuario("juan@gmail.com");
            assertEquals(Rol.Proponente,usu.getRol());
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
    */
    /*
    @Test
    public void NoDebeRegistrarIniciativa(){
        
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini1="Cemento,Echar pala,Micro";
            String fecha = "2019-10-20";
            
            
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini1);
            Date d1 = Date.valueOf(fecha);
            Usuario proponente= new Usuario("alex.garci@yahoo.com","alex22","alex","gordillo",Rol.Proponente,true,"civil");
            
            Iniciativa a= new Iniciativa(2,"Construcción del bloque Z", d1,"En espera",proponente,palabras);
            serviciosBanco.registrarIniciativa(a);
            
            assertTrue(false);
        }catch(ExcepcionServiciosBanco ex){
            System.out.println(ex);
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
    */
    
    /*
     * 
     * Consultar iniciativa
     */
    @Test
    public void consultarIniciativa(){
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini1="Cemento,Echar pala,Micro";
            String fecha = "2019-10-20";
            
            
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini1);
            Date d1 = Date.valueOf(fecha);
            Usuario proponente= new Usuario("alex.garci@yahoo.com","alex22","alex","gordillo",Rol.Proponente,true,"civil");
            
            Iniciativa a= new Iniciativa(2,"Construcción del bloque Z", d1,"En espera",proponente,palabras);
            Iniciativa ini = serviciosBanco.consultarIniciativa(2);


            assertEquals(a.toString(),ini.toString());
            
           
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
    /**
     * 
     * Existen iniciativas dadas palabras clave
     */
    @Test
     public void ConsultarIniciativasPorPalabras() {
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini="Cemento,Desarrollo";
            
            String palabrasini1="Cemento,Echar pala,Micro";
            String palabrasini2="Complejidad,Implementacion,Desarrollo";
              
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini);
            
            ArrayList<String> palabras1 = convertidor.convertirPalabras(palabrasini1);
            ArrayList<String> palabras2 = convertidor.convertirPalabras(palabrasini2);
            
            String fecha = "2000-10-20";
            String fecha2 = "2019-10-20";
            
            Date d1 = Date.valueOf(fecha2);
            Date d2 = Date.valueOf(fecha);
            
            Usuario proponente1= new Usuario("juan@gmail.com","Juanito","Juan","Perez",Rol.Proponente,true,"Sistemas");
            Usuario proponente2= new Usuario("alex.garci@yahoo.com","alex22","alex","gordillo",Rol.Proponente,true,"civil");
            
            Iniciativa a= new Iniciativa(2,"Construcción del bloque Z", d1,"En espera",proponente2,palabras1);
            Iniciativa b= new Iniciativa(1,"Optimizacion de Osiris", d2,"En espera",proponente1,palabras2);
            

            
            ArrayList<Iniciativa> ini2 = new ArrayList<>();
                   
            
            ini2.add(b);
            ini2.add(a);
         
            
            
            
            List<Iniciativa> ini = serviciosBanco.consultarIniciativas(palabras);
           
            assertTrue(true);
            
            assertEquals(ini.toString(),ini2.toString());
        } catch (ExcepcionServiciosBanco ex) {
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
        
    }
        /*
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


    
     @Test
     public void ConsultarIniciativasPorArea(){
         try{
             List<Area> inici = serviciosBanco.iniciativasPorArea();
             assertTrue(true);
         }catch(ExcepcionServiciosBanco ex){
             assertTrue(false);
         }
     }

}
