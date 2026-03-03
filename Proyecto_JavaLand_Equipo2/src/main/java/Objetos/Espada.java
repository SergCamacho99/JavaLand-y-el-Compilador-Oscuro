/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;

/**
 *
 * @author dam118
 * Espada aumenta la fuerza del  valiente
 */
public class Espada extends Arma {
    public Espada(int fuerza){
     super("Espada", fuerza);
}

@Override
    public void usar(Valiente valiente){
    
}

    @Override
    public void equipar(Valiente valiente, Objeto objeto) {
       
        valiente.setArma((Arma) objeto);
        
    }
}
    
    
    
    
    

