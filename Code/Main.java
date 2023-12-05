package Code;

import Code.Model.ModelGames;
import Code.Model.ModelUser;
// import Code.Model.ModelAdmin;
// import Code.Model.ModelUser;
// import Code.Model.Login;
import Code.ModelJSON.ModelJSONAdmin;
import Code.ModelJSON.ModelJSONGames;
import Code.ModelJSON.ModelJSONUser;
import Code.Node.NodeAdmin;
import Code.Node.NodeGames;
import Code.Node.NodeUser;
import Code.View.MenuAdmin;
import Code.View.MenuUser;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;


public class Main {
    public static void main(String[] args) {
        ModelGames modelgame = new ModelGames();
        ModelUser modeluser = new ModelUser();
        MenuAdmin menuadmin = new MenuAdmin();
        
        Scanner input = new Scanner(System.in);

        // ModelJSONUser modelJSONUser = new ModelJSONUser();
        // ArrayList <NodeUser> listuser1 = new ArrayList<>();
        // listuser1.add(new NodeUser("Nopal Penyepong Miku", "Nigga Hitam", 121) );
        // listuser1.add(new NodeUser("Miku Bitchi", "Nopal Weabo" , 221) );
        // modelJSONUser.writeFileJSON(listuser1);
        // modeluser.ViewAllUser();
        // modeluser.DeleteUser("Nopal Penyepong Miku");
        // System.out.println("Admin Terdaftar");
        modeluser.ViewAllUser();

        // modelgame.ViewAllGames();
        menuadmin.menuAdmin();
        
    
}
}


