/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacebattle;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author NgoQuyen
 */
public class MyAirplane implements Runnable{
    JLabel plane;
    int dx = 5, dy = 2; // Bước nhảy của máy bay theo trục x và trục y
    Point p;// p là tọa độ của máy bay
    
    // Kích thước màn hình
    Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
    int w_sizeScreen = sizeScreen.width;
    int h_sizeScreen = sizeScreen.height;
    
    public MyAirplane(JLabel plane, Point p) {
        this.plane = plane;
        this.p = p;
        plane = new JLabel(new ImageIcon("img/plane/plane4.png"));
        plane.setBounds(p.x, p.y, 130, 130);
        
    }
    
    @Override
    public void run() {
        while (true) {
            //plane.setBounds(p.x, p.y, 130, 130);
            System.out.println("???????????????????");
            plane.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}
                @Override
                public void keyPressed(KeyEvent e) {

                    switch ((int)e.getKeyCode()) {
                        case 37:// 37 left
                            p.x -= dx;
                            p = rule(p);
                            System.out.println(p.x + "    " + p.y);
                            break;
                        case 38:// 38 up
                            p.y -= dy;
                            p = rule(p);
                            break;
                        case 39:// 39 right
                            p.x += dx;
                            p = rule(p);
                            break;
                        case 40:// 40 down
                            p.y += dy;
                            p = rule(p);
                            break;
                        default:
                            System.out.println("AAAAAAAAAAAAA");
                            break;
                    }

                }
                @Override
                public void keyReleased(KeyEvent e) {}
            });
            
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyAirplane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    
    public Point rule(Point p) {
        if (p.x < 0) p.x = 0;
        if (p.y < 0) p.y = 0;
        if (p.x > (w_sizeScreen - 130)) p.x = (w_sizeScreen - 130);
        if (p.y > (h_sizeScreen - 130)) p.y = (w_sizeScreen - 130);
            
        return p;
    }
}
