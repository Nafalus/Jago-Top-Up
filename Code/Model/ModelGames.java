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
    public void addGame(NodeGames paramGames){
        // Scanner input = new Scanner(System.in);
        ModelJSONGames modelJSONGames = new ModelJSONGames();
        ArrayList<NodeGames> listGames = modelJSONGames.readFromJSON();
        // buat baca data di database kalo kosong biar gak ngasih [] manual
        if (listGames == null) {
            listGames = new ArrayList<>();
        }

        listGames.add(paramGames);
        
        // Cetak Data
        // System.out.println("LIST ITEM DAN HARGA");
        // for (NodeGames game : listGames) {
        //     System.out.println("Game : " + game.nameGame);
        //     System.out.println("Currency : " + game.currencyName);
        //     System.out.println("Items:");
        //     for (NodeGames.Item item : game.getItems()) {
        //         System.out.println("  - " + item.itemName + ": Rp" + item.itemPrice);
        //     }
        //     System.out.println("-----------------------");
        // }
        
        modelJSONGames.writeFileJSON(listGames);
    }
    
    // Done
    public ArrayList <NodeGames> ViewAllGames() {
        ArrayList <NodeGames> listGames = new ModelJSONGames().readFromJSON();
        return listGames;
    }

    // Done
        public boolean DeleteGame(String nameGame) {
            ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
            boolean found = false;
            if (listGames != null) {
                for (NodeGames games : listGames){
                    if (games.getNameGame().equalsIgnoreCase(nameGame)) {
                        listGames.remove(games);
                        found = true;
                        new ModelJSONGames().writeFileJSON(listGames);
                        break;
                    }
                }
                if (!found) {
                    return found;
                }
            }
            return found;
        }

    
    // Done
    public NodeGames searchGame(String nameGame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        boolean found = false;
        NodeGames paramOut = new NodeGames(null, null);
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(nameGame)) {
                    paramOut = game;
                }
            }
            if (found) {
                return null;
            }
        }
        return paramOut;
    }


    // Done
    public void updateItemPrice(NodeGames paramGames) {
        Scanner input = new Scanner(System.in);
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(paramGames.getNameGame())) {
                    game = paramGames;
                    // for (NodeGames.Item item : game.getItems()) {
                    //     System.out.println("Masukkan Nama item : ");
                    //     String itemName = input.nextLine();
                    //     if (item.itemName.equalsIgnoreCase(itemName)) {
                    //         input.nextLine();
                    //         System.out.println("Masukkan Harga Baru : ");
                    //         double newPrice = input.nextDouble();
                    //         item.setItemPrice(newPrice);
                    //         break;
                    //     }else{
                    //         System.out.println("Item Tidak Ditemukan");
                    //     }
                    // }
                    new ModelJSONGames().writeFileJSON(listGames);
                    break;
                }
            }
        }
        else {
            System.out.println("List Game Kosong");
        }
    }
}

