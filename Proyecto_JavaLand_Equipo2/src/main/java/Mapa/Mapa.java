/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

import Objetos.Escudo;
import Objetos.Espada;
import Objetos.FabricaArmas;
import Objetos.Inventario;
import Objetos.Objeto;
import Objetos.PlantaCurativa;
import Personajes.Combate;
import Personajes.GestorMonstruosImp;
import Personajes.GestorValientesImp;
import Personajes.Monstruo;
import Personajes.Valiente;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Mapa {

    Scanner teclado = new Scanner(System.in);

    private Espada[] espadas;
    private Escudo[] escudos;

    GestorMonstruosImp monstruos = new GestorMonstruosImp();
    GestorValientesImp valientes = new GestorValientesImp();
    CompiladorOscuro compiladorOscuro;
    Valiente valiente;
    Monstruo monstruo;
    Inventario inventario;

    private char[][] mapaReal = new char[12][12];
    private char[][] mapaVisible = new char[12][12];
    private int x = 1;
    private int y = 1;
    private Random random = new Random();
    
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

//Constructor de mapa con los parámetros para poder inicializarlo.
    public Mapa(Valiente v, Inventario inventario) {
        this.inventario = inventario;
        this.valiente = v;

        espadas = FabricaArmas.crearEspadas();
        escudos = FabricaArmas.crearEscudos();
        inicializarMapa();
        colocarEnemigos(15);
        colocarCofres(10);
        colocarObstaculos(15);
        mapaReal[11][11] = '☠';

        actualizarMapaVisible();
    }

    /**
     * Autor: Sergio C Inicializa el juego con ambos mapas, el real es donde se
     * encuentran los enemigos, cofres y muros, el otro muestra la niebla de
     * guerra.
     */
    public void inicializarMapa() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                //Ambos mapas, uno te muestra lo que hay dentro de las casillas y el otro es la niebla de guerra.
                mapaReal[i][j] = ' ';
                mapaVisible[i][j] = '░';
            }
        }
    }

    /**
     * Autor: Sergio C Con random coloca los enemigos y dibuja el símbolo que
     * los representa.
     */
    public void colocarEnemigos(int cantidad) {

        int colocados = 0;
        while (colocados < cantidad) {
            int fila = random.nextInt(12);
            int columna = random.nextInt(12);
            if (mapaReal[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapaReal[fila][columna] = '☻';
                colocados++;
            }
        }
    }

    /**
     * Autor: Sergio C Con random colocas los cofres y dibuja el símbolo.
     */
    public void colocarCofres(int cantidad) {
        int colocados = 0;
        while (colocados < cantidad) {
            int fila = random.nextInt(12);
            int columna = random.nextInt(12);
            if (mapaReal[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapaReal[fila][columna] = '⊟';
                colocados++;
            }
        }
    }

    /**
     * Autor: Sergio C Con random colocas los obstáculos y dibuja el símbolo.
     */
    public void colocarObstaculos(int cantidad) {
        int colocados = 0;
        while (colocados < cantidad) {
            int fila = random.nextInt(12);
            int columna = random.nextInt(12);
            if (mapaReal[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapaReal[fila][columna] = '■';
                colocados++;
            }
        }
    }

    /**
     * Autor: Sergio C Este método contiene el símbolo que representa al
     * jugador, a sus lados, despeja la niebla de guerra de las casillas
     * adyacentes de manera perpendicular del ,apa Visible y muestra el mapa
     * real. Se utilizan las coordenadas con X e Y dependiendo de donde se
     * encuentre el símbolo del jugador.
     */
    public void actualizarMapaVisible() {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                mapaVisible[i][j] = '░';
            }
        }

        mapaVisible[x][y] = '웃';

        if (x - 1 >= 0) {
            mapaVisible[x - 1][y] = mapaReal[x - 1][y];
        }
        if (x + 1 < 12) {
            mapaVisible[x + 1][y] = mapaReal[x + 1][y];
        }
        if (y - 1 >= 0) {
            mapaVisible[x][y - 1] = mapaReal[x][y - 1];
        }

        if (y + 1 < 12) {
            mapaVisible[x][y + 1] = mapaReal[x][y + 1];
        }

    }

    /**
     * Autor: Sergio C Con un switch leemos la tecla y con cada una hace que el
     * personaje se mueva a la coordenada correspondiente. Dentro de este mismo
     * método está puesta la limitación para que el personaje no pueda atravesar
     * los muros del mapa y las diferentes interacciones con el entorno. Si
     * entramos en la casilla de enemigo, hace que comience el combate llamando
     * al método correspondiente y lo mismo con los cofres. Ambas cosas tras
     * terminar el evento asignado, hace que desaparezcan del mapa.
     */
    public void moverPersonaje(char direccion) {

        int nuevaX = x;
        int nuevaY = y;

        switch (direccion) {
            case 'w':
                nuevaX--;
                break;
            case 's':
                nuevaX++;
                break;
            case 'a':
                nuevaY--;
                break;
            case 'd':
                nuevaY++;
                break;
            default:
        }

        if (nuevaX >= 0 && nuevaX < 12 && nuevaY >= 0 && nuevaY < 12 && mapaReal[nuevaX][nuevaY] != '■') {

            if (mapaReal[nuevaX][nuevaY] == '⊟') {
                System.out.println(VERDE + "¡Has abierto un cofre!" + RESET);
                crearObjetoAleatorio(inventario);
                mapaReal[nuevaX][nuevaY] = ' ';
            }
            if (mapaReal[nuevaX][nuevaY] == '☻') {
                System.out.println(ROJO + "¡Te encuentras con un enemigo!" + RESET);
                Combate combate = new Combate(inventario);
                combate.iniciarCombate(valiente, monstruos.generarMonstruos(nuevaY));
                mapaReal[nuevaX][nuevaY] = ' ';
            }
            if (mapaReal[nuevaX][nuevaY] == '☠') {
                System.out.println(MORADO + "¡Te enfrentas al Compilador Oscuro!" + RESET);
                //El compilador está colocador en la última casilla con -1, -1.
                CompiladorOscuro BossFinal = new CompiladorOscuro(12, 12, monstruos.getContadorMonstruos());
                Combate combate = new Combate(inventario);
                combate.iniciarCombate(valiente, BossFinal);

                mapaReal[nuevaX][nuevaY] = ' ';
            }
            x = nuevaX;
            y = nuevaY;

            actualizarMapaVisible();
        }
    }

    /**
     * Autor: Sergio C y David
     */
    public void mostrarMapa() {
        for (int i = 0; i < 12; i++) {
            System.out.println();
            for (int j = 0; j < 12; j++) {
                System.out.print("  " + mapaVisible[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(AMARILLO+"╔═══════════════════════════════════════════════════════════════"+ RESET);
        System.out.println(AMARILLO+"║                                                       "+ RESET);
        System.out.println(AMARILLO+"║ j. Mostrar Valiente   k. Usar Objeto   p. salir       "+ RESET);
        System.out.println(AMARILLO+"║                                                       "+ RESET);
        System.out.println(AMARILLO+"╚═══════════════════════════════════════════════════════════════"+ RESET);
    }

    /**
     * Autor: David
     * Metodo que genera un objeto aleatorio mediante un random.
     */
    private void crearObjetoAleatorio(Inventario inventario) {

        int objetoAleatorio = random.nextInt(3);
        int aleatorizadorObjeto = random.nextInt(espadas.length);
        boolean eleccion = false;
        int equipar;

        if (objetoAleatorio == 0) {

            Espada espada = espadas[aleatorizadorObjeto];
            System.out.println(VERDE + "Has encontrado: " + espada.getNombre()+""+RESET);

            do {
                System.out.println(VERDE+"¿Quieres equipar este objeto ahora?"+RESET);
                System.out.println("1. Si | 2. No");
                equipar = teclado.nextInt();

                if (equipar == 1) {
                    espada.equipar(valiente, espada);
                    eleccion = true;

                } else if (equipar == 2) {
                    inventario.agregarObjeto(espada);
                    eleccion = true;

                } else {
                    System.out.println("Introduce una opción válida.");
                }

            } while (!eleccion);

        } else if (objetoAleatorio == 1) {

            Escudo escudo = escudos[aleatorizadorObjeto];
            System.out.println(VERDE+"Has encontrado: " + escudo.getNombre()+""+RESET);

            do {
                System.out.println(VERDE+"¿Quieres equipar este objeto ahora?"+RESET);
                System.out.println("1. Si | 2. No");
                equipar = teclado.nextInt();

                if (equipar == 1) {
                    escudo.equipar(valiente, escudo);
                    eleccion = true;

                } else if (equipar == 2) {
                    inventario.agregarObjeto(escudo);
                    eleccion = true;

                } else {
                    System.out.println("Introduce una opción válida.");
                }

            } while (!eleccion);

        } else {

            Objeto obj = new PlantaCurativa(10);
            System.out.println(VERDE+"¡Has encontrado una planta curativa!"+RESET);
            inventario.agregarObjeto(obj);
        }
    }

}
