/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import interfaces.GestoresInterface;

/**
 *
 * @author Leila
 */
public class GestorMonstruosImp implements GestoresInterface{

    @Override
    public void crearValientesIniciales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Monstruo generarMonstruos(int nivel) {
        return new Monstruo("Orco", nivel);
    }

    @Override
    public void eliminarMonstruo(Monstruo m) {
       System.out.println("El monstruo " + m.getNombre() + " ha sido eliminado");
    }
    
}
