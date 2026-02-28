/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

import Objetos.Arma;
import Objetos.Consumible;
import Objetos.Escudo;
import Objetos.Espada;
import Objetos.Inventario;
import Objetos.Objeto;
import Objetos.PlantaCurativa;
import Personajes.Combate;
import Personajes.GestorMonstruosImp;
import Personajes.GestorValientesImp;
import Personajes.Monstruo;
import Personajes.Valiente;
import interfaces.CombateInterface;
import interfaces.JuegoInterface;
import interfaces.ObjetoInterface;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dam125
 */
public class Mapa {
    
    Scanner teclado = new Scanner(System.in);
    
    GestorMonstruosImp monstruos = new GestorMonstruosImp();
    GestorValientesImp valientes = new GestorValientesImp();
    Valiente valiente;
    Monstruo monstruo;
    Inventario inventario = new Inventario();

    private char[][] mapaReal = new char[12][12];
    private char[][] mapaVisible = new char[12][12];
    private int x = 1;
    private int y = 1;
    private Random random = new Random();

    public Mapa(Valiente v) {
        this.valiente = v;
        inicializarMapa();
        colocarEnemigos(15);
        colocarCofres(10);
        colocarObstaculos(15);
        actualizarMapaVisible();
    }

    public void inicializarMapa() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                mapaReal[i][j] = ' ';
                mapaVisible[i][j] = '░';
            }
        }
    }

    public void colocarEnemigos(int cantidad) {

        //GestorMonstruosImp monstruo = new GestorMonstruosImp();
        //monstruo.generarMonstruos(x)
        //int nivelMonstruo = monstruos.
        int colocados = 0;
        while (colocados < cantidad) {
            int fila = random.nextInt(12);
            int columna = random.nextInt(12);
            if (mapaReal[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapaReal[fila][columna] = '☻';
            }
            colocados++;
        }
    }

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
                System.out.println("¡Has abierto un cofre!");
                crearObjetoAleatorio();
                mapaReal[nuevaX][nuevaY] = ' ';
            }
            if (mapaReal[nuevaX][nuevaY] == '☻') {
                System.out.println("¡Te encuentras con un enemigo!");
                Combate combate = new Combate(inventario);
                combate.iniciarCombate(valiente, monstruos.generarMonstruos(nuevaY));
                mapaReal[nuevaX][nuevaY] = ' ';
            }
            x = nuevaX;
            y = nuevaY;

            actualizarMapaVisible();
        }
    }

    public void mostrarMapa() {
        for (int i = 0; i < 12; i++) {
            System.out.println();
            for (int j = 0; j < 12; j++) {
                System.out.print("  " + mapaVisible[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                       ║");
        System.out.println("║ j. Mostrar Valiente   k. Usar Objeto   p. salir       ║");
        System.out.println("║                                                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
    
    private void crearObjetoAleatorio(){
        
        int objetoAleatorio = (int) random.nextInt(3);
        
        if (objetoAleatorio == 0) {
            
            int valor = valiente.getNivel() + 5;
            Arma obj = new Espada(valor);
            int decision = 0;
            System.out.println("Has encontrado una espada!");
            while (decision != 1 && decision != 2){
            System.out.println("Quieres equipar el objeto ahora?");
            System.out.println("1. Si | 2. No");
            decision = teclado.nextInt();
            }
            if ( decision == 1) {
            valiente.setArma(obj);
            } else if(decision == 2) {
            inventario.agregarObjeto(obj);
            }
            
        } else if (objetoAleatorio == 1) {
            int valor = valiente.getNivel() + 5;
            Escudo obj = new Escudo(valor);
            System.out.println("Has encontrado un escudo!");
            System.out.println("Quieres equipar el objeto ahora?");
            System.out.println("1. Si | 2. No");
            int decision = teclado.nextInt();
            if ( decision == 1) {
            valiente.setEscudo(obj);
            } else if (decision == 2) {
            inventario.agregarObjeto(obj);
            }
            
            
        } else {
            
            Objeto obj = new PlantaCurativa(10);
            System.out.println("Has encontrado una planta curativa!");
            
        } 
        
    }
    
}
