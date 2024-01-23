package oop_uygulamaodevi3;

/**
 *
 * @author Emir AYDIN
 */
public class Manav {
   
    private String meyve, sebze, cerez, sarkuteri;
    private int adet;

    Manav(String meyve, String sebze, String cerez, String sarküteri, int fiyat) {
        this.meyve = meyve;
        this.sebze = sebze;
        this.cerez = cerez;
        this.sarkuteri = sarküteri;
       
        
    }

    public String getMeyve() {
        return meyve;
    }

    public void setMeyve(String meyve) {
        this.meyve = meyve;
    }

    public String getSebze() {
        return sebze;
    }

    public void setSebze(String sebze) {
        this.sebze = sebze;
    }

    public String getCerez() {
        return cerez;
    }

    public void setCerez(String cerez) {
        this.cerez = cerez;
    }

    public String getSarkuteri() {
        return sarkuteri;
    }

    public void setSarkuteri(String sarkuteri) {
        this.sarkuteri = sarkuteri;
    }

    public int getFiyat() {
        return adet;
    }

    public void setFiyat(int fiyat) {
        this.adet = fiyat;
    }

}
