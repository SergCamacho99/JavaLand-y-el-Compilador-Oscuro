/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Objetos.Objeto;
import Objetos.Objeto;
import Personajes.Valiente;
import Personajes.Valiente;

/**
 *
 * @author DAM118
 */
public class Inventario {

    // guarda los objestos del jugador 
    private Objeto[] Objetos; //array para guardar objetos
    private int cantidad;

    //Constructor 
    //Inventario con espacio para 5 Objetos
    public Inventario() {
        Objetos = new Objeto[5];
        cantidad = 0;
    }
//añade un objeto al inventario si hay espacio
    public void agregarObjeto(Objeto obj) {
        if (cantidad < Objetos.length) {
            Objetos[cantidad] = obj;
            cantidad++;
            System.out.print("Objeto agregado al inventario");
        } else {
            System.out.print("Inventario lleno");
        }
    }
//metodo mostrar inventario
//muestra los objetos guardados 
    public void mostrarInventario() {
        if (cantidad == 0) {
            System.out.print("Inventario vacio");
        } else {
            for (int i = 0; i < cantidad; i++) {
                System.out.println(Objetos[i].getnombre());
            }
        }
    }
//metodo usar objeto
//permite usar un objeto buscandolo por su nombre
    public void usarObjeto(String nombre, Valiente valiente) {
        for (int i = 0; i< cantidad ; i++){
                
                if (Objetos[i].getnombre().equalsIgnoreCase(nombre)) {
                Objetos[i].usar(valiente);
                System.out.println("Objeto usado");
                return;
            }
        }
        System.out.println("No tienes ese objeto");
    }
    
    public boolean hayPlanta(String nombre){
        boolean hayPlanta=false;
        if (cantidad == 0) {
            hayPlanta=false;
        } else {
            for (int i = 0; i < cantidad; i++) {
                if(Objetos[i].getnombre().equalsIgnoreCase(nombre)){
                  hayPlanta=true;  
                }
                
            }
        }
        return hayPlanta;
    }
}
