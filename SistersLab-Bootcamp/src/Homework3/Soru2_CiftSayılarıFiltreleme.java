package Homework3;
/**
 *
 * @author emira
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/*
Soru-2: Cift Sayilari Filtreleme
Bir ArrayList icinde rastgele sayilari saklayin.
Cift sayilari bir HashSet icine ekleyip, tek sayilari bir ArrayList icine ekleyen bir program yazin.
*/
public class Soru2_CiftSayılarıFiltreleme {
    public static void main(String[] args) {
        ArrayList<Integer> sayiListesi = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            sayiListesi.add(random.nextInt(100));
        }

        System.out.println("Rastgele Sayılar: " + sayiListesi);

        Set<Integer> ciftSayilar = new HashSet<>();
        ArrayList<Integer> tekSayilar = new ArrayList<>();

        for (int sayi : sayiListesi) {
            if (sayi % 2 == 0) {
                ciftSayilar.add(sayi);
            } else {
                tekSayilar.add(sayi);
            }
        }

        System.out.println("Çift Sayılar: " + ciftSayilar);
        System.out.println("Tek Sayılar: " + tekSayilar);
    }
}


