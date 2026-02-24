/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

import java.util.Random;

/**
 *
 * @author dam125
 */
public class Mapa {

    private char[][] mapaReal = new char[12][12];
    private char[][] mapaVisible = new char[12][12];
    private int x = 1;
    private int y = 1;
    private Random random = new Random();

    public Mapa() {
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

    public void moverX(char direccion) {

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
}
