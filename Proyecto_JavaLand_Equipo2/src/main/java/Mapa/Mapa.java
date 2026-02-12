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

    private char[][] mapa = new char[12][12];
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
                mapa[i][j] = '?';
                mapa[i][j] = ' ';

            }
        }
    }

    public void colocarEnemigos(int cantidad) {
        int colocados = 0;
        while (colocados > cantidad) {

            int fila = random.nextInt(12);
            int columna = random.nextInt(12);

            if (mapa[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapa[fila][columna] = 'E';
                colocados++;

            }
        }

    }

    public void colocarObstaculos(int cantidad) {
        int colocados = 0;
        while (colocados > cantidad) {

            int fila = random.nextInt(12);
            int columna = random.nextInt(12);

            if (mapa[fila][columna] == ' ' && !(fila == x && columna == y)) {
                mapa[fila][columna] = '#';
                colocados++;
            }
        }
    }

    public void actualizarMapa() {

        mapa[x][y] = 'X';

        despejarAdyacentes(x, y);
    }

    public void despejarAdyacentes(int x, int y) {

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (mapa[i][j] == ' ') {
                    mapa[i][j] = '?';
                }else if (mapa[i][j] == 'E'){
                    mapa[i][j] = '?';
                }

            }
        }

        if (x - 1 >= 0) {
            mapa[x - 1][y] = ' ';
        }
        if (x + 1 < 12) {
            mapa[x + 1][y] = ' ';
        }
        if (y - 1 >= 0) {
            mapa[x][y - 1] = ' ';
        }
        if (y + 1 < 12) {
            mapa[x][y + 1] = ' ';
        }
        mapa[x][y] = 'X';
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
        if (nuevaX >= 0 && nuevaX < 12 && nuevaY >= 0 && nuevaY < mapa[0].length) {
            x = nuevaX;
            y = nuevaY;
            actualizarMapa();
        }
        if (mapa[nuevaX][nuevaY] != '#') {
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

                System.out.print(" " + (mapa[i][j] == ' ' ? mapa[i][j] : mapa[i][j]) + " |");
            }
            System.out.println();
        }
    }

}
