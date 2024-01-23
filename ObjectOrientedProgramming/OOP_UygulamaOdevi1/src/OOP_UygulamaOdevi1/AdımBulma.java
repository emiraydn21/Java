package OOP_UygulamaOdevi1;

/**
 *
 * @author Emir AYDIN
 */
public class AdımBulma {

    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            if (i % 100 == 0) {
                System.out.println(i + ".adım");
            } else {
                System.out.println(i);
            }
        }
        System.out.println("Döngü Bitmiştir.");
    }
}
