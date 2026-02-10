/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Marginado {

    Scanner teclado = new Scanner(System.in);

    private int puntosRestantes;
    private int fuerza;
    private int defensa;
    private int velocidad;
    private int habilidad;

    public Marginado() {

        puntosRestantes = 40;

        System.out.println("Asi que te gustan los retos eh?");
        System.out.println("Por muy valiente que seas, necesitaras hacer uso de esto, repartelo con sabiduria");
        System.out.println("Que la habilidad guie tu camino y la suerte este de tu lado, valiente.");

        this.fuerza = 0;
        this.defensa = 0;
        this.velocidad = 0;
        this.habilidad = 0;

        while (puntosRestantes > 0) {
//anadir que pasa si eleccion es menor que 1 o mayor que 4
            int eleccion = 0;
            System.out.println("Elige en que quieres invertir tus puntos: (Puntos restantes " + puntosRestantes + ")");
            System.out.println("1. Fuerza");
            System.out.println("2. Defensa");
            System.out.println("3. Velocidad");
            System.out.println("4. Habilidad");
            try {
                eleccion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un numero entero.");
            }

            switch (eleccion) {

                case 1: {

                    aumentarFuerza();
                    break;
                }

                case 2: {
                    aumentarDefensa();
                    break;
                }

                case 3: {
                    aumentarVelocidad();
                    break;
                }

                case 4: {
                    aumentarHabilidad();
                    break;
                }

                default:

            }
        }
        System.out.println("Puntos agregados correctamente. Buena suerte en tu camino Valiente.");
    }

    private void aumentarFuerza() {

        boolean valido = false;
        int puntos = 0;
        System.out.println("El poder del guerrero.");
        System.out.println("Valentia sin igual.");
        System.out.println("Una habilidad hecha para herir al projimo.");
        do {
            System.out.println("Cuantos puntos quieres para esta habilidad?");
            try {
                puntos = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un numero entero.");
            }

            if (puntos <= puntosRestantes && puntos > 0) {

                fuerza += puntos;
                puntosRestantes -= puntos;
                valido = true;

            } else if (puntos < 0) {
                System.out.println("No puedes anadir puntos negativos.");

            } else if (puntos == 0) {
                
                System.out.println("Debes anadir al menos un punto.");
            
            } else {

                System.out.println("No dispones de tantos puntos para repartir. Te quedan: " + puntosRestantes + " puntos para repartir");

            }

        } while (!valido);

    }

    private void aumentarDefensa() {
        boolean valido = false;
        int puntos = 0;
        System.out.println("El poder del guardian.");
        System.out.println("Resistir cuando otros caen.");
        System.out.println("Un muro levantado con pura determinacion.");

        do {
            System.out.println("Cuantos puntos quieres para esta habilidad?");
            try {
                puntos = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un numero entero.");
            }

            if (puntos <= puntosRestantes && puntos > 0) {

                defensa += puntos;
                puntosRestantes -= puntos;
                valido = true;

            }  else if (puntos < 0) {
                System.out.println("No puedes anadir puntos negativos.");

            } else if (puntos == 0) {
                
                System.out.println("Debes anadir al menos un punto.");
            
            }else {

                System.out.println("No dispones de tantos puntos para repartir. Te quedan: " + puntosRestantes + " puntos para repartir");

            }

        } while (!valido);
    }

    private void aumentarVelocidad() {
        boolean valido = false;
        int puntos = 0;
        System.out.println("El poder del explorador.");
        System.out.println("Moverse antes de que el peligro despierte.");
        System.out.println("Un paso rapido puede salvar una vida.");

        do {
            System.out.println("Cuantos puntos quieres para esta habilidad?");
            try {
                puntos = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un numero entero.");
            }

            if (puntos <= puntosRestantes && puntos > 0) {

                velocidad += puntos;
                puntosRestantes -= puntos;
                valido = true;

            }  else if (puntos < 0) {
                System.out.println("No puedes anadir puntos negativos.");

            } else if (puntos == 0) {
                
                System.out.println("Debes anadir al menos un punto.");
            
            }else {

                System.out.println("No dispones de tantos puntos para repartir. Te quedan: " + puntosRestantes + " puntos para repartir");

            }

        } while (!valido);
    }

    private void aumentarHabilidad() {
        boolean valido = false;
        int puntos = 0;
        System.out.println("El poder del elegido.");
        System.out.println("Una capacidad que no todos poseen.");
        System.out.println("El talento marca la diferencia.");

        do {
            System.out.println("Cuantos puntos quieres para esta habilidad?");
            try {
                puntos = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un numero entero.");
            }

            if (puntos <= puntosRestantes && puntos > 0) {

                habilidad += puntos;
                puntosRestantes -= puntos;
                valido = true;

            }  else if (puntos < 0) {
                System.out.println("No puedes anadir puntos negativos.");

            } else if (puntos == 0) {
                
                System.out.println("Debes anadir al menos un punto.");
            
            }else {

                System.out.println("No dispones de tantos puntos para repartir. Te quedan: " + puntosRestantes + " puntos para repartir");

            }

        } while (!valido);
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

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

}
