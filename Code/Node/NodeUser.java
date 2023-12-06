package Code.Node;

public class NodeUser extends NodeAdmin {
    public int pin;
    
    public NodeUser (String email, String pass, int pin) {
        super(email,pass);
        this.email = email;
        this.pass = pass;
        this.pin = pin;
    }
    
    public String getEmail () {
        return email;
    }

    public String getPass () {
        return pass;
    }
    
    public int getPin (){
        return pin;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String pass){
        this.pass = pass;
    }

    public void setPin(int pin){
        this.pin = pin;
    }
}
