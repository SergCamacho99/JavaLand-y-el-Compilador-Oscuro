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
    public int orden;
    
    
    @Override
    public  boolean turno(Valiente valiente, Monstruo monstruo) {
        int numeroAleatorio;
        double calculo;
        if(this.orden==0){
            
            numeroAleatorio = random.nextInt(101);
            calculo=4*monstruo.getHabilidad()-(valiente.getDefensa()+valiente.getDefensaEscudo());
            if(numeroAleatorio<calculo){
                monstruo.atacar(valiente);
            }else{
                System.out.println("El ataque ha fallado");
            }
        }else if(this.orden==1){
            
            numeroAleatorio = random.nextInt(101);
            calculo=4*valiente.getHabilidad()-(monstruo.getDefensa());
            if(numeroAleatorio<calculo){
                valiente.atacar(monstruo);
            }else{
                System.out.println("El ataque ha fallado");
            }
        }
        
    }

    
    

    
    
    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
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
    public void iniciarCombate(Valiente valiente, Monstruo monstruo) {
        
        
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
                this.orden=0;
                System.out.println("Turno del rival");
                turno(valiente, monstruo);
                //poner if si ha tenido exito el ataque y mostrar el daño
            }else{
                this.orden=1;
                System.out.println("Es tu turno");
                turno(valiente, monstruo);
                //poner si ha tenido exito el ataque y mostrar el daño
            }
            
            
            
        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);
    }
    
    
}


