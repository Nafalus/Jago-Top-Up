package Code.View;

import java.util.ArrayList;
import java.util.Scanner;

import Code.Controller.ControllerGames;
import Code.Node.NodeGames;

public class ViewAdmin {
    // private ModelGames modelgames = new ModelGames();
    // private ModelUser modeluser = new ModelUser();
    private ControllerGames controller;

    public ViewAdmin (ControllerGames controller) {
        this.controller = controller;
    }

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
        System.out.println("6. Search Games");
        System.out.println("7. Log Out");
        System.out.print("Pilih Menu : ");
        pilih = input.nextInt();
        
            switch (pilih) {
                case 1:
                    input.nextLine();
                    System.out.println("Masukkan Nama Game : ");
                    String gameName = input.nextLine();
                    System.out.println("Masukkan Nama Currency Game : ");
                    String currencyName = input.nextLine();
                    controller.addGame(gameName, currencyName);
                    break;
                    
                case 2:
                    input.nextLine();
                    System.out.println("Masukkan Nama Game yng ingin Diedit");
                    String oldName = input.nextLine();
                    System.out.println("Masukkan Nama Game Baru");
                    String newName = input.nextLine();
                    System.out.println("Masukkan Nama Currency Baru");
                    String newcurrency = input.nextLine();
                    controller.updateGame(oldName, newName, newcurrency);
                    break;

                case 3:
                    input.nextLine();
                    System.out.println("Masukkan Nama Game Yang ingin Dihapus : ");
                    String nameGame = input.nextLine();
                    controller.deleteGame(nameGame);
                    // if (deleted) {
                    //     System.out.println("Game Berhasil Dihapus");
                    // }
                    // else {
                    //     System.out.println("Game Tidak Dapat Ditemukan");
                    // }
                    break;

                case 4:
                    System.out.println("Daftar Game");
                    for (NodeGames game : controller.viewGames()) {
                        System.out.println("Nama game : " + game.nameGame);
                        System.out.println("Nama Currency :" + game.currencyName);
                    }
                    break;

                case 5:
                    // System.out.println("LIST USER");
                    // ArrayList <NodeUser> listUser = new ArrayList<>();
                    // listUser = modeluser.ViewAllUser();
                    // if (listUser != null){
                    //     for (NodeUser user : listUser){
                    //         System.out.println("Email User : "+user.getEmail());
                    //         System.out.println("Password User : "+user.getPass());
                    //         System.out.println("Pin User : "+user.getPin());
                    //         System.out.println("--------------------");
                    //     }
                    // }
                    System.out.println("Belum Selesai");
                    break;

                case 6 :
                    input.nextLine();
                    System.out.println("Masukkan Nama Game Yang ingin dicari : ");
                    String nameGameSearch = input.nextLine();
                    NodeGames games = controller.searchGame(nameGameSearch);
                    if (games == null){
                        System.out.println("Game Tidak Ada");
                    }else{
                        System.out.println("Nama Game : "+games.nameGame);
                        System.out.println("Nama Currency : "+games.currencyName);
                    }
                    break;

                case 7:
                    System.out.println("Log Out");
                    break;
                    
                default:
                    System.out.println("Pilih menu yang tersedia");
                    break;
            }
        
        }while(pilih !=7);

    input.close();
    // modelgames.commit();
    }

}