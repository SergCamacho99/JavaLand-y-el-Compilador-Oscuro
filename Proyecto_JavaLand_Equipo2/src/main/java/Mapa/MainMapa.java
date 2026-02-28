/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Mapa;

/**
 *
 * @author DAM119
 */
import Personajes.Valiente;
import Personajes.GestorValientesImp;
import java.util.Scanner;

public class MainMapa {

    public static void main(String[] args) {
        GestorValientesImp gvi = new GestorValientesImp();
        Scanner teclado = new Scanner(System.in);
        gvi.crearValientesIniciales();
        
        Valiente inicial = gvi.getListaValientes()[0];
        //Mapa mapa = new Mapa(inicial,);
        char tecla;

        do {
            //mapa.mostrarMapa();
            tecla = teclado.next().toLowerCase().charAt(0);

            //mapa.moverPersonaje(tecla);

            System.out.println("\n\n");
        } while (tecla != 'q');

        teclado.close();
    }
}

