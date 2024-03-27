package bilinearinterpolation;

/**
 *
 * @author emira
 */
//public class BilinearInterpolation {
//
//    /* Verilen {65, 121}, {93, 37} değerli 2X2 Boyutunda olan pikseli 
//        6X6 boyutuna ayarladığımızda arada oluşan satır ve sütunları 
//        Bilinear  Interpolation yöntemine göre iki sayı arasındaki farkı bulup,
//        arada oluşan değere bölüp sonuca ulaşıyoruz.
//    65 121 6X6 boyutuna çıkartılınca arada oluşan 5 adım için (121-65)/5 yapıp 
//    çıkan 11,2 sonucunu en yakın tam sayıya yuvarlayıp araya eklemek 
//    Örneğin 65 121 için 65 76 87 98 109 121 gibi
//     */
//
//    public static void main(String[] args) {
//        int[][] d = {{65, 121}, {93, 37}};
//
//        int[][] m = new int[6][6];
//
//        // Bilinear interpolasyon
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                // Normalleştirilmiş x ve y değerlerini hesaplayın .
//                double x = (double) j / 5;
//                double y = (double) i / 5;
//
//                // Bilinear interpolasyon formülü
//                // x ve y koordinatları arasındaki değeri hesaplayın.
//                int value = (int) (d[0][0] * (1 - x) * (1 - y)
//                        + d[0][1] * x * (1 - y)
//                        + d[1][0] * (1 - x) * y
//                        + d[1][1] * x * y);
//
//                // Hesaplanan değeri sonuç matrisine atayın.
//                m[i][j] = value;
//            }
//        }
//
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(m[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
public class BilinearInterpolation {
    public static void main(String[] args) {
        // Örnek kullanım
        int[][] originalMatrix = {{65, 121}, {93, 37}};
        int newRow = 6;
        int newColumn = 6;

        int[][] resizedMatrix = resizeMatrix(originalMatrix, newRow, newColumn);

        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newColumn; j++) {
                System.out.print(resizedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Bilinear interpolasyon kullanarak matrisi yeniden boyutlandıran metod
    public static int[][] resizeMatrix(int[][] originalMatrix, int newRow, int newColumn) {
        int[][] resizedMatrix = new int[newRow][newColumn];

        // Bilinear interpolasyon
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newColumn; j++) {
                double x = (double) j / (newColumn - 1); // Normalleştirilmiş x değeri (0 ile 1 arasında)
                double y = (double) i / (newRow - 1); // Normalleştirilmiş y değeri (0 ile 1 arasında)

                // Bilinear interpolasyon formülü
                int value = (int) (originalMatrix[0][0] * (1 - x) * (1 - y) +
                                   originalMatrix[0][1] * x * (1 - y) +
                                   originalMatrix[1][0] * (1 - x) * y +
                                   originalMatrix[1][1] * x * y);

                resizedMatrix[i][j] = value;
            }
        }

        return resizedMatrix;
    }
}
