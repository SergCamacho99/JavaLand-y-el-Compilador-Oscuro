/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import interfaces.PersonajesInterface;

/**
 *
 * @author Leila
 */
public class Monstruo extends Personaje implements PersonajesInterface {

    public Monstruo(String nombre, int nivel) throws IllegalArgumentException {
        super(nombre, 50 + (nivel * 10), 5 + nivel, 5 + nivel, 5 + nivel, 5 + nivel, nivel);
    }

    @Override
    public void subirNivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void recibirDaño(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nombre + " ha recibido daño. Vida restante: " + this.vida);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    public <T extends Personaje> double atacar(T Personaje) {
        double danioRealizado = (double) this.fuerza; 
        System.out.println("El monstruo " + this.nombre + " ataca a " + Personaje.getNombre() + " causando " + danioRealizado + " de daño");
        Personaje.recibirDaño((int) danioRealizado);
        return danioRealizado;
    }


}

      