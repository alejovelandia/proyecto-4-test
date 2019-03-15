/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapascoebustos;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Alejo02
 */
public class Principal {

    public Principal() {
       
    }

    public HashMap<Integer, Persona> llenarMapa() {
        HashMap<Integer, Persona> mapPersons = new HashMap<>();
        
        Persona h1 = new Persona(1111, "Angie", "Paez");
        Persona h2 = new Persona(2222, "Jose", "Mora");
        Persona h3 = new Persona(3333, "Johans", "Gonzalez");
        Persona h4 = new Persona(4444, "Victor", "Mora");

        Persona p1 = new Persona(5555, "Orlando", "Mora");
        Persona p2 = new Persona(6666, "Luis", "Gonzalez");
        Persona p3 = new Persona(7777, "Luisa", "Mora");

        Persona a1 = new Persona(8888, "Alejandro", "Paez");
        Persona a2 = new Persona(9999, "Fernando", "Mora");

        p3.nucleoF.put(h1.getCedula(), h1);
        p1.nucleoF.put(h2.getCedula(), h2);
        p2.nucleoF.put(h3.getCedula(), h3);
        p2.nucleoF.put(h4.getCedula(), h4);

        a1.nucleoF.put(p3.getCedula(), p3);
        a2.nucleoF.put(p1.getCedula(), p1);
        a2.nucleoF.put(p2.getCedula(), p2);

        mapPersons.put(a1.getCedula(), a1);
        mapPersons.put(a2.getCedula(), a2);

        return mapPersons;
    }

    public void buscar() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el documento : ");
        Integer cc = sc.nextInt();
        
        HashMap<Integer, Persona> mapa=llenarMapa();
      
        System.err.println(buscarPersona(cc, mapa));

    }

    public String buscarPersona(int cc, HashMap<Integer, Persona> mapaAbuelos) {
       
        boolean existe=false;
        String resultado="";
        
        for (Integer i1 : mapaAbuelos.keySet()) {
            Persona abuelo= mapaAbuelos.get(i1);
            
            if(abuelo.getCedula()==cc){
                resultado=resultado+"persona: "+abuelo.getNombre();
                existe=true;
            }
            
            for (Integer i2 : abuelo.nucleoF.keySet()) {
                Persona padre = abuelo.nucleoF.get(i2);

                if(abuelo.getCedula()==cc){
                    resultado=resultado+"\n   hijo: "+padre.getNombre();
            
                }
                if(padre.getCedula()==cc){
                    resultado=resultado+"persona: "+padre.getNombre();
                    resultado=resultado+"\n   padre: "+abuelo.getNombre();
                    existe=true;
                }
                    
                for (Integer i3 : padre.nucleoF.keySet()) {
                    Persona hijo = padre.nucleoF.get(i3);
                    
                    if(abuelo.getCedula()==cc){
                        resultado=resultado+"\n      nieto: "+hijo.getNombre();
                       
                       
                    }
                    if(padre.getCedula()==cc){
                        resultado=resultado+"\n      hijo: "+hijo.getNombre();
                    }
                    if(hijo.getCedula()==cc){
                        resultado=resultado+"persona: "+hijo.getNombre();
                        resultado=resultado+"\n   padre: "+padre.getNombre();
                        resultado=resultado+"\n      abuelo: "+abuelo.getNombre();
                         existe=true;
                    }
                    
                }
                
            }
        }
        if(existe==false){
            resultado="SIN COINCIDENCIAS";
        }

        return resultado;
       
    }

}
