/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
/**
 *
 * @author Hosam
 */
public class SignUpPage {
    private static SignUpPage Instance = null;
    private String fullName, userName, password, repeatPassword, status, NationalID;
    private int age;
    boolean gender;
    public static SignUpPage Instance(){
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new SignUpPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    
    public static SignUpPage Instance(String database_URL)
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new SignUpPage(database_URL,"root","");
        }
        return Instance;
    }
    SignUpPage(String database_URL, String database_name, String database_password){
        Database_handler.Instance(
                database_URL,
                database_name,
                database_password);
    }
    public boolean checkPassword(
            JTextField passwordTextField, JTextField repeatPasswordTextField,
            JLabel msgToAppearInWrongPassword){
        try{
            msgToAppearInWrongPassword.setText("");
            setPassword(passwordTextField.getText());
            setRepeatPassword(repeatPasswordTextField.getText());
            if( getPassword().equals(getRepeatPassword()) ){
                return true;
            }else{
                msgToAppearInWrongPassword.setText("Those passwords didn’t match. Try again.");
                passwordTextField.setText("");
                repeatPasswordTextField.setText("");
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in check password method");
            return false;
        }
    }
    public boolean getGender(ComboBoxModel<String> genderComboBox){
        String gender= genderComboBox.getSelectedItem().toString();
        return "Male".equals(gender);
    }
    public boolean insertDataOfNewAccount(JTextField NAmeTextField,JTextField NationalIDTextField,JTextField PhoneNumberTextFiled,JPasswordField PasswordFiled,JTextField EmailTextField,JTextField AgeTextField,JComboBox<String> GenderCB,JComboBox<String> StatusCB,JLabel ErrorLabel){
        boolean okay;
        try{
            boolean Geneder = "Male".equals(GenderCB.getSelectedItem().toString());
            okay = Database_handler.Instance().insertVisitor(NAmeTextField.getText(),NationalIDTextField.getText(),PhoneNumberTextFiled.getText(),PasswordFiled.getText(),EmailTextField.getText(),Integer.parseInt( AgeTextField.getText() ),Geneder,StatusCB.getSelectedItem().toString());
            ErrorLabel.setText("");
            return  okay;
        }catch(NumberFormatException e){
            System.out.println(e);
            ErrorLabel.setText(e.toString());
            System.out.println("Error in sign up method");
            return false;
        }
    }
    public void backButtom(JFrame signUpPage, JFrame pervPage){
        try{
            signUpPage.dispose();
            pervPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in back buttom method");
        }
    }
    public void toNextPage(JFrame signUpPage, JFrame nextPage, boolean dataInserted){
        try{
            if(dataInserted){
                signUpPage.dispose();
                nextPage.show(); 
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in next buttom method");
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the repeatPassword
     */
    public String getNationalID() {
        return NationalID;
    }
     public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }

    /**
     * @return the repeatPassword
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * @param repeatPassword the repeatPassword to set
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
//JFrame pervPage, JFrame signUpPage, JFrame nextPage