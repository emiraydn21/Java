package paralelprogramlama5;

import java.util.Random;
/**
 *
 * @author emira
 */
//Ana İş Parçaçığımızın İsmi
public class ParalelProgramlama5 {

    public static void main(String[] args) {

        int[] sayilar = new int[10];
        Random random = new Random();

        for (int i = 0; i < sayilar.length; i++) {
            sayilar[i] = random.nextInt(100);
        }

        EnBuyukSayi buyukSayi = new EnBuyukSayi(sayilar);
        EnKucukSayi kucukSayi = new EnKucukSayi(sayilar);

        buyukSayi.start();
        kucukSayi.start();

        try {

            buyukSayi.join();
            kucukSayi.join();

            int maxSayi = buyukSayi.getMaxSayi();
            int minSayi = kucukSayi.getMinSayi();

            int fark = maxSayi - minSayi;

            System.out.println("En büyük sayı: " + maxSayi);
            System.out.println("En küçük sayı: " + minSayi);
            System.out.println("Fark: " + fark);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
