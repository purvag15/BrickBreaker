/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author snigd
 */
public class BackAndBorder 
{
    void addBackgroundColor(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,1920,1080);
    }
    void setBorders(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(0,0,10,1080);//left border
        g.fillRect(0,0,1920,10);//top border
        g.fillRect(1910,0,10,1080);//right border
    }
}
