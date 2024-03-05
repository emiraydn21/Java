package Simulasyon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emira
 */
public class TopSıçramaSimülasyonu extends JPanel {

    private ArrayList<Top> toplar;

    private static final int GENISLIK = 600;
    private static final int YUKSEKLIK = 600;

    public TopSıçramaSimülasyonu() {
        toplar = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) { //5 top olacağı için döngüde top sayısını 5 belirttik.
            int yarıçap = rand.nextInt(20) + 10; // 10 ile 30 arasında rastgele yarıçap oluşturuyoruz.
            int x = rand.nextInt(GENISLIK - 2 * yarıçap) + yarıçap; // x-koordinatı
            int y = rand.nextInt(YUKSEKLIK - 2 * yarıçap) + yarıçap; // y-koordinatı
            int dx = rand.nextInt(5) + 1; // Rastgele x yönündeki hız
            int dy = rand.nextInt(5) + 1; // Rastgele y yönündeki hız
            Color renk = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Rastgele renk
            toplar.add(new Top(x, y, yarıçap, dx, dy, renk));
        }

//16 milisaniye
        Timer zamanlayıcı = new Timer(16, e -> {
            for (Top top : toplar) {
                top.hareketEt();
                carpışmayıKontrolEt(top);
            }
            repaint();
        });
        zamanlayıcı.start();
    }

    private void carpışmayıKontrolEt(Top top) {
        int x = top.getX(); // Topun x koordinatını 
        int y = top.getY(); // Topun y koordinatını 
        int yarıçap = top.getYarıçap(); // Topun yarıçapı
        int dx = top.getDx(); // Topun x yönündeki hızını 
        int dy = top.getDy(); // Topun y yönündeki hızını 

        // Duvardaki x yönündeki hızını tersine çevir (sabit hızla sıçratma)
        if (x - yarıçap <= 0 || x + yarıçap >= GENISLIK) {
            top.setDx(-dx);
        }
        // y yönündeki hızını tersine çevir (sabit hızla sıçratma)
        if (y - yarıçap <= 0 || y + yarıçap >= YUKSEKLIK) {
            top.setDy(-dy);
        }

        // Toplar arasındaki çarpışmaları kontrol et
        for (Top digerTop : toplar) {
            if (top != digerTop && top.kesişiyor(digerTop)) {
                // Eğer iki top birbirine çarpıyorsa, hızlarını değiştir
                int tempDx = top.getDx(); // Geçici olarak topun x yönündeki hızını sakla
                int tempDy = top.getDy(); // Geçici olarak topun y yönündeki hızını sakla
                top.setDx(digerTop.getDx()); // Topun x yönündeki hızını diğer topun x yönündeki hızıyla değiştir
                top.setDy(digerTop.getDy()); // Topun y yönündeki hızını diğer topun y yönündeki hızıyla değiştir
                digerTop.setDx(tempDx); // Diğer topun x yönündeki hızını geçici olarak saklanan topun x yönündeki hızıyla değiştir
                digerTop.setDy(tempDy); // Diğer topun y yönündeki hızını geçici olarak saklanan topun y yönündeki hızıyla değiştir
                break; // Çift çarpışma durumunda ikinci çarpışmayı önlemek için döngüden çık
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension boyut = getSize();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, boyut.width, boyut.height); // Beyaz arka plan ile paneli temizle
        for (Top top : toplar) {
            top.çiz(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GENISLIK, YUKSEKLIK);
    }

    public static void main(String[] args) {
        JFrame çerçeve = new JFrame("Top Sıçrama Simülasyonu | Emir AYDIN");
        çerçeve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        çerçeve.setResizable(false);
        çerçeve.add(new TopSıçramaSimülasyonu());
        çerçeve.pack(); // Pencere boyutunu panelin boyutuna göre ayarla
        çerçeve.setLocationRelativeTo(null); //ekran ortasına yerleştirme
        çerçeve.setVisible(true); // Pencereyi görüntüle
    }
}
