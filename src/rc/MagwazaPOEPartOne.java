package rc;

import javax.swing.JOptionPane;

/**
 *
 * @author Kgothatso Magwaza [ST10456830]
 */
public class MagwazaPOEPartOne {
    static Login objLogin = new Login();
    static Account objAccount = new Account();

    public static void main(String[] args) {      
        getAccount();    
        login(); 
        
    } 
    
    //Question 1
    public static void getAccount(){
        boolean isValidUsername = false;
        while(!isValidUsername){
            String myUsername = JOptionPane.showInputDialog("Enter username");        
            int myUsernameLength = myUsername.length();
            boolean hasUnderScore = objAccount.containsUnderScore(myUsername);

            if(myUsernameLength<=5 && hasUnderScore == true){
                isValidUsername = true;        
                objAccount.setUsername(myUsername);
                JOptionPane.showMessageDialog(null,"Username succesfully captured");             
            } else {
                JOptionPane.showMessageDialog(null,"Username is not corretly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }
        boolean isValidPassword = false;
        while(!isValidPassword){
            String myPassword = JOptionPane.showInputDialog("Enter password");        
            int myPasswordLength = myPassword.length();
            boolean capitalLetter = objAccount.containsCapitalLetter(myPassword);    
            boolean number = objAccount.containsNumber(myPassword);
            boolean specialCharacter = objAccount.containsSpecialCharacter(myPassword);

            if(myPasswordLength>=8 && capitalLetter == true && number == true && specialCharacter == true ){
                isValidPassword = true;
               objAccount.setPassword(myPassword);
                JOptionPane.showMessageDialog(null,"Password succesfully captured");
            }else{
               JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that the password contains at least 8 characters, a  capital, a number and a special character");

            }
        }
        boolean isValidFirstName = false;
        while(!isValidFirstName){
            String myFirstName = JOptionPane.showInputDialog("Enter first name");
            if(!myFirstName.isEmpty()){
                isValidFirstName = true;
                objAccount.setFirstName(myFirstName);
             }else{
                JOptionPane.showMessageDialog(null,"First name can not be empty.");
            }
         }
        boolean isValidLastName = false;
        while(!isValidLastName){
         String myLastName = JOptionPane.showInputDialog("Enter last name");
         if(!myLastName.isEmpty()){
            isValidLastName = true;
             objAccount.setLastName(myLastName);
         }else{
            JOptionPane.showMessageDialog(null,"Last name can not be empty.");             
         } 
        }
    }
    
    // Question 2
    public static void login(){
      boolean isValidLogin = false;
      while(!isValidLogin){
        objLogin.objAccount = objAccount;
        String myUsername = JOptionPane.showInputDialog("Enter username");
        objLogin.setUsername(myUsername);
        String myPassword = JOptionPane.showInputDialog("Enter password");
        objLogin.setPassword(myPassword);
        String Success = objLogin.returnLoginStatus();
        JOptionPane.showMessageDialog(null,Success );
     
        if(objAccount.getUsername().equals(myUsername) && objAccount.getPassword().equals(myPassword)){
        isValidLogin = true;
          JOptionPane.showMessageDialog(null, "Welcome" + " " + objAccount.getFirstName() + " " + objAccount.getLastName() + " " + "it is great to see you again.");
        }else{
          JOptionPane.showMessageDialog(null,"Username or password incorrect, please try again.");
        }
      }
    }
      
}
