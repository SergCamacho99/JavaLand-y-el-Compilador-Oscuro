/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import Enumerados.TipoClase;
import interfaces.GestoresInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leila
 */
public class GestorValientesImp implements GestoresInterface {

     private Valiente[] listaValientes;

    @Override
    public void crearValientesIniciales() {
       listaValientes = new Valiente[4];
        listaValientes[0] = new Valiente("Ragnar", TipoClase.GUERRERO, 15, 10, 8, 7);
        listaValientes[1] = new Valiente("Elena", TipoClase.PALADÍN, 8, 15, 7, 10);
        listaValientes[2] = new Valiente("Aris", TipoClase.MAGO, 7, 8, 15, 10);
        listaValientes[3] = new Valiente("Loki", TipoClase.PÍCARO, 8, 7, 10, 15);
        System.out.println("Valientes iniciales creados");
    }
    public Valiente crearExploradorEspecial(String nombre) {
        return new Valiente(nombre, TipoClase.EXPLORADOR, 9, 9, 11, 11);
    }
    @Override
    public Monstruo generarMonstruos(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMonstruo(Monstruo m) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Valiente[] getListaValientes() {
        return listaValientes;
    }
}
