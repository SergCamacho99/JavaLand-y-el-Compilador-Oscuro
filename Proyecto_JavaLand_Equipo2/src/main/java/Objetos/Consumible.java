/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;

/**
 *
 * @author dam118
 */
public abstract class Consumible extends Objeto {
    // Objeto que consume al utilizar 
        protected int efecto;
        
        public Consumible( String nombre , int efecto){
            super(nombre);
       this.efecto = efecto;
            
            
        }
    }
    
    

