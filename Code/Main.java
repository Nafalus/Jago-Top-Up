package Code;


// import Code.Model.ModelAdmin;
// import Code.Model.ModelUser;
// import Code.Model.Login;
import Code.ModelJSON.ModelJSONAdmin;
import Code.Node.NodeAdmin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        System.out.println(modelJSONAdmin.cekFile());

        ArrayList <NodeAdmin> listadmin2 = new ArrayList<>();
        listadmin2.add(new NodeAdmin("Nopal PenYepong Miku", "JJJJJ") );
        listadmin2.add(new NodeAdmin("Gendy Goib", "Memang Goib") );

        // Tes func Write File Json
        modelJSONAdmin.writeFileJSON(listadmin2);
    }
}
