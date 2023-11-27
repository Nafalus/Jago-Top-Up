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
        // ModelUser modeluser = new ModelUser();
        // ModelAdmin modeladmin = new ModelAdmin();
        // Login login = new Login();

        // login.Validasi();
        // System.out.println("Admin : " + login.validAdmin);
        // System.out.println("User : " + login.validUser);
        
        // modeluser.RegisterUser("Nopal Penyepong Miku", "Palll", 1234);
        // modeluser.ViewAllUser();
        // modeluser.updateUser("Budi","Pale Pale",1111);
        // modeluser.ViewAllUser();
        // modeladmin.ViewAllAdmin();

        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        System.out.println(modelJSONAdmin.cekFile());


        
        // ArrayList <NodeAdmin> listadmin = null;
        // JSONArray arrayAdmin1 = modelJSONAdmin.convertArrayListToArrayJSON(listadmin);
        // System.out.println("Testing Array 1 : " + arrayAdmin1);

        ArrayList <NodeAdmin> listadmin2 = new ArrayList<>();
        listadmin2.add(new NodeAdmin("Nopal PenYepong Miku", "JJJJJ") );
        // JSONArray arrayAdmin2 = modelJSONAdmin.convertArrayListToArrayJSON(listadmin2);
        // System.out.println("Testing Array 2 : " + arrayAdmin2);

        // Tes func Write File Json
        modelJSONAdmin.writeFileJSON(listadmin2);
        
        // listAdmin.add(new NodeAdmin("Nopal Pentepong Miku", "JJJJJ") );
        // JSONArray arrayAdmin = modelJSONAdmin.convertArrayListToArrayJSON(listAdmin);
        // listAdmin.add(new NodeAdmin("Kokok", "kkkkkk"));
        
        // System.out.println("Read JSONArray : " + arrayAdmin);
        // for (NodeAdmin Admin : listAdmin){
        //     System.out.println(Admin.email);
        //     System.out.println(Admin.pass);
        // }
    
    }
}
