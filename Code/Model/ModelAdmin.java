package Code.Model;

import java.util.ArrayList;
 
// import Node
import Code.Node.NodeAdmin;
import Code.Controller.ControllerAdmin;
import Code.ModelJSON.ModelJSONAdmin;
public class ModelAdmin{
    public ArrayList <NodeAdmin> dataAdmin;
    ControllerAdmin firstData;

    public ModelAdmin(){
        this.dataAdmin = new ArrayList<>();
        this.firstData = new ControllerAdmin();
        this.dataAdmin.addFirst(firstData.getDataAdmin());
    }

    public void insertAdmin (String email, String pass) {
        dataAdmin.add(new NodeAdmin(email, pass)); 
    }

    public void ViewAllAdmin(){
       ArrayList <NodeAdmin> listAdmin = new ModelJSONAdmin().readFromJSON();
       if (listAdmin != null) {
       for (NodeAdmin admin : listAdmin) {
           System.out.println("Email Admin : "+admin.getemail());
           System.out.println("Password Admin : "+admin.getPass());
       }
       }
    }    
}