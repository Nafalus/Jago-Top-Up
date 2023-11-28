package Code.NodeJSON;
import Code.NodeJSON.NodeJSONUser;
// package Code.NodeJSON.NodeJSONAdmin;



public class NodeJSONUser extends NodeJSONAdmin {
    public int pin;
    
    public NodeJSONUser (String email,String pass,int pin) {
        super(email,pass);
        this.pin = pin;
    }
}
