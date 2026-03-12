/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Personajes;

import Enumerados.TipoClase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DAM119
 */
public class MonstruoTest {
    
    public MonstruoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of subirNivel method, of class Monstruo.
     */
    @Test
    public void testSubirNivel() {
        System.out.println("subirNivel");
        Monstruo instance = null;
        instance.subirNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDaño method, of class Monstruo.
     */
    @Test
    public void testRecibirDaño() {
        Monstruo monstruos = new Monstruo("Mimeto",1);
        System.out.println("recibirDa\u00f1o");
        int cantidad = 20;
        monstruos.recibirDaño(cantidad);
        assertEquals(49, monstruos.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Monstruo.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Monstruo instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Monstruo.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Monstruo instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVida method, of class Monstruo.
     */
    @Test
    public void testGetVida() {
        System.out.println("getVida");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getVida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVida method, of class Monstruo.
     */
    @Test
    public void testSetVida() {
        System.out.println("setVida");
        int vida = 0;
        Monstruo instance = null;
        instance.setVida(vida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuerza method, of class Monstruo.
     */
    @Test
    public void testGetFuerza() {
        System.out.println("getFuerza");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getFuerza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFuerza method, of class Monstruo.
     */
    @Test
    public void testSetFuerza() {
        System.out.println("setFuerza");
        int fuerza = 0;
        Monstruo instance = null;
        instance.setFuerza(fuerza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensa method, of class Monstruo.
     */
    @Test
    public void testGetDefensa() {
        System.out.println("getDefensa");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefensa method, of class Monstruo.
     */
    @Test
    public void testSetDefensa() {
        System.out.println("setDefensa");
        int defensa = 0;
        Monstruo instance = null;
        instance.setDefensa(defensa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHabilidad method, of class Monstruo.
     */
    @Test
    public void testGetHabilidad() {
        System.out.println("getHabilidad");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilidad method, of class Monstruo.
     */
    @Test
    public void testSetHabilidad() {
        System.out.println("setHabilidad");
        int habilidad = 0;
        Monstruo instance = null;
        instance.setHabilidad(habilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocidad method, of class Monstruo.
     */
    @Test
    public void testGetVelocidad() {
        System.out.println("getVelocidad");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getVelocidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocidad method, of class Monstruo.
     */
    @Test
    public void testSetVelocidad() {
        System.out.println("setVelocidad");
        int velocidad = 0;
        Monstruo instance = null;
        instance.setVelocidad(velocidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNivel method, of class Monstruo.
     */
    @Test
    public void testGetNivel() {
        System.out.println("getNivel");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNivel method, of class Monstruo.
     */
    @Test
    public void testSetNivel() {
        System.out.println("setNivel");
        int nivel = 0;
        Monstruo instance = null;
        instance.setNivel(nivel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of atacar method, of class Monstruo.
     */
    @Test
    public void testAtacar() {
        Monstruo monstruos = new Monstruo("Mimeto",1);
        Valiente valientes= new Valiente("Hamud Habibi",TipoClase.GUERRERO,10,1,1,1);
        System.out.println("atacar");
        monstruos.atacar(valientes);
        assertEquals(80, valientes.getVida());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
