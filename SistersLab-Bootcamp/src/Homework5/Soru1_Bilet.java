package Homework5;
/**
 *
 * @author emira
 */
public class Soru1_Bilet {
    private int koltukNumarasi;
    private boolean rezerveEdildiMi;

    public Soru1_Bilet(int koltukNumarasi) {
        this.koltukNumarasi = koltukNumarasi;
        this.rezerveEdildiMi = false;
    }

    public int getKoltukNumarasi() {
        return koltukNumarasi;
    }

    public boolean isRezerveEdildiMi() {
        return rezerveEdildiMi;
    }

    public void rezervasyonYap() {
        this.rezerveEdildiMi = true;
    }
}
