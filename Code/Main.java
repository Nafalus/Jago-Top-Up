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
import Code.View.MenuUser;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;


public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        // ModelJSONAdmin modelJSONAdmin = new ModelJSONAdmin();
        // System.out.println(modelJSONAdmin.cekFile());

        // ArrayList <NodeAdmin> listAdmin = new ArrayList<>();
        // listAdmin.add(new NodeAdmin("Davin Mbokne ancok", "ancen jancok") );
        // listAdmin.add(new NodeAdmin("Gendy Goib", "Memang Goib") );
        // modelJSONAdmin.writeFileJSON(listAdmin);
        // listAdmin = modelJSONAdmin.readFromJSON();
        // for (NodeAdmin admin : listAdmin) {
        //     System.out.println("Email : " + admin.email);
        //     System.out.println("Password : " + admin.pass);
        //     System.out.println("-----------------------");
        // }

        // NodeAdmin objAdmin = new NodeAdmin(null, null);
        // System.out.println("Masukkan Email : ");
        // objAdmin.email = input.nextLine();
        // System.out.println("Masukkan Password : ");
        // objAdmin.pass = input.nextLine();
        // modelJSONAdmin.Insert(objAdmin);



        // ModelJSONUser modelJSONUser = new ModelJSONUser();
        // ArrayList <NodeUser> listuser1 = new ArrayList<>();
        // listuser1.add(new NodeUser("Nopal Penyepong Miku", "Nigga Hitam", 121) );
        // listuser1.add(new NodeUser("Miku Bitchi", "Nopal Weabo" , 221) );
        // modelJSONUser.writeFileJSON(listuser1);
        // for (NodeUser user : listuser1) {
        //     System.out.println("Email : " + user.email);
        //     System.out.println("Password : " + user.pass);
        //     System.out.println("Pin : " + user.pin);
        //     System.out.println("-----------------------");
        // } 


        ModelJSONGames modelJSONGames = new ModelJSONGames();
        ArrayList<NodeGames> listGames = modelJSONGames.readFromJSON();
        // buat baca data di database kalo kosong biar gak ngasih [] manual
        if (listGames == null) {
            listGames = new ArrayList<>();
        }

        NodeGames newGame = new NodeGames(null, null);
        System.out.println("Masukkan Nama Game Baru : ");
        newGame.nameGame = input.nextLine();
        System.out.println("Masukkan Currency Game Baru : ");
        newGame.currencyName = input.nextLine();

        // Tambah item & harga
        boolean tambahItem = true;
        while (tambahItem) {
            System.out.println("Masukkan Nama Item : ");
            String itemName = input.nextLine();
            double itemPrice = 0;

            boolean validInput = false;
            while (!validInput) {
                System.out.println("Masukkan Harga Item : ");
                String inputPrice = input.nextLine();
            
                if (inputPrice.matches("\\d+(\\.\\d+)?")) {
                    itemPrice = Double.parseDouble(inputPrice);
                    validInput = true;
                } else {
                    System.out.println("Harga harus berupa angka. Silakan coba lagi.");
                }
            }
            

            // Tambah item game
            newGame.addItem(itemName, itemPrice);

            System.out.println("Tambah item lagi? (y/n): ");
            String tambahLagi = input.nextLine();
            tambahItem = tambahLagi.equalsIgnoreCase("y");
        }

        // Save data ke Json
        listGames.add(newGame);
        modelJSONGames.writeFileJSON(listGames);

        // Cetak Data
        System.out.println("LIST ITEM DAN HARGA");
        for (NodeGames game : listGames) {
            System.out.println("Game : " + game.nameGame);
            System.out.println("Currency : " + game.currencyName);
            System.out.println("Items:");
            for (NodeGames.Item item : game.getItems()) {
                System.out.println("  - " + item.itemName + ": Rp" + item.itemPrice);
            }
            System.out.println("-----------------------");
        }
    }

    
}

