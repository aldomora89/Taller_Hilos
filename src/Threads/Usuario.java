/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import taller_hilos.RunM;


/**
 *
 * @author aldomora89
 */
public class Usuario implements Runnable {

    @Override
    public void run() {

        int uX;
        int uY;
        int NSemillas = 0;

        while (RunM.correr) {

            uX = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posición en que FILA podria existir una semilla: "));
            uY = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posición en que COLUMNA podria existir una semilla"));

            RunM.Matriz[uX][uY].setUs(1);
            System.out.println("El usuario se encuentra en la posicion " + uX + "  " + uY);

            if (RunM.Matriz[uX][uY].getSer() >= 1) {
                JOptionPane.showMessageDialog(null, "Una serpiente esta en la misma posición que Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                RunM.correr = false;
                break;
            } else if (RunM.Matriz[uX][uY].getSemi() >= 1) {
                RunM.Matriz[uX][uY].setSemi(RunM.Matriz[uX][uY].getSemi() - 1);
                NSemillas++;
                JOptionPane.showMessageDialog(null, "Has encontrado una semilla ", " Bingo!", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Serpiente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Serpiente.class.getName()).log(Level.SEVERE, null, ex);

            }

            RunM.Matriz[uX][uY].setUs(0);
        }

        JOptionPane.showMessageDialog(null, "Habian " + RunM.TotalS  + " Semillas " + "\nLos Usuarios consiguieron: " + NSemillas + "\nLas Serpientes consiguieron: " + RunM.SSerpi, "Juego Terminado! ", JOptionPane.INFORMATION_MESSAGE);
    }

}
