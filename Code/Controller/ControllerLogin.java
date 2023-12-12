package Code.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.View;

import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONUser;
import Code.Node.NodeAdmin;
import Code.Node.NodeUser;
import Code.View.ViewAdmin;
import Code.View.ViewUser;

public class ControllerLogin {
    private ViewAdmin menuAdmin;
    private ViewUser menuUser;
    
    public ControllerLogin (ViewAdmin menuAdmin, ViewUser menuUser) {
        this.menuAdmin = menuAdmin;
        this.menuUser = menuUser;
    }
    
    public void ValidasiLogin(String email, String pass){
        ArrayList <NodeUser> listuser = new ModelJSONUser().readFromJSON();
        if (listuser != null) {
            for (NodeUser user : listuser) {
                if (user.getEmail().equalsIgnoreCase(email) && user.getPass().equalsIgnoreCase(pass)){
                    menuUser.menuUser();
                }
            }
        }

        ArrayList <NodeAdmin> listAdmins = new ModelJSONAdmin().readFromJSON();
        if (listAdmins != null) {
            for (NodeAdmin admin : listAdmins) {
                if (admin.getemail().equalsIgnoreCase(email) && admin.getPass().equalsIgnoreCase(pass)){
                    menuAdmin.menuAdmin();
                }else{
                    System.out.println("Email atau Password Salah");
                }
            }
        }
    }
}
