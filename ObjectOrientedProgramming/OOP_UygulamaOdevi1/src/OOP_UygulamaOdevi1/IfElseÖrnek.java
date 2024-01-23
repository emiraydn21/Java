package OOP_UygulamaOdevi1;

/**
 *
 * @author Emir AYDIN
 */
public class IfElseÖrnek {

    public static void main(String[] args) {
        int hız = 110;
        if (hız > 90) {
            System.out.println("Radara Girdiniz.");
            if (hız > 90 && hız < 120) {
                System.out.println("Cezanız 200 TL");
            } else if (hız >= 120) {
                System.out.println("Cezanız 400 TL");
            }
        } else {
            System.out.println("Hızınız Gayet Normal");
        }
    }
}
