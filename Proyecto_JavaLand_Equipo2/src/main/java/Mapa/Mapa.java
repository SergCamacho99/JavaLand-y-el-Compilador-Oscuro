/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapa;
/**
 *
 * @author dam125
 */
public class Mapa {

    //private char mapa[][] = {
    //    {'?', '?', '?', '?', '?', '?', '?', '?', '?', '?'},
    //    {'?', 'x', '?', '?', '?', '?', '?', '?', '?', '?'},
    //    {'?', '?', '?', '?', '?', '?', '?', '?', '?', '?'},
    //    {'?', '?', '?', '?', '?', '?', '?', '?', '?', '?'},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    //    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
    
    private char[][] mapa = new char[10][10];
//};

    public void mostrarMapa() {

        for (int i = 0; i < 10; i++) {
            if (i == 0 || i % 1 == 0) {
                for(int j = 0; j < 10; j++) {
                System.out.print("---+");
                }
                    System.out.println();

            }
            for (int j = 0; j < 10; j++) {
               // if(mapa[i][j] == ' '){
               //     mapa[i][j]='?';
               // }else if (mapa[i][j] == 'x') {
               //     mapa[i+1][j+1] = 'n';
               // }
               
               if (i == 1 && j == 1) {
                   
                   mapa[i][j] = 'x';
                   
               } else {
                   
                   mapa[i][j] = '?';
               }
               
               if(mapa[i][j]=='x'){
               }
                System.out.print(" "+mapa[i][j]+" |");
            }
            System.out.println();
        }
    }
}

