/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.tests;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Area;
import edu.eci.cvds.samples.entities.Estado;
import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Like;
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
import org.primefaces.model.chart.PieChartModel;

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
     
    @Test
    public void consultarIniciativa(){
        try {
            Convertidor convertidor=new Convertidor();
            String palabrasini1="Cemento,Echar pala,Micro";
            String fecha = "2019-10-20";
            
            
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini1);
            Date d1 = Date.valueOf(fecha);
            Usuario proponente= new Usuario("alex.garci@yahoo.com","alex22","alex","gordillo",Rol.Proponente,true,"civil");
            
            Iniciativa a= new Iniciativa(2,"Construcción del bloque Z", d1,"En revisión",proponente,palabras,null);
            Iniciativa ini = serviciosBanco.consultarIniciativa(2);

            Iniciativa C= new Iniciativa(2,"Construcción del bloque Z", d1,"En ESPERA",proponente,palabras,null);
            

            
            assertEquals(C.toString(),ini.toString());
            
           
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
            ArrayList<String> palabras = convertidor.convertirPalabras(palabrasini);
            ArrayList<Iniciativa> ini2 = new ArrayList<>();
            ini2.add(serviciosBanco.consultarIniciativa(1));
            ini2.add(serviciosBanco.consultarIniciativa(2));
            ini2.add(serviciosBanco.consultarIniciativa(3));
            ini2.add(serviciosBanco.consultarIniciativa(11));
            ini2.add(serviciosBanco.consultarIniciativa(12));
            ini2.add(serviciosBanco.consultarIniciativa(13));
            
            List<Iniciativa> ini = serviciosBanco.consultarIniciativas(palabras);
            

            
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
            String palabrasini ="Sostebinilidad,Humanistica";
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
    public void RegistrarLikes() {
        try {
            serviciosBanco.registrarLike(3,"alex.garci@yahoo.com");
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
        }
    }

    @Test
    public void ConsultarLikes() {
        try {
            List<Like> likes =serviciosBanco.consultarLikesIn(1);
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
        }
    }
    @Test
    public void ConsultarLikesCor() {
        try {
            Like like=serviciosBanco.consultarLikesInCor(3,"alex.garci@yahoo.com");
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
        }
    }


    @Test
    public void QuitarLike() {
        try {
            serviciosBanco.deleteLikes(3,"alex.garci@yahoo.com");
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
        }
    }

    @Test
    public void consultarIniciativasCor() {
        try {
            List<Iniciativa> inis = serviciosBanco.consultarIniciativaCor("alex.garci@yahoo.com");
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
        }
    }

    @Test
    public void updateDescripcion() {
        try {
            java.util.Date utilDate = new java.util.Date();
            serviciosBanco.updateDescripcion("nuevo detalle para esta descripcion 2", new java.sql.Date(utilDate.getTime()), 16);
            Iniciativa ini = serviciosBanco.consultarIniciativa(16);
            
            assertTrue(true);
        } catch (ExcepcionServiciosBanco ex) {
            ex.getStackTrace();
            assertTrue(false);
        }
    }






     /*
     * 
     * agregar comentarios a una iniciativa dado el correo del publico
     
    @Test
    public void agregarComentarios(){
        try{
            serviciosBanco.agregarComentariosAIniciativa(2,"monica.galindo@outlook.com" , "comentario");
            assertTrue(true);
        }catch(ExcepcionServiciosBanco ex){
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
    */
     /*
     * 
     * No se puede agregar comentarios a una iniciativa dado el correo del publico
     
    
    @Test
    public void agregarComentarios2(){
        try{
            serviciosBanco.agregarComentariosAIniciativa(1,"leandro.gado@gmail.com" , "Perfecto");
            assertTrue(false);
        }catch(ExcepcionServiciosBanco ex){
            Logger.getLogger(ServiciosBancoTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
    */
        @Test
    public void ConsultarIniciativasPorArea(){
         try{
             List<Area> inici = (List<Area>) serviciosBanco.iniciativasPorArea();
             assertTrue(true);
         }catch(ExcepcionServiciosBanco ex){
             assertTrue(false);
         }
    }
    
    
    @Test 
    public void AgruparIniciativasRelacionadas(){
        
        try{
   
            Iniciativa a = serviciosBanco.consultarIniciativa(2);
            List<Iniciativa> relacionados2= new ArrayList<>();           
            relacionados2.add(serviciosBanco.consultarIniciativa(12));
            relacionados2.add(serviciosBanco.consultarIniciativa(13));          
            List<Iniciativa> relacionados = serviciosBanco.agruparIniciativas(a);
            assertEquals(relacionados.toString(),relacionados2.toString());
            
        }catch(ExcepcionServiciosBanco ex){
            assertTrue(false);
        }
    
    }
    @Test
    public void consultarComentarios(){
        try{
            Iniciativa a = serviciosBanco.consultarIniciativa(2);
            assertTrue(true);
        }catch(ExcepcionServiciosBanco ex){
            assertTrue(false);
        }
        
    }
    @Test
    public void consultarIniciativasPorEstado(){
        try{
            String estado="Proyecto";
            List<Iniciativa> iniciativas = serviciosBanco.consultarIniciativasPorEstado(estado);
            assertEquals(7,iniciativas.size());
        }catch(ExcepcionServiciosBanco ex){
            assertTrue(false);
            
        }
    
    }
    @Test
    public void estadosIniciativas(){
        try{
            List<List<Iniciativa>> iniEstados = new ArrayList<List<Iniciativa>>();
            Estado[] estados = Estado.values();
            for(Estado e: estados){
                List<Iniciativa> iniciativas = serviciosBanco.consultarIniciativasPorEstado(e.getName());   
                iniEstados.add(iniciativas);
            }
            assertTrue(true);
        }catch(Exception ex){
            assertTrue(false);
        }
    }
     

}
