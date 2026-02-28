/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.CooldownException;
import Personajes.Monstruo;
import Personajes.Valiente;



/**
 *
 * @author dam125
 */
public interface CombateInterface {
    //Esta interface va a ser usada por Combate
    
    public  void turno(Valiente valiente, Monstruo monstruo)throws CooldownException;
    
    public void iniciarCombate(Valiente valiente, Monstruo monstruo);
    
    public  void combateTerminado (Valiente valiente, Monstruo monstruo);
    
    
    
    
    
}
