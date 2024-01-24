package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru7:
Switch-case kullan
Kullaniciya bir hava durumu kodu girmesini isteyin. 
Girdigi koda gore hava durumunu ekrana yazdirin.
*/
public class Soru7_HavaDurumu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen 1-4 arasında bir hava durumu kodunu girin: ");
        int havaDurumuKodu = scanner.nextInt();

        String havaDurumu;

        switch (havaDurumuKodu) {
            case 1:
                havaDurumu = "Güneşli";
                break;
            case 2:
                havaDurumu = "Bulutlu";
                break;
            case 3:
                havaDurumu = "Yağmurlu";
                break;
            case 4:
                havaDurumu = "Karlı";
                break;
            default:
                havaDurumu = "Geçersiz hava durumu kodu";
                break;
        }
        System.out.println("Hava Durumu: " + havaDurumu);
    }
}
