/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paralelprogramlama3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emira
 */
class ThreadOrnek extends Thread {

    public ThreadOrnek() {

    }

    @Override
    public void run() {
        System.out.println("Değişen isim: " + this.getName());
    }

}

public class ParalelProgramlama3 {

    public static void main(String[] args) {
        ThreadOrnek[] thr1 = new ThreadOrnek[5];

        for (int i = 0; i < thr1.length; i++) {
            thr1[i] = new ThreadOrnek();
            thr1[i].setName("Thread-" + (i+1));

        }
        for (ThreadOrnek thread : thr1) {
            thread.start();

            try {
                Thread.sleep(1000);
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ParalelProgramlama3.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }

}
