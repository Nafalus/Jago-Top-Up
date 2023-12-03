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
    

    // belum
    public void DeleteGames(String nameGame) {
        for (int i = 0; i < dataGames.size(); i++) {
            if (nameGame.equalsIgnoreCase(dataGames.get(i).getNameGame())) {
                dataGames.remove(i);
            }
        }
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


    // Done Mungkin belum cek
    public void searchGame(NodeGames paramInsert) {
        ArrayList<NodeGames> listGames = new ModelJSONGames().readFromJSON();
        if (listGames != null) {
            for (NodeGames game : listGames) {
                if (game.getNameGame().equalsIgnoreCase(paramInsert.getNameGame())) {
                    game.viewGame();
                    break;
                }
            }
        }
        System.out.println("Game Tidak Ditemukan");
    }
    
}

