package Code.Model;

import java.util.ArrayList;

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
    
    public void ViewAllUser(){
        for (int i = 0; i < dataUser.size(); i++){
           ModelUser.dataUser.get(i).ViewUser();
           System.out.println("--------------------");
        }
    }

    public void DeleteUSer(String email){
        for (int i=0; i< dataUser.size(); i++){
            if (email.equals(dataUser.get(i).getemail())){
                dataUser.remove(i);
            }
        }
    }

    public void updateUser(String email,String pass,int pin) {
        for (int i = 0; i < dataUser.size(); i++) {
            if (email.equals(dataUser.get(i).getemail())) {
                if (!"-".equals(dataUser.get(i).getemail())) {
                dataUser.get(i).setEmail(email);
                }
                if (!"-".equals(dataUser.get(i).getPass())) {
                dataUser.get(i).setPassword(pass);
                }
                if (dataUser.get(i).getPin() != -1) {
                    dataUser.get(i).setPin(pin);
                }
            }
        }
    }

    public ArrayList<NodeUser> getListDataUser () {
        return this.dataUser;
    }
}