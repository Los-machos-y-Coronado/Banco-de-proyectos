/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author Jairo Gomez
 */
public class Proponente extends Usuario{
    private String area;
    public Proponente(String correo,String nombreUsuario, String nombre,String apellido,boolean estado,String area) {
        super(correo, nombreUsuario, nombre, apellido, estado);
        this.area=area;
    }

    public String getArea(){
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "correo"+correo +", nombre Usuario "+nombreUsuario + ", nombre=" + nombre + ", apellido "+apellido +", estado " + estado + ", area: "+area+ '}';
    }
    
}
