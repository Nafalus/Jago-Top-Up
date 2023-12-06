package Code.View;
import java.util.Scanner;

import Code.Model.ModelGames;
import Code.Model.ModelUser;

public class MenuAdmin {
    ModelGames modelgames = new ModelGames();
    ModelUser modeluser = new ModelUser();



    public void menuAdmin(){
        Scanner input = new Scanner(System.in);
        int pilih;
        do{
        System.out.println("MENU ADMIN");
        System.out.println("1. Tambah Game");
        System.out.println("2. Edit Game");
        System.out.println("3. Hapus Game");
        System.out.println("4. Lihat Game");
        System.out.println("5. Lihat User");
        System.out.println("6. Log Out");
        System.out.print("Pilih Menu : ");
        pilih = input.nextInt();
        

        switch (pilih) {
            case 1:
               modelgames.addGame();
                break;
            case 2:
                input.nextLine();
                System.out.println("Masukkan Nama Game Yang ingin DiEdit : ");
                String namegame = input.nextLine();
                modelgames.updateItemPrice(namegame);;
                break;
            case 3:
                input.nextLine();
                System.out.println("Masukkan Nama Game Yang ingin Dihapus : ");
                String nameGame = input.nextLine();
                modelgames.DeleteGame(nameGame);
                break;
            case 4:
                modelgames.ViewAllGames();
                break;
            case 5:
                System.out.println("LIST USER");
                modeluser.ViewAllUser();
                break;
            case 6:
                System.out.println("Log Out");
                break;
            default:
                System.out.println("Pilih menu yang tersedia");
                break;
        }
        
    }while(pilih !=6);

    input.close();
}
}