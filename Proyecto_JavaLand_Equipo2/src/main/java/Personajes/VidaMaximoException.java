/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 * Aqui creo una excepcion personalizada para usar en el menu de combate, en este caso es para cuando tengas la vida al maximo y si haya planta en el inventario
 * @author Miguel Martinez Revuelta
 */
public class VidaMaximoException extends Exception{
    public VidaMaximoException (String mensaje){
        super(mensaje);
    }

}
