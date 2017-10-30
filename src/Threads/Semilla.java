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
public class Semilla implements Runnable {
    
    int Sx = 0;
    int Sy = 0;  

    
    @Override
    public void run(){
        
        while (RunM.correr){
            for (int i = 0; i < 10; i++) {
                Sx = (int) (Math.random() * RunM.mX);
                Sy = (int) (Math.random() * RunM.mY);
                RunM.Matriz[Sx][Sy].setSemi(RunM.Matriz[Sx][Sy].getSemi() + 1);
                System.out.println("La semilla fue plantada en la posicion " + Sx + "  " + Sy);
                RunM.TotalS++;
            }
            try {
                Thread.sleep(10000);
                
            }catch (InterruptedException ex) {
                Logger.getLogger(Semilla.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
    
}
