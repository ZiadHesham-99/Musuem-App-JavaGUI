/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Backend;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Hosam
 */
public class BookingPage{
 private static BookingPage Instance = null;


    public BookingPage(String database_URL, String database_name, String database_password) {
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
    }
    public static BookingPage Instance(){
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new BookingPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    public static BookingPage Instance(String database_URL)
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new BookingPage(database_URL,"root","");
        }
        return Instance;
    }

    private String fullName;
    private String dateOfVisit;
    private String nationalID;
    private String phoneNumber;

    public void confirmButtom(JTextField fullnameTextField, JTextField nationalIDTextField, 
            JTextField phoneNumberTextField, JTextField dateOfVisitTextField, 
            JLabel errorMessageLabel, 
            JFrame bookingPage , JFrame nextPage){
        try{
            errorMessageLabel.setText("");
            setFullName(fullnameTextField.getText());
            setNationalID(nationalIDTextField.getText());
            setPhoneNumber(phoneNumberTextField.getText());
            setDateOfVisit(dateOfVisitTextField.getText());
            if(("".equals(getFullName())) || ("".equals(nationalIDTextField.getText())) ||
                    ("".equals(phoneNumberTextField.getText())) || ("".equals(getDateOfVisit())) ){
                errorMessageLabel.setText("There is an empty cell");
            }
            else{
               // database_methods.
               Database_handler.Instance().bookTicket(fullName,getDateOfVisit(),900);
               bookingPage.dispose();
               nextPage.show();
            }
            
        }catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("Error in booking page method");
        }
    }
    public void confirmEventTicketButtom(JTextField fullnameTextField, JTextField nationalIDTextField, 
            JTextField phoneNumberTextField, 
            JLabel errorMessageLabel,
            JFrame bookingPage , JFrame nextPage){
        try{
            errorMessageLabel.setText("");
            setFullName(fullnameTextField.getText());
            setNationalID(nationalIDTextField.getText());
            setPhoneNumber(phoneNumberTextField.getText());
            if(("".equals(getFullName())) || ("".equals(nationalIDTextField.getText())) 
                    || ("".equals(phoneNumberTextField.getText())) ){
                errorMessageLabel.setText("There is an empty cell");
            }
            else{
               // database_methods.
                System.out.println(EventDetailsPage.Instance().getEventID());
               Database_handler.Instance().bookEvent(getFullName(), EventDetailsPage.Instance().getEventID());
               bookingPage.dispose();
               nextPage.show();
            }
            
        }catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("Error in booking page method");
        }
    }
    public void backButtom(JFrame creditCardPaymentPage, JFrame nextPage){
        try{
            creditCardPaymentPage.dispose();
            nextPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in back buttom method");
        }
    }
    public void showEventDetails(JLabel[] eventImageNameTimeDateBreif){
        ArrayList<String> eventInfo= new ArrayList<>();
        try{
            eventInfo= Database_handler.Instance().getEvent(EventDetailsPage.Instance().getEventID());
            //Image
            URL imageURL= new URL(eventInfo.get(5));
            ImageIcon imageIcon= new ImageIcon(imageURL);
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
        }catch(MalformedURLException e){
            System.out.println(e);
            System.out.println("Error in show event details method");
        }
    }
    
    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the nationalID
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * @param nationalID the nationalID to set
     */
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the dateOfVisit
     */
    public String getDateOfVisit() {
        return dateOfVisit;
    }

    /**
     * @param dateOfVisit the dateOfVisit to set
     */
    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
}