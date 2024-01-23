package oop_uygulamaodevi9;

/**
 *
 * @author Emir AYDIN
 */
public class Sayilar {

    public int sayi1;
    public int sayi2;
    public int obeb;
    public int okek;
    public int[] asalCarpanlar;
    private boolean aralarindaAsal;

    public boolean aralarindaAsalKontrol(int sayi1, int sayi2) {
        // Eğer ikisi de 1'den büyükse
        if (sayi1 > 1 && sayi2 > 1) {
            // Eğer sayi1 ve sayi2 arasında asal ise
            if (sayi1 % sayi2 == 0 || sayi2 % sayi1 == 0) {
                aralarindaAsal = false;
            } else {
                aralarindaAsal = true;
            }
        } else {
            // Eğer ikisi de 1'den küçükse
            aralarindaAsal = false;
        }
        return aralarindaAsal;
    }

    public int obebHesapla(int sayi1, int sayi2) {
        for (int i = 1; i < sayi1; i++) {
            if (sayi1 % i == 0 && sayi2 % i == 0) {
                obeb = i;
            }
        }
        System.out.println("Obeb = " + obeb);
        return obeb;
    }

    public int okekHesapla(int sayi1, int sayi2) {
        int max = sayi1 * sayi2;
        /* 2 sayı eger aralarında asal ise ekoku
        çarpımlarıdır. Yanı 2 sayının ekoku maximum çarpımlarıdır.*/

        for (int i = max; i > 0; i--) {
            if (i % sayi1 == 0 && i % sayi2 == 0) {
                okek = i;
            }
        }
        System.out.println("Ekok = " + okek);
        return okek;
    }

    private int[] asalCarpanBul(int sayi1[]) {
        int sayac;
        
        for(int x =1;x<sayi1.length;x++){
            sayi1[x]= asalCarpanlar[x];
            sayac=0;
            for(int j=1; j<=sayi1[x];j++){
                if((sayi1[x]%j)==0){
                    sayac++;
                }
                   
            }
            if(sayac==2){
                System.out.println(sayi1[x] + "Asal sayıdır.");
            }
        }
        return sayi1;
    }

      
}


class BolunebilirSayilar extends Sayilar {

    boolean beseBolunur;
    int asalCarpanSayi;

    public void Goster() {
        aralarindaAsalKontrol(sayi1, sayi2);
        obebHesapla(sayi1, sayi2);
        okekHesapla(sayi1, sayi2);
         
    }

    public static void main(String[] args) {
        Sayilar s = new Sayilar();
        BolunebilirSayilar bs = new BolunebilirSayilar();
        System.out.println(bs.aralarindaAsalKontrol(3, 5));
        System.out.println(bs.obebHesapla(35, 65));
        System.out.println(bs.okekHesapla(35, 65));
    }
}
