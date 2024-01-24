package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru8:
Switch-case kullan
Kullanicdan iki deger alan ve kullanicinin 
toplama,cikarma,bolme,carpa islemlerinden birisini sectigi bir hesap makinesi uygulamasi yapin 
*/
public class Soru8_HesapMakinesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen ilk sayıyı girin: ");
        double sayi1 = scanner.nextDouble();

        System.out.print("Lütfen ikinci sayıyı girin: ");
        double sayi2 = scanner.nextDouble();

        System.out.println("Yapmak istediğiniz işlemi seçin:");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme");

        int secim = scanner.nextInt();
        double sonuc = 0;

        switch (secim) {
            case 1:
                sonuc = sayi1 + sayi2;
                break;
            case 2:
                sonuc = sayi1 - sayi2;
                break;
            case 3:
                sonuc = sayi1 * sayi2;
                break;
            case 4:
                // Bu durumda, sıfıra bölme durumunu if ile kontrol ediyoruz.
                if (sayi2 != 0) {
                    sonuc = sayi1 / sayi2;
                } else {
                    System.out.println("Hata: Sıfıra bölme hatası!");
                    return;
                }
                break;
            default:
                System.out.println("Geçersiz işlem seçimi!");
                return;
        }
        System.out.println("Sonuç: " + sonuc);
    }
}
