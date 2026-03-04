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
 * @author Kateh Barreto Ramirez
 * //Clase que representa el inventario del jugador , Permite guardar, mostrar , usar y elimar objetos
 */
public class Inventario {

    // guarda los objestos del jugador 
    private Objeto[] Objetos; //array para guardar objetos
    private int cantidad; // numero de objetos guardados

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
   /**
    * @author Kateh Barreto 
    */

    public void mostrarInventario() {
        System.out.println("        +----------------------+");
        System.out.println("        |      INVENTARIO      |");
        System.out.println("        +----------------------+");

        if (cantidad == 0) {
            System.out.println("        | Vacio                |");
        } else { //recorre el array mostrando cada objeto
            for (int i = 0; i < cantidad; i++) {
                // Asegúrate de que el nombre del objeto esté alineado
                System.out.printf("        | %2d. %s\n", (i + 1), Objetos[i].getnombre());
            }
        }

        System.out.println("        +----------------------+");
        System.out.println("cantidad: " + cantidad);
    }

    //metodo usar objeto
    //permite usar un objeto buscandolo por su nombre
    /**
     * @author Kateh barreto
     * @param nombre
     * @param valiente 
     */
    public void usarObjeto(String nombre, Valiente valiente) {
        for (int i = 0; i < cantidad; i++) {

            if (Objetos[i].getnombre().equalsIgnoreCase(nombre)) { // comprueba si el objeto con el nombre
                if (valiente.getVida() == valiente.getVidaMaxima()) { 
                    System.out.println("Tu vida esta al maximo, no puedes usar el objeto");
                } else {
                    Objetos[i].usar(valiente);
                    System.out.println("Objeto usado");
                    return;
                }

            }
        }
        System.out.println("No tienes ese objeto");
    }

    //verifica que si existe una planta en el iventario
   

    /**
     * Este metodo te recorre el array de inventario para validar si hay una planta curativa o si no hay, devolviendo un boolean para gestionar en otros metodos, como por ejemplo en combate
     * @author Miguel Martinez Revuelta
     * @param nombre
     * @return 
     */

    public boolean hayPlanta(String nombre) {
        boolean hayPlanta = false;
        if (cantidad == 0) {
            hayPlanta = false;
        } else {
            for (int i = 0; i < cantidad; i++) {
                if (Objetos[i].getnombre().equalsIgnoreCase(nombre)) {
                    hayPlanta = true; //planta encontrada   

                }

            }
        }

        if (hayPlanta) {

        }

        return hayPlanta;
    }
//Permite seleccionar un objeto del inventario por su posicion
    /**
     * @author David alonso
    */
    public void seleccionarObjeto(int objetoElegido, Valiente valiente) {

        objetoElegido -= 1;

        if (objetoElegido > cantidad) {

            System.out.println("Por favor eleige un objeto existente.");

        } else if (this.cantidad > 0) {

            if (Objetos[objetoElegido] instanceof Espada) {
                valiente.setArma((Arma) Objetos[objetoElegido]);
                eliminarObjetoInventario(Objetos[objetoElegido].getnombre());
            } else if (Objetos[objetoElegido] instanceof Escudo) {

                valiente.setEscudo((Escudo) Objetos[objetoElegido]);

            } else {

                for (int i = 0; i < cantidad; i++) {

                    if (i == objetoElegido) {

                        usarObjeto(Objetos[i].getnombre(), valiente);
                        eliminarObjetoInventario(Objetos[i].getnombre());

                    }

                }
            }
        }
    }
// Elimina un objeto del inventario
    /**
     * @author David alonso
     * @param nombre 
     */
    public void eliminarObjetoInventario(String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (Objetos[i].getnombre().equals(nombre)) {

                for (int j = i; j < cantidad - 1; j++) {

                    Objetos[j] = Objetos[j + 1];

                }

                Objetos[cantidad - 1] = null;
                cantidad--;

                return;
            }

        }

    }

    public int getCantidad() {

        return this.cantidad;

    }

}
