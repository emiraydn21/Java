package mymathclass;

/**
 *
 * @author Emir AYDIN
 */
public class MyMath {

    static double pow(double taban, double üs) {
        double ret2 = 1;
        for (int i = 0; i < üs;) {
            if (üs >= 1) {

                ret2 = taban * ret2;  // ---->>>>  ret2*=taban;
                üs--;
            } else {
                ret2 *= Math.exp(üs * Math.log(taban));
                üs--;
            }
        }
        return ret2;

    }

    public static double mutlakDeger(double x) {
        if (x < 0) {
            return x * -1;
        } else {
            return x;
        }
    }

    public static int mutlakDeger(int x) {
        if (x < 0) {
            return x * -1;
        } else {
            return x;
        }
    }

    public static byte isEven(int x) {
        if (x % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }



    public static double Ln(double x) {

        double ln2 = 0.69314718055994530941723212145818;
        int x_int = (int) x - 1;

        if (x_int < 0) {
            return Double.NaN;
        }

        if (x_int == 0) {
            return 0;
        }

        if (x_int + 1 == 2) {
            return ln2;
        }

        if (x_int <= 0) {
            x_int = 1;
        }
        double sonuc = 0;

        for (int i = 1; i < 10; i++) {
            sonuc += isEven(i + 1) * (1 / Math.pow(x - 1, i)) * Math.pow(-x_int + x, i) / i;
        }

        return sonuc + Ln(x - 1);
    }

    public static double eUssu(double x) {
        double e = 2.7182818284590452353602874713527;
        int x_int = mutlakDeger((int) x);

        if ((mutlakDeger(x) - x_int) == 0.0) {
            if (x > 0) {
                return Math.pow(e, x_int); 
            } else {
                return 1 / Math.pow(e, x_int); 
            }
        }

        if (x <= 2 && x > 0) {
            return eUssuK2(x); 
        }
        
        double lna = mutlakDeger(x) / x_int;
        double a = eUssuK2(lna);
        if (x > 0) {
            return Math.pow(a, x_int); 
        } else {
            return 1 / Math.pow(a, x_int); 
        }
    }

    public static double eUssuK2(double x) {
        double sonuc = 0;
        for (int i = 0; i < 10; i++) {
            sonuc += Math.pow(x, i) / Faktoriyel(i);
        }

        return sonuc;
    }

    public static int Faktoriyel(int n) {
        if (n == 1 | n == 0) {
            return 1;
        } else {
            return (n * Faktoriyel(n - 1));
        }
    }

}
