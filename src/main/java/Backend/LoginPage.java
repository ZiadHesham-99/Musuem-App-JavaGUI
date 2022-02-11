/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Hosam
 */
public class LoginPage {
    private static LoginPage Instance = null;
    private String user_name, password;
    private int attempts;
    private boolean  okay;
    //private Database_handler  database_methods;
  
     public static LoginPage Instance()
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new LoginPage("jdbc:mysql://localhost:3306/trial2?zeroDateTimeBehavior=convertToNull","root","");
        }
        return Instance;
    }
    
    public static LoginPage Instance(String database_URL)
    {
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new LoginPage(database_URL,"root","");
        }
        return Instance;
    }
     
   private LoginPage(String database_URL, String database_name, String database_password){
        Database_handler.Instance(database_URL,database_name,database_password);
        this.attempts= 3;
    }
    
    public void signInButtom(JTextField usernameTextField, JTextField passwordTextField, 
            JLabel msgToAppearInWrongPassword,
            JFrame signInPage, JFrame nextPage){
        try{
            msgToAppearInWrongPassword.setText("");
            setUser_name(usernameTextField.getText());
            setPassword(passwordTextField.getText());            
            if("".equals(getUser_name())||"".equals(getPassword())){
                msgToAppearInWrongPassword.setText("Please enter your password and username!!");
            }else{
                setOkay(Database_handler.Instance().verifyVisitor(getUser_name(), getPassword()));
                if(isOkay()){
                   signInPage.dispose();
                   nextPage.show();
                }else{
                    msgToAppearInWrongPassword.setText("Wrong username or password!! \n"
                            +"You have "+getAttempts()+ " attempts");
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                    setAttempts(getAttempts() - 1);
                }                
            }
            if(getAttempts()==0){
                signInPage.dispose();
            }            
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in sign in buttom method");
        }
    }

    public void signUpButton(JFrame signInPage, JFrame signUpPage){
        try{
            signInPage.dispose();
            signUpPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in sign up buttom method");
        }
    }

    /**
     * @return the user_name
     */
    public  String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
     * @return the attempts
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * @param attempts the attempts to set
     */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    /**
     * @return the okay
     */
    public boolean isOkay() {
        return okay;
    }

    /**
     * @param okay the okay to set
     */
    public void setOkay(boolean okay) {
        this.okay = okay;
    }
}