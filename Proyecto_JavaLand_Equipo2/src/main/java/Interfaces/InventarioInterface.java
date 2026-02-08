/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Objetos.Objeto;
import Personajes.Valiente;

/**
 *
 * @author dam125
 */
public interface InventarioInterface {
    
  void agregarObjeto(Objeto obj);

    void usarObjeto(String nombre, Valiente valiente);

    void mostrarInventario();
}
    
