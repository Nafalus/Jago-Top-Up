package Code.Model;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
// import Node
import Code.Node.NodeAdmin;
import Code.Controller.Controller;
public class ModelAdmin{
    public ArrayList <NodeAdmin> dataAdmin;
    Controller firstData;

    public ModelAdmin(){
        this.dataAdmin = new ArrayList<>();
        this.firstData = new Controller();
        this.dataAdmin.addFirst(firstData.getDataAdmin());
    }

    public void insertAdmin (String email, String pass) {
        dataAdmin.add(new NodeAdmin(email, pass)); 
    }

    public void ViewAllAdmin(){
       for (int i = 0; i < this.dataAdmin.size(); i++){
            this.dataAdmin.get(i).ViewAdmin();
            System.out.println("--------------------");
       }
    }    
}