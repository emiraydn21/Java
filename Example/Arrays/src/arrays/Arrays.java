package arrays;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
public class Arrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kaç elamanlı bir dizi oluştarmak istiyorsunuz? : ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Dizide kullanmak istediğiniz sayıları teker teker giriniz: ");
            numbers[i] = scanner.nextInt();
        }

//    for (int j = 0;j< n ; j++) {
//      int number = numbers[j];
//        boolean asalMi = true;
//        for (int k = 2; k < number; k++) {
//            if (number % k == 0) {
//                asalMi = false;
//                break;
//            }
//        }
//        if (asalMi) {
//            System.out.println(number + " Asaldır.");
//        } else {
//            System.out.println(number + " Asal değildir.");
//        }
        int toplam = 0;
        for (int i = 0; i < n; i++) {
            toplam += numbers[i];
        }
        int carpim = 1;
        for (int i = 0; i < n; i++) {
            carpim *= numbers[i];
        }
        double ortalama = (double) toplam / n;
        double result = Math.pow(toplam, 1.0 / n);
        System.out.println("***************************************");
        System.out.println("Girdiğiniz Sayıların Toplamı: " + toplam);
        System.out.println("Girdiğiniz Sayıların (nkökü) : " + result);
        System.out.println("Girdiğiniz Sayıların Çarpımı: " + carpim);
        System.out.println("Girdiğiniz Sayıların Ortalaması: " + ortalama);
    }

}
