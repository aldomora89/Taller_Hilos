/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import taller_hilos.MatrizC;
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

            uX = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion en que fila podria existir una semilla", JOptionPane.QUESTION_MESSAGE + RunM.mX));
            uY = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la posicion en que Columna podria existir una semilla", JOptionPane.QUESTION_MESSAGE + RunM.mY));

            RunM.Matriz[uX][uY].setUs(1);

            if (RunM.Matriz[uX][uY].getSer() >= 1) {
                JOptionPane.showMessageDialog(null, "Una serpiente ", " esta en la misma posicion que Usuario!", JOptionPane.ERROR_MESSAGE);
                RunM.correr = false;
                break;
            } else if (RunM.Matriz[uX][uY].getSemi() >= 1) {
                RunM.Matriz[uX][uY].setSemi(RunM.Matriz[uX][uY].getSemi() - 1);
                NSemillas++;
                JOptionPane.showMessageDialog(null, "Bingo has encontrado ", " una semilla!", JOptionPane.INFORMATION_MESSAGE);
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

        JOptionPane.showMessageDialog(null, "Juego Terminado! ", "\nHabian " + RunM.NSemilla +" Semillas " + "\nUsuario consiguio: " + NSemillas + "\n Las Serpientes consiguieron: " + RunM.SSerpi, JOptionPane.INFORMATION_MESSAGE);
    }

}
