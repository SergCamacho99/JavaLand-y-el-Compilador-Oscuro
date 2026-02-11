/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;
import Mapa.Mapa;
import Enumerados.TipoClase;
import Personajes.Personaje;
import Personajes.Valiente;
import Personajes.GestorMonstruosImp;
import Personajes.GestorValientesImp;
import interfaces.JuegoInterface;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Juego implements JuegoInterface {
    Mapa map;
    Scanner teclado = new Scanner(System.in); 
    @Override
    public void IniciarJuego() {
        
        creacionOEleccionValiente();
        
    }

    @Override
    public void creacionOEleccionValiente() {

        int opcion = 0;

        do {

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
                Marginado m1 = new Marginado("Marginado",TipoClase.MARGINADO,0,0,0,0);
                System.out.println("====[###]");
                System.out.println("Se ha creado un Marginado con las siguientes estadisticas\n:"+m1.toString());
                this.map = new Mapa();
                jugar(m1);
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
            
        
        
        
        } while (opcion != 6 && opcion < 1 || opcion > 6);
    }

    @Override
    public void mostrarMenuPrincipal() {
        
        System.out.println("╔═════════════════════════════════════════════════════════╗");
        System.out.println("║                                                  ║");
        System.out.println("║ 1. Mostrar valiente 2. Equipar Objeto 3. Salir   ║");
        System.out.println("║                                                  ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝");
    }

    @Override
    public void explorarMapa() {
        char direccion = teclado.next().charAt(0);
        map.moverX(direccion);
        
    }

    @Override
    public void mostrarEstadoJuego() {

    }

    private void mostrarMenuInicio() {

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

    public void jugar(Valiente v) {
        map.mostrarMapa();
        mostrarMenuPrincipal();
        
    } 

    
}
