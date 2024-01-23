
package oop_uygulamaodevi3;

/**
 *
 * @author Emir AYDIN
 */
public class Sepet {
    // Bir Manavda Her bir üründen 2 adet alabaliceğiniz bir menü var 
    public static void main(String[] args) {
        Manav m1 = new Manav("Muz","Domates","Fıstık","Peynir",2); //Menü 1
        m1.setCerez("Çekirdek");
        System.out.println(m1.getCerez());
        Manav m2 = new Manav("Elma","Salatalık","Fındık","Zeytin",2); //Menü 2
        System.out.println(m2.getCerez());
        Manav m3 = new Manav("Mandalina","Patates","Leblebi","Saralle",2); //Menü 3
        System.out.println(m3.getCerez());
        // Menü 
    }
    
    
    
}
