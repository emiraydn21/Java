package Homework3;
/**
 *
 * @author emira
 */
    import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Soru-1: Ogrenci Notlari
Bir ogrenci not takip sistemi yazin. 
Her ogrencinin adini anahtar, notunu deger olarak iceren bir HashMap kullanarak,
kullaniciya ogrenci eklemesini ve bir ogrencinin notunu sorgulamasini saglayan bir program yapin.
*/
public class Soru1_OgrenciNotları {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ogrenciNotlari = new HashMap<>();

        while (true) {
            System.out.println("Öğrenci Not Takip Sistemi");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Öğrenci Not Sorgula");
            System.out.println("3. Çıkış");
            System.out.print("1-3 Arasında Bir Seçim Yapın : ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    ogrenciEkle(ogrenciNotlari, scanner);
                    break;
                case 2:
                    ogrenciNotSorgula(ogrenciNotlari, scanner);
                    break;
                case 3:
                    System.out.println("Programdan Çıkılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz Seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    private static void ogrenciEkle(Map<String, Integer> ogrenciNotlari, Scanner scanner) {
        System.out.print("Öğrenci Adını Girin: ");
        String ogrenciAdi = scanner.next();

        System.out.print("Öğrenci Notunu Girin: ");
        int ogrenciNotu = scanner.nextInt();

        ogrenciNotlari.put(ogrenciAdi, ogrenciNotu);
        System.out.println(ogrenciAdi + " öğrencisi başariyla eklendi.");
    }

    private static void ogrenciNotSorgula(Map<String, Integer> ogrenciNotlari, Scanner scanner) {
        System.out.print("Notunu sorgulamak istediginiz öğrenci adını girin: ");
        String ogrenciAdi = scanner.next();

        if (ogrenciNotlari.containsKey(ogrenciAdi)) {
            int ogrenciNotu = ogrenciNotlari.get(ogrenciAdi);
            System.out.println(ogrenciAdi + " öğrencisinin notu: " + ogrenciNotu);
        } else {
            System.out.println(ogrenciAdi + " öğrencisi bulunamadı.");
        }
    }
}


