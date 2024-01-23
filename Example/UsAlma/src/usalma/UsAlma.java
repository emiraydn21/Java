package usalma;

/**
 * @author Emir AYDIN
 */
public class UsAlma {

    static double pow(double taban, double üs) {

        int c = 5;

//        int ret = 1;
        double ret2 = 1;
        for (int i = 0; i < üs;) {
            if (üs >= 1) {

                ret2 = taban * ret2;  // ---->>>>  ret2*=taban;
                üs--;
            } else {
                System.out.println("Alınan üs = " + üs);
                ret2*=Math.exp(üs*Math.log(taban));
                üs--;
            }
        }
        return ret2;

    }

    public static void main(String[] args) {
        double result1 = pow(2.1, 3.1);
        double result2 = Math.pow(2.1, 3.1);
        System.out.println("Ulaştığım Sonuç: " + result1);
        System.out.println("Gerçek Sonuç: " + result2);
    }
}