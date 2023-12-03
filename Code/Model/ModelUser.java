package Code.Model;

import java.util.ArrayList;

import Code.ModelJSON.ModelJSONUser;
// import Node
import Code.Node.NodeUser;

public class ModelUser{
    public static ArrayList <NodeUser> dataUser;

    public ModelUser(){
        ModelUser.dataUser = new ArrayList<>();
    }
    public void RegisterUser(String email,String pass,int pin,double saldo){
        dataUser.add(new NodeUser (email,pass,pin,saldo));
    }
    
    // Done
    public void ViewAllUser(){
        ArrayList <NodeUser> listUser = new ModelJSONUser().readFromJSON();
        if (listUser != null){
            for (NodeUser user : listUser){
                user.ViewUser();
                System.out.println("--------------------");
            }
        }
    }


    // Done
    public void DeleteUSer(String email){
        ArrayList <NodeUser> listUser = new ModelJSONUser().readFromJSON();
        if (listUser != null){
            for (int i = 0; i < listUser.size(); i++ ){
                NodeUser User = listUser.get(i);
                if (email.equals(User.getemail())){
                    listUser.remove(i);
                    new ModelJSONUser().writeFileJSON(listUser);
                    break;
                }
            }
        }
    }

    public ArrayList<NodeUser> getListDataUser () {
        return this.dataUser;
    }
}