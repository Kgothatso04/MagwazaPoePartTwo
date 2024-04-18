package rc;

import static rc.MagwazaPOEPartOne.objAccount;

/**
 *
 * @author Kgothatso Magwaza [ST10456830]
 */
public class Login {
   // creating Attributes
    private String username ;
   private String password ;
   
   
   // Creating a constructor
   public Login(){
    this.username = "" ;
    this.password = "" ;
    
   }
   //setters
   public void setUsername(String username){
      this.username = username;
  }
   public void setPassword(String password){
        this.password = password;
    }
  
   
  // getters
   public String getUsername(){
       return this.username;
   }
   public String getPassword(){
       return this.password;
   }
  public boolean checkUserName(){     
    int myUsernameLength = this.username.length();
    boolean hasUnderScore = false;
    if(this.username.contains("_")){ hasUnderScore = true;}
        
    return myUsernameLength<=5 && hasUnderScore == true;
  }
 
  public boolean checkPasswordComplexity() {
        boolean passwordComplexityFlag = false;    
        int passwordLength = this.password.length();
        boolean capitalLetter = false;
        char ch;
        // Contain a capital letter
         for(int i=0;i < this.password.length(); i++) {
            ch = this.password.charAt(i);
            if (Character.isUpperCase(ch)) {
                capitalLetter = true;
                break;
            }
        }
         //Contain a number
        boolean number = false;
        for(int i=0;i < this.password.length();i++) {
            ch = this.password.charAt(i);
            if( Character.isDigit(ch)) {
                number = true;
                break;
            }
        }
        //Contain a special character
        boolean specialCharacter = false;
         for(int i=0;i < this.password.length(); i++) {
            ch = this.password.charAt(i);
            if (Character.isDigit(ch)== false && Character.isLetter(ch) == false && Character.isWhitespace(ch) == false) {
                specialCharacter = true;
                break;
            }
        }
        if(passwordLength>=8 && capitalLetter == true && number == true && specialCharacter == true ){
            passwordComplexityFlag = true;
        }
        return passwordComplexityFlag;
    }
  public String registerUser(){
      String registerUser = "";
      boolean cUsername = this.checkUserName();
      boolean cPasswordComplexity = this.checkPasswordComplexity();
      if(!cUsername){
       registerUser = "The username is incorrectly formatted.";  
      }
      if(!cPasswordComplexity){
        registerUser = "The password does not meet the complexity requirement." ;
      }
      if(cUsername && cPasswordComplexity){
           registerUser = "The two above conditions have been met and the user has been registered successfully.";
      }
        return registerUser;     
  }
    Account objAccount = new Account();  
  public boolean loginUser(){
    boolean loginUser = false;
    
    if(objAccount.getUsername().equals(this.username) && objAccount.getPassword().equals(this.password)){
      loginUser = true;  
    }
    return loginUser;
  }
  public String returnLoginStatus(){
      String returnLoginStatus;
      boolean cLogin = this.loginUser();
      if(cLogin){
         returnLoginStatus ="A successful login."; 
      }else{
          returnLoginStatus = "A failed login.";
      }
      return returnLoginStatus;
  }
}
