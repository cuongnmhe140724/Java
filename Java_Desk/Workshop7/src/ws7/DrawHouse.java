/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws7;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Minh Thanh
 */
class MyPanel1 extends JPanel {
    
    public void paintComponent(Graphics g) {
        // Draw the roof


        g.setColor(Color.red);
        int xs[] = {100, 160, 220};
        int ys[] = {100, 50, 100};
        Polygon poly = new Polygon(xs, ys, 3);
        g.drawPolygon(poly);
        g.fillPolygon(poly);

        // Draw the body of house
        g.setColor(Color.blue);
        g.fillRect(100, 100, 120, 120);

        // draw the door
        g.setColor(Color.white);
        g.fillRect(145, 160, 30, 60);

        // draw sun
        g.setColor(Color.yellow);
        g.fillOval(240, 30, 50, 50);

        //draw chimney
        g.setColor(Color.black);
        g.fillRect(120, 55, 10, 30);
        
    }
    
}

public class DrawHouse {
    
    public static void main(String[] args) {
        JFrame t = new JFrame();
        MyPanel1 h = new MyPanel1();
        t.setTitle("Test grapchics");
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.add(h);
        t.setSize(700, 600);
        t.setVisible(true);
        
        System.out.println();
    }
}
