/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import Objetos.Objeto;
import Objetos.Arma;
import Objetos.Consumible;
import Objetos.Espada;
import Objetos.PlantaCurativa;
import Objetos.Inventario;
import Mapa.Mapa;
import Enumerados.TipoClase;
import Personajes.Valiente;
import Personajes.GestorValientesImp;
import interfaces.JuegoInterface;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Juego implements JuegoInterface {

    Mapa map;
    Inventario inventario;
    Scanner teclado = new Scanner(System.in);
    Objeto obj = new Espada(15);

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
                    Marginado m1 = new Marginado("Marginado", TipoClase.MARGINADO, 0, 0, 0, 0);
                    System.out.println("====[###]");
                    System.out.println("Se ha creado un Marginado con las siguientes estadisticas\n:" + m1.toString());
                    this.map = new Mapa();
                    this.inventario = new Inventario();
                    jugar(m1);
                    break;
                }
                case 2: {

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
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                       ║");
        System.out.println("║ j. Mostrar Valiente   k. Usar Objeto   p. salir       ║");
        System.out.println("║                                                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

    }

    @Override
    public void explorarMapa(char direccion) {

        map.moverX(direccion);
        map.actualizarMapaVisible();
        map.mostrarMapa();

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

        inventario.agregarObjeto(obj);

        boolean terminar = false;

        while (!terminar) {
            int opcion = 0;

            char direccion = teclado.next().charAt(0);

            if (direccion == 'w' || direccion == 'a' || direccion == 's' || direccion == 'd') {

                explorarMapa(direccion);

            } else if (direccion == 'j') {

                mostrarValiente(v, inventario);

            } else if (direccion == 'k') {

            } else if (direccion == 'p') {
                System.out.println("Saliendo del juego.........");
                terminar = true;

            }

        }
    }

    private void mostrarValiente(Valiente v, Inventario inventario) {
        System.out.println("        +--------------------------------------------+");
        System.out.println("        |               ESTADISTICAS                 |");
        System.out.println("        |                                            |");
        System.out.println("        |  Nombre: " + v.getNombre() + "                 |");
        System.out.println("        |                                            |");
        System.out.println("        |  Nivel:  " + v.getNivel() + "                  |");
        System.out.println("        |                                            |");
        System.out.println("        |  Fuerza: " + v.getFuerza() + "                 |");
        System.out.println("        |                                            |");
        System.out.println("        |  Defensa: " + v.getDefensa() + "               |");
        System.out.println("        |                                            |");
        System.out.println("        |  Velocidad: " + v.getVelocidad() + "           |");
        System.out.println("        |                                            |");
        System.out.println("        |  Habilidad: " + v.getHabilidad() + "           |");
        System.out.println("        |                                            |");
        System.out.println("        |--------------------------------------------|");
        System.out.println();
        inventario.mostrarInventario();

    }
}
