/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.Valiente;
import Objetos.Objeto;

/**
 *
 * @author dam125
 */

public interface MapaInterface {

    // Mueve al valiente, 'w', 'a', 's', 'd';
    void moverPersonaje(char direccion);

    // Muestra el mapa
    void mostrarMapa();

    // Coloca un objeto en el mapa
    void colocarObjeto(Objeto obj, int cantidad);

    // Coloca enemigos en el mapa
    void colocarEnemigos(int cantidad);

    // Coloca obstáculos en el mapa
    void colocarObstaculos(int cantidad);

    // Devuelve el valiente.
    Valiente getValiente();
}
