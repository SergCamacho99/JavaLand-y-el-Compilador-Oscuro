/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Personajes.Monstruo;



/**
 *
 * @author dam125
 */
public interface GestoresInterface {
    //Esta Interface va a ser usada por GestorValientes y GestorMonstruos
    //El metodo se llamara crear y sera comun para todos los personajes
    public void crearValientesIniciales();
    public Monstruo generarMonstruos(int nivel);
    public void eliminarMonstruo(Monstruo m);
}
