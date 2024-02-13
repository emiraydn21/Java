package Homework5;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
### Gundelik hayatta kullandiginiz bir uygulama, 
veya bir akis iceren(ucak bileti rezervasyonu) 
oop mantigina dokebileceginiz bir konuyu. 
OOP mantiklarini kullanarak koda dokmeye calisin
 */
public class Soru1_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Soru1_Ucak ucak = new Soru1_Ucak("İstanbul", "Ankara", "12:00");
        Soru1_Rezervasyon rezervasyonYoneticisi = new Soru1_Rezervasyon();

        // Örnek biletler oluşturulur ve rezervasyon yöneticisine eklenir
        for (int i = 1; i <= 10; i++) {
            Soru1_Bilet bilet = new Soru1_Bilet(i);
            rezervasyonYoneticisi.biletEkle(bilet);
        }

        int secim;
        do {
            System.out.println("1. Bilet Bilgilerini Göster");
            System.out.println("2. Bilet Rezervasyon Yap");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    rezervasyonYoneticisi.biletBilgileriniGoster();
                    break;
                case 2:
                    System.out.print("Rezerve etmek istediğiniz koltuk numarası: ");
                    int koltukNumarasi = scanner.nextInt();
                    rezervasyonYoneticisi.biletRezerveEt(koltukNumarasi);
                    break;
                case 3:
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        } while (secim != 3);

        scanner.close();
    }
}
