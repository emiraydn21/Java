package passwordattack;

/**
 *
 * @author emira
 */
public class PasswordAttackBruteForceRecursive {

    public static void main(String[] args) {
        String sifre = "abcd";
        String[] alfabe = {"a", "b", "c", "d", "e", "f", "g"};
        attachPass(sifre, alfabe, "", sifre.length(), new int[]{0});
    }

    private static void attachPass(String sifre, String[] alfabe, String trypass, int len, int[] atakSayisi) {
        if (len == 0) {
            System.out.println(trypass);
            atakSayisi[0]++; 
            if (sifre.equals(trypass)) {
                System.out.println("Şifre " + atakSayisi[0] + ". atakta bulundu.");
                System.exit(0); // Şifre bulunduğunda programı sonlandır
            }
        } else {
            for (int k = 0; k < alfabe.length; k++) {
                attachPass(sifre, alfabe, trypass + alfabe[k], len - 1, atakSayisi);
            }
        }
    }
}
