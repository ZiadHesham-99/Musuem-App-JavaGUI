/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author bethoveen
 */
public class GUIManager {
    

    private static GUIManager Instance = null;
    
    // Constructor of this class
    // Here private constructor is is used to
    // restricted to this class itself
    private GUIManager()
    {
        
    }
    // Method
    // Static method to create instance of Singleton class
    public static GUIManager Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new GUIManager();
        }
        return Instance;
    }
    public void SwipePanel(JPanel panel,Point A, Point B) // From Line 46 ->63 Swipe panel 
                                                           // used to interpolate the Position of a given panel between two positions , acts as a imple animator 
    {
       
       try{  
           
       if(panel.getLocation().equals(A))
       {              
        panel.setLocation(B);
        System.out.println("A");
       }else if(panel.getLocation().equals(B)){
        panel.setLocation(A);
        System.out.println("A");
       }
       
       }catch(Exception e){System.out.println(e);}
 
        System.out.println(panel.getLocation());
    }
    
    public BufferedImage getScreenShotPAnel(Component C) // getScreenShotPAnel function from line 66 to 72 , it converts and returns all the content of the panel into a bufferedimage[GUI img] of same size as the given panel 
    {
        BufferedImage Img = new BufferedImage(C.getWidth(),C.getHeight(),BufferedImage.TYPE_INT_RGB);
        C.paint(Img.getGraphics());
        return Img;
    }
    
    public void SaveScreenShotPAnel(Component C, String File) throws Exception //Save ScreenshotPanel Function 73-77    it stores the output of the getScreenShotpanel as a png , used to store user's Tickets 
    {
        BufferedImage Img = getScreenShotPAnel(C);
        ImageIO.write(Img,"png" ,new File(File) );
    }
    
    public void setDynamicSize(JFrame TargetFrame,JPanel TargetPanel) //setDynamicSize 79->85  Calcualtes the position of the panels to center them dynamically to any screen resolution
    {
        Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
        TargetFrame.setLocation(dimen.width/2-TargetFrame.getSize().width/2 , dimen.height/2-TargetFrame.getSize().height/2);
        TargetFrame.setBackground(new Color(0,0,0,0));
        TargetPanel.setBackground(new Color(0,0,0,0));
    }
}

