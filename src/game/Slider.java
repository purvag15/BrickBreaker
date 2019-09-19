/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author snigd
 */
public class Slider 
{
    final int sliderY=920;
    public int sliderX;
    void createSlider(Graphics g,int sliderX)
    {
        this.sliderX=sliderX;
        g.setColor(Color.BLACK);
        g.fillRect(sliderX, sliderY, 200, 16);
    }
    public int moveRight()
    {
        Final.play=true;
        sliderX+=50;
        return sliderX;
    }
     public int moveLeft()
    {
        Final.play=true;
        sliderX-=50;
        return sliderX;
    }
}
