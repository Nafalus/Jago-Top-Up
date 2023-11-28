package Code.ModelJSON;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Code.Node.NodeAdmin;
import Code.NodeJSON.NodeJSONAdmin;

public class ModelJSONAdmin {
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

    public ArrayList <NodeAdmin> convertJSONArrayToArrayList (JSONArray arrayAdmin) {
        if (arrayAdmin == null) {
            return null;
        }
        else {
            ArrayList <NodeAdmin> listAdmin = new ArrayList<>();
            for (Object objectAdmin : arrayAdmin) {
                JSONObject admin = (JSONObject) objectAdmin;
                String email = admin.get().toString();
            }
            return listAdmin;
        }
    }
}