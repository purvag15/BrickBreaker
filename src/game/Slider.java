/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author snigd
 */
public class Slider 
{
    final int sliderY=820;
    private int sliderX;//Starting position of slider(310)
    String sliderColour;
    void createSlider(Graphics g,int sliderX)
    {
        g.setColor(Color.BLACK);
        g.fillRect(sliderX, sliderY, 200, 16);
        System.out.println("Slider was created");
    }
    //Normal Slider
    void sliderOpertion(int ballPositionX,int ballPositionY,int ballYdir)
    {
        if (new Rectangle(ballPositionX,ballPositionY,20,20).intersects(new Rectangle(sliderX, 550,100,2)))//When the slider rectangle had a height of 8 when the ball was falling down and it touched the bottom part of the slider it used to slide and again reflect
        {
                ballYdir=-ballYdir;
        }
    }
    //Realistic Slider
    void sliderOperation(int ballPositionX,int ballPositionY,int ballXdir,int ballYdir)
    {
        if (new Rectangle(ballPositionX,ballPositionY,20,20).intersects(new Rectangle(sliderX, 550,100,2)))//When the slider rectangle had a height of 8 when the ball was falling down and it touched the bottom part of the slider it used to slide and again reflect
        {
                System.out.println(ballXdir);
                ballYdir=-ballYdir;
                ballXdir=ballXdir+((ballPositionX-sliderX-50)/10);
        }
    }
    public boolean moveRight(boolean play)
    {
        play=true;
        sliderX+=20;
        return play;
    }
     public boolean moveLeft(boolean play)
    {
        play=true;
        sliderX-=20;
        return play;
    }
    public boolean performKeyPress(KeyEvent e,boolean play)
    {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if (sliderX>=600)
            {
                sliderX=600;
            }
            else
            {
                play=moveRight(play);
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if (sliderX<10)
            {
                sliderX=10;
            }
            else
            {
                play=moveLeft(play);
            }
        }
        return play;
    }
}
