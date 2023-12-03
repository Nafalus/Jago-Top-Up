package Code.View;

import java.util.ArrayList;
import java.util.Scanner;

import Code.Model.ModelGames;
import Code.Model.ModelUser;
import Code.ModelJSON.ModelJSONGames;
import Code.Node.NodeGames;

public class MenuAdmin {
    ModelGames modelgames = new ModelGames();
    ModelUser modeluser = new ModelUser();



    public MenuAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("MENU ADMIN");
        System.out.println("1. Tambah Game");
        System.out.println("2. Edit Game");
        System.out.println("3. Hapus Game");
        System.out.println("4. Lihat Game");
        System.out.println("5. Lihat User");
        System.out.println("6. Log Out");
        System.out.print("Pilih Menu : ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1:
                ModelJSONGames modelJSONGames = new ModelJSONGames();
                ArrayList<NodeGames> listGames = modelJSONGames.readFromJSON();
                // buat baca data di database kalo kosong biar gak ngasih [] manual
                if (listGames == null) {
                    listGames = new ArrayList<>();
                }

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

                // Save data ke Json
                listGames.add(newGame);
                modelJSONGames.writeFileJSON(listGames);

                // Cetak Data
                System.out.println("LIST ITEM DAN HARGA");
                for (NodeGames game : listGames) {
                    System.out.println("Game : " + game.nameGame);
                    System.out.println("Currency : " + game.currencyName);
                    System.out.println("Items:");
                    for (NodeGames.Item item : game.getItems()) {
                        System.out.println("  - " + item.itemName + ": Rp" + item.itemPrice);
                    }
                    System.out.println("-----------------------");
                }
            
                break;
            case 2:
                break;
            case 3:
            
                System.out.println("Masukkan Nama Game Yang ingin Dihapus : ");
                String gameName = input.nextLine();
                modelgames.DeleteGame(gameName);
                break;
            case 4:
                modelgames.ViewAllGames();
                break;
            case 5:
                System.out.println("LIST USER");
                modeluser.ViewAllUser();
                break;
            case 6:
                break;
            default:
                break;
        }
        
    }
}
