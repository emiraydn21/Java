package Homework5;
/**
 *
 * @author emira
 */
public class Soru1_Ucak {
    private String kalkisYeri;
    private String varisYeri;
    private String kalkisSaati;

    public Soru1_Ucak(String kalkisYeri, String varisYeri, String kalkisSaati) {
        this.kalkisYeri = kalkisYeri;
        this.varisYeri = varisYeri;
        this.kalkisSaati = kalkisSaati;
    }

    public String getKalkisYeri() {
        return kalkisYeri;
    }

    public String getVarisYeri() {
        return varisYeri;
    }

    public String getKalkisSaati() {
        return kalkisSaati;
    }
}
