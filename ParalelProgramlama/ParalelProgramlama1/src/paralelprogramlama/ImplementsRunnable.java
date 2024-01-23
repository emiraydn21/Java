/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paralelprogramlama;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emira
 */
public class ImplementsRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=20 ; i>0 ; i--){
            System.out.println("Xun bi xer hâtın :" +i);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImplementsRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
