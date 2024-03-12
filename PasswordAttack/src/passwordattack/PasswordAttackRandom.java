/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordattack;

/**
 *
 * @author emira
 */
public class PasswordAttackRandom {

    public static void main(String[] args) {
        String sifre = "abc";
        String[] alfabe = {"a", "b", "c", "d", "e", "f", "g"};
        attachPass(sifre, alfabe);
    }

    private static void attachPass(String sifre, String[] alfabe) {
        int len = sifre.length();
        String trypass = "";
        int atakSayisi = 0;

        while (!sifre.equals(trypass)) {
            int h1 = (int) Math.floor((Math.random() * len));
            int h2 = (int) Math.floor((Math.random() * len));
            int h3 = (int) Math.floor((Math.random() * len));
            trypass = alfabe[h1] + alfabe[h2] + alfabe[h3];
            System.out.println(trypass);
            atakSayisi++; 
        }

        System.out.println("Şifre " + atakSayisi + ". atakta bulundu.");
    }
}
