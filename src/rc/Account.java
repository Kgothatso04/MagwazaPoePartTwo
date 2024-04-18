package rc;

/**
 *
 * @author Kgothatso Magwaza [ST10456830]
 */
public class Account {
   // Creating attributes
   private String username ;
   private String password ;
   private String firstName ;
   private String lastName ;
   
   // Creating constructor
   public Account(){
    this.username = "" ;
    this.password = "" ;
    this.firstName = "" ;
    this.lastName = "" ;
   }
   //setters
   public void setUsername(String username){
      this.username = username;
  }
   public void setPassword(String password){
        this.password = password;
    }
   public void setFirstName(String firstName){
       this.firstName = firstName;
   } 
   public void setLastName(String lastName){
       this.lastName = lastName;
   }
  // getter
   public String getUsername(){
       return this.username;
   }
   public String getPassword(){
       return this.password;
   }
   public String getFirstName(){
    return this.firstName;
}
   public String getLastName(){
       return this.lastName;
   }
   // username validation
    public boolean containsUnderScore(String str) {
        boolean underScoreFlag = false;    
        if(str.contains("_")){ underScoreFlag = true;}
        return underScoreFlag;
    }
    //Password validation
    public boolean containsCapitalLetter(String str) {
        char ch;
        boolean capitalFlag = false;

        for(int i=0;i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                capitalFlag = true;
                break;
            }
        }

        return capitalFlag;
    }    
    public boolean containsNumber(String str) {
        char ch;
        boolean numberFlag = false;

        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
                break;
            }
        }

        return numberFlag;      
    }
    public boolean containsSpecialCharacter(String str) {
        char ch;
        boolean specialCharacter = false;

        for(int i=0;i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)== false && Character.isLetter(ch) == false && Character.isWhitespace(ch) == false) {
                specialCharacter = true;
                break;
            }
        }

        return specialCharacter;
    }
}
