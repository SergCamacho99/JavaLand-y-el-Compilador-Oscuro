/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Personajes.Monstruo;
import interfaces.GestoresInterface;
import java.util.Random;

/**
 *
 * @author Leila
 */
public class GestorMonstruosImp implements GestoresInterface {
  private Random random = new Random();
    @Override
    public void crearValientesIniciales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Monstruo generarMonstruos(int nivel) {
        String nombreSeleccionado;
        if (nivel <=3) {
            String[] nivelBajo = {
                "Kobold", "Orco", "Cubo gelatinoso", "Araña gigante", 
                "Almeja gigante", "Siluro gigante", "Abrian", "Hongos"
            };
            nombreSeleccionado = nivelBajo[random.nextInt(nivelBajo.length)];
        } 
        else if (nivel <= 7) {
            String[] nivelMedio = {
                "Mimeto", "Oso lechuza", "Tiefling", "Aarakocra", 
                "Devorador de intelectos", "Yuan-ti", "Hombre tigre", "No muerto"
            };
            nombreSeleccionado = nivelMedio[random.nextInt(nivelMedio.length)];
        } 
        else {
            String[] nivelAlto = {
                "Liche", "Bestia desplazadora", "Dragón negro", 
                "Dragón rojo", "Dragón de piedra", "Semidragón"
            };
            nombreSeleccionado = nivelAlto[random.nextInt(nivelAlto.length)];
        }

        return new Monstruo(nombreSeleccionado, nivel);
    }

    @Override
    public void eliminarMonstruo(Monstruo m) {
        System.out.println("El monstruo " + m.getNombre() + " ha sido eliminado y desaparece del mapa");
    }

}
