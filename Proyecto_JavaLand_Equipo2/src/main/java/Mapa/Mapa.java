/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

/**
 *
 * @author dam125
 */
public class Mapa {

    private char[][] mapa = new char[10][10];
    private int x = 1;
    private int y = 1;

    public Mapa() {
        inicializarMapa();
        actualizarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapa[i][j] = '?';
            }
        }
    }

    private void actualizarMapa() {
        inicializarMapa();

        mapa[x][y] = 'X';

        despejarAdyacentes(x, y);
    }

    public void despejarAdyacentes(int x, int y) {

        if (x - 1 >= 0) {
            mapa[x - 1][y] = ' ';
        }
        if (x + 1 < mapa.length) {
            mapa[x + 1][y] = ' ';
        }
        if (y - 1 >= 0) {
            mapa[x][y - 1] = ' ';
        }
        if (y + 1 < mapa[x].length) {
            mapa[x][y + 1] = ' ';
        }
    }
    
    public void moverX(char direccion){
        int nuevaX= x;
        int nuevaY= y;
        switch (direccion) {
            case 'w': nuevaX--; break;
            case 's': nuevaX++; break;
            case 'a': nuevaY--; break;
            case 'd': nuevaY++; break;
            default: return;
        }
        if(nuevaX >= 0 && nuevaX < mapa.length && nuevaY >=0 && nuevaY < mapa[0].length){
            x=nuevaX;
            y=nuevaY;
            actualizarMapa();
        }
    }

    public void mostrarMapa() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("---+");
            }
            System.out.println();

            for (int j = 0; j < 10; j++) {
                // if(mapa[i][j] == ' '){
                //     mapa[i][j]='?';
                // }else if (mapa[i][j] == 'x') {
                //     mapa[i+1][j+1] = 'n';
                // }

                System.out.print(" " + mapa[i][j] + " |");
            }
            System.out.println();
        }
    }

}

