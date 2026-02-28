/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;

/**
 *
 * @author DAM119
 */
public class CompiladorOscuro {

    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;

    private int x;
    private int y;

    public CompiladorOscuro(int n, int m) {
        this.vida = 150;
        //this.fuerza = 3*;
        //this.defensa = 3*;
        //this.habilidad = 3*;
        //this.velocidad = 3*;

        this.x = n;
        this.y = m;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
