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


import Code.Node.NodeUser;


public class ModelJSONUser {
    String fname = "Code/Database/DatabaseUser.json";

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
    
    public JSONArray convertArrayListToArrayJSON(ArrayList <NodeUser> listUser){
        if (listUser == null){
            return null;
        }else {
            JSONArray arrayUser = new JSONArray();
            for (NodeUser USer : listUser){
                JSONObject objUser = new JSONObject();
                objUser.put("email",USer.email);
                objUser.put("pass",USer.pass) ;
                objUser.put("pin",USer.pin) ; 
                arrayUser.add(objUser);
            }
            return arrayUser;
        }
    }

    public void writeFileJSON(ArrayList <NodeUser> listUser){
        JSONArray arrayUser = convertArrayListToArrayJSON(listUser);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayUser.toJSONString());
            file.flush();
            file.close();
        }
        
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList <NodeUser> readFromJSON () {
        if (cekFile() == false){
            return null;
        }
        ArrayList listUser = null;
        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayUser = (JSONArray) parser.parse(reader);
            listUser = convertJSONArrayToArrayList(arrayUser);
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
        return listUser;
    }

    public ArrayList <NodeUser> convertJSONArrayToArrayList (JSONArray arrayUser) {
        if (arrayUser == null) {
            return null;
        }
        else {
            ArrayList <NodeUser> listUser = new ArrayList<>();
            for (Object objUser : arrayUser) {
                JSONObject User = (JSONObject) objUser;
                String email = User.get("email").toString();
                String pass = User.get("pass").toString();
                int pin = Integer.parseInt(User.get("pin").toString());
                listUser.add(new NodeUser(email, pass,pin));
            }
            return listUser;
        }
    }
}