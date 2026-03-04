/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 * Aqui creo una excepcion personalizada para el menu de combate, ene ste caso es para cuando no hay planta curativa
 * @author Miguel Martinez Revuelta
 */
public class NoHayPlantaException extends Exception {
    public NoHayPlantaException (String mensaje){
        super(mensaje);
    }
}
