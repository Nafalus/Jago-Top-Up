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
    public void ViewAllGames() {
        ArrayList <NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
             for (NodeGames game : listGames) {
                game.viewGame();
                System.out.println("--------------------");
            }
        }
    }

    // Done
    public void DeleteGame(String nameGame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(nameGame)) {
                    listGames.remove(game);
                    new ModelJSONGames().writeFileJSON(listGames);
                    break;
                }else{
                    System.out.println("Game Tidak Dapat Ditemukan / Dihapus");
                }
            }
        }
    }
    
    
    // Done
    public void searchGame(String nameGame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equals(nameGame)) {
                    game.viewGame();
                    break;
                }else{
                    System.out.println("Game Tidak Dapat Ditemukan");
                }
            }
        }
    }


    // Done
    public void updateItemPrice(String namegame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(namegame)) {
                    for (NodeGames.Item item : game.getItems()) {
                        System.out.println("Masukkan Nama item : ");
                        String itemName = new Scanner(System.in).nextLine();
                        if (item.itemName.equalsIgnoreCase(itemName)) {
                            Scanner input = new Scanner(System.in);
                            input.nextLine();
                            System.out.println("Masukkan Harga Baru : ");
                            double newPrice = new Scanner(System.in).nextDouble();
                            item.setItemPrice(newPrice);
                            break;
                        }else{
                            System.out.println("Item Tidak Ditemukan");
                        }
                    }
                    new ModelJSONGames().writeFileJSON(listGames);
                    break;
                }else {
                    System.out.println("Game Tidak Dapat Ditemukan");
                }
            }
        } 
    }
}

