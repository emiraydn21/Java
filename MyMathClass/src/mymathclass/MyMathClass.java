package mymathclass;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
public class MyMathClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Lütfen Double Türündeki İlk Sayıyı Giriniz: ");
        double sayi1 = scanner.nextDouble();
        System.out.print("Lütfen Double Türündeki İkinci Sayıyı Giriniz: ");
        double sayi2 = scanner.nextDouble();
        System.out.print("Lütfen Integer Türündeki Sayınızı Giriniz: ");
        int sayi3 = scanner.nextInt();
        System.out.println("~~~~~~~~~~~***********~~~~~~~~~~~");
        System.out.println("("+sayi1+")^("+sayi2 + ") = " +Math.pow(sayi1,sayi2));     //Math.pow Kütüphanesi Kullanarak Edinilen Sonuç
        System.out.println("("+sayi1+")^("+sayi2 + ") = " +MyMath.pow(sayi1,sayi2));   //Math.exp ve Math.log Kütüphanesi Kullanılarak Edinilen Sonuç
        System.out.println("Ln("+sayi1+ ") = " +MyMath.Ln(sayi1));              //Ln sayı
        System.out.println("(e)^("+ sayi3 + ") = "  + MyMath.eUssu(sayi3));     //e sayısı(2.7182818284590452353602874713527)nın İnteger Üssü
        System.out.println("(e)^("+ sayi1 + ") = "  + MyMath.eUssu(sayi1));     //e sayısı(2.7182818284590452353602874713527)nın Double Üssü
        System.out.println( sayi3+ "! = " + MyMath.Faktoriyel(sayi3));          //İnteger Sayının Faktöriyeli
        
        
        
        
    }

}
