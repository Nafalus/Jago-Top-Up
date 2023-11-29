package Code.ModelJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList; 



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Code.Node.NodeGames;
import Code.Node.NodeUser;


public class ModelJSONGames {
    String fname = "Code/Database/DatabaseGames.json";

    public boolean cekFile () {
        boolean output = false;
        try {
            java.io.File file = new java.io.File(fname);
            if (file.exists()){
                output = true;
            }
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return output;
    }
    
    public JSONArray convertArrayListToArrayJSON(ArrayList <NodeGames> listGame){
        if (listGame == null){
            return null;
        }else {
            JSONArray arrayGame = new JSONArray();
            for (NodeGames Game : listGame){
                JSONObject objGame = new JSONObject();
                objGame.put("nameGame", Game.nameGame);
                objGame.put("currencyGame", Game.currencyName); 
                arrayGame.add(objGame);
            }
            return arrayGame;
        }
    }

    public void writeFileJSON(ArrayList <NodeGames> listGame){
        JSONArray arrayGame = convertArrayListToArrayJSON(listGame);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayGame.toJSONString());
            file.flush();
            file.close();
        }
        
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList <NodeGames> readFromJSON () {
        if (cekFile() == false){
            return null;
        }
        ArrayList listGame = null;
        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayGame = (JSONArray) parser.parse(reader);
            listGame = convertJSONArrayToArrayList(arrayGame);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException (e);
        }
        catch (IOException e) {
            throw new RuntimeException (e);
        }
        catch (ParseException e) {
            throw new RuntimeException (e);
        }
        return listGame;
    }

    public ArrayList <NodeGames> convertJSONArrayToArrayList (JSONArray arrayGame) {
        if (arrayGame == null) {
            return null;
        }
        else {
            ArrayList <NodeGames> listGame = new ArrayList<>();
            for (Object objGame : arrayGame) {
                JSONObject Game = (JSONObject) objGame;
                String nameGame = Game.get("nameGame").toString();
                String currencyName = Game.get("currencyGame").toString();
                listGame.add(new NodeGames(nameGame,currencyName));
            }
            return listGame;
        }
    }
}