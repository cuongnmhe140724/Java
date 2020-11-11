/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Minh Thanh
 */
class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        int xs[] = {100, 300, 500, 300};
        int ys[] = {100, 30, 100, 200};
        Polygon polygon = new Polygon(xs, ys, 4);
        g.fillPolygon(polygon);
        // mat ban

        g.setColor(Color.BLACK);
        int x1[] = {100, 300, 300, 100};
        int y1[] = {100, 200, 220, 120};
        Polygon poly1 = new Polygon(x1, y1, 4);
        g.fillPolygon(poly1);
        // khoi duoi mat ben trai

        g.setColor(Color.MAGENTA);
        int x2[] = {300, 500, 500, 300};
        int y2[] = {200, 100, 120, 220};
        Polygon poly2 = new Polygon(x2, y2, 4);
        g.fillPolygon(poly2);


        g.setColor(Color.gray);
        int x3[] = {100, 125, 125, 110, 100};
        int y3[] = {120, 130, 295, 300, 285};
        Polygon poly3 = new Polygon(x3, y3, 5);
        g.fillPolygon(poly3);
        // chan ben trai

        g.setColor(Color.LIGHT_GRAY);


        int x4[] = {285, 300, 320, 320, 300, 285};
        int y4[] = {212, 220, 210, 370, 380, 370};
        Polygon poly4 = new Polygon(x4, y4, 6);
        g.fillPolygon(poly4);
        // chan o giua

        g.setColor(Color.red);
        int x5[] = {475, 500, 500, 490, 475};
        int y5[] = {132, 120, 285, 300, 295};
        Polygon poly5 = new Polygon(x5, y5, 5);
        g.fillPolygon(poly5);
        // chan ben phai

        g.setColor(Color.BLACK);
        g.drawLine(110, 125, 110, 300);
        g.drawLine(300, 220, 300, 380);
        g.drawLine(490, 125, 490, 300);

    }
}

public class DrawTable {

    public static void main(String[] args) {
        JFrame t = new JFrame();
        MyPanel h = new MyPanel();
        t.setTitle("Test grapchics");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.add(h);
        t.setSize(1000, 600);
        t.setVisible(true);

        System.out.println();
    }
}
