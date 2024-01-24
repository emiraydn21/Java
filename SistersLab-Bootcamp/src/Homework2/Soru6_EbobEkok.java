package Homework2;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
6-Ebob ve Ekok bulma
*/
public class Soru6_EbobEkok {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("İlk sayıyı girin: ");
        int sayi1 = scanner.nextInt();

        System.out.print("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();

        int ebob = Ebob(sayi1, sayi2);
        int ekok = Ekok(sayi1, sayi2);

        System.out.println("Ebob: " + ebob);
        System.out.println("Ekok: " + ekok);
    }

    public static int Ebob(int a, int b) {
        while (b != 0) {
            int gecici = b;
            b = a % b;
            a = gecici;
        }
        return a;
    }

    public static int Ekok(int a, int b) {
        return (a * b) / Ebob(a, b);
    
    }
}
