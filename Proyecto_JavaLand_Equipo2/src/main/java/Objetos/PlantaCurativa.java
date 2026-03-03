/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;
/**
 *
 * @author DAM118
 */
public class PlantaCurativa extends Consumible{
    // Planta que recupera vida
    
    public PlantaCurativa ( int vida){
        super("Planta curativa", vida);
        
    }
    @Override
    public void usar(Valiente valiente){
        /*if(valiente.getVida()>(valiente.getVidaMaxima()-10){
        }else{
        
        valiente.setVida(valiente.getVida() + efecto);
        System.out.print("Has usado una planta. Vida recuperada");
        //}*/ 
        int vidaActual = valiente.getVida(); // obtiene la vida actual del valie 
        int vidaMaxima = valiente.getVidaMaxima(); //obtener la vida maxima 
        
        int recuperacion = (int) (vidaMaxima * 0.25); //25% de la vida 
        int nuevavida = vidaActual + recuperacion;
        
        if ( nuevavida > vidaMaxima) {
             nuevavida = vidaMaxima;
             
        }
        valiente.setVida(nuevavida);
    }
    
    @Override
    public void equipar(Valiente valiente, Objeto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
