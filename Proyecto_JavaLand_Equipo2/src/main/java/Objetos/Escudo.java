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
<<<<<<< HEAD
=======
/**
 * 
 * @author DAM118
 **/
>>>>>>> 03d1fcaf0321d9d93c6a3d75ee9f8afb9311b420

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

    @Override
    public void equipar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}
