/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import GUI.ArtPieceObject;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class ArtPiecePage {

    private static ArtPiecePage Instance = null;

     public static ArtPiecePage Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new ArtPiecePage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }

    ArtPiecePage(String database_URL, String database_name, String database_password){
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
    }
    public void setOneMonument(int monumentID , JPanel monumentPanel){
        ArrayList <String> monumentInfo = new ArrayList <>();
        String monumentName , monumentImageURL, monumentDetails;
        try {
            monumentInfo = Database_handler.Instance().getMonument(monumentID);
            monumentName = monumentInfo.get(0);
            monumentImageURL = monumentInfo.get(5);
            monumentDetails = monumentInfo.get(2);
            ArtPieceObject newArt = new ArtPieceObject(monumentName , monumentImageURL, monumentDetails);
            monumentPanel.add(newArt);

        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in setMonument Method");
        }
    }
    public void setAllMonuments(int Tag,JPanel monumentsPanel){
        try{
            ArrayList <Integer> monumentsID = new ArrayList<>();
            monumentsID = Database_handler.Instance().getAllMonumentsID(Tag);
            for(int i=0 ; i<monumentsID.size() ; i++){
                setOneMonument(monumentsID.get(i), monumentsPanel);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in setAllMonuments Method");
        }
    }
     public void backButtom(JFrame currentPage, JFrame pervPage){
        try{
            currentPage.dispose();
            pervPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in back button method");
        }
    }

}
