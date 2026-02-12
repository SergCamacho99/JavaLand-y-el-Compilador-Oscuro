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
/**
public class Escudo extends Arma {
    //Escudo aumenta la defena del valiente
    public Escudo (int defensa ){
        super("Escudo", defensa);
    }
    
    @Override
    public void usar(Valiente Valiente){
        Valiente.setDefensa(Valiente.getDefensa() + valor);
        System.out.print("Equipado un escudo. Defensa aumentada");
    }
  
}
**/