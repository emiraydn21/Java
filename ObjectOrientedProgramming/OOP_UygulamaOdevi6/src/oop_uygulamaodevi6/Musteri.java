package oop_uygulamaodevi6;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
public class Musteri {

    String Musteri_Ad;
    String Musteri_Soyad;
    double Musteri_No;
    public double bakiye;

    public Musteri(String Musteri_Ad, String Musteri_Soyad, double Musteri_No, double bakiye) {
        this.Musteri_Ad = Musteri_Ad;
        this.Musteri_Soyad = Musteri_Soyad;
        this.Musteri_No = Musteri_No;
        this.bakiye = bakiye;

    }

    public void ParaCekme(double Cekilecek_Para) {
        this.bakiye -= Cekilecek_Para;
    }

    public void ParaYatırma(double Yatırılacak_Para) {
        this.bakiye += Yatırılacak_Para;
    }

    public double MusteriBakiyesi() {
        return this.bakiye;
    }
        public void bilgileriListele() {
        System.out.println("Müşteri Ad : " + Musteri_Ad + "\nMüşteri Soyad : " + Musteri_Soyad + "\nMüşteri No : " + Musteri_No + "\nBakiye : " + bakiye);
    }

}
 class Main{

    public static void main(String[] args) {
        Musteri musteri1 = new Musteri("Emir", "AYDIN",001,8500);
        Musteri musteri2 = new Musteri("Ahmet", "ACIR",002,3000);
        musteri1.bilgileriListele();
        musteri1.ParaCekme(1870);
        System.out.println("Yeni Bakiyeniz:" + musteri1.MusteriBakiyesi());
        System.out.println("*************************************************");
        
        musteri2.bilgileriListele();
        musteri2.ParaYatırma(50000);
        System.out.println("Yeni Bakiyeniz:" + musteri2.MusteriBakiyesi());
    }
 }

