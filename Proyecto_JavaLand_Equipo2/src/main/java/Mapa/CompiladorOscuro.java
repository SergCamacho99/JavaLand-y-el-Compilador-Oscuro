/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

import Personajes.Monstruo;

/**
 *
 * @author DAM119
 */
public class CompiladorOscuro extends Monstruo {
    
    private int x;
    private int y;

    /**
     * Autor: Sergio C
     */
    public CompiladorOscuro(int n, int m, int cantidadMonstruos) {
        super("Compilador Oscuro", 1);

        this.x = n;
        this.y = m;
        cantidadMonstruos = 15;

        int estadistica = 3 * cantidadMonstruos;

        setVida(150);
        setFuerza(estadistica);
        setDefensa(estadistica);
        setHabilidad(estadistica);
        setVelocidad(estadistica);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
