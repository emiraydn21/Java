package Homework2;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
2-Palindrom kontrolü yapan metod:
*/
public class Soru2_Palindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (isPalindrom(sayi)) {
            System.out.println(sayi + " palindrom bir sayıdır.");
        } else {
            System.out.println(sayi + " palindrom bir sayı değildir.");
        }
    }
    public static boolean isPalindrom(int num) {
        int originalSayi = num;
        int tersSayi = 0;

        while (num > 0) {
            int sonBasamak = num % 10;
            tersSayi = tersSayi * 10 + sonBasamak;
            num /= 10;
        }
        return originalSayi == tersSayi;
    }
}
