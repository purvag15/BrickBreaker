package game;


import java.io.*;
import sun.audio.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Final extends JPanel implements KeyListener, ActionListener, MouseListener,MouseMotionListener
{
    public static boolean play=false;
    public static int score=0;
    private int totalBricks=21;
    private Timer timer;
    private int delay=4;
    private Image bg;
    private boolean loaded;
    static int sliderX=860;
    static int ballX=940,ballY=880,ballXdir=-2,ballYdir=-5;
    Level l;
    
    public Final() 
    {
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g)
    {
        if (g instanceof Graphics2D)
        {
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        super.paint(g);
        if (loaded)
        {
            g.drawImage(bg,0,0,null);
        }
        try 
        {
            //setBackground(g);
            l=new Level(g,sliderX,ballX,ballY);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        System.out.println("SliderX="+sliderX);
        loadpics();
    }
    
    private void loadpics() 
    {
        bg=new ImageIcon("E:\\BrickBreaker\\src\\game\\bg1.jpg").getImage();
        loaded=true;
        repaint();
    }
     private static void playMusic(String filepath) {
        InputStream music;
        try
        {
            music=new FileInputStream(new File(filepath));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        timer.start();
        if (play) 
        {
            if (new Rectangle(ballX,ballY,40,40).intersects(new Rectangle(sliderX, 920,200,8)))//When the slider rectangle had a height of 8 when the ball was falling down and it touched the bottom part of the slider it used to slide and again reflect
            {
                playMusic("C:\\Users\\kaulv\\Documents\\NetBeansProjects\\BrickBreaker\\src\\resources\\effect1.wav");
                ballYdir=-ballYdir;
                
                ballXdir=ballXdir+((ballX-sliderX-50)/10);
                if(ballXdir>7) ballXdir=7;
            }
//            A:for (int i=0;i<map.map.length;i++)//first map is object of MapGenerator class and second map is instance member matrix map
//            {
//                for (int j=0;j<map.map[0].length;j++)
//                {
//                    if (map.map[i][j]>0) 
//                    {
//                        
//                        int brickX=j*map.brickWidth+80;
//                        int brickY=i*map.brickHeight+50;
//                        int brickWidth=map.brickWidth;
//                        int brickHeight=map.brickHeight;
//                        Rectangle brickrect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
//                        Rectangle ballrect=new Rectangle(ballPositionX,ballPositionY,20,20);
//                        if (ballrect.intersects(brickrect))
//                        {
//                            map.setBrickValue(0, i, j);
//                            totalBricks--;
//                            score+=5;
//                            //Next if code is for the reflection of ball from the bricks
//                            if ((ballPositionX+19<=brickrect.x) || ballPositionX +1>=brickrect.x+brickrect.width)
//                            {
//                                ballXdir=-ballXdir;
//                            }
//                            else
//                            {
//                                ballYdir=-ballYdir;
//                            }
//                            break A;
//                        }
//                    }
//                }
//            }
            if (ballX<0)
            {
                ballXdir=-ballXdir;
            }
            if (ballY<0)
            {
                ballYdir=-ballYdir;
            }
            if (ballX>1880)
            {
                ballXdir=-ballXdir;
            }
            l.ball.ballMotion(ballXdir,ballYdir);
            ballX=l.ball.returnX();
            ballY=l.ball.returnY();
        }
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        System.out.println("Key Typed");
    }
    
     @Override
    public void keyReleased(KeyEvent e) 
    {
        System.out.println("Key Released");
    }
    
    @Override
    public void keyPressed(KeyEvent e) 
    {
        System.out.println("Key was pressed");
        if (e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if (l.s.sliderX>=1690)
            {
                l.s.sliderX=1720;
            }
            else
            {
                sliderX=l.s.moveRight();
                play=true;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if (l.s.sliderX<10)
            {
                l.s.sliderX=10;
            }
            else
            {
                sliderX=l.s.moveLeft();
                play=true;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if ((e.getX()>=l.s.sliderX) && (e.getX()<=l.s.sliderX+80))
        {
            System.out.println("Mouse Clicked");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        System.out.println("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        System.out.println("Mouse Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
//        if ((e.getX()>=l.s.sliderX) && (e.getX()<=l.s.sliderX+80))
//        {
//            System.out.println("Mouse Entered");
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        System.out.println("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        if ((e.getX()>=l.s.sliderX) && (e.getX()<=l.s.sliderX+80))
        {
            System.out.println("Mouse Dragged");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        
    }

   
}
