package Code;

import Code.Model.ModelGames;
// import Code.Model.ModelAdmin;
// import Code.Model.ModelUser;
// import Code.Model.Login;
import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONGames;
import Code.ModelJSON.ModelJSONUser;
import Code.Node.NodeAdmin;
import Code.Node.NodeGames;
import Code.Node.NodeUser;

import java.util.ArrayList;

import org.json.simple.JSONArray;


public class Main {
    public static void main(String[] args) {

        ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        // System.out.println(modelJSONAdmin.cekFile());

        ArrayList <NodeAdmin> listadmin1 = new ArrayList<>();
        listadmin1.add(new NodeAdmin("Davin Mbokne ancok", "ancen jancok") );
        listadmin1.add(new NodeAdmin("Gendy Goib", "Memang Goib") );
        modelJSONAdmin.writeFileJSON(listadmin1);
        for (NodeAdmin admin : listadmin1) {
            System.out.println("Email : " + admin.email);
            System.out.println("Password : " + admin.pass);
            System.out.println("-----------------------");
        }


        ModelJSONUser modelJSONUser = new ModelJSONUser();
        ArrayList <NodeUser> listuser1 = new ArrayList<>();
        listuser1.add(new NodeUser("Nopal Penyepong Miku", "Nigga Hitam", 121) );
        listuser1.add(new NodeUser("Miku Bitchi", "Nopal Weabo" , 221) );
        modelJSONUser.writeFileJSON(listuser1);
        for (NodeUser user : listuser1) {
            System.out.println("Email : " + user.email);
            System.out.println("Password : " + user.pass);
            System.out.println("Pin : " + user.pin);
            System.out.println("-----------------------");
        } 


        ModelJSONGames modelJSONGames = new ModelJSONGames();
        ArrayList <NodeGames> listgame = new ArrayList<>();
        listgame.add(new NodeGames("EMEL", "DEEM"));
        listgame.add(new NodeGames("EPEP", "DEEM"));
        modelJSONGames.writeFileJSON(listgame);
        for (NodeGames game : listgame) {
            System.out.println("Game : " + game.nameGame);
            System.out.println("Currency : " + game.currencyName);
            System.out.println("-----------------------");
        }


        


        // // Tes func Write File Json
        // modelJSONAdmin.writeFileJSON(listadmin1);
        // JSONArray arrayJSONAdmin = modelJSONAdmin.convertArrayListToArrayJSON(listadmin1);
        // ArrayList <NodeAdmin> listadmin2 = modelJSONAdmin.convertJSONArrayToArrayList(arrayJSONAdmin);
        // for (NodeAdmin Admin : listadmin2) {
        //     System.out.println(Admin.email);
        //     System.out.println(Admin.pass);            
        // }

    }
}
