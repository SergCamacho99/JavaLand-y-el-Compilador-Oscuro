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
    
  public void agregarObjeto(Objeto obj);

    public void usarObjeto(String nombre, Valiente valiente);

    public void mostrarInventario();
}
    
