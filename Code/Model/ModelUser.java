package Code.Model;

import java.util.ArrayList;
import java.util.Scanner;

import Code.ModelJSON.ModelJSONUser;

// import Node
import Code.Node.NodeUser;

public class ModelUser{
    public  ArrayList <NodeUser> dataUser;
    Scanner input = new Scanner(System.in);


    public ModelUser(){
        this.dataUser = new ArrayList<>();
    }
    // public void RegisterUser(String email,String pass,int pin){
    //     dataUser.add(new NodeUser (email,pass,pin));
    // }
    
    public ArrayList <NodeUser> getListUsers(){
        return dataUser;    
        }

   public void addUser(String email,String pass,int pin){
        NodeUser User = new NodeUser(email,pass,pin);
        dataUser.add(User);    
   }



    public NodeUser getUser(String email){
        NodeUser listUser = null;
        for (NodeUser User : dataUser){
            if (User.email == email){
                return User;
            }
        }
        return listUser;
    }
    // Done
    public ArrayList <NodeUser> ViewAllUser(){
        ArrayList <NodeUser> listUser = new ModelJSONUser().readFromJSON();
        return listUser;
        // if (listUser != null){
        //     for (NodeUser user : listUser){
        //         System.out.println("Email User : "+user.getEmail());
        //         System.out.println("Password User : "+user.getPass());
        //         System.out.println("Pin User : "+user.getPin());
        //         System.out.println("--------------------");
        //     }
        // }
    }


    // Done
    public void deleteUser(NodeUser User){
        dataUser.remove(User);
    }
    


}