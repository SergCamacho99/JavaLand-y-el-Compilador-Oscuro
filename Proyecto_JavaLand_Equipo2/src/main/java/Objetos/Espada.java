/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;

/**
 *@author Kateh Barreto Ramirez
 * @author dam118
 * //Clase que representa una espada
 * //Hereda de la clase arma y permite equipar un arma al valiente para aumentar su fuerza en combate
 */
public class Espada extends Arma {
    public Espada(String nombre, int fuerza){
     super(nombre, fuerza);
}
// metodo que se ejecuta donde el jugador usa la espada
@Override
    public void usar(Valiente valiente){
        
}
    //metodo que equipa la espada al valiente
    @Override
    public void equipar(Valiente valiente, Objeto objeto) {
       //asigna el arma al personaje
        valiente.setArma((Arma) objeto);
        
    }
    
    
    public String getNombre(){
        return nombre;
    }
}
    
    
    
    
    

