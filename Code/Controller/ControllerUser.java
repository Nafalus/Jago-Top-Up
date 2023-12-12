package Code.Controller;

import Code.View.ViewUser;
import Code.Model.ModelUser;

public class ControllerUser {
    private ViewUser view;
    private ModelUser modelUser;

    public ControllerUser (ViewUser view) {
        this.view = view;
    }

    public void insertUser(String email,String pass,int pin){
        modelUser.addUser(email,pass,pin);
    }
}