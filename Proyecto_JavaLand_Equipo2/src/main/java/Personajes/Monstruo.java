/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import interfaces.PersonajesInterface;

/**
 * Clase que representa a un Monstruo dentro del juego Extiende de Personaje e
 * implementa PersonajesInterface Los monstruos tienen estadísticas que escalan
 * automáticamente según su nivel
 *
 * @author Leila
 */
public class Monstruo extends Personaje implements PersonajesInterface {

    /**
     * Constructor del monstruo. Genera estadísticas base en función del nivel:
     * - Vida: 50 + (nivel * 10) - Fuerza, Defensa, Habilidad, Velocidad: 5 +
     * nivel
     * @param nombre nombre del monstruo
     * @param nivel nivel del monstruo
     * @throws IllegalArgumentException si los parámetros no son válidos
     */
    public Monstruo(String nombre, int nivel) throws IllegalArgumentException {
        super(nombre, 50 + (nivel * 10), 5 + nivel, 5 + nivel, 5 + nivel, 5 + nivel, nivel);
    }

    @Override
    public void subirNivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Aplica daño al monstruo. Si la vida baja de 0, se ajusta a 0 (para que no
     * haya números negativos)
     * @param cantidad cantidad de daño recibido
     */
    @Override
    public void recibirDaño(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nombre + " ha recibido daño. Vida restante: " + this.vida);
    }

    //getters y setters
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public int getHabilidad() {
        return habilidad;
    }

    @Override
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método de ataque del monstruo
     * El daño realizado es igual a su fuerza 
     * @param Personaje objetivo del ataque
     */
    @Override
    public <T extends Personaje> void atacar(T Personaje) {
        double danioRealizado = (double) this.fuerza;
        System.out.println("El monstruo " + this.nombre + " ataca a " + Personaje.getNombre() + " causando " + danioRealizado + " de daño");
        Personaje.recibirDaño((int) danioRealizado);

    }

}
