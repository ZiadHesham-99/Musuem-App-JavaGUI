/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author Hosam
 */
public class SelectPaymentPage {
    private static SelectPaymentPage Instance = null;

    public boolean SelectPayment(JRadioButton cash,JRadioButton creditCard){
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cash);
        paymentGroup.add(creditCard); 
        return creditCard.isSelected();
    }
    public static SelectPaymentPage Instance(){
        // To ensure only one instance is created
        if (Instance == null) {
            Instance = new SelectPaymentPage();
        }
        return Instance;
    }
    
    public void continueButton(JFrame paymentPage , JFrame cashPage,JFrame creditCardPage ,boolean payment){
        try{
            if (payment){
                paymentPage.dispose();
                creditCardPage.show();
            }else{
                paymentPage.dispose();
                cashPage.show();
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in continue button method");
        }
    }
    public void backButton(JFrame paymentPage , JFrame previousPage){
        try{
            paymentPage.dispose();
            previousPage.show();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error in back button method");
        }
    }
}