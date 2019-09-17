/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

/**
 *
 * @author snigd
 */
public class Main extends JFrame
{
    public static void main(String[]args)
    {
        DisplayMode dm=new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
        Main i=new Main();
        i.run(dm);
    }
    private Screen s;
    private Image bg;
    private Image pic;
    private boolean loaded;
    //run method
    public void run(DisplayMode dm)
    {
        getContentPane().setBackground(Color.PINK);
        setForeground(Color.BLUE);
        setFont(new Font("Arial",Font.BOLD,24));
        loaded=false;
        s=new Screen();
        try
        {
            s.setFullScreen(dm,this);
            loadpics();
            try
            {
                Thread.sleep(5000);
            }
            catch(Exception e)
            {
                e.getMessage();
            }
        }
        finally
        {
            s.restoreScreen();
        }
    }
    public void paint(Graphics g)
    {
        if (g instanceof Graphics2D)
        {
            Graphics2D g2=(Graphics2D)g;g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
        }
        super.paint(g);
        if (loaded)
        {
            g.drawImage(bg,0,0,null);
        }
        addSlider(g);
        addBall(g);
    }

    private void loadpics() 
    {
        bg=new ImageIcon("E:\\BrickBreaker\\src\\game\\bg1.jpg").getImage();
        loaded=true;
        repaint();
    }
    void addSlider(Graphics g)
    {
        Slider s=new Slider();
        s.createSlider(g,860);
    }
    void addBall(Graphics g)
    {
        Ball ball=new Ball(940,780);
        ball.makeBall(g);
    }
}
