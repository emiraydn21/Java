package Homework2;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
1-Fibonacci sayılarını özyinelemeli (recursive) olarak bulan program
 */
public class Soru1_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fibonacci serisini bulmak istediğiniz sayıyı giriniz: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Lütfen Pozitif bir sayı girin!");
        } else {
            System.out.print(n + " Sayısına göre Fibonacci Serisi:");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
