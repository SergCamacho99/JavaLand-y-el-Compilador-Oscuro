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
        super("Planta Curativa", vida);
        
    }
    @Override
    public void usar(Valiente valiente){
        valiente.setVida(valiente.getVida() + efecto);
        System.out.print("Has usado una planta. Vida recuperada");
    }

    @Override
    public void equipar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
