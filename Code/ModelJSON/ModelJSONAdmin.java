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

import Code.Node.NodeAdmin;
import Code.NodeJSON.NodeJSONAdmin;


public class ModelJSONAdmin {
    String fname = "Code/Database/DatabaseAdmin.json";

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
    
    public JSONArray convertArrayListToArrayJSON(ArrayList <NodeAdmin> listAdmin){
        if (listAdmin == null){
            return null;
        }else {
            JSONArray arrayAdmin = new JSONArray();
            for (NodeAdmin Admin : listAdmin){
                JSONObject objAdmin = new JSONObject();
                objAdmin.put("email", Admin.email);
                objAdmin.put("pass", Admin.pass);
                arrayAdmin.add(objAdmin);
            }
            return arrayAdmin;
        }
    }

    public void writeFileJSON(ArrayList <NodeAdmin> listAdmin){
        JSONArray arrayAdmin = convertArrayListToArrayJSON(listAdmin);
        try {
            FileWriter file = new FileWriter(fname);
            file.write(arrayAdmin.toJSONString());
            file.flush();
            file.close();
        }
        
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList <NodeAdmin> readFromJSON () {
        if (cekFile() == false){
            return null;
        }
        ArrayList listAdmin = null;
        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader(fname);
            JSONArray arrayAdmin = (JSONArray) parser.parse(reader);
            listAdmin = convertJSONArrayToArrayList(arrayAdmin);
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
        return listAdmin;
    }

    public ArrayList <NodeAdmin> convertJSONArrayToArrayList (JSONArray arrayAdmin) {
        if (arrayAdmin == null) {
            return null;
        }
        else {
            ArrayList <NodeAdmin> listAdmin = new ArrayList<>();
            for (Object objectAdmin : arrayAdmin) {
                JSONObject Admin = (JSONObject) objectAdmin;
                String email = Admin.get("email").toString();
                String pass = Admin.get("pass").toString();
                listAdmin.add(new NodeAdmin(email, pass));
            }
            return listAdmin;
        }
    }

    public void Insert (NodeAdmin paramInsert) {
        ArrayList <NodeAdmin> listAdmin = readFromJSON();
        listAdmin.add(new NodeAdmin(paramInsert.email, paramInsert.pass));
        writeFileJSON(listAdmin);
    }
}