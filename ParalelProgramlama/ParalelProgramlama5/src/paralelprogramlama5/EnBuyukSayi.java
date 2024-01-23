package paralelprogramlama5;
/**
 *
 * @author emira
 */
public class EnBuyukSayi extends Thread {

    private int[] sayilar;
    private int maxSayi;

    public EnBuyukSayi(int[] sayilar) {
        this.sayilar = sayilar;
    }

    @Override
    public void run() {
        maxSayi = sayilar[0];

        for (int i = 1; i < sayilar.length; i++) {
            if (sayilar[i] > maxSayi) {
                maxSayi = sayilar[i];
            }
        }
    }

    public int getMaxSayi() {
        return maxSayi;
    }
}
