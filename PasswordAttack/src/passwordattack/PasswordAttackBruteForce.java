/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordattack;

/**
 *
 * @author emira
 */
public class PasswordAttackBruteForce {

    public static void main(String[] args) {
        String sifre = "aaa";
        String[] alfabe = {"a", "b", "c", "d", "e", "f", "g"};
        attachPass(sifre, alfabe);
    }

    private static void attachPass(String sifre, String[] alfabe) {
        int len = sifre.length();
        int alen = alfabe.length;
        String trypass = "";
        int h1, h2, h3;
        int atakSayisi = 0;

        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < alen; j++) {
                for (int k = 0; k < alen; k++) {
                    trypass = alfabe[i] + alfabe[j] + alfabe[k];
                    atakSayisi++; 
                    System.out.println(trypass);
                    if (sifre.equals(trypass)) {
                        System.out.println("Şifre " + atakSayisi + ". atakta bulundu.");
                        return; 
                    }
                }
            }
        }

        System.out.println("Şifre bulunamadı.");
    }
}
