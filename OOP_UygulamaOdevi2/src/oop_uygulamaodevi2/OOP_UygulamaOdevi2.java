package oop_uygulamaodevi2;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
public class OOP_UygulamaOdevi2 {

    public static int length;
    static Scanner scanner = new Scanner(System.in);
    static String ogrenciler[][] = new String[6][2];
    static String notlar[][] = new String[6][5];

    public static int notHesapla(int vize, int fınal) {
        int ortalama = (int) (vize * 0.4d + fınal * 0.6d);
        return ortalama;
    }

    public static void main(String[] args) {
        for (int i = 0; (i < ogrenciler.length && i < notlar.length); i++) {
            System.out.print((i + 1) + ". Öğrencinin Adını Giriniz: ");
            ogrenciler[i][0] = scanner.nextLine();
            System.out.print((i + 1) + ". Öğrencinin Soyadını Giriniz: ");
            ogrenciler[i][1] = scanner.nextLine();
            System.out.print(ogrenciler[i][0] + "\t" + ogrenciler[i][1] + " adlı kişinin Vize Notunu Giriniz: ");
            notlar[i][0] = scanner.nextLine();
            System.out.print(ogrenciler[i][0] + "\t" + ogrenciler[i][1] + " adlı kişinin Final Notunu Giriniz: ");
            notlar[i][1] = scanner.nextLine();
            notlar[i][2] = String.valueOf(notHesapla(Integer.valueOf(notlar[i][0]), Integer.valueOf(notlar[i][1])));

            if (Integer.valueOf(notlar[i][2]) > 90) {
                notlar[i][3] = "AA";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 85) {
                notlar[i][3] = "AB";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 80) {
                notlar[i][3] = "BA";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 75) {
                notlar[i][3] = "BB";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 70) {
                notlar[i][3] = "BC";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 65) {
                notlar[i][3] = "CB";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 60) {
                notlar[i][3] = "CC";
                notlar[i][4] = "Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 55) {
                notlar[i][3] = "CD";
                notlar[i][4] = "Sorumlu Geçti";

            } else if (Integer.valueOf(notlar[i][2]) > 50) {
                notlar[i][3] = "DD";
                notlar[i][4] = "Sorumlu Geçti";
            } else {
                notlar[i][3] = "FF";
                notlar[i][4] = "Kaldı";
            }
        }
        System.out.println("\nAdı\tSoyadı\t\tVizesi\tFinali\tOrtalaması\tHarf Ve Geçme Durumu");

        for (int i = 0; i < notlar.length; i++) {
            System.out.println(ogrenciler[i][0] + "\t" + ogrenciler[i][1] + "\t\t"
                    + notlar[i][0] + "\t" + notlar[i][1] + "\t"
                    + notlar[i][2] + "\t\t" + notlar[i][3] + "\t" + notlar[i][4]);

        }
    }

}
