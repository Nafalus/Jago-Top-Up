package Code.View;

// import Code.View.ViewAdmin;
import Code.Controller.ControllerLogin;
import java.util.Scanner;

public class ViewLogin {
    private ControllerLogin controller;
    private Scanner input;

    public ViewLogin (ControllerLogin controller) {
        this.controller = controller;
        input = new Scanner(System.in);
    }

    public void Login () {
        System.out.print("Masukkan Email : ");
        String email = input.nextLine();
        System.out.print("Masukkan Password : ");
        String pass = input.nextLine();
        controller.ValidasiLogin(email, pass);
        input.close();
    }
}
