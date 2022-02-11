/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.sql.*;
import java.util.ArrayList;  
import java.sql.SQLException;
import java.util.Iterator;
/**
 *
 * @author ziad
 */
public class Database_handler {
    /*database  link and username and password */
    public String URL , username ,password ;
    public  Connection connect;
    /*the constructor of Database_handler tintialize  database link , username and password but it could be changed by setters  */
   
    private  static Database_handler Instance = null;
    
    public static Database_handler Instance(String database_URL,String databaseUsername,String Password)
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new Database_handler(database_URL,databaseUsername,Password);
        }
        return Instance;
    }
    
    public static Database_handler Instance()
    {
        if (Instance == null) {
            Instance = new Database_handler("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    public Database_handler (String URL , String username  , String password ){
        this.URL = URL ;
        this.username = username;
        this.password = password;
        connect();
    }
    
    
    /*******************************  connect to data base    *********************************************************************************************************/
    //takes void return boolean true if a there is a connection  or false if falied   
    private boolean connect(){
        try{
            // Get a connection to database
            
             connect = DriverManager.getConnection(this.URL ,this.username , this.password);
            System.out.println("DB: Connecteed ......");
            return(true);
            }
        catch(Exception e){
            // if the connection fails print the exception and return false 
        
            System.out.println(e);
            System.out.println("DB: Failed.............................!");
            return(false);
            }
    }  
    /****************************************************************************************************************************************************************/

    
    
    
    
    
    /********************************************************************* Insert into visitor table **************************************************/
    /*String name and Email and Password  , int age  , boolean gender -> 1 male   ->0 Female    , int status...... 1->egyptian  2->forigner->  3->student  4->guide*/
    //return boolean 
    public boolean insertVisitor(String Name,String National_ID,String Phone_number ,String Password ,String Email ,int Age , boolean Gender , String Status ){
       //Converting all arguments to Strings so we can inser them into the database
        String S_Age = Integer.toString(Age);
        String S_Gender ;
        if(Gender){
            S_Gender = "Male";
        }
        else{
            S_Gender = "Female";
        }
        
        try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `visitor` ( `Email`, `Password`, `Name`,`National_ID`,`phone number`, `Age`, `Gender`, `Status`) VALUES ('"+Email+"','"+Password+"','"+Name+"','"+National_ID+"','"+Phone_number+"','"+S_Age+"','"+S_Gender+"','"+Status+"');");
                   return true ;
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    return false;
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
        
    }
    
    /************************************************************************************************************************************************************************/
    
    
    
    
    
    
    /********************************************************* Verify the visitor credentials on login *******************************************************/
    // takes Email and password as strings 
    public boolean verifyVisitor(String Email , String Password){
       try{     
                Statement myStatement= connect.createStatement();
                try{
                    ResultSet myresult =myStatement.executeQuery("SELECT * FROM `visitor` WHERE Email='"+Email+"' AND password='"+Password+"'");
                    if(myresult.next())
                    {
                      
                       System.out.println("DB: Hello "+myresult.getString("Name")+" Welcome back !");
                       return true;
                    }
                    
                    else{ System.out.println("DB: The Email or Password is not valid ........!"); }
                    
                }
                catch(SQLException x){
                  //  x.printStackTrace();
                    System.out.println("DB: can't create result as "+x);
                    return false;
                 }
            }
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
        return false;
    }
    
    /*******************************************************************************************************************************************************************/
    
    
    
    
    
    /********************************************************edit visitor *******************************************************************/
    public boolean editVisitor (int ID,String Name,String National_ID,String Phone_number,String Password ,String Email ,int Age , boolean Gender , int Status ){
        //Converting all arguments to Strings so we can inser them into the database
        String S_Age = Integer.toString(Age);
        String S_Gender ;
      
        if(Gender){
            S_Gender = "Male";
        }
        else{
            S_Gender = "Female";
        }
     
        try{     
                Statement myStatement= connect.createStatement();
                try{
                     myStatement.executeUpdate("INSERT INTO `visitor` ( `Email`, `Password`, `Name`,`National_ID`,`phone number`, `Age`, `Gender`, `Status`) VALUES ('"+Email+"','"+Password+"','"+Name+"','"+National_ID+"','"+Phone_number+"','"+S_Age+"','"+S_Gender+"','"+Status+"');");
                   return true ;
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    return false;
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
    }
    /***********************************************************************************************************************************************************************/
    
    /****************************************************************verfiy admin login***************************************************************************/
     public boolean verifyAdmin(String Email , String Password){
       try{     
                Statement myStatement= connect.createStatement();
                try{
                    ResultSet myresult =myStatement.executeQuery("SELECT * FROM `admin` WHERE Admin_Email='"+Email+"' AND Admin_password='"+Password+"'");
                    if(myresult.next())
                    {
                      
                       System.out.println("DB: Hello admin "+myresult.getString("Admin_Email")+" Welcome back !");
                       return true;
                    }
                    
                    else{ System.out.println("DB: The Email or Password is not valid ........!"); }
                    
                }
                catch(SQLException x){
                  //  x.printStackTrace();
                    System.out.println("DB: can't create result as "+x);
                    return false;
                 }
            }
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
        return false;
    }
   /****************************************************************************************************************************************************************/
     
     
     
    /**********************************************Inserting in admin log table*******************************************************************/
     public boolean insertAdminLog(String Admin_Email , int edited_visitor_ID , int edited_Event_ID , int edited_monument_ID){
         String S_Date="dd/mm/yyyy";
         String S_time="**:**";
         try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `admin_log`( `Admin_Email`, `Date`, `Time`, `Edited_visitor_ID`, `Edited_events_ID`, `Edited_monuments_ID`) VALUES ('"+Admin_Email+"','"+S_Date+"' ,'"+S_time+"' ,'"+Integer.toString(edited_visitor_ID)+"' , '"+Integer.toString(edited_Event_ID)+"' ,'"+Integer.toString(edited_monument_ID)+"');");
                   
                   return true ;
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    return false;
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
         
     }
     /**********************************************************************************************************************************************************/
    
     
     
     /*admin editing in visitor table admin credintials is needed rhen data about the edited visitor as id name password Email and age */
    private void adminEditVisitor(String Admin_Email, String Admin_password, int ID,String Name,String National_ID,String Phone_number ,String Password ,String Email ,int Age , boolean Gender , int Status ){
        
        if(verifyAdmin(Admin_Email, Admin_password))
        {
             editVisitor(ID, Name, National_ID,Phone_number,Password, Email, Age, Gender, Status);
             insertAdminLog(Admin_Email,ID,0,0);
             
        }
        
    }
    
    /*******************************************Inserting an event all srgs passed as strings ************************************************/
    public boolean insertEvent(String eventName , String eventStartTime ,String eventEndTime ,String eventDate , String eventDescription ,String URL){
       //Converting all arguments to Strings so we can inser them into the database
               
        try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `events`(`Event Name`, `Event_start_time`, `Event_end_time`, `Event_Date`, `Event_description`, `URL` ) VALUES ('"+eventName+"','"+eventStartTime+"','"+eventEndTime+"','"+eventDate+"','"+eventDescription+"','"+URL+"');");
                   return true ;
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    return false;
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
    }
                }
        
    /**************************************************************************************************************************************************************************/
    
    /*get a row from event in an array list 1-> event name , 2->start time  , 3->end time  , 4->event date , 5-> event description  */
    public ArrayList<String> getEvent(int eventID){
        ArrayList<String> event = new ArrayList<String>();
        int i=4;
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `events` WHERE ID="+Integer.toString(eventID));
                 if(result.next()){
                  event.add(result.getString("Event Name"));
                  event.add(result.getString("Event_start_time"));
                  event.add(result.getString("Event_end_time"));
                  event.add(result.getString("Event_Date"));
                  event.add(result.getString("Event_description"));
                  event.add(result.getString("URL"));
                     
                 }
                 else{
                 
                 System.out.println("DB: error could not find that ID");
                     }
            }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        return event ;
        
    }
    /********************************************************************************************************************************************/
    
    
    /*******************************************Inserting an monument ***************************************************************************/
    public boolean insertMonument (String Name ,int barcode , String breif,int Tag , String URL ){
       //Converting all arguments to Strings so we can inser them into the database
               
        try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `monuments`(`Name`, `Barcode`, `Breif` ,`Tag`,`URL`) VALUES ('"+Name+"','"+barcode+"','"+breif+"','"+Tag+"','"+URL+"');");
                   return true ;
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    return false;
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                return false;
                }
        
    }
    /**************************************************************************************************************************************************************************/
    
     /*get a row from event in an array list 1-> event name , 2->start time  , 3->end time  , 4->event date , 5-> event description  */
    public ArrayList<String> getMonument(int ID){
        ArrayList<String> monument = new ArrayList<String>();
        int i=4;
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `monuments` WHERE ID="+Integer.toString(ID));
                 if(result.next()){
                  monument.add(result.getString("Name"));
                  monument.add(result.getString("Barcode"));
                  monument.add(result.getString("Breif"));
                  monument.add(result.getString("Tag"));
                  monument.add(result.getString("occupied_by_EventID"));
                  monument.add(result.getString("URL"));
                 }
                 else{
                 
                 System.out.println("DB: error could not find that ID");
                     }
            }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        return monument ;
        
    }
    /********************************************************************************************************************************************/
    
    
    
    
    /*get a row from a visitor by giving it's Id as a argument  */
    public ArrayList<String> getVisitor(int eventID){
        ArrayList<String> visitor = new ArrayList<String>();
        
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `visitor` WHERE ID="+Integer.toString(eventID));
                 if(result.next()){
                  visitor.add(result.getString("Name"));
                  visitor.add(result.getString("National_ID"));
                  visitor.add(result.getString("phone number"));
                  visitor.add(result.getString("Age"));
                  visitor.add(result.getString("Gender"));
                  visitor.add(result.getString("Status"));
                 }
                 else{
                 
                 System.out.println("DB: error could not find that ID");
                     }
            }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        return visitor ;
        
    }
    /********************************************************************************************************************************************/
    /**/
    public int bookTicket(String Email , String Date,int price){
        int ID=7777;
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `visitor` WHERE `Email` = '"+Email+"'");
                
                 if(result.next()){
                  ID = Integer.parseInt(result.getString("ID")) ;
                 }
                 else{
                 
                 System.out.println("DB: error could not find that Email");
                     }
            }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `ticket`(`price`, `date`, `Visitor_ID`) VALUES ('"+Integer.toString(price)+"', '"+Date+"' ,'"+ID+"');");
                   
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                
                }
        
        return ID;
        
    }
    /*Boook an Event*/
    public void bookEvent(String Visitor_Email , int Event_ID){
         int ID=7777;
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `visitor` WHERE `Email` = '"+Visitor_Email+"'");
                
                 if(result.next()){
                  ID = Integer.parseInt(result.getString("ID")) ;
                 }
                 else{
                 
                 System.out.println("DB: error could not find that Email");
                     }
            }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
         try{     
                Statement myStatement= connect.createStatement();
                try{
                   myStatement.executeUpdate("INSERT INTO `book an event`(`VisitorID`, `EventsID`) VALUES ('"+ID+"','"+Event_ID+"');");
                   
                   } 
                catch(SQLException x){
                    System.out.println("DB: can't INSERT as "+x);
                    
                    }
            }
        
        catch(SQLException x){
                System.out.println("DB: can't create statement as "+x);
                
                }
        
    }
    
     /***************************************************get all Events ID *******************************************************************************************/
    public ArrayList<Integer>  getAllEventsID (){
         ArrayList<Integer> ID = new ArrayList<Integer>();

        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT ID FROM events");
                 while(result.next()){
                    ID.add(Integer.parseInt( result.getString("ID")));
                 }
            } 
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        return ID;
    } 
    
    /***************************************************************************************************************************************************************/
  
    /*******************************************************************get all monuments Id**************************************/
    public ArrayList<Integer>  getAllMonumentsID (int Tag){
         ArrayList<Integer> ID = new ArrayList<Integer>();

        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT ID FROM monuments where Tag ="+Tag);
                 while(result.next()){
                    ID.add(Integer.parseInt( result.getString("ID")));
                 }
            } 
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
           }
        catch(SQLException e){
            
            System.out.println("DB: can't create statement as "+e);
        }
        return ID;
    }
    
    /*ticket data to be printed on the ticket page */
     public ArrayList<String> getticket(String Email){
        ArrayList<String> ticket = new ArrayList<String>();
         int ID=7777;
        try{
            Statement myStatement= connect.createStatement();
            try{
                 ResultSet result = myStatement.executeQuery("SELECT * FROM `visitor` WHERE Email= '"+Email+"'");
                 if(result.next()){
                  ID = Integer.parseInt(result.getString("ID"));
                  ticket.add(result.getString("Name"));
                  ticket.add(result.getString("National_ID"));
                  ticket.add(result.getString("phone number"));
                  ticket.add(result.getString("Age"));
                  ticket.add(result.getString("Gender"));
                  ticket.add(result.getString("Status"));
                 }
                 else{
                 
                 System.out.println("DB: error could not find that Email");
                     }
                }
                catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
                }
        }
            catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
            }
            try{
                Statement Statement= connect.createStatement();
                try{ ResultSet result = Statement.executeQuery("SELECT * FROM `ticket` WHERE Visitor_ID ="+Integer.toString(ID));
                     if(result.next()){
                        ticket.add(result.getString("date"));
                         
                     }
                    }
               catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
                }
            }
           catch(SQLException e){
                
                System.out.println("DB: can't create result as "+e);        
             }
            
            
           
        
        return ticket ;
        
     }
    
    
         
    
}