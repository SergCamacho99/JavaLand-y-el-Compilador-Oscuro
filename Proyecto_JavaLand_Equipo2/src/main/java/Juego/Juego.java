/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import Objetos.Objeto;
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
 * @author David Alonso
 */
public class Juego implements JuegoInterface {

    GestorValientesImp gvi = new GestorValientesImp();
    Mapa map;
    Inventario inventario;
    Scanner teclado = new Scanner(System.in);

    @Override
    public void iniciarJuego() {

        creacionOEleccionValiente();

    }

    /**
     * 
     * Autor: David Alonso
     * Metodo que se muestra al inicio del juego para seleccionar el valiente que quieres utilizar o crear el tuyo propio.
     * Desde aqui arranca todo.
     */
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

                case 1 -> {
                    Marginado m1 = new Marginado("Marginado", TipoClase.MARGINADO, 0, 0, 0, 0);
                    System.out.println("====[###]");
                    System.out.println("Se ha creado un Marginado con las siguientes estadisticas\n:" + m1.toString());
                    this.inventario = new Inventario();
                    this.map = new Mapa(m1, inventario);
                    jugar(m1, inventario);
                }
                case 2 -> {
                    gvi.crearValientesIniciales();
                    Valiente inicial = gvi.getListaValientes()[0];
                    this.inventario = new Inventario();
                    this.map = new Mapa(inicial, this.inventario);
                    jugar(inicial, this.inventario);
                }

                case 3 -> {
                    gvi.crearValientesIniciales();
                    Valiente inicial = gvi.getListaValientes()[1];
                    this.inventario = new Inventario();
                    Objeto obj = new PlantaCurativa(10);
                    inventario.agregarObjeto(obj);
                    this.map = new Mapa(inicial, this.inventario);
                    jugar(inicial, this.inventario);
                }

                case 4 -> {
                    gvi.crearValientesIniciales();
                    Valiente inicial = gvi.getListaValientes()[2];
                    this.inventario = new Inventario();
                    Objeto obj = new PlantaCurativa(10);
                    inventario.agregarObjeto(obj);
                    this.map = new Mapa(inicial, this.inventario);
                    jugar(inicial, this.inventario);

                }

                case 5 -> {
                    gvi.crearValientesIniciales();
                    Valiente inicial = gvi.getListaValientes()[3];
                    this.inventario = new Inventario();
                    Objeto obj = new PlantaCurativa(10);
                    inventario.agregarObjeto(obj);
                    this.map = new Mapa(inicial, this.inventario);
                    jugar(inicial, this.inventario);

                }

                case 6 -> {

                    System.out.println("Buena decision, ni si quiera creo que tengas la habilidad para salir de esta con vida.");

                }

                default -> {

                }
            }

        } while (opcion != 6 && opcion < 1 || opcion > 6);
    }

    @Override
    public void mostrarMenuPrincipal() {

    }

    
    /**
     * 
     * Autor: David Alonso
     * Metodo para controlar la direccion a la que se mueve el jugador.
     * @param direccion
     * @param v 
     */
    @Override
    public void explorarMapa(char direccion, Valiente v) {

        map.moverPersonaje(direccion);
        map.actualizarMapaVisible();
        if (v.getVida() > 0) {
            map.mostrarMapa();
        }
    }

    @Override
    public void mostrarEstadoJuego() {

    }
    
    /**
     * 
     * Autor: David Alonso
     * Metodo que muestra al usuario el menu de opciones inicial cuando arranca el juego.
     */
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
    
    
    /**
     * 
     * Autor: David Alonso
     * Metodo que da el ritmo al juego, desde aqui se controla todo el juego asi como se llama a los metodos necesarios en cada momento.
     * @param v
     * @param inventario 
     */
    public void jugar(Valiente v, Inventario inventario) {

        boolean terminar = false;
        map.mostrarMapa();
        while (!terminar) {

            char direccion = teclado.next().charAt(0);

            switch (direccion) {
                case 'w', 'a', 's', 'd' -> {
                    explorarMapa(direccion, v);
                }
                case 'j' -> {
                    boolean salir = false;
                    while (!salir){
                    mostrarValiente(v, inventario);
                        System.out.println("Para salir del inventario pulse 0.");
                        int salida = teclado.nextInt();
                        
                        if (salida == 0){
                            
                            salir = true;
                            System.out.println("Saliendo del menu....");
                        } else if (salida != 0){
                            System.out.println("Por favor pulse 0 para salir.") ;
                        }
                    }
                    map.mostrarMapa();
                }
                case 'k' -> {
                    boolean salir = false;
                    inventario.mostrarInventario();
                    while (!salir) {

                        if (salir) {
                            map.mostrarMapa();
                        } else if (!salir && inventario.getCantidad() != 0) {
                            System.out.println("Que objeto quieres usar? 9. para salir");
                            int eleccion = teclado.nextInt();
                            inventario.seleccionarObjeto(eleccion, v);
                            if (v.getVida() > 0) {
                                map.mostrarMapa();
                            }
                            salir = true;
                        } else if (inventario.getCantidad() == 0) {
                            System.out.println("El inventario esta vacio, no hay nada que te pueda ayudar.");
                            salir = true;
                            map.mostrarMapa();
                        }
                    }
                }
                case 'p' -> {
                    System.out.println("Saliendo del juego.........");
                    terminar = true;
                }
                default -> {

                }
                
               
                
            }
            
            if (v.getVida() <= 0){
            
            System.out.println("Vida agotada. Has perdido");
            terminar = true;
        }
            if (terminar){
                creacionOEleccionValiente();
            }

            if (v.getVida() <= 0) {
                terminar = true;

            }

        }

    }

    /**
     * 
     * Autor: David Alonso
     * Metodo que muestra las estadisticas del valiente.
     * @param v
     * @param inventario 
     */
    
    private void mostrarValiente(Valiente v, Inventario inventario) {

        System.out.println("        +--------------------------------------------+");
        System.out.println("        |               ESTADISTICAS                 |");
        System.out.println("        |                                            |");

        System.out.printf("        |  Nombre: %-33s |\n", v.getNombre());
        System.out.println("        |                                            |");
        System.out.printf("        |  Tipo: %-33s |\n", v.getTipo());
        System.out.println("        |                                            |");
        System.out.printf("        |  Nivel: %-34d |\n", v.getNivel());
        System.out.println("        |                                            |");

        System.out.printf("        |  Fuerza: %-33d |\n", v.getFuerza());
        System.out.println("        |                                            |");

        System.out.printf("        |  Defensa: %-32d |\n", v.getDefensa());
        System.out.println("        |                                            |");

        System.out.printf("        |  Velocidad: %-30d |\n", v.getVelocidad());
        System.out.println("        |                                            |");

        System.out.printf("        |  Habilidad: %-30d |\n", v.getHabilidad());
        System.out.println("        |                                            |");
        System.out.printf("        |  Vida maxima: %-35d |\n", v.getVidaMaxima());
        System.out.println("        |                                            |");

        System.out.printf("        |  Vida actual: %-35d |\n", v.getVida());
        System.out.println("        |                                            |");

        System.out.printf("        |  Espada: %-33s |\n", v.getValorArma());
        System.out.println("        |                                            |");

        System.out.printf("        |  Escudo: %-33s |\n", v.getValorEscudo());
        System.out.println("        |                                            |");

        System.out.println("        +--------------------------------------------+");
        System.out.println();

        inventario.mostrarInventario();

    }
}
