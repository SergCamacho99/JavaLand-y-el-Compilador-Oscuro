/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Juego;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author david
 */
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        Juego juego = new Juego();
        
        juego.creacionOEleccionValiente();
    }
    
}
