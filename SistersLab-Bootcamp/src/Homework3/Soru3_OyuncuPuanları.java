package Homework3;
/**
 *
 * @author emira
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Soru: Oyuncu Puanlari
Bir oyuncu puan sistemini simule eden bir program yazin. 
Oyuncularin isimlerini anahtar, puanlarini deger olarak kullanarak bir HashMap icinde saklayin. 
Oyunculara puan eklemek ve puanlarini goruntulemek gibi islemleri gerceklestiren bir program yazin.
*/
public class Soru3_OyuncuPuanları {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> oyuncuPuanlari = new HashMap<>();

        while (true) {
            System.out.println("Oyuncu Puan Sistemi");
            System.out.println("1. Oyuncu Ekle");
            System.out.println("2. Puan Ekle");
            System.out.println("3. Puanları Görüntüle");
            System.out.println("4. Çıkış");
            System.out.print("1-4 arasında bir Seçim Yap: ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    oyuncuEkle(oyuncuPuanlari, scanner);
                    break;
                case 2:
                    puanEkle(oyuncuPuanlari, scanner);
                    break;
                case 3:
                    puanlariGoruntule(oyuncuPuanlari);
                    break;
                case 4:
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private static void oyuncuEkle(Map<String, Integer> oyuncuPuanlari, Scanner scanner) {
        System.out.print("Oyuncu adını girin: ");
        String oyuncuAdi = scanner.next();

        if (oyuncuPuanlari.containsKey(oyuncuAdi)) {
            System.out.println(oyuncuAdi + " oyuncusu zaten var.");
        } else {
            oyuncuPuanlari.put(oyuncuAdi, 0);
            System.out.println(oyuncuAdi + " oyuncusu başarıyla eklendi.");
        }
    }

    private static void puanEkle(Map<String, Integer> oyuncuPuanlari, Scanner scanner) {
        System.out.print("Puan eklemek istediğiniz oyuncunun adını girin: ");
        String oyuncuAdi = scanner.next();

        if (oyuncuPuanlari.containsKey(oyuncuAdi)) {
            System.out.print("Eklemek istediğiniz puanı girin: ");
            int eklenenPuan = scanner.nextInt();

            int mevcutPuan = oyuncuPuanlari.get(oyuncuAdi);
            oyuncuPuanlari.put(oyuncuAdi, mevcutPuan + eklenenPuan);
            System.out.println(oyuncuAdi + " oyuncusuna " + eklenenPuan + " puan eklendi.");
        } else {
            System.out.println(oyuncuAdi + " oyuncusu bulunamadı.");
        }
    }

    private static void puanlariGoruntule(Map<String, Integer> oyuncuPuanlari) {
        System.out.println("Oyuncu Puanları:");
        for (Map.Entry<String, Integer> entry : oyuncuPuanlari.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " puan");
        }
    }
}


