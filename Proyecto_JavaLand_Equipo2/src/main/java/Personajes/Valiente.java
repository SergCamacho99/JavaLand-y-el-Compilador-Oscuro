/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Enumerados.TipoClase;
import Objetos.Arma;
import Objetos.Escudo;
import Objetos.Inventario;
import interfaces.PersonajesInterface;
import java.util.Scanner;

/**
 * Clase que representa a un Valiente Extiende de Personaje e implementa
 * PersonajesInterface Cada valiente tiene una clase (GUERRERO, MAGO, etc.) y
 * puede usar armas, escudos y habilidades especiales.
 *
 * @author dam125
 */
public class Valiente extends Personaje implements PersonajesInterface {
    //atributos de la clase valiente

    private TipoClase tipo;
    private Arma arma;
    private Escudo escudo;
    private int vidaMaxima = 100;

    /**
     * Constructor del valiente. Todos los valientes empiezan con 100 de vida y
     * nivel 1
     *
     * @param nombre nombre del personaje
     * @param tipo clase del personaje (GUERRERO, MAGO, etc.)
     * @param fuerza fuerza base
     * @param defensa defensa base
     * @param habilidad habilidad base
     * @param velocidad velocidad base
     */
    public Valiente(String nombre, TipoClase tipo, int fuerza, int defensa, int habilidad, int velocidad) throws IllegalArgumentException {
        super(nombre, 100, fuerza, defensa, habilidad, velocidad, 1);
        this.tipo = tipo;
        this.vidaMaxima = 100; //vida máxima inicial
    }

    /**
     * Aplica daño al valiente La vida nunca baja de 0
     * @param cantidad
     */
    @Override
    public void recibirDaño(int cantidad) {

        int danioTotal = (int) cantidad - getDefensaTotal();
        if (danioTotal <= 0) {

            danioTotal = 0;

        } else {
            this.vida -= danioTotal;
            if (this.vida < 0) {
                this.vida = 0;
            }

        }
        System.out.println(this.nombre + " pierde " + danioTotal + " de vida. Vida restante: " + this.vida);
    }

    /**
     * Habilidad especial según la clase del valiente Cada clase tiene un efecto
     * distinto
     * @param enemigo
     */
    public void usarHabilidadEspecial(Monstruo enemigo) {
        switch (this.tipo) {
            case GUERRERO -> {
                System.out.println(nombre + " usa 'Golpe de Acero' (Fuerza x 1.5, estunea 1 turno al rival)");
                enemigo.recibirDaño((int) (fuerza * 1.5));
            }
            case PALADÍN -> {
                System.out.println(nombre + " usa 'Escudo Divino' (Recupera 20 de vida)");
                this.vida = Math.min(100, this.vida + 20);
            }
            case MAGO -> {
                System.out.println(nombre + " usa 'Explosión de Código' (Daño ignorando defensa)");
                enemigo.recibirDaño(fuerza + 10);
            }
            case PÍCARO -> {
                System.out.println(nombre + " usa 'Ataque Crítico' (Doble de fuerza)");
                enemigo.recibirDaño(fuerza * 2);
            }
            case EXPLORADOR -> {
                System.out.println(nombre + " usa 'Ojo del Halcón'");
                System.out.println("Revelando casillas adyacentes y permitiendo movimiento diagonal");
                enemigo.recibirDaño(fuerza + velocidad);
            }
        }
    }

    /**
     * Subida de nivel del valient Aumenta todas las estadísticas y permite
     * mejorar una adicional
     */
    @Override
    public void subirNivel() {
        this.nivel++;
        this.vida += 10;
        this.fuerza++;
        this.defensa++;
        this.habilidad++;
        this.velocidad++;
        System.out.println("Se ha subido el nivel de todas las estadísticas!");
        boolean mejorado = false;
        do {
            System.out.println("¿Qué estadística quieres mejorar?");
            System.out.println("1.- Vida");
            System.out.println("2.- Fuerza");
            System.out.println("3.- Defensa");
            System.out.println("4.- Habilidad");
            System.out.println("5.- Velocidad");
            System.out.print("Elige una opción: ");
            int opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    setVida(getVida() + 10);
                    mejorado = true;
                    System.out.println("Se ha mejorado la vida en +10");
                }
                case 2 -> {
                    setFuerza(getFuerza() + 1);
                    mejorado = true;
                    System.out.println("Se ha mejorado la fuerza en +1");
                }
                case 3 -> {
                    setDefensa(getDefensa() + 1);
                    mejorado = true;
                    System.out.println("Se ha mejorado la defensa en +1");
                }
                case 4 -> {
                    setHabilidad(getHabilidad() + 1);
                    mejorado = true;
                    System.out.println("Se ha mejorado la habilidad en +1");
                }
                case 5 -> {
                    setVelocidad(getVelocidad() + 1);
                    mejorado = true;
                    System.out.println("Se ha mejorado la velocidad en +1");
                }
                default -> System.out.println("Error: Opción inválida.Introduce una opción válida");
            }
        } while (!mejorado);
    }

    /**
     * Ataque básico del valiente El daño depende de su fuerza, el arma equipada
     * y la defensa del enemigo
     *
     * @param <T>
     * @param Personaje
     */
    @Override
    public <T extends Personaje> void atacar(T Personaje) {
        double danioTotal = 0;
        if (arma == null) {
            danioTotal = (double) this.fuerza;
        } else {

            danioTotal = (double) this.fuerza + arma.getValor();

        }
        System.out.println(this.nombre + " ataca a " + Personaje.getNombre() + " causando " + danioTotal + " de daño");
        Personaje.recibirDaño((int) danioTotal);
    }

    public int getDefensaTotal() {
        if (escudo != null) {
            return defensa + escudo.getValor();
        }
        return defensa;
    }
//getters y setters

    public TipoClase getTipo() {
        return tipo;
    }

    public void setTipo(TipoClase tipo) {
        this.tipo = tipo;
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

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        if (this.vida > vidaMaxima) {
            this.vida = vidaMaxima;
        }
    }
}
