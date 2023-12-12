package Code.Model;

import java.util.ArrayList;

import java.util.Scanner;
import Code.ModelJSON.ModelJSONGames;
import Code.Node.NodeGames;

public class ModelGames {
    private ArrayList<NodeGames> listGame;
    private ModelJSONGames modelJSONGames;

    public ModelGames() {
        modelJSONGames = new ModelJSONGames();
        listGame = modelJSONGames.readFromJSON();
        // loadGame();
    }

    public void loadGame () {
        listGame = modelJSONGames.readFromJSON();
    }

    // Done
    public void addGame(String gameName, String currencyName){
        // ArrayList<NodeGames> listGame = new ModelJSONGames().readFromJSON();
        
        NodeGames newGame = new NodeGames(gameName, currencyName);
        listGame.add(newGame);
        // commit();
        // new ModelJSONGames().writeFileJSON(listGame);
    }
    
    // Done
    public ArrayList <NodeGames> ViewAllGames() {
        // ArrayList <NodeGames> listGame = new ModelJSONGames().readFromJSON();
        return listGame;
    }

    // Done
    public void deleteGame(NodeGames nameGame) {
        // ArrayList<NodeGames> listGame = new ModelJSONGames().readFromJSON();
        listGame.remove(nameGame);
        // new ModelJSONGames().writeFileJSON(listGame);
        // commit();
    }

    // Done
    public NodeGames searchGame(String nameGame) {
        // ArrayList<NodeGames> listGame = new ModelJSONGames().readFromJSON();
        boolean found = false;
        NodeGames paramOut = new NodeGames(null, null);
        if (listGame != null) {
            for (NodeGames game : listGame) {
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
    public void updateGame(NodeGames paramGames) {
        // Scanner input = new Scanner(System.in);
        // ArrayList<NodeGames> listGame = new ModelJSONGames().readFromJSON();
        if (listGame != null) {
            for (NodeGames game : listGame) {
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
                    // new ModelJSONGames().writeFileJSON(listGame);
                    break;
                }

            }
        }
        else {
            System.out.println("List Game Kosong");
        }
        // commit();
    }

    public NodeGames getGame (String gameName) {
        NodeGames gameKosong = null;
        for (NodeGames game : listGame) {
            if (game.getNameGame().equalsIgnoreCase(gameName)) {
                return game;
            }
        }
        return gameKosong;
    }

    public void commit () {
        new ModelJSONGames().writeFileJSON(listGame);
    }

    public ArrayList <NodeGames> getGames(){
        return listGame;
    }
    
}

