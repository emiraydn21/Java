package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru9:
Switch-case kullan
Kullaniciya hangi geometrik seklin alanini hesaplamak istedigini sorun. 
Ardindan, secilen sekle gore gerekli bilgileri alarak alani hesaplayin. 
(1-Dikdortgen, 2-Kare, 3-Ucgen)
 */
public class Soru9_AlanHesaplama {
    public static void main(String[] args) {
        System.out.println("Hangi geometrik şeklin alanını hesaplamak istersiniz?");
        System.out.println("1. Dikdörtgen");
        System.out.println("2. Kare");
        System.out.println("3. Üçgen");
        System.out.print(":");
        Scanner scanner = new Scanner(System.in);
        int secim = scanner.nextInt();
        double alan = 0;
        
        switch (secim) {
            case 1:
                System.out.print("Dikdörtgenin uzun kenarını girin: ");
                double uzunKenar = scanner.nextDouble();
                System.out.print("Dikdörtgenin kısa kenarını girin: ");
                double kisaKenar = scanner.nextDouble();
                alan = uzunKenar * kisaKenar;
                break;
            case 2:
                System.out.print("Karenin kenar uzunluğunu girin: ");
                double kenar = scanner.nextDouble();
                alan = kenar * kenar;
                break;
            case 3:
                System.out.print("Üçgenin taban uzunluğunu girin: ");
                double taban = scanner.nextDouble();
                System.out.print("Üçgenin yüksekliğini girin: ");
                double yukseklik = scanner.nextDouble();
                alan = (taban * yukseklik)/2;
                break;
            default:
                System.out.println("Geçersiz seçim!");
                return;
        }
        System.out.println("Seçtiğiniz şeklin alanı: " + alan);
    }
}

