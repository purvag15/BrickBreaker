/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JFrame;

/**
 *
 * @author snigd
 */
public class Advanced 
{
    public static void main(String[] args) 
    {
        JFrame obj=new JFrame();
        obj.setResizable(false);
        obj.setBounds(0,0,1920,1080);
        Final gameplay=new Final();
        obj.setTitle("Brick Breaker");
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
    }
}
