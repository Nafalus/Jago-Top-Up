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
    
   public void daftarAkun() {
        ModelJSONUser modelJsonUser = new ModelJSONUser();
        ArrayList<NodeUser> listUser = modelJsonUser.readFromJSON();

        if (listUser == null) {
            listUser = new ArrayList<>();
        }
        NodeUser newUser = new NodeUser(null,null,0);
        System.out.println("Masukkan Email");
        newUser.email = input.nextLine();
        System.out.println("Masukkan Password");
        newUser.pass = input.nextLine();
        System.out.println("Masukkan PIN");
        newUser.pin = input.nextInt();
        listUser.add(newUser);
        modelJsonUser.writeFileJSON(listUser);
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
                    System.out.println("User Berhasil Dihapus");
                    break;
                }
            }
        }
    }
    


    public ArrayList<NodeUser> getListDataUser () {
        return this.dataUser;
    }
}