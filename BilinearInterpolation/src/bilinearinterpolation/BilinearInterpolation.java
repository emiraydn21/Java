package bilinearinterpolation;

/**
 *
 * @author emira
 */
public class BilinearInterpolation {

    /* Verilen {65, 121}, {93, 37} değerli 2X2 Boyutunda olan pikseli 
        6X6 boyutuna ayarladığımızda arada oluşan satır ve sütunları 
        Bilinear  Interpolation yöntemine göre iki sayı arasındaki farkı bulup,
        arada oluşan değere bölüp sonuca ulaşıyoruz.
    65 121 6X6 boyutuna çıkartılınca arada oluşan 5 adım için (121-65)/5 yapıp 
    çıkan 11,2 sonucunu en yakın tam sayıya yuvarlayıp araya eklemek 
    Örneğin 65 121 için 65 76 87 98 109 121 gibi
     */

    public static void main(String[] args) {
        int[][] d = {{65, 121}, {93, 37}};

        int[][] m = new int[6][6];

        // Bilinear interpolasyon
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Normalleştirilmiş x ve y değerlerini hesaplayın .
                double x = (double) j / 5;
                double y = (double) i / 5;

                // Bilinear interpolasyon formülü
                // x ve y koordinatları arasındaki değeri hesaplayın.
                int value = (int) (d[0][0] * (1 - x) * (1 - y)
                        + d[0][1] * x * (1 - y)
                        + d[1][0] * (1 - x) * y
                        + d[1][1] * x * y);

                // Hesaplanan değeri sonuç matrisine atayın.
                m[i][j] = value;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
