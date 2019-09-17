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
    int ballX;
    int ballY;
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
}
