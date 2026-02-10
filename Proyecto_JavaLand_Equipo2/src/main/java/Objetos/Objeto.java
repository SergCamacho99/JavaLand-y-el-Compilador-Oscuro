/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;
/**
 *
 * @author kateh barreto
 *
 * clase padre, representando cualquier objeto 
 */
public abstract class Objeto {
    protected String nombre;
    
    // Constructor del objeto
    public Objeto (String nombre){
        this.nombre = nombre;
    }
    //Devuelve el nombre del Objeto 
   public String getnombre(){
       return nombre;
   }
  // Cada objeto se implementa de forma diferente:
   //espada aumenta la fuerza , el escudo defensa y la planta recupera vida 
   
   public abstract void usar (Valiente Valiente);
    
}
