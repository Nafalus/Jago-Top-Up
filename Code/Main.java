package Code;

import Code.Controller.ControllerGames;
import Code.Model.ModelGames;
import Code.Controller.ControllerLogin;
import Code.Controller.ControllerUser;
import Code.View.ViewLogin;
import Code.View.ViewAdmin;
import Code.View.ViewUser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ModelUser modeluser = new ModelUser();
        // ModelLogin login = new ModelLogin();

        ModelGames modelGame = new ModelGames();
        ControllerGames controllerGame = new ControllerGames(modelGame);
        ViewAdmin viewAdmin = new ViewAdmin (controllerGame);
        ViewUser viewUser = new ViewUser(controllerGame);
        ControllerUser controllerUser = new ControllerUser(viewUser);
        ControllerLogin controllerLogin = new ControllerLogin(viewAdmin, viewUser);
        ViewLogin viewLogin = new ViewLogin(controllerLogin);
        


        Scanner input = new Scanner(System.in);

        viewAdmin.menuAdmin();
        modelGame.commit(); 

    //     int pilih;
    //     do{
    //         input.nextLine();
    //         System.out.println("1. Daftar ");
    //         System.out.println("2. Login");
    //         System.out.println("3. Keluar");
    //         System.out.println("Masukkan Pilihan");
    //         // try {
    //         // pilih = input.nextInt();
    //         // } catch (Exception e){
    //         //     System.out.println(e);
    //         // }
    //         // input.nextLine();
    //         pilih = input.nextInt();

    //         switch (pilih) {
    //             case 1:
    //                 System.out.println("Masukkan Email");
    //                 String email = input.nextLine();
    //                 input.nextLine();
    //                 System.out.println("Masukkan Password");
    //                 String pass = input.nextLine();
    //                 System.out.println("Masukkan Pin");
    //                 int pin = input.nextInt();
    //                 controllerUser.insertUser(email, pass, pin);
    //                 break;
    //             case 2:
    //                 viewLogin.Login();
    //                 break;
    //             case 3:
    //                 System.out.println("Log Out");
    //             default:
    //                 break;
    //         }
    //     }while ( pilih != 3);

    //     input.close();
    //     modelGame.commit();
    // }
}
}