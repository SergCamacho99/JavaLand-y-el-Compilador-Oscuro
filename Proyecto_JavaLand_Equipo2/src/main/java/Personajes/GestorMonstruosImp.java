/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Personajes.Monstruo;
import interfaces.GestoresInterface;
import java.util.Random;

/**
<<<<<<< Updated upstream
 *
 * Implementación de la clase para gestionar los monstruos . Esta clase se
 * encarga de generar monstruos según el nivel del jugador y llevar un conteo de
 * cuántos monstruos se han creado
 *
=======
 * 
>>>>>>> Stashed changes
 * @author Leila
 */
public class GestorMonstruosImp implements GestoresInterface {

    //generador de números aleatorios para seleccionar monstruos al azar
    private Random random = new Random();
    //contador de monstruos generados (útil para estadísticas o control interno)
    private int contadorMonstruos = 0;

    @Override
    public void crearValientesIniciales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * * Genera un monstruo dependiendo del nivel recibido - Niveles 1 a 3:
     * monstruos débiles - Niveles 4 a 7: monstruos intermedios - Niveles 8+ :
     * monstruos fuertes
     *
     * @param nivel nivel del monstruo a generar
     * @return un objeto Monstruo con nombre aleatorio y el nivel indicado
     */
    @Override
    public Monstruo generarMonstruos(int nivel) {
        String nombreSeleccionado;
        if (nivel <= 3) {
            String[] nivelBajo = {
                "Kobold", "Orco", "Cubo gelatinoso", "Araña gigante",
                "Almeja gigante", "Siluro gigante", "Abrian", "Hongos"
            };
            nombreSeleccionado = nivelBajo[random.nextInt(nivelBajo.length)];
        } else if (nivel <= 7) {
            String[] nivelMedio = {
                "Mimeto", "Oso lechuza", "Tiefling", "Aarakocra",
                "Devorador de intelectos", "Yuan-ti", "Hombre tigre", "No muerto"
            };
            nombreSeleccionado = nivelMedio[random.nextInt(nivelMedio.length)];
        } else {
            String[] nivelAlto = {
                "Liche", "Bestia desplazadora", "Dragón negro",
                "Dragón rojo", "Dragón de piedra", "Semidragón"
            };
            nombreSeleccionado = nivelAlto[random.nextInt(nivelAlto.length)];
        }
        //se aumenta el contador de monstruos creados
        this.contadorMonstruos++;
        return new Monstruo(nombreSeleccionado, nivel);
    }

    /**
     * Elimina un monstruo del juego
     *
     * @param m monstruo a eliminar
     */
    @Override
    public void eliminarMonstruo(Monstruo m) {
        System.out.println("El monstruo " + m.getNombre() + " ha sido eliminado y desaparece del mapa");
    }

    /**
     * Devuelve cuántos monstruos se han generado hasta ahora.
     *
     * @return número total de monstruos creados
     */
    public int getContadorMonstruos() {
        return this.contadorMonstruos;
    }

}
