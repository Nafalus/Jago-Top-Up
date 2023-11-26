package Code.Controller;

// import java.util.ArrayList;

import Code.Node.NodeAdmin;
// import Code.Node.NodeUser;
// import Code.Node.NodeGames;
import Code.Node.NodeUser;

public class Controller {
    public NodeAdmin dataControllerAdmin = new NodeAdmin("paijo123@gmail.com", "mikumylove");

    public NodeAdmin getDataAdmin () {
        return this.dataControllerAdmin;
    }

    public NodeUser getEmailPass () {
        NodeUser temp = new NodeUser(this.dataControllerAdmin.email, this.dataControllerAdmin.pass, 0);
        return temp;
    }
}




