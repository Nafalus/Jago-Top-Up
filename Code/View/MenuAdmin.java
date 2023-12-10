package Code.View;
import java.util.Scanner;

import Code.Model.ModelGames;
import Code.Model.ModelUser;
import Code.Node.NodeGames;

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
        System.out.println("6. Search Games");
        System.out.println("7. Log Out");
        System.out.print("Pilih Menu : ");
        pilih = input.nextInt();
        

        switch (pilih) {
            case 1:
            input.nextLine();
                NodeGames newGame = new NodeGames(null, null);
                System.out.println("Masukkan Nama Game Baru : ");
                newGame.nameGame = input.nextLine();
                System.out.println("Masukkan Currency Game Baru : ");
                newGame.currencyName = input.nextLine();

                // Tambah item & harga
                boolean tambahItem = true;
                while (tambahItem) {
                    System.out.println("Masukkan Nama Item : ");
                    String itemName = input.nextLine();
                    double itemPrice = 0;

                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println("Masukkan Harga Item : ");
                        String inputPrice = input.nextLine();
                    
                        if (inputPrice.matches("\\d+(\\.\\d+)?")) {
                            itemPrice = Double.parseDouble(inputPrice);
                            validInput = true;
                        } else {
                            System.out.println("Harga harus berupa angka. Silakan coba lagi.");
                        }
                    }
                    

                    // Tambah item game
                    newGame.addItem(itemName, itemPrice);

                    System.out.println("Tambah item lagi? (y/n): ");
                    String tambahLagi = input.nextLine();
                    tambahItem = tambahLagi.equalsIgnoreCase("y");
                }
                modelgames.addGame(newGame);
                break;
                
            case 2:
                input.nextLine();
                System.out.println("Masukkan Nama Game Yang ingin DiEdit : ");
                String namegame = input.nextLine();
                NodeGames paraGames = modelgames.searchGame(namegame);
                for (NodeGames.Item item : paraGames.getItems()) {
                    System.out.println("Masukkan Nama item : ");
                    String itemName = input.nextLine();
                    if (item.itemName.equalsIgnoreCase(itemName)) {
                        input.nextLine();
                        System.out.println("Masukkan Harga Baru : ");
                        double newPrice = input.nextDouble();
                        item.setItemPrice(newPrice);
                        break;
                    }else{
                        System.out.println("Item Tidak Ditemukan");
                    }
                }
                modelgames.updateItemPrice(paraGames);
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

            case 6 :
                input.nextLine();
                System.out.println("Masukkan Nama Game Yang ingin dicari : ");
                String nameGameSearch = input.nextLine();
                System.out.println("Nama Game : " + modelgames.searchGame(nameGameSearch).nameGame);
                System.out.println("Nama Currency Game : " + modelgames.searchGame(nameGameSearch).getCurrencyName());
                System.out.println("Daftar Item : ");
                for (NodeGames.Item item : modelgames.searchGame(nameGameSearch).getItems()) {
                    System.out.println("  - " + item.getItemName() + ": Rp" + item.getItemPrice());
                }
                break;

            // case 6:
            //     System.out.println("Log Out");
            //     break;
            default:
                System.out.println("Pilih menu yang tersedia");
                break;
        }
        
    }while(pilih !=7);

    input.close();
}
}