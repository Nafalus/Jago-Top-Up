package Code;

import Code.Model.ModelLogin;
import Code.Model.ModelGames;
import Code.Model.ModelUser;
import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONUser;
import Code.View.ViewAdmin;
import Code.View.ViewUser;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ModelGames modelgame = new ModelGames();
        ModelUser modeluser = new ModelUser();
        ViewAdmin menuadmin = new ViewAdmin();
        ModelJSONUser modelJSONUser = new ModelJSONUser();
        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        ViewUser menuuser = new ViewUser();
        ModelLogin login = new ModelLogin();
        
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
    }
}


