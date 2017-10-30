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
public class Serpiente implements Runnable {

    int nSerp;
    int x = 0;
    int y = 0;
    int Direccion = 0;

    public Serpiente(int nSerp) {
        this.nSerp = nSerp;
    }

    @Override

    public void run() {
        x = (int) (Math.random() * RunM.mX);
        x = (int) (Math.random() * RunM.mY);
        while (RunM.correr) {
            RunM.Matriz[x][y].setSer(RunM.Matriz[x][y].getSer() + 1);
            System.out.println("Serpiente " + nSerp + " está en " + x + " , " + y);
            if (RunM.Matriz[x][y].getUs() == 1) {
                JOptionPane.showMessageDialog(null, "La Serpiente " + nSerp, " encontró al usuario!", JOptionPane.ERROR_MESSAGE);
                RunM.correr = false;
                break;
            } else if (RunM.Matriz[x][y].getSemi() >= 1) {
                RunM.Matriz[x][y].setSemi(RunM.Matriz[x][y].getSemi() - 1);
                RunM.SSerpi++;
                JOptionPane.showMessageDialog(null, "La serpiente " + nSerp , " encontró una semilla",JOptionPane.INFORMATION_MESSAGE);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Serpiente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Direccion();

        }
    }

    private void Direccion() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Serpiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        RunM.Matriz[x][y].setSer(RunM.Matriz[x][y].getSer() - 1);
        Direccion = (int) (Math.random() * 3);
        if (Direccion == 1) {
            if (x <= RunM.mX) {
                x++;
            } else {
                x--;
            }

        } else if (Direccion == 2) {
            if (x >= 0) {
                x--;
            } else {
                x++;
            }
        }
        Direccion = (int) (Math.random() * 3);
        if (Direccion == 1) {
            if (y <= RunM.mY) {
                y++;
            } else {
                y--;
            }

        } else if (Direccion == 2) {
            if (y >= 0) {
                y--;
            } else {
                y++;
            }
        }

    }

}
