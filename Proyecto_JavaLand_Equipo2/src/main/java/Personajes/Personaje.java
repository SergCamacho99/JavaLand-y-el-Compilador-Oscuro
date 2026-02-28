/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

/**
 * Clase abstracta que representa un personaje genérico dentro del juego Sirve
 * como base para Valientes y Monstruos Contiene atributos comunes y métodos que
 * deben implementar las subclases
 *
 * @author Leila
 */
public abstract class Personaje {

    //atributos de los personajes
    protected String nombre;
    protected int vida;
    protected int fuerza;
    protected int defensa;
    protected int habilidad;
    protected int velocidad;
    protected int nivel;

    /**
     * Constructor del personaje. Valida los parámetros y asigna las
     * estadísticas iniciales
     *
     * @param nombre nombre del personaje
     * @param vida vida inicial (0–100)
     * @param fuerza fuerza inicial (1–20)
     * @param defensa defensa inicial (1–20)
     * @param habilidad habilidad inicial (1–20)
     * @param velocidad velocidad inicial (1–20)
     * @param nivel nivel inicial del personaje
     * @throws IllegalArgumentException si alguna estadística está fuera de
     * rango
     */
    public Personaje(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) throws IllegalArgumentException {
        this.nombre = nombre;
        if (vida < 0 || vida > 100) {
            vida = 100;
        }
        this.vida = vida;
        if (fuerza < 1 || fuerza > 20) {
            throw new IllegalArgumentException("Error, la fuerza está fuera del rango (1-20)");
        }
        this.fuerza = fuerza;
        if (defensa < 1 || defensa > 20) {
            throw new IllegalArgumentException("Error, la defensa está fuera del rango (1-20)");

        }
        this.defensa = defensa;
        if (habilidad < 1 || habilidad > 20) {
            throw new IllegalArgumentException("Error, la habilidad está fuera del rango (1-20)");

        }
        this.habilidad = habilidad;
        if (velocidad < 1 || velocidad > 20) {
            throw new IllegalArgumentException("Error, la velocidad está fuera del rango (1-20)");
        }
        this.velocidad = velocidad;
        this.nivel = nivel;
    }

    /**
     * Método abstracto que obliga a las subclases a implementar cómo sube de
     * nivel un personaje
     */
    public abstract void subirNivel();

    /**
     * Método abstracto para recibir daño. Cada subclase puede manejarlo de
     * forma distinta
     */
    public abstract void recibirDaño(int cantidad);
  
    //geterrs y setters
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
}
