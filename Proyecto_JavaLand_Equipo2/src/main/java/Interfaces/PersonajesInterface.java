/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.Personaje;

/**
 *
 * @author dam125
 */
public interface PersonajesInterface {
    
    //Esta interfaz va a ser usada por Valientes y Monstruos
    public <T extends Personaje> void atacar(T Personaje); 
    
}
