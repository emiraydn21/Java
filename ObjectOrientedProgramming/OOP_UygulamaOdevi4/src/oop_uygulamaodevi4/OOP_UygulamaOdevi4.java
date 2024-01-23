
package oop_uygulamaodevi4;

import java.util.Scanner;

/**
 *
 * @author Emir AYDIN
 */
public class OOP_UygulamaOdevi4 {

   
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String OgrenciAdı[] = {"Emir","Veli","Ahmet","Can"};
       String OgrenciSoyadı[] = {"AYDIN","ATEŞ","ACIR","ERŞEN"};
       String email[] = {"emir.aydn21@gmail.com","veli@gmail.com","a.acir@gmail.com","can.ersen@gmail.com"};
       int OgrenciNo[] = {1,2,3,4};
       System.out.println("Öğrenci No Giriniz:" );
       int no=scanner.nextInt();
       for(int i=0;i<OgrenciNo.length;i++){
           if(no==OgrenciNo[i]){
               System.out.println("Öğrenci Numaranız:" +OgrenciNo[i]);
               System.out.println("Öğrenci Adı:" +OgrenciAdı[i]);
               System.out.println("Öğrenci Soyadı:" +OgrenciSoyadı[i]);
               System.out.println("Öğrenci Emaili:" +email[i]);
           }
               
           
       }
       
    }
    
    }
