/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.Valiente;

/**
 *
 * @author dam125
 */
public interface JuegoInterface {
    
    public void iniciarJuego();
    
    public void creacionOEleccionValiente();
    
    public void mostrarMenuPrincipal();
    
    public void explorarMapa(char direccion, Valiente v);
    
    public void mostrarEstadoJuego();
    
}
