
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Purva
 */
public class test {
    
    public static void main(String[] args) throws Exception
    {
        File file = new File("C:\\Users\\Purva\\Documents\\NetBeansProjects\\BrickBreaker\\src\\resources\\dp.txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st; 
  while ((st = br.readLine()) != null) 
    System.out.println(st); 
    }
    
}
