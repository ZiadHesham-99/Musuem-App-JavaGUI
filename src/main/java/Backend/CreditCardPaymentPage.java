
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Hosam
 */
public class CreditCardPaymentPage {
    private static CreditCardPaymentPage Instance = null;
    private String fullName;
    private String creditCardNumber, cvvNumber, mounth, year;
    public static CreditCardPaymentPage Instance(){
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new CreditCardPaymentPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    public static CreditCardPaymentPage Instance(String database_URL)
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new CreditCardPaymentPage(database_URL,"root","");
        }
        return Instance;
    }
    CreditCardPaymentPage(String database_URL, String database_name, String database_password){
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
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
    public void questionMarkIconMouseEntered(JLabel hoverEffectLabel){
        hoverEffectLabel.setText("The CVV Number (\"Card Verification Value\")"
                + " on your credit card or debit card is a 3 digit number "
                + "on VISA®, MasterCard® and Discover® branded credit and debit cards."
                + " On your American Express® branded credit or debit card"
                + " it is a 4 digit numeric code.");
    }
    public void questionMarkIconMouseExited(JLabel hoverEffectLabel){
        hoverEffectLabel.setText("");
    } 
    public boolean noEmptyCell(JTextField creditCardNumberTextField, JTextField CvvTextField,
            JTextField nameTextField, JLabel errorMsg,
            JComboBox<String> mounthComboBox, JComboBox<String> yearComboBox){
        try{
            errorMsg.setText("");
            setFullName(nameTextField.getText());
            setCreditCardNumber(creditCardNumberTextField.getText());
            setCvvNumber(CvvTextField.getText());
            setMounth(mounthComboBox.getSelectedItem().toString());
            setYear(yearComboBox.getSelectedItem().toString());
            if("".equals(getFullName())||"".equals(creditCardNumberTextField.getText())||
                    "".equals(CvvTextField.getText())){
                errorMsg.setText("There is an empty cell");
                    return false;
            }else{
                //database method
                    return true;
            }
        }catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("Error in empty cell method");
            return false;
        }
    }
    public void payNowButtom(JFrame creditCardPaymentPage, JFrame nextPage,
            boolean noEmptyCellMethod){
        try{
            if(noEmptyCellMethod){
                creditCardPaymentPage.dispose();
                nextPage.show();
            }
        }catch(NumberFormatException e){
            System.out.println(e);
            System.out.println("Error in empty cell method");
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
     * @return the creditCardNumber
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @param creditCardNumber the creditCardNumber to set
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * @return the cvvNumber
     */
    public String getCvvNumber() {
        return cvvNumber;
    }

    /**
     * @param cvvNumber the cvvNumber to set
     */
    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    /**
     * @return the mounth
     */
    public String getMounth() {
        return mounth;
    }

    /**
     * @param mounth the mounth to set
     */
    public void setMounth(String mounth) {
        this.mounth = mounth;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
}
