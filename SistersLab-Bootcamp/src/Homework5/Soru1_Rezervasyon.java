package Homework5;
/**
 *
 * @author emira
 */
import java.util.ArrayList;
import java.util.List;

public class Soru1_Rezervasyon {
    private List<Soru1_Bilet> biletListesi;

    public Soru1_Rezervasyon() {
        biletListesi = new ArrayList<>();
    }

    public void biletEkle(Soru1_Bilet bilet) {
        biletListesi.add(bilet);
    }

    public void biletRezerveEt(int koltukNumarasi) {
        for (Soru1_Bilet bilet : biletListesi) {
            if (bilet.getKoltukNumarasi() == koltukNumarasi && !bilet.isRezerveEdildiMi()) {
                bilet.rezervasyonYap();
                System.out.println("Bilet rezerve edildi.");
                return;
            }
        }
        System.out.println("Belirtilen koltuk numarası için uygun bilet bulunamadı veya zaten rezerve edilmiş.");
    }

    public void biletBilgileriniGoster() {
        for (Soru1_Bilet bilet : biletListesi) {
            System.out.println("Koltuk Numarası: " + bilet.getKoltukNumarasi() +
                    ", Durumu: " + (bilet.isRezerveEdildiMi() ? "Rezerve Edildi" : "Rezerve Edilmedi"));
        }
    }
}
