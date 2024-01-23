package oop_uygulamaodevi7;

/**
 *
 * @author Emir AYDIN
 */
public abstract class Sekiller {

    public int cevre() {
        return 0;
    }

    public int alan() {
        return 0;
    }

    public void ciz() {
        System.out.println("Şekiller Çiziliyor..");
        System.out.println("*********************");
    }

}

class Cokgenler {

    public int kenar_sayisi;

    public void ciz() {
        System.out.println("Çokgen Çizildi");
    }

}

class Dikdörtgen extends Cokgenler {

    public int boy =3;
    public int en = 5;

    Dikdörtgen() {
        kenar_sayisi = 4;
    }

    public int cevre() {
        return (2 * (boy + en));
    }

    public int alan() {
        return (en *boy);
    }

    public void ciz() {
        System.out.println("Dikdörtgen Çizildi");
    }

}

class Kare extends Cokgenler {

    public int kenar_sayisi;

    Kare() {
        kenar_sayisi = 4;
    }

    public int cevre() {
        return (4 * kenar_sayisi);
    }

    public int alan() {
        return (int) (Math.pow(kenar_sayisi, 2));
    }

    public void ciz() {
        System.out.println("Kare Çizildi");
    }

}

class Daire extends Sekiller {

    private int yaricap1;
    private int yaricap2;

    Daire() {
        yaricap2 = yaricap1;
    }

    Daire(int yaricap) {
        yaricap1 = yaricap;
        yaricap2 = yaricap;
    }

    public int alan() {
        return (yaricap1 * yaricap2);
    }

    public void ciz() {
        System.out.println("Daire Çizildi");
    }

}

class Elips extends Daire {

    private int kenar_sayisi;

    public void ciz() {
        System.out.println("Elips Çizildi");
    }

}

class Main {

    public static void main(String[] args) {
        
               
        Dikdörtgen d = new Dikdörtgen();
        System.out.println(d.cevre());
        System.out.println(d.alan());
        d.ciz();

        Kare kare = new Kare();
        System.out.println(kare.cevre());
        System.out.println(kare.alan());
        kare.ciz();

        Daire daire = new Daire();
        System.out.println(daire.alan());
        daire.ciz();

        Elips elp = new Elips();
        elp.ciz();
    }
}
