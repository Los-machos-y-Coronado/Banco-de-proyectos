/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.util.List;

/**
 *
 * @author Andres Gonzalez
 */
public class Area {
    private String nombre;
    private List<Iniciativa> iniciativas;
    
    
    public Area(){
    
    }
   public Area(String nombre, List<Iniciativa> iniciativas){
       this.nombre=nombre;
       this.iniciativas=iniciativas;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Iniciativa> getIniciativas() {
        return iniciativas;
    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }
   
    @Override
    public String toString() {
        return "Area{" + "nombre= "+nombre +", Iniciativas= "+iniciativas+ "}";
    }
}
