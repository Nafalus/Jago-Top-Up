package Code.Model;

import java.util.ArrayList;

// import Node

import Code.Node.NodeGames;
import Code.Controller.Controller;
public class ModelGames{
    public ArrayList <NodeGames> dataGames;
    Controller firstData;

    public ModelGames(){
        this.dataGames = new ArrayList<>();
    }

    public void insertAdmin (String name,String currencyName) {
        dataGames.add(new NodeGames(name, currencyName)); 
    }

    public void ViewAllAdmin(){
       for (int i = 0; i < this.dataGames.size(); i++){
            this.dataGames.get(i).ViewGames();
            System.out.println("--------------------");
       }
    }    

    public void DeleteUSer(String nameGame){
        for (int i=0; i< dataGames.size(); i++){
            if (nameGame.equalsIgnoreCase(dataGames.get(i).getNamegame())){
                dataGames.remove(i);
            }
        }
    }

    // public void updateHargaGame(String nameGame){
    //     for (int i = 0; i < dataGames.size(); i++){
    //         if (nameGame.equalsIgnoreCase(dataGames.get(i).getNamegame())){
    //             nameGame.get(i).setnameGame()
    //         }
    //     }
    // }

    public NodeGames searchGame(String nameGame){
        for (int i = 0; i < dataGames.size(); i++){
            if (nameGame.equalsIgnoreCase(dataGames.get(i).getNamegame())){
                return dataGames.get(i);
            }
        }
        return null;
    }


}