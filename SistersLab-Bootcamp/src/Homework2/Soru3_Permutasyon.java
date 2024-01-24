package Homework2;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
3-Permutasyon hesaplama
*/
public class Soru3_Permutasyon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n değerini girin: ");
        int n = scanner.nextInt();

        System.out.print("r değerini girin: ");
        int r = scanner.nextInt();

        if (n < 0 || r < 0 || r > n) {
            System.out.println("n ve r pozitif tamsayılar olmalı, r <= n.");
        } else {
            long permutasyonSonucu = permutasyonHesapla(n, r);
            System.out.println("P(" + n + ", " + r + ") = " + permutasyonSonucu);
        }
    }
    
    public static long permutasyonHesapla(int n, int r) {
        return faktoriyel(n) / faktoriyel(n - r);
    }

    public static long faktoriyel(int sayi) {
        if (sayi == 0 || sayi == 1) {
            return 1;
        } else {
            return sayi * faktoriyel(sayi - 1);
        }
    }
}


