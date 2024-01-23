/*
Java da iki yolla Threads oluşturulur.
"extends Thread" ile veya 
"impements Runnable" ile
Daha çok implements tercih edilir.
Çünkü extends ile yapınca 1 hak ile sınırlandırılmıştır.
*/
package paralelprogramlama;

/**
 *
 * @author emira
 */
public class ParalelProgramlama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExtendsThread threads1 = new ExtendsThread();
        threads1.start();
        
        ImplementsRunnable threads2 = new ImplementsRunnable();
        Thread tre = new Thread(threads2);
        tre.start();
    }
    
}
