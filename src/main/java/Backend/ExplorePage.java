/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import GUI.GUIManager;
import javax.swing.JFrame;
/**
 *
 * @author Hosam
 */
public class ExplorePage {
    
    private static ExplorePage Instance = null;
    
     public static ExplorePage Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new ExplorePage();
        }
        return Instance;
    }
    public void signOutButtom(JFrame explorePage, JFrame signInPage){
        try{
           explorePage.dispose();
           signInPage.show();
        }catch(Exception e){
           System.out.println(e);
           System.out.println("Error in signOut buttom method"); 
        }
    }
    public void eventsButtom(JFrame explorePage, JFrame eventsPage){
        try{
           explorePage.dispose();
           eventsPage.show();
        }catch(Exception e){
           System.out.println(e);
           System.out.println("Error in events buttom method"); 
        }        
    }
        public void bookButtom(JFrame explorePage, JFrame bookPage){
        try{
           explorePage.dispose();
           bookPage.show();
        }catch(Exception e){
           System.out.println(e);
           System.out.println("Error in book buttom method");
        }
    }
    public void miniSatusPanel(JFrame explorePage, JFrame miniStatusPage){
        try{
            explorePage.dispose();
            miniStatusPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in mini Staus Panel method");
        }
    }
    public void historicPaintingsPanel(JFrame explorePage, JFrame historicPaintingsPage){
        try{
           explorePage.dispose();
           historicPaintingsPage.show();
        }catch(Exception e){
           System.out.println(e);
           System.out.println("Error in historic paintings panel method"); 
        }
    }
    public void monumentsPanel(JFrame explorePage, JFrame monumentsPage){
        try{
           explorePage.dispose();
           monumentsPage.show();
        }catch(Exception e){
           System.out.println(e);
           System.out.println("Error in monuments panel method"); 
        }        
    }
}
