/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Color;
/**
 *
 * @author snigd
 */
public class Ball 
{
    public int ballX;
    public int ballY;
    public int ballXdir=-5;
    public int ballYdir=-10;
    Ball(int ballX, int ballY)
    {
        this.ballX=ballX;
        this.ballY=ballY;
    }
    void makeBall(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(ballX, ballY, 40, 40);
    }
    void ballMotion(int ballXdir,int ballYdir)
    {
        ballX=ballX+ballXdir;
        ballY+=ballYdir;
        if (ballX<0)
        {
            System.out.println("Ball x<0");
            ballXdir=-ballXdir;
        }
        if (ballY<0)
        {
            System.out.println("Ball y<0,ballYdir="+ballYdir);
            ballYdir=-ballYdir;
            System.out.println("Ball Ydir="+ballYdir);
        }
        if (ballX>1720)
        {
            ballXdir=-ballXdir;
        }
    }
    int returnX()
    {
        return ballX;
    }
    int returnY()
    {
        return ballY;
    }
}
