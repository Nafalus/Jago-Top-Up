package Code.Node;

public class NodeUser extends NodeAdmin {
    public int pin;
    
    public NodeUser (String email, String pass, int pin) {
        super(email,pass);
        this.email = email;
        this.pass = pass;
        this.pin = pin;
    }
    
    public String getemail () {
        return this.email;
    }

    public String getPass () {
        return this.pass;
    }
    
    public int getPin (){
        return this.pin;
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

    public void ViewUser(){
        System.out.println("Email USer : "+this.email);
        System.out.println("Password User : "+this.pass);
        System.out.println("Pin User : "+pin);
    }
}
