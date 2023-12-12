package Code.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Node;

import Code.Model.ModelGames;
import Code.ModelJSON.ModelJSONGames;
// import Code.Node.NodeAdmin;
// import Code.Node.NodeUser;
// import Code.Node.NodeGames;
import Code.Node.NodeGames;

public class ControllerGames {
    private ModelGames model;
    // private Scanner input;

    public ControllerGames (ModelGames model){
        this.model = model;
        // this.model = model;
        // this.input = new Scanner(System.in);
    }
    

    public ArrayList <NodeGames> viewGames(){
        return model.ViewAllGames();
    }
    public void addGame (String gameName, String currencyName) {
        model.addGame(gameName, currencyName);
    }

    public void deleteGame (String gameName) {
        NodeGames game = model.getGame(gameName);
        if (game == null) {
            System.out.println("Game Tidak Ditemukan!!!");
        }
        else {
            model.deleteGame(game);
        }
    }
    
    public NodeGames searchGame (String nameGame){
        return model.getGame(nameGame);
    }

    public void updateGame(String nameGame,String newnameGame,String currencyName){
        NodeGames games = model.getGame(nameGame);
        if (games == null){
            System.out.println("Game Tidak DItemukan");
        }else{
            games.nameGame = newnameGame;
            games.currencyName = currencyName;
            model.updateGame(games);
        }
    }





}
