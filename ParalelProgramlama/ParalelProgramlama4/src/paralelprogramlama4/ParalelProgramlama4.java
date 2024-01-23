/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paralelprogramlama4;

/**
 *
 * @author emira
 */

public class ParalelProgramlama4 {

    public static void main(String[] args) {
        Thread ciftThread = new Thread(() -> {
            int number = 20;
            while (number > 0) {
                Thread.currentThread().setName("Çift Thread = " + number);
                System.out.println(Thread.currentThread().getName());
                number -= 2;
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread tekThread = new Thread(() -> {
            int number = 1;
            while (number < 20) {
                Thread.currentThread().setName("Tek Thread = " + number);
                System.out.println(Thread.currentThread().getName());
                number += 2;
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        ciftThread.start();
        tekThread.start();

        try {
            tekThread.join(); 
            ciftThread.join(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ciftThread.interrupt();
        tekThread.interrupt();

        System.out.println("Çift Thread is Alive: " + ciftThread.isAlive());
        System.out.println("Tek Thread is Alive: " + tekThread.isAlive());
    }
}
