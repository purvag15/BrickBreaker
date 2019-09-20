/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author snigd
 */
public class Map 
{
    public int brickX=150,brickY=150;
    char [] map1={'a','b','c','a','b','c','a'};
    char [] map2={'a','a','b','b','c','c','a'};
    char [] map3={'a','a','a','b','b','b','c'};
    int [][]A=new int[7][21];
    void addBrick(Graphics g,int x,int y,char type)
    {
        Rectangle brickRect=new Rectangle(x,y,70,60);
        Rectangle ballRect=new Rectangle(Final.ballX,Final.ballY,40,40);
        if (brickRect.intersects(ballRect))
        {
            Final.ballXdir=-Final.ballXdir;
            Final.ballYdir=-Final.ballYdir;
            playMusic("E:\\BrickBreaker\\src\\game\\brick.wav");
            A[(y-210)/60][(x-150)/70]=1;
            Final.score+=5;
        }
        for (int i=0;i<7;i++)
        {
            for (int j=0;j<21;j++)
            {
                System.out.print(A[i][j]+"\t");
                if (A[i][j]==0)
                {
                    Brick h=new Brick();
                    h.makeBrick(g, type, x, y);
                }
            }
            System.out.println("");
        }
    }
    public void toRight(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=0;i<n;i++)
        {
            type=map1[i];
            x=x+70;
            addBrick(g,x,y,type);
            
        }
        brickX=x;
        brickY=y;
    }
    public void toLeft(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=n-1;i>=0;i--)
        {
            type=map1[i];
            x=x-70;
            addBrick(g,x,y,type);
            
        }
        brickX=x;
        brickY=y;
    }
    public void toUp(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=n-1;i>=0;i--)
        {
            type=map1[i];
            y=y-60;
            addBrick(g,x,y,type);
            
        }
        brickX=x;
        brickY=y;
    }
    public void toDown(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=0;i<n;i++)
        {
            type=map1[i];
            y=y+60;
            addBrick(g,x,y,type);
            
        }
        brickX=x;
        brickY=y;
    }
    public void diagonalright(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=0;i<n;i++)
        {
            type=map1[i];
            addBrick(g,x,y,type);
            x=x+70;
            y=y+60;
        }
        brickX=x;
        brickY=y;
    }
    public void diagonalLeft(Graphics g,int x,int y,int n) throws IOException
    {
        char type;
        for (int i=0;i<n;i++)
        {
            type=map1[i];
             x=x-70;
            y=y+60;
            addBrick(g,x,y,type);
           
        }
        brickX=x;
        brickY=y;
    }
    public void diagonalUpRight(Graphics g,int x,int y,int n)
    {
        char type;
        for (int i=0;i<n;i++)
        {
            type=map1[i];
            x=x+70;
            y=y-60;
            addBrick(g,x,y,type);
            
        }
        brickX=x;
        brickY=y;
    }
    void makeMap1(Graphics g) throws IOException
    {
        toDown(g,brickX,brickY,7);
        diagonalUpRight(g,brickX,brickY,6);
        toDown(g,brickX,brickY,6);
        
        //Next Letter-O
        brickX+=140;
        brickY-=420;
        toDown(g,brickX,brickY,7);
        toRight(g,brickX,brickY,3);
        toUp(g,brickX,brickY,6);
        toLeft(g,brickX,brickY,3);
        
        //Next Letter-O
        brickX+=350;
        brickY-=60;
        toDown(g,brickX,brickY,7);
        toRight(g,brickX,brickY,3);
        toUp(g,brickX,brickY,6);
        toLeft(g,brickX,brickY,3);
        
        //Next Letter-B
        brickX+=350;
        brickY-=60;
        toDown(g,brickX,brickY,7);
        toRight(g,brickX,brickY,2);
        brickX+=70;
        toUp(g,brickX,brickY,2);
        brickY-=60;
        toUp(g,brickX,brickY,2);
        brickY-=60;
        toLeft(g,brickX,brickY,2);
        brickY+=180;
        brickX-=70;
        toRight(g,brickX,brickY,2);
    }
    void makeMap2(Graphics g) throws IOException
    {
        //digit 4
        brickX=150;
        brickY=150+5*60;
        diagonalUpRight(g,brickX,brickY,5);
        toDown(g,brickX,brickY,7);
        toRight(g,220,390,3);
        toRight(g,500,390,1);
        
       //Next Letter-O
        brickX+=240;
        brickY-=420;
        toDown(g,brickX,150,7);
        toRight(g,brickX,brickY,3);
        toUp(g,brickX,brickY,6);
        toLeft(g,brickX,brickY,3);      

        // digit 4
        diagonalUpRight(g,1200,450,5);
        toDown(g,brickX,brickY,7);
        toRight(g,1270,390,3);
        toRight(g,1550,390,1);
    }
    void makeMap3(Graphics g) throws IOException
    {
        //letter P
        toDown(g,brickX,50,7);
        toRight(g,brickX,110,3);
        toDown(g,brickX,110,2);
        toLeft(g,brickX,230,2);
       
        //letter R
        brickX=750;
        toDown(g,brickX,50,7);
        toRight(g,brickX,110,3);
        toDown(g,brickX,110,2);
        toLeft(g,brickX,230,2);
        diagonalright(g,750,230,3);
        toDown(g,960,410,1);
       
         //Next Letter-O
        brickX=1380;
        brickY=50;
        toDown(g,brickX,brickY,7);
        toRight(g,brickX,brickY,3);
        toUp(g,brickX,brickY,6);
        toLeft(g,brickX,brickY,3);
    }

    private void playMusic(String eBrickBreakersrcgamebrickwav) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
