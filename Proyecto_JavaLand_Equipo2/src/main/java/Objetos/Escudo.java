/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;
/**
 * @author Kateh Barreto Ramirez
 * // Clase que representa un escudo 
 * //Hereda de arma, Cuando se usa o se equipa aumenta la defensa del Valiente
 **/

public class Escudo extends Arma {
    
    //Recibe el nombre objeto y el valor de defensa
    public Escudo (String nombre, int defensa ){
        super(nombre, defensa);
    }
    //metodo qye se ejecuta cuando cuando el jugador usa el escudo
    /**
     * @author Kateh barreto
     * @param Valiente 
     */
    @Override
    public void usar(Valiente Valiente){
        Valiente.setDefensa(Valiente.getDefensa() + valor); // aumenta la defensa del valiente sumando el valor del escudo
        System.out.print("Equipado un escudo. Defensa aumentada");
    }

    @Override
    public void equipar(Valiente valiente, Objeto objeto) {
        valiente.setEscudo((Escudo) objeto); //asigna el escudo al valiente
    }
    //devuelve el nombre del escudo
    public String getNombre(){
        return nombre;
    }
  
}
