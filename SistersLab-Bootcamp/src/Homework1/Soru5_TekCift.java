package Homework1;
/**
 *
 * @author emira
 */
import java.util.Scanner;
/*
Soru5:
if kullan
Kullanicidan bir sayi girmesini isteyen ve girilen sayinin 
tek mi yoksa cift mi oldugunu belirleyen bir Java programini yazin.
 */
public class Soru5_TekCift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (sayi % 2 == 0) {
            System.out.println("Girilen sayı çifttir.");
        } else {
            System.out.println("Girilen sayı tektir.");
        }
    }
}
