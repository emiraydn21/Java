package oop_uygulamaproje;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
//Sipariş Sınıfımız
public class Siparis {

    //2 tane private 1 tane public olmak üzere 3 tane değişkenimiz var.
    public int siparisNo;
    private String müsteriAdı;
    private double fiyat;

    public Siparis(int siparişNo, String müsteriAdı, double fiyat) {
        this.siparisNo = siparişNo;
        this.müsteriAdı = müsteriAdı;
        this.fiyat = fiyat;
    }

    public String getMüsteriAdı() {
        return müsteriAdı;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setMüsteriAdı(String müsteriAdı) {
        this.müsteriAdı = müsteriAdı;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public double hesaplaKdv() {
        return 0.0;
    }

    public double hesaplaToplamFiyat() {
        return fiyat + hesaplaKdv();
    }
}

class KahveSiparisi extends Siparis {

    public KahveSiparisi(int siparisNo, String müsteriAdı, double fiyat) {
        super(siparisNo, müsteriAdı, fiyat);
    }

    @Override
    public double hesaplaKdv() {
        return getFiyat() * 0.18;
    }
}

class SodaSiparisi extends Siparis {

    public SodaSiparisi(int siparisNo, String müsteriAdı, double fiyat) {
        super(siparisNo, müsteriAdı, fiyat);
    }

    @Override
    public double hesaplaKdv() {
        return getFiyat() * 0.08;
    }
}

class SiparisTest {

    public static void main(String[] args) {
        /* Bu kod bloğunda;
       Kullanıcıdan istenmeden direk oluşturduğumuz nesne üzerinden değişiklik yapabiliriz.
       
       Siparis s1 = new KahveSiparisi(1, "Emir", 5.0);
       Siparis s2 = new SodaSiparisi(2, "Ahmet", 3.0);
       
       System.out.println("1.Sipariş: " + s1.getMüsteriAdı() + " - " + s1.getFiyat());
       
       System.out.println("2.Sipariş: " + s2.getMüsteriAdı() + " - " + s2.getFiyat());
         */

        // Burada ise Kullanıcıdan ismini ve istediği siparişin türünü aldırtıyoruz.
        Scanner sc = new Scanner(System.in);
        System.out.print("Müşteri Adını Girin :");
        String müsteriAdı = sc.nextLine();

        String siparisTürü;
        System.out.print("Kahve mi istiyorsunuz, Soda mı? (Kahve = 1/Soda = 2) : ");
        siparisTürü = sc.nextLine();

        //Burada verdiği sipariş türüne göre önce doğruluğunu kontrol ediyoruz.
        //Daha sonra işlem doğru ise fiyatlandırma adımına geçiyoruz.
        Siparis siparis;
        if (siparisTürü.equalsIgnoreCase("1") || siparisTürü.equalsIgnoreCase("Kahve")) {
            siparis = new KahveSiparisi(1, müsteriAdı, 25);
        } else if (siparisTürü.equalsIgnoreCase("2") || siparisTürü.equalsIgnoreCase("Soda")) {
            siparis = new SodaSiparisi(2, müsteriAdı, 10);
        } else {
            System.out.println("Geçersiz sipariş türü");
            return;
        }
        System.out.println(siparis.siparisNo + " Nolu sipariş için KDV dahil : " + siparis.hesaplaToplamFiyat() + " TL 'lik bir ödemeniz vardır.");

        //Burada da işlemi onayladığımız türe göre sonuçlarımızı alıyoruz.
        System.out.println("Onaylıyor musunuz?");
        String islem = sc.nextLine();
        if (islem.equalsIgnoreCase("Evet")) {
            System.out.println(siparis.siparisNo + " Nolu sipariş bilgileri: "
                    + siparis.getMüsteriAdı() + " adlı müşterinin "
                    + siparis.hesaplaToplamFiyat() + " TL ödemesi gerçekleşmiştir.");
            System.out.println("Siparişiniz hazır. Afiyet olsun");
        } else {
            System.out.println("İşlem Reddedildi ve Sipariş Oluşturulamadı.");
            return;
        }

    }
}
