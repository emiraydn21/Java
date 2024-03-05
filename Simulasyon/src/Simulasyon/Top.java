package Simulasyon;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author emira
 */
public class Top {
    private int x, y, yarıçap, dx, dy;
    private Color renk;

    public Top(int x, int y, int yarıçap, int dx, int dy, Color renk) {
        this.x = x;
        this.y = y;
        this.yarıçap = yarıçap;
        this.dx = dx;
        this.dy = dy;
        this.renk = renk;
    }

    public void hareketEt() {
        x += dx;
        y += dy;
    }

    public boolean kesişiyor(Top diğerTop) {
        int dx = x - diğerTop.x;
        int dy = y - diğerTop.y;
        int mesafe = (int) Math.sqrt(dx * dx + dy * dy);
        return mesafe <= yarıçap + diğerTop.yarıçap;
    }

    public void çiz(Graphics g) {
        g.setColor(renk);
        g.fillOval(x - yarıçap, y - yarıçap, 2 * yarıçap, 2 * yarıçap);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getYarıçap() {
        return yarıçap;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
