package Code.NodeJSON;

import java.util.ArrayList;

public class NodeJSONGames {
    public String nameGame;
    public String currencyName;
    public ArrayList<Item> items;

    public NodeJSONGames(String nameGame, String currencyName, ArrayList<Item> items) {
        this.nameGame = nameGame;
        this.currencyName = currencyName;
        this.items = items;
    }

    public static class Item {
        public String itemName;
        public double itemPrice;

        public Item(String itemName, double itemPrice) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }
    }
}
