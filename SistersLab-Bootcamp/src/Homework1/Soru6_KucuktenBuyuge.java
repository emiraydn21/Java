package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru6:
if kullan
Girilen 3 sayiyi "kucukten buyuge" siralayan programi yaziniz.
*/
public class Soru6_KucuktenBuyuge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen ilk sayıyı girin: ");
        int sayi1 = scanner.nextInt();

        System.out.print("Lütfen ikinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        System.out.print("Lütfen üçüncü sayıyı girin: ");
        int sayi3 = scanner.nextInt();

        if (sayi1 <= sayi2 && sayi1 <= sayi3) {
            if (sayi2 <= sayi3) {
                System.out.println("Sıralama: " + sayi1 + " " + sayi2 + " " + sayi3);
            } else {
                System.out.println("Sıralama: " + sayi1 + " " + sayi3 + " " + sayi2);
            }
        } else if (sayi2 <= sayi1 && sayi2 <= sayi3) {
            if (sayi1 <= sayi3) {
                System.out.println("Sıralama: " + sayi2 + " " + sayi1 + " " + sayi3);
            } else {
                System.out.println("Sıralama: " + sayi2 + " " + sayi3 + " " + sayi1);
            }
        } else {
            if (sayi1 <= sayi2) {
                System.out.println("Sıralama: " + sayi3 + " " + sayi1 + " " + sayi2);
            } else {
                System.out.println("Sıralama: " + sayi3 + " " + sayi2 + " " + sayi1);
            }
        }
    }
}
