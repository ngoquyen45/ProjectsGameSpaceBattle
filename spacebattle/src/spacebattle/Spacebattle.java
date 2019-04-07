/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacebattle;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nhóm BTL Lập Trình 
 */
public class Spacebattle implements MouseListener{
    // Button Play
    JButton buttonPlay;
    
    // Image (Dữ liệu ảnh có thển được tái sử dụng
    JLabel galaxyBackground = new JLabel(new ImageIcon("img/playscreen/galaxy.png"));
    JLabel gameBackground = new JLabel(new ImageIcon("img/gamescreen/gamegalaxy.png"));
    
    
    JLabel test;
    Point p = new Point(600, 400);
    
    
    
    
    
    
    
    // Kích thước màn hình
    Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
    int w_sizeScreen = sizeScreen.width;
    int h_sizeScreen = sizeScreen.height;
    
    // Khởi tạo ra các đối tượng
    //1. Frame play
    JFrame fPlayScreen;
    int w_fPlayScreen = 900, h_fPlayScreen = 600;
    
    //2. Frame game
    JFrame fGameScreen;
    int w_fGameScreen = w_sizeScreen, h_fGameScreen = w_sizeScreen;
    
    //Hàm khởi tạo

    public Spacebattle() {
        initialScreenPlay(); // Khoi tao man hinh choi
        

    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Spacebattle sb = new Spacebattle();
        
    }

    private void initialScreenPlay() {
        
        // Tạo background bằng JLabel
        fPlayScreen = new JFrame();
        fPlayScreen.setBounds((w_sizeScreen - w_fPlayScreen) / 2,
                                (h_sizeScreen - h_fPlayScreen) / 2,
                                w_fPlayScreen, h_fPlayScreen);
        
        
        galaxyBackground.setSize(w_fPlayScreen, h_fPlayScreen);
        
        fPlayScreen.setUndecorated(true);
        fPlayScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fPlayScreen.setResizable(false);
        
        // Tạo button để vào chơi
        buttonPlay = new JButton();
        buttonPlay.setIcon(new ImageIcon("img/playscreen/buttonplaygame.png"));
        buttonPlay.setBounds((w_fPlayScreen - 271) / 2,
                                (h_fPlayScreen - 93) / 2,
                                271, 93);
        // Tắt chế độ mặc định của button
        buttonPlay.setOpaque(false);
        buttonPlay.setContentAreaFilled(false);
        buttonPlay.setBorderPainted(false);
        
        // Add event for button
        buttonPlay.addMouseListener(this);

        
        fPlayScreen.add(buttonPlay);
        fPlayScreen.add(galaxyBackground);
        fPlayScreen.setVisible(true);
    }

    private void initialFrameGame() {
        // Tạo background bằng FJLabel
        fGameScreen = new JFrame();
        fGameScreen.setSize(w_sizeScreen, h_sizeScreen);
        gameBackground.setSize(w_sizeScreen, h_sizeScreen);
        //System.out.println("Above 1");
        
        
        
        
        
        test = new JLabel(new ImageIcon("img/plane/plane4.png"));
        test.setBounds(p.x, p.y, 130, 130);
        MyAirplane mp = new MyAirplane(test, p);
        Thread t = new Thread(mp);
        t.start();
        
        fGameScreen.add(test);
        fGameScreen.add(gameBackground);
        fGameScreen.setUndecorated(true);
        fGameScreen.setLayout(null);
        fGameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fGameScreen.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("May co o day ?");
        fPlayScreen.dispose();
        initialFrameGame();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
