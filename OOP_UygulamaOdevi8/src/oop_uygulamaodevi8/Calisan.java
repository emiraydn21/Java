package oop_uygulamaodevi8;

/**
 *
 * @author Emir AYDIN
 */
public abstract class Calisan {

    public String ad;
    public String soyad;
    private String TC;
    private int Maas;

    public String getTC() {
        String sonDortHarf = TC.substring(TC.length()-4);
        return "*******" + sonDortHarf;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public int getMaas() {
        return Maas;
    }

    public void setMaas(int Maas) {
        this.Maas = Maas;
    }

}

class Mudur extends Calisan {

    public String ad;
    public String soyad;

    public Mudur(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public Mudur() {
        setTC("11111111111");
        getTC();
        setMaas(16000);
        getMaas();
    }

}

class Personel extends Calisan {

    public String ad;
    public String soyad;

    public Personel(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public Personel() {
        setTC("22222222222");
        getTC();
        setMaas(5500);
        getMaas();
    }

}

class Main {

    public static void main(String[] args) {
        Mudur müdür = new Mudur();
        Personel personel = new Personel();
        System.out.println(müdür.getTC());
        System.out.println(müdür.ad = "Emir");
        System.out.println(müdür.soyad = "AYDIN");
        System.out.println(müdür.getMaas());
        System.out.println("**********************");
        System.out.println(personel.getTC());
        System.out.println(personel.ad = "Ahmet");
        System.out.println(personel.soyad = "ACIR");
        System.out.println(personel.getMaas());

    }
}
