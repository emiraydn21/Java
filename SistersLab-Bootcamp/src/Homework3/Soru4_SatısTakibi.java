package Homework3;
/**
 *
 * @author emira
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Soru: Satis Takibi
Bir sirketin satislarini takip eden bir program yazin. 
Her musterinin adini anahtar, satis miktarini deger olarak iceren bir HashMap kullanin. 
Toplam satis miktarini hesaplayarak en cok satis yapan musteriyi bulan bir program yazin.
*/
public class Soru4_SatısTakibi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> satislar = new HashMap<>();

        while (true) {
            System.out.println("Satış Takip Programı");
            System.out.println("1. Satış Ekle");
            System.out.println("2. En Çok Satış Yapan Müşteri");
            System.out.println("3. Çıkış");
            System.out.print("1-3 Arsında Bir Seçim Yapın : ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    satisEkle(satislar, scanner);
                    break;
                case 2:
                    enCokSatisYapanMusteriyiBul(satislar);
                    break;
                case 3:
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private static void satisEkle(Map<String, Double> satislar, Scanner scanner) {
        System.out.print("Müşteri adını girin: ");
        String musteriAdi = scanner.next();

        System.out.print("Satış miktarını girin: ");
        double satisMiktari = scanner.nextDouble();

        if (satislar.containsKey(musteriAdi)) {
            double mevcutSatis = satislar.get(musteriAdi);
            satislar.put(musteriAdi, mevcutSatis + satisMiktari);
        } else {
            satislar.put(musteriAdi, satisMiktari);
        }

        System.out.println(musteriAdi + " müşterisine " + satisMiktari + " birim satış eklendi.");
    }

    private static void enCokSatisYapanMusteriyiBul(Map<String, Double> satislar) {
        if (satislar.isEmpty()) {
            System.out.println("Henüz hiç satış yapılmamış.");
            return;
        }

        String enCokSatanMusteri = null;
        double enCokSatisMiktari = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : satislar.entrySet()) {
            if (entry.getValue() > enCokSatisMiktari) {
                enCokSatanMusteri = entry.getKey();
                enCokSatisMiktari = entry.getValue();
            }
        }

        System.out.println("En çok satış yapan müşteri: " + enCokSatanMusteri);
        System.out.println("Toplam satış miktarı: " + enCokSatisMiktari);
    }
}


