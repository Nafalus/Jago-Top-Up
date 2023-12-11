package Code.Model;

import java.util.ArrayList;
import java.util.Scanner;

import Code.Node.NodeAdmin;
import Code.Node.NodeUser;
import Code.View.ViewAdmin;
import Code.View.ViewUser;
import Code.Controller.ControllerAdmin;
// import Code.Model.ModelUser;
import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONUser;

public class ModelLogin {
    ArrayList <NodeUser> dataUser;
    public boolean validAdmin, validUser;
    ViewUser menuuser = new ViewUser();
    ViewAdmin menuadmin = new ViewAdmin();

    public ModelLogin () {
        validAdmin = false;
        validUser = false;
        this.dataUser = new ArrayList<NodeUser>();
        ControllerAdmin temp = new ControllerAdmin();
        ModelUser tempModelUser = new ModelUser();
        this.dataUser.add(temp.getEmailPass());
        for (int i = 1; i < tempModelUser.getListDataUser().size() + 1; i++) {
            this.dataUser.add(i, null);
        }
    }

    public void Validasi () {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("========================\nSilahkan Melakukan Login\n========================\n");
            System.out.print("Masukkan Id :");
            String email = input.nextLine();
            System.out.print("Masukkan Password : ");
            String pass = input.nextLine();
            
            for (int i=0;i<this.dataUser.size();i++) {
                if (email.equals(this.dataUser.get(i).getemail()) && pass.equals(this.dataUser.get(i).getPass()) && i == 0) {
                    this.validAdmin = true;
                }
                else if (email.equals(this.dataUser.get(i).getemail()) && pass.equals(this.dataUser.get(i).getPass()) && i > 0) {
                    this.validUser = true;
                }
            }

        } while (!validAdmin && !validUser);

        input.close();
    }

    public void ValidasiLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Email : ");
        String email = input.nextLine();
        System.out.println("Masukkan Password : ");
        String pass = input.nextLine();
        ArrayList <NodeUser> listuser = new ModelJSONUser().readFromJSON();
        if (listuser != null) {
            for (NodeUser user : listuser) {
                if (user.getEmail().equalsIgnoreCase(email) && user.getPass().equalsIgnoreCase(pass)){
                    menuuser.menuUser();
                }
            }
        }

        ArrayList <NodeAdmin> listAdmins = new ModelJSONAdmin().readFromJSON();
        if (listAdmins != null) {
            for (NodeAdmin admin : listAdmins) {
                if (admin.getemail().equalsIgnoreCase(email) && admin.getPass().equalsIgnoreCase(pass)){
                    menuadmin.menuAdmin();
                }else{
                    System.out.println("Email atau Password Salah");
                }
            }
        }
    }
    
}