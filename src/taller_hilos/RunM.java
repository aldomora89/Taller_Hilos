/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_hilos;

/**
 *
 * @author aldomora89
 */
public class RunM {

    public static int SSerpi = 0, mX = 8, mY = 8, NSerpi, TotalS = 0;
    public static MatrizC Matriz[][] = new MatrizC[mX][mY];
    public static boolean correr = true;

    public RunM() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Matriz[i][j] = new MatrizC();
            }

        }
    }
}
