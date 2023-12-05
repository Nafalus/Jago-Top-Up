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
    public void RegisterUser(String email,String pass,int pin){
        dataUser.add(new NodeUser (email,pass,pin));
    }
    
    // Done
    public void ViewAllUser(){
        ArrayList <NodeUser> listUser = new ModelJSONUser().readFromJSON();
        if (listUser != null){
            for (NodeUser user : listUser){
                System.out.println("Email User : "+user.getEmail());
                System.out.println("Password User : "+user.getPass());
                System.out.println("Pin User : "+user.getPin());
                System.out.println("--------------------");
            }
        }
    }


    // Done
    public void DeleteUser(String email) {
        ArrayList<NodeUser> listUser = new ModelJSONUser().readFromJSON();
        if (listUser != null) {
            for (NodeUser user : listUser) {
                if (email.equals(user.getEmail())) {
                    listUser.remove(user);
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