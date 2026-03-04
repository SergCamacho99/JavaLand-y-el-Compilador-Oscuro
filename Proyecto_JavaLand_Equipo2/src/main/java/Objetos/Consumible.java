/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;

/**
 *
 * @author Kateh Barreto Ramirez
 */
//Clase abstract para objetos consumibles
public abstract class Consumible extends Objeto {
    // Objeto que consume al utilizar 
        protected int efecto;
        
        //Recibe el nombre del objeto y el efecto que tendra al usarse
        public Consumible( String nombre , int efecto){
            super(nombre);
       this.efecto = efecto;
            
            
        }
    }
    
    

