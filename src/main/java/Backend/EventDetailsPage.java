/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Hosam
 */
public class EventDetailsPage {
    
    private static EventDetailsPage Instance = null;
    
    public static EventDetailsPage Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new EventDetailsPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    
    private int eventID ; 
    
    public EventDetailsPage(String database_URL, String database_name, String database_password) {
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
    }
    public void showEventDetails(JLabel[] eventImageNameTimeDateBreif){
        ArrayList<String> eventInfo= new ArrayList<>();
        try{
            eventInfo= Database_handler.Instance().getEvent(this.eventID);
            //Image
            
            String imageURL= eventInfo.get(5); 
            ImageIcon imageIcon= new ImageIcon(getClass().getResource(imageURL));
            eventImageNameTimeDateBreif[0].setIcon(imageIcon);
            //name
            eventImageNameTimeDateBreif[1].setText(eventInfo.get(0));
            //Time
            eventImageNameTimeDateBreif[2].setText(eventInfo.get(1)+
                    " - "+eventInfo.get(2));
            //Date
            eventImageNameTimeDateBreif[3].setText(eventInfo.get(3));
            //Brief
            eventImageNameTimeDateBreif[4].setText(eventInfo.get(4));
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in show event details method");
        }
    }
    public void bookEventTicketButtom(JFrame currentPage, JFrame nextPage){
        try{
            currentPage.dispose();
            nextPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in book event ticket buttom method");
        }        
    }
    /**
     * @return the eventID
     */
    public int getEventID() {
        return this.eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
}
