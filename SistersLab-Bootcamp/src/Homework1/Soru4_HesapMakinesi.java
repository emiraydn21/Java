package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru4:
Switch-case kullanmadan gerekiyorsa if kullan
Basit Hesap Makinesi
Kullanicidan iki sayi girmesini isteyen ve ardindan bu iki sayi uzerinde 
toplama, cikarma, carpma ve bolme islemlerini gerceklestiren bir Java programi yazin.
*/
public class Soru4_HesapMakinesi {
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

        if (secim == 1) {
            sonuc = sayi1 + sayi2;
        } else if (secim == 2) {
            sonuc = sayi1 - sayi2;
        } else if (secim == 3) {
            sonuc = sayi1 * sayi2;
        } else if (secim == 4) {
            // Bu if bloğunu, sıfıra bölme durumunu kontrol etmek için kullanıyoruz.
            if (sayi2 != 0) {
                sonuc = sayi1 / sayi2;
            } else {
                System.out.println("Sıfıra bölme hatası!");
                return;
            }
        } else {
            System.out.println("Geçersiz işlem!");
            return;
        }
        System.out.println("Sonuç: " + sonuc);
    }
}
