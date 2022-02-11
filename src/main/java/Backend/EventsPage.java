/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import GUI.EventObject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Hosam
 */
public class EventsPage {
    
    private static EventsPage Instance = null;
    
     public static EventsPage Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new EventsPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    
    EventsPage(String database_URL, String database_name, String database_password){
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
    }
    
    public void setEvent(int eventID, JPanel eventPanel){
        ArrayList<String> eventInfo = new ArrayList<>();
        String eventName, eventTime, eventDate, eventImageURL;
        try{
            eventInfo= Database_handler.Instance().getEvent(eventID);
            eventName= eventInfo.get(0);
            eventTime= eventInfo.get(1)+" - "+eventInfo.get(2)+"\n";
            eventDate= eventInfo.get(3);
            eventImageURL= eventInfo.get(5);
            EventObject newEvent= new EventObject(eventName, eventImageURL, eventID);
            eventPanel.add(newEvent);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in setEvent Methiod");
        }
    }
    public void setEvents(JPanel eventPanel){
        int [] arrID;
       // arrID= database_methods.getAllEventsID();
        //for(int i=0; i<sizeof(arrID), i++){
        //    setEvent(i, eventPanel);
       // }
    }
    public void backButtom(JFrame currentPage, JFrame pervPage){
        try{
            currentPage.dispose();
            pervPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in back buttom method");
        }
    }
    
     public void CreateAllEvents(JPanel eventPanel){
         
        ArrayList<Integer> EventsID = Database_handler.Instance().getAllEventsID(); // this getsa all IDs of events in database
        
        String eventName, eventTime, eventDate, eventImageURL;
        
        try{
            for (Integer EventID : EventsID)  {                                     //goes through each Elements of these
            
             ArrayList<String> EventDetails= Database_handler.Instance().getEvent(EventID);
            
            eventName= EventDetails.get(0);
            eventTime= EventDetails.get(1)+" - "+EventDetails.get(2)+"\n";
            eventDate= EventDetails.get(3);
            eventImageURL= EventDetails.get(5);
            EventObject newEvent= new EventObject(eventName, eventImageURL, EventID);
            eventPanel.add(newEvent);
            }   
            
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in setEvent Methiod");
        }
    }
     
}
