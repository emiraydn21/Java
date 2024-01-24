package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/* 
Soru1:
Switch-case kullanmadan gerekiyorsa if kullan
kullanicidan alinan para degerinin KDV'li fiyatini ve KDV tutarini hesaplayip ekrana bastiran programi yazin.
KDV tutarini 30% 
KDV'siz Fiyat = 10;
KDV'li Fiyat = 13;
KDV tutari = 3;
 */
public class Soru1_KDVHesaplayıcı {
    public static void main(String[] args) {
        // KDV oranı
        double kdvOrani = 0.30;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen ödenecek Para miktarını girin: ");
        double Para = scanner.nextDouble();

        double kdvsizFiyat = Para;
        double kdvliFiyat = kdvsizFiyat * (1 + kdvOrani);
        double kdvTutari = kdvliFiyat - kdvsizFiyat;

        System.out.println("Kdvsiz Fiyat:" + kdvsizFiyat);
        System.out.println("Kdvli Fiyat:" + kdvliFiyat);
        System.out.println("Kdv Tutarı:" + kdvTutari);
    }
}
