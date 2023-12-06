package Code;

import Code.Model.Login;
import Code.Model.ModelGames;
import Code.Model.ModelUser;
// import Code.Model.ModelAdmin;
// import Code.Model.ModelUser;
// import Code.Model.Login;
import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONUser;
import Code.View.MenuAdmin;
import Code.View.MenuUser;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ModelGames modelgame = new ModelGames();
        ModelUser modeluser = new ModelUser();
        MenuAdmin menuadmin = new MenuAdmin();
        ModelJSONUser modelJSONUser = new ModelJSONUser();
        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        MenuUser menuuser = new MenuUser();
        Login login = new Login();
        
        Scanner input = new Scanner(System.in);



        int pilih;
        do{
            input.nextLine();
            System.out.println("1. Daftar ");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.println("Masukkan Pilihan");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    modeluser.daftarAkun();
                    break;
                case 2:
                    login.ValidasiLogin();
                    break;
                case 3:
                    System.out.println("Log Out");
                default:
                    break;
            }
        }while ( pilih != 3);

        input.close();


        


        // ModelJSONUser modelJSONUser = new ModelJSONUser();
        // ArrayList <NodeUser> listuser1 = new ArrayList<>();
        // listuser1.add(new NodeUser("Nopal Penyepong Miku", "Nigga Hitam", 121) );
        // listuser1.add(new NodeUser("Miku Bitchi", "Nopal Weabo" , 221) );
        // modelJSONUser.writeFileJSON(listuser1);
        // modeluser.ViewAllUser();
        // modeluser.DeleteUser("Nopal Penyepong Miku");
        // System.out.println("Admin Terdaftar");
        // modeluser.ViewAllUser();

        // modelgame.ViewAllGames();
        // menuadmin.menuAdmin();
        
        
}
}


