/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mapascoebustos.Persona;
import com.mycompany.mapascoebustos.Principal;
import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alejandro
 */
public class PrincipalTest {
    
    public PrincipalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("TEST INICIADO");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("TEST FINALIZADO");
    }
    
    @Test
    public void buscarPersonaTest(){
        
        Principal p=new Principal();
        HashMap<Integer, Persona> mapa=p.llenarMapa();
        
        String resultado=p.buscarPersona(999,mapa);
        
        assertEquals(resultado, "persona: Fernando"
                + "\n   hijo: Orlando"
                + "\n      nieto: Jose"
                + "\n   hijo: Luis"
                + "\n      nieto: Johans"
                + "\n      nieto: Victor");
    }
    
    @Test
    public void buscarVacioTest(){
        
        Principal p=new Principal();
        HashMap<Integer, Persona> mapa=p.llenarMapa();
        
        String resultado=p.buscarPersona(1234,mapa);
        
        assertEquals(resultado, "SIN COINCIDENCIAS");
    }
}
