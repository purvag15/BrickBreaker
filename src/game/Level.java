/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

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
/**
 *
 * @author snigd
 */
public class Level extends JPanel implements KeyListener,ActionListener,MouseMotionListener
{
    private boolean play=false;//play is true when we have pressed the left or right button
    static int levelNo;
    private Timer timer;
    private int delay=4;//on decreasing delay variable speed of ball increases
    Level()
    {
        addKeyListener(this);
//        addMouseMotionListener(this);
        setFocusable(true);//This means thatwhenever a keyboard action is performed then the focus of that action is set on our panel and not anywhere else
        setFocusTraversalKeysEnabled(false);//setFocusTraversalKeysEnabled() decides whether or not focus traversal keys (TAB key, SHIFT+TAB, etc.) are allowed to be used when
        //the current Component has focus.
        timer=new Timer(delay,this);//(delay parameter, action listener)
        timer.start();
    }
    void setLevelNo()
    {
        levelNo=1;
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        System.out.println("Key Typed");
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        play=s.performKeyPress(e,play);
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        System.out.println("Key Released");
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        timer.start();
        
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        System.out.println("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        System.out.println("Mouse Moved");
    }
}
