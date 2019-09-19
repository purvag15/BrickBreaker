/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author snigd
 */
public class Brick 
{
    static int height,width,x,y;
    int noOfHitsTaken;
    boolean destroyed;
    char colour;
    int health;
    void makeBrick(Graphics g,char a,int x,int y)
    {
            this.x=x;
            this.y=y;
            colour=a;
            if (a=='a')
            {
                g.setColor(Color.BLACK);
                health=3;
            }
            else if (a=='b')
            {
                g.setColor(Color.PINK);
                health=2;
            }
            else 
            {
                g.setColor(Color.LIGHT_GRAY);
                health=1;
            }
            g.fillRect(x,y,70,60);
            g.setColor(Color.BLUE);
            g.drawRect(x,y,70,60);
    }
}
