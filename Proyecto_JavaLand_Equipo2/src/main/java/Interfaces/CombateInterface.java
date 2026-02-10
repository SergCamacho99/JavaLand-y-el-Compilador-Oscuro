/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.Monstruo;
import Personajes.Valiente;



/**
 *
 * @author dam125
 */
public interface CombateInterface {
    //Esta interface va a ser usada por Combate
    
    public <T>  boolean turno(T Defensor, T Atacante);
    
    public  void iniciarCombate(Valiente valiente, Monstruo monstruo);
    
    public <T> void combateTerminado (T valiente, T monstruo);
    
    
    
    
    
}
