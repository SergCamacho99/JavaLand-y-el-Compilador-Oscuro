/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;


import interfaces.CombateInterface;
import java.util.Random;

/**
 *
 * @author dam125
 */
public class Combate implements CombateInterface {
    Random random=new Random();
    public boolean tieneExito;
    @Override
    public <T> boolean turno(T Defensor, T Atacante) {
        
    }

    
    

    
    @Override
    public void combateTerminado(Object valiente, Object monstruo) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              Fin del combate             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    /**
     *
     * @param valiente
     * @param monstruo
     */
    @Override
    public void iniciarCombate(Object valiente, Object monstruo) {
        
        
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║            Comienza el combate           ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        do {
            double iniciativa_Monstruo;
            double iniciativa_Valiente;
            do{
                double numeroAleatorio=0.75+random.nextDouble()*(1-0.75);
                iniciativa_Valiente=valiente.getVelocidad()*numeroAleatorio;
                iniciativa_Monstruo=monstruo.getVelocidad()*numeroAleatorio;
            }while(iniciativa_Valiente!=iniciativa_Monstruo);
            if(iniciativa_Monstruo>iniciativa_Valiente){
                System.out.println("Turno del rival");
                Combate.turno(monstruo);
                
            }else{
                System.out.println("Es tu turno");
                Combate.turno(valiente);
                
            }
            
            
            
        } while (defensor.getVida() > 0 && monstruo.getVida() > 0);
    }
    
    
}


