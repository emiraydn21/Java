package paralelprogramlama5;
/**
 *
 * @author emira
 */
public class EnKucukSayi extends Thread {

    private int[] sayilar;
    private int minSayi;

    public EnKucukSayi(int[] numbers) {
        this.sayilar = numbers;
    }

    @Override
    public void run() {
        minSayi = sayilar[0];

        for (int i = 1; i < sayilar.length; i++) {
            if (sayilar[i] < minSayi) {
                minSayi = sayilar[i];
            }
        }
    }

    public int getMinSayi() {
        return minSayi;
    }
}
