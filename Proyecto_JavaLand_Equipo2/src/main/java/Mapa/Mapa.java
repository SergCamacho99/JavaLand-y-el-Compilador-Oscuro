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

    private char[][] mapaVisible = new char[12][12];
    private char[][] mapaNiebla = new char[12][12];
    private int x = 1;
    private int y = 1;
    private Random random = new Random();
    
    public Mapa() {
        inicializarMapa();
        actualizarMapa();
    }

    public void inicializarMapa() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                mapaVisible[i][j] = ' ';
                mapaNiebla[i][j] = '?';
            }
        }
    }

    public void actualizarMapa() {

        mapaVisible[x][y] = 'X';

        despejarAdyacentes(x, y);
    }

    public void despejarAdyacentes(int x, int y) {

        if (x - 1 >= 0) {
            mapaNiebla[x - 1][y] = mapaVisible[x - 1][y] = ' ';
        }
        if (x + 1 < 12) {
            mapaNiebla[x + 1][y] = mapaVisible[x + 1][y] = ' ';
        }
        if (y - 1 >= 0) {
            mapaNiebla[x][y - 1] = mapaVisible[x][y - 1] = ' ';
        }
        if (y + 1 < 12) {
            mapaNiebla[x][y + 1] = mapaVisible[x][y + 1] = ' ';
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
                return;
        }
        if (nuevaX >= 0 && nuevaX < 12 && nuevaY >= 0 && nuevaY < mapaVisible[0].length) {
            x = nuevaX;
            y = nuevaY;
            actualizarMapa();
        }
        if (mapaVisible[nuevaX][nuevaY] != '#') {
            x = nuevaX;
            y = nuevaY;
            actualizarMapa();
        }
    }

    public void mostrarMapa() {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print("---+");
            }
            System.out.println();

            for (int j = 0; j < 12; j++) {

                System.out.print(" " + mapaVisible[i][j] + " |");
            }
            System.out.println();
        }
    }

    public void colocarEnemigos(int cantidad) {
        int colocados = 10;

            int fila = random.nextInt(12);
            int columna = random.nextInt(12);

            if (mapaVisible[fila][columna] == '?' && !(fila == x && columna == y)) {
                mapaVisible[fila][columna] = 'E';
                colocados++;
            
        }
    }

    public void colocarObstaculos(int cantidad) {
        int colocados = 15;

            int fila = random.nextInt(12);
            int columna = random.nextInt(12);

            if (mapaVisible[fila][columna] == '?' && !(fila == x && columna == y)) {
                mapaVisible[fila][columna] = '#';
                colocados++;
            
        }
    }

}
