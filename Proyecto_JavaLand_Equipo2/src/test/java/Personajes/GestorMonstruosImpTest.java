/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Personajes;

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
public class GestorMonstruosImpTest {
    
    public GestorMonstruosImpTest() {
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
     * Test of crearValientesIniciales method, of class GestorMonstruosImp.
     */
    @Test
    public void testCrearValientesIniciales() {
        System.out.println("crearValientesIniciales");
        GestorMonstruosImp instance = new GestorMonstruosImp();
        instance.crearValientesIniciales();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generarMonstruos method, of class GestorMonstruosImp.
     */
    @Test
    public void testGenerarMonstruos() {
        System.out.println("generarMonstruos");
        int nivel = 0;
        GestorMonstruosImp instance = new GestorMonstruosImp();
        Monstruo expResult = null;
        Monstruo result = instance.generarMonstruos(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMonstruo method, of class GestorMonstruosImp.
     */
    @Test
    public void testEliminarMonstruo() {
        Monstruo [] monstruos;
        System.out.println("eliminarMonstruo");
        Monstruo m = null;
        GestorMonstruosImp instance = new GestorMonstruosImp();
        instance.eliminarMonstruo(m);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContadorMonstruos method, of class GestorMonstruosImp.
     */
    @Test
    public void testGetContadorMonstruos() {
        System.out.println("getContadorMonstruos");
        GestorMonstruosImp instance = new GestorMonstruosImp();
        int expResult = 0;
        int result = instance.getContadorMonstruos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
