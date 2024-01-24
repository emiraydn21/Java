package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru3:
Switch-case kullanmadan gerekiyorsa if kullan
Not Hesaplama
Kullanicidan bir ogrencinin sinav notunu girmesini isteyen ve bu notun harf notunu hesaplayarak ekrana yazdiran bir Java programi yazin. 
(Ornegin, 90-100 arasi AA, 80-89 arasi BA, 70-79 arasi BB, 60-69 arasi CB, 50-59 arasi CC, 0-50 arasi FF)
 */
public class Soru3_NotHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen sınav notunu girin: ");
        int sinavNotu = scanner.nextInt();

        String harfNotu;

        if (sinavNotu >= 90 && sinavNotu <= 100) {
            harfNotu = "AA";
        } else if (sinavNotu >= 85 && sinavNotu < 90) {
            harfNotu = "AB";
        } else if (sinavNotu >= 80 && sinavNotu < 85) {
            harfNotu = "BA";
        } else if (sinavNotu >= 75 && sinavNotu < 80) {
            harfNotu = "BB";
        } else if (sinavNotu >= 70 && sinavNotu < 75) {
            harfNotu = "CA";
        } else if (sinavNotu >= 65 && sinavNotu < 70) {
            harfNotu = "CB";
        } else if (sinavNotu >= 60 && sinavNotu < 65) {
            harfNotu = "CC";
        } else if (sinavNotu >= 50 && sinavNotu < 60) {
            harfNotu = "DD";
        } else if (sinavNotu >= 0 && sinavNotu < 50) {
            harfNotu = "FF";
        } else {
            harfNotu = "Geçersiz not aralığı";
        }

        System.out.println("Harf Notu: " + harfNotu);
    }
}
