/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import Threads.Semilla;
import Threads.Usuario;
import Threads.Serpiente;

/**
 *
 * @author aldomora89
 */
public class Taller_Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        String tfila = JOptionPane.showInputDialog(null, "Ingrese la cantidad de Filas de la matriz: ");
        RunM.mX = Integer.parseInt(tfila);

        String tColum = JOptionPane.showInputDialog(null, "Ingrese la cantidad de Columnas de la matriz: ");
        RunM.mY = Integer.parseInt(tColum);

        RunM.NSerpi = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de serpientes que desea colocar dentro de la matriz: "));
        RunM matrizRun = new RunM();
        Semilla hilo1 = new Semilla();
        Usuario hilo2 = new Usuario();

        ExecutorService servicio = Executors.newCachedThreadPool();
        servicio.submit(hilo1);
        servicio.submit(hilo2);
        for (int i = 0; i <= RunM.NSerpi; i++) {

            servicio.submit(new Serpiente(i));
        }
        servicio.shutdown();
    }

}
