/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import javaland.interfaces.JuegoInterface;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Juego implements JuegoInterface {
    
    Scanner teclado = new Scanner(System.in);
    
    @Override
    public void IniciarJuego() {
        creacionOEleccionValiente();
    }

    @Override
    public void creacionOEleccionValiente() {
        
        int opcion = 0;
        
        do{
            
            mostrarMenuInicio();
            
            System.out.println("Introduce tu opcion:");
           
            try {
                
            opcion = Integer.parseInt(teclado.nextLine());
            
            } catch (NumberFormatException e) {
                
                opcion = -1;
            
            }
            if (opcion < 1 || opcion > 6) { //validacion para que no se introduzca un numero fuera de rango

                System.out.println("Por favor elige un numero del 1 al 5, aunque intuyo que quizas prefieras el 6.");

            }

            switch (opcion) {

                case 1: {
                    
                    crearMarginado();
                    break;
                }
                case 2: {

                    //Llamada al metodo de gestionar valientes (Guerrero)
                    break;
                }

                case 3: {

                    //Llamada al metodo de gestionar valientes (Paladin)
                    break;
                }

                case 4: {

                    //Llamada al metodo de gestionar valientes (Mago)
                    break;
                }

                case 5: {

                    //Llamada al metodo de gestionar valientes (Picaro)
                    break;
                }

                case 6: {

                    System.out.println("Buena decision, ni si quiera creo que tengas la habilidad para salir de esta con vida.");
                    break;

                }
                
                default:
            }
        } while (opcion < 1 || opcion > 6);
    }

    @Override
    public void mostrarMenuPrincipal() {
        
            
        
    }

    @Override
    public void explorarMapa() {

    }

    @Override
    public void mostrarEstadoJuego() {

    }
    
    private void mostrarMenuInicio(){
        
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║          Bienvenido a JavaLand:          ║");
            System.out.println("║    La tierra de los codigos olvidados    ║");
            System.out.println("║                                          ║");
            System.out.println("║ Elige como quieres empezar tu aventura:  ║");
            System.out.println("║                                          ║");
            System.out.println("║ 1. Marginado (Clase personalizada)       ║");
            System.out.println("║                                          ║");
            System.out.println("║ 2. Guerrero                              ║");
            System.out.println("║                                          ║");
            System.out.println("║ 3. Paladin                               ║");
            System.out.println("║                                          ║");
            System.out.println("║ 4. Mago/a                                ║");
            System.out.println("║                                          ║");
            System.out.println("║ 5. Picaro/a                              ║");
            System.out.println("║                                          ║");
            System.out.println("║ 6. Huir                                  ║");
            System.out.println("║                                          ║");
            System.out.println("╚════════════════════════════════════════════════╝");
        
        
    }

    private void crearMarginado(){
        
                    int puntosRestantes = 8;
                    int eleccion = 0;

                    System.out.println("Asi que te gustan los retos eh?");
                    System.out.println("Por muy valiente que seas, necesitaras hacer uso de esto, repartelo con sabiduria");
                    System.out.println("Que la habilidad guie tu camino y la suerte este de tu lado, valiente.");
                    
                        int fuerza = 0, defensa = 0, velocidad = 0, habilidadEspecial = 0;                       
                        
                    do {

                        boolean valido = false;

                        System.out.println("Elige a que asignar el punto: (puntos restantes: " + puntosRestantes + ")");
                        System.out.println("1. fuerza");
                        System.out.println("2. defensa");
                        System.out.println("3. Velocidad");
                        System.out.println("4. Habilidad");
                        System.out.println("Y bien, que sera esta vez?");
                       
                       do { 
                        try {
                        eleccion = Integer.parseInt(teclado.nextLine());
                        if (eleccion >= 1 && eleccion <= 4){
                        valido = true;
                        } else {
                            
                             System.out.println("Por favor elige con sabiduria (un numero del 1 al 4)");
                            
                        }
                       } catch (NumberFormatException e) {
                           
                           System.out.println("Por favor elige con sabiduria (un numero del 1 al 4)");
                           
                       }
                    } while (!valido);
                        switch (eleccion) {

                            case 1: {

                                System.out.println("El poder del guerrero.");
                                System.out.println("Valentia sin igual.");
                                System.out.println("Una habilidad hecha para herir al projimo.");
                                fuerza++;
                                break;
                            }

                            case 2: {

                                System.out.println("El poder del guardian.");
                                System.out.println("Bondad para ayudar a los amigos.");
                                System.out.println("Un escudo cobarde que todo lo rechaza.");
                                defensa++;
                                break;
                            }

                            case 3: {

                                System.out.println("El poder del explorador.");
                                System.out.println("Rapidez que desafía al viento.");
                                System.out.println("Un paso veloz que decide el combate.");
                                velocidad++;
                                break;
                            }

                            case 4: {

                                System.out.println("El poder del elegido.");
                                System.out.println("Un don que rompe las reglas.");
                                System.out.println("Una técnica única nacida del destino.");
                                habilidadEspecial++;
                                break;
                            }
                        }

                        if (eleccion < 1 || eleccion > 4) {

                            System.out.println("Estas seguro que este es el camino que quieres tomar? no eres capaz ni de expresar bien lo que quieres hacer.");

                        } else {

                            puntosRestantes--;

                        }

                    } while (puntosRestantes > 0 );
    }
    
}
