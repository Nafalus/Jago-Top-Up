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

    public ControllerGames (){
        this.model = new ModelGames();
        // this.model = model;
        // this.input = new Scanner(System.in);
    }
    
    public void addGame (NodeGames paramGames) {
        model.addGame(paramGames);
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

}
