package Code.Model;

import java.util.ArrayList;

import Code.ModelJSON.ModelJSONGames;
import Code.Node.NodeAdmin;
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
        if (listGames == null) {
            System.out.println("Data Game Kosong");
        }else{
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
            for (int i = 0; i < listGames.size(); i++) {
                NodeGames game = listGames.get(i);
                if (game.getNameGame().equalsIgnoreCase(nameGame)) {
                    listGames.remove(i);
                    new ModelJSONGames().writeFileJSON(listGames);
                    break;
                }
            }
        }
    }
    
    
    // Done
    public void searchGame(String nameGame) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(nameGame)) {
                    game.viewGame();
                    break;
                }
            }
        }
    }
    
}

