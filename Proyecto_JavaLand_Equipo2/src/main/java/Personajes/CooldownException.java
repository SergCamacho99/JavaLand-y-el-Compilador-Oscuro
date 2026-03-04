/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 * Aqui he creado una excepcion personalizada para usar en el menu del combate, en este caso es para el cooldown de las habilidades
 * @author Miguel Martinez Revuelta
 */
public class CooldownException extends Exception {
    public CooldownException (String mensaje){
        super(mensaje);
    }
}
