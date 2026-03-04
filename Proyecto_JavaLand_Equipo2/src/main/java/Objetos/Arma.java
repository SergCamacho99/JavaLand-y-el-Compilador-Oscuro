/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Personajes.Valiente;
/**
 *
 * @author dam118
 * @author Kateh barreto Ramirez
 * //Clase abstrac que representa las armas del juego
 * //Hereda de objeto y contiene el valor del arma
 * // Espada y escudo heredan de esta clase
 */
public abstract class Arma extends Objeto{ 
// Valor del arma (fuerza o defensa)
protected int valor = 1;

    public Arma(String nombre, int valor){
            super(nombre);
           this.valor = valor;
}
// Cada arma aplicará su efecto distinto
    public abstract void usar(Valiente valiente);

    public int getValor() {
        
        return valor;
    }
    
}
