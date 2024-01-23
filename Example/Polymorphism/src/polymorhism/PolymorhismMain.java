package polymorhism;

/**
 *
 * @author Emir AYDIN
 */
public class PolymorhismMain {

    public static void main(String[] args) {

        Sekiller sekiller = new Sekiller();
        Daire daire = new Daire();
        Elips elips = new Elips();
        Cokgenler cokgenler = new Cokgenler();
        Ucgen ucgen = new Ucgen();
        Kare kare = new Kare();
        Dikdörtgen dikdörtgen = new Dikdörtgen();
        EskenarDörtgen eskenarDörtgen = new EskenarDörtgen();

        Sekiller ref;
        ref = sekiller;
        ref.dogruParcası();

        System.out.println("-----------------------");

        ref = daire;
        daire.nokta();

        ref = elips;
        elips.nokta();

        System.out.println("-----------------------");

        ref = cokgenler;
        ref.dogruParcası();

        ref = ucgen;
        ref.dogruParcası();

        ref = kare;
        ref.dogruParcası();

        ref = dikdörtgen;
        ref.dogruParcası();

        ref = eskenarDörtgen;
        ref.dogruParcası();

    }
}
