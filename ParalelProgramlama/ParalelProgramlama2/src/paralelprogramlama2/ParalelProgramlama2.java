/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paralelprogramlama2;

/**
 *
 * @author emira
 */
public class ParalelProgramlama2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
//            issAlive , getPriority, setPriority, 
//            Thread.currentThreaad, thread1.join,
//            getName, setName
//        Thread tho1=new ImplementsRunnable(i);
//        tho1.start();
//        
            ExtendsThread tho2 = new ExtendsThread(i);
            Thread thr = new Thread(tho2);
            thr.start();
        }

//        Thread thr1 = new Thread(new th2());
//        thr1.start();
    }

}
