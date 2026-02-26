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
public abstract class Arma extends Objeto{ 
// Valor del arma (fuerza o defensa)
protected int valor;

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
