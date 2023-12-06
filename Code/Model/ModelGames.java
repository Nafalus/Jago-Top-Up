package Code.Model;

import java.util.ArrayList;

import java.util.Scanner;
import Code.ModelJSON.ModelJSONGames;
import Code.Node.NodeGames;

public class ModelGames {
    public ArrayList<NodeGames> dataGames;

    public ModelGames() {
        this.dataGames = new ArrayList<>();
    }


    // Done
    public void insertGames(String name, String currencyName) {
        dataGames.add(new NodeGames(name, currencyName));
    }


    // Done
    public void addGame(){
        Scanner input = new Scanner(System.in);
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

        
        listGames.add(newGame);
        
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
        
        modelJSONGames.writeFileJSON(listGames);
    }
    

    // Done
    public void ViewAllGames() {
        ArrayList <NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
             for (NodeGames game : listGames) {
                System.out.println("Nama Game: " + game.getNameGame());
                System.out.println("Nama Currency Game: " + game.getCurrencyName());
                System.out.println("Items:");
                for (NodeGames.Item item : game.getItems()) {
                    System.out.println("  - " + item.getItemName() + ": Rp" + item.getItemPrice());
                }
                System.out.println("--------------------");
            }
        }
    }

    // Done
        public void DeleteGame(String nameGame) {
            ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
            boolean found = false;
            if (listGames != null) {
                for (NodeGames games : listGames){
                    if (games.getNameGame().equalsIgnoreCase(nameGame)) {
                        listGames.remove(games);
                        found = true;
                        new ModelJSONGames().writeFileJSON(listGames);
                        System.out.println("Game Berhasil Dihapus");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Game Tidak Ditemukan");
                }
            }
        }

    
    // Done
    public void searchGame(String nameGame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(nameGame)) {
                    System.out.println("Nama Game: " + game.getNameGame());
                    System.out.println("Nama Currency Game: " + game.getCurrencyName());
                    System.out.println("Items:");
                    for (NodeGames.Item item : game.getItems()) {
                        System.out.println("  - " + item.getItemName() + ": Rp" + item.getItemPrice());
                    }
                        System.out.println("--------------------");
                    break;
                }else{
                    System.out.println("Game Tidak Dapat Ditemukan");
                }
            }
        }
    }


    // Done
    public void updateItemPrice(String namegame) {
        Scanner input = new Scanner(System.in);
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(namegame)) {
                    for (NodeGames.Item item : game.getItems()) {
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
                    new ModelJSONGames().writeFileJSON(listGames);
                    break;
                }
            }
        } 
    }
}

