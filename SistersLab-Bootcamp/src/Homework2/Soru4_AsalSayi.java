package Homework2;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
4-Girilen sayıyı asal mı kontrol eden program
 */
public class Soru4_AsalSayi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (sayi < 2) {
            System.out.println("Sayı asal değildir.");
        } else {
            if (asalMi(sayi)) {
                System.out.println(sayi + " sayısı asal bir sayıdır.");
            } else {
                System.out.println(sayi + " sayısı asal bir sayı değildir.");
            }
        }
    }
    
    public static boolean asalMi(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(sayi); i++) {
            if (sayi % i == 0) {
                return false;
            }
        }
        return true;
    }

}
