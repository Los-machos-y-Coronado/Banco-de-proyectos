/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author Andres Gonzalez
 */
public enum Estado { 
    
    EN_ESPERA("En espera de revisión"),
    EN_REVISION("En revisión"),
    PROYECTO("Proyecto"),
    SOLUCIONADO("Solucionado");
    
    private String name;
    
    Estado(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
