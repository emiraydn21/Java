package OOP_UygulamaOdevi1;

/**
 *
 * @author Emir AYDIN
 */
public class Break_Continue {

    public static void main(String[] args) {
        int a = 900;
        dur:
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 500; j++) {
                if (j < a) {
                    System.out.println("J a dan küçüktür.");
                    break;
                    //komutu tek bir sefer çalıştırıp durdurur
                } else if (j > a) {
                    System.out.println("J a dan büyüktür.");
                    continue;
                    //komutu i değerinin j ile döngüsü bitene kadar çalıştırır, sonra döngüden çıkılır. 
                } else {
                    System.out.println("J a ya eşittir.");
                    continue dur;
                    // eşittir komutu ile beraber dur komutu döngü bitene kadar sürekli output verir.
                }
            }
            System.out.println("Döngüden Çıkıldı");
            break dur;
            // dur komutu ile tek bir sefer Döngüden Çıkıldı yazılıp durdurulur.
        }
    }

}
