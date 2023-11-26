package Code;

import Code.Model.ModelAdmin;
import Code.Model.ModelUser;
import Code.Model.Login;

public class Main {
    public static void main(String[] args) {
        ModelUser modeluser = new ModelUser();
        ModelAdmin modeladmin = new ModelAdmin();
        Login login = new Login();

        login.Validasi();
        System.out.println("Admin : " + login.validAdmin);
        System.out.println("User : " + login.validUser);
        
        modeluser.RegisterUser("Nopal Penyepong Miku", "Palll", 1234);
        modeluser.ViewAllUser();
        modeluser.updateUser("Budi","Pale Pale",1111);
        modeluser.ViewAllUser();
        modeladmin.ViewAllAdmin();

    }
}
