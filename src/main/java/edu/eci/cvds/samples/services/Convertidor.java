/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

import java.util.ArrayList;


/**
 *
 * @author David Coronado
 */
public class Convertidor {

    public Convertidor() {
    }
    
    public ArrayList<String> convertirPalabras(String palabras){
        
        
        String[] pala = palabras.split(",");
        
        ArrayList<String> pala2 = new ArrayList<>();
        
        for (int i=0;i<pala.length;i++){
            pala2.add(pala[i]);
        }
        
        return pala2;
    }
    
}
