/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapascoebustos;

/**
 *
 * @author Alejo02
 */

import java.util.HashMap;

 public class Persona {
    
    private Integer cedula;
    
    private String nombre;
    
    private String apellido;

    public Persona(Integer cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        nucleoF=new HashMap<>();
    }

    public HashMap<Integer, Persona> nucleoF;
    
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}

