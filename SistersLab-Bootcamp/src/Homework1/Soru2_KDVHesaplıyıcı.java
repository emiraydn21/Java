package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru2:
Switch-case kullanmadan gerekiyorsa if kullan
Eger girilen tutar 0 ve 1000 TL arasinda ise KDV orani %10 , 
tutar 1000 TL'den buyuk ise KDV oranini %22 olarak KDV tutari hesaplayan programi yaziniz.
 */
public class Soru2_KDVHesaplıyıcı {
    public static void main(String[] args) {
        // KDV oranları
        double kdvOrani1 = 0.10;  // 0 ile 1000 TL Arasındaki Tutarlarda Geçerli Olan
        double kdvOrani2 = 0.22;  // 1000 TL üzerindeki Tutarlarda Geçerli olan Oran

        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen tutarı girin: ");
        double tutar = scanner.nextDouble();

        double kdvTutari;

        if (tutar >= 0 && tutar <= 1000) {
            kdvTutari = tutar * kdvOrani1;
        } else {
            kdvTutari = tutar * kdvOrani2;
        }

        System.out.println("Girilen tutar: " + tutar);
        System.out.println("KDV Tutarı:" + kdvTutari);
    }
}
