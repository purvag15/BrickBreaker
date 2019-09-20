/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Component;
import java.io.IOException;
/**
 *
 * @author snigd
 */
public class Level extends JPanel
{
    Slider s;
    Ball ball;
    int levelNo;
    Level(Graphics g,int k,int ballX,int ballY,int levelNo) throws IOException
    {
        this.levelNo=levelNo;
        addSlider(g,k);
        addBall(g,ballX,ballY);
        Map m=new Map();
        if (levelNo==1)
        {
            m.makeMap1(g);
        }
        else if (levelNo==2)
        {
            m.makeMap2(g);
        }
        else
        {
            m.makeMap3(g);
        }
    }
    void addSlider(Graphics g,int k)
    {
        s=new Slider();
        s.createSlider(g,k);
    }
    void addBall(Graphics g,int ballX,int ballY)
    {
        ball=new Ball(ballX,ballY);
        ball.makeBall(g);
    }
}
