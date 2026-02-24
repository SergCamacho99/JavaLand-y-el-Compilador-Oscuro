/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Enumerados.TipoClase;
import Objetos.Inventario;
import interfaces.PersonajesInterface;

/**
 *
 * @author dam125
 */
public class Valiente extends Personaje implements PersonajesInterface {

    private TipoClase tipo;
    private int ataqueArma = 0;
    private int defensaEscudo = 0;

    
    public Valiente(String nombre, TipoClase tipo, int fuerza, int defensa, int habilidad, int velocidad) throws IllegalArgumentException {
        super(nombre, 100, fuerza, defensa, habilidad, velocidad, 1);
        this.tipo = tipo;
    }

    @Override
    public void recibirDaño(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nombre + " pierde " + cantidad + " de vida. Vida restante: " + this.vida);
    }

    public void usarHabilidadEspecial(Monstruo enemigo) {
        switch (this.tipo) {
            case GUERRERO:
                System.out.println(nombre + " usa 'Golpe de Acero' (Fuerza x 1.5, estunea 1 turno al rival)");
                enemigo.recibirDaño((int) (fuerza * 1.5));
                break;
            case PALADÍN:
                System.out.println(nombre + " usa 'Escudo Divino' (Recupera 20 de vida)");
                this.vida = Math.min(100, this.vida + 20);
                break;
            case MAGO:
                System.out.println(nombre + " usa 'Explosión de Código' (Daño ignorando defensa)");
                enemigo.recibirDaño(fuerza + 10);
                break;
            case PÍCARO:
                System.out.println(nombre + " usa 'Ataque Crítico' (Doble de fuerza)");
                enemigo.recibirDaño(fuerza * 2);
                break;
            case EXPLORADOR:
            System.out.println(nombre + " usa 'Ojo del Halcón'");
            System.out.println("Revelando casillas adyacentes y permitiendo movimiento diagonal");
            enemigo.recibirDaño(fuerza + velocidad); 
            break;
        }
    }

    @Override
    public void subirNivel() {
        this.nivel++;
        this.vida += 10;
        this.fuerza += 1;
        this.defensa += 1;
        this.habilidad += 1;
        this.velocidad += 1;
        
    }

    @Override
    public <T extends Personaje> void atacar(T Personaje) {
        double danioTotal = (double) this.fuerza + this.ataqueArma;
        System.out.println(this.nombre + " ataca a " + Personaje.getNombre() + " causando " + danioTotal + " de daño");
        Personaje.recibirDaño((int) danioTotal);
        
    }

    public TipoClase getTipo() {
        return tipo;
    }

    public void setTipo(TipoClase tipo) {
        this.tipo = tipo;
    }

    public int getAtaqueArma() {
        return ataqueArma;
    }

    public void setAtaqueArma(int ataqueArma) {
        this.ataqueArma = ataqueArma;
    }

    public int getDefensaEscudo() {
        return defensaEscudo;
    }

    public void setDefensaEscudo(int defensaEscudo) {
        this.defensaEscudo = defensaEscudo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public int getHabilidad() {
        return habilidad;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
