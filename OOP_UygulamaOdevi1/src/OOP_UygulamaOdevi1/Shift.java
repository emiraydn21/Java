package OOP_UygulamaOdevi1;

/**
 *
 * @author Emir AYDIN
 */
public class Shift {

    public static void main(String[] args) {
        System.out.println(9 << 2);
        /*9 Sayısı 1001 e karşılık gelir. Bu Sayıyı 2 bit sola kaydırdığımızda bütün bitler 2 kere sola 
kaydırılır ve en sağdan 2 tane 0 gelir. Yeni sayımız 100100 olur. Bu da 36 sayısına Karşılık Gelir*/
        System.out.println(9 >> 2);
        /*9 Sayısı 1001 e karşılık gelir. Bu Sayıyı 2 bit sağa kaydırdığımızda en sağdaki 2 bit kaybolur ve 
kalan bitler 2 basamak sağa kayar. Yeni sayımız 0010 olur. Bu da 2 sayısına Karşılık Gelir*/
    }
}
