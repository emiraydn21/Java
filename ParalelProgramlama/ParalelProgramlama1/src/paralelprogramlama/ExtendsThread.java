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
public class ExtendsThread extends Thread{
    @Override
    public void run(){
        for(int i=0 ; i<10 ; i++){
            System.out.println("Merhaba :" +i);
           
            try {
                Thread.sleep(1000); //
            } catch (InterruptedException ex) {
                Logger.getLogger(ExtendsThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
