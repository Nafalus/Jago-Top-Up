package Code.Node;

import java.util.ArrayList;

public class NodeGames {
    public String nameGame;
    public String currencyName;
    public ArrayList<Item> items;

    public NodeGames(String nameGame, String currencyName) {
        this.nameGame = nameGame;
        this.currencyName = currencyName;
        this.items = new ArrayList<>();
    }

    public String getNameGame() {
        return this.nameGame;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void addItem(String itemName, double itemPrice) {
        this.items.add(new Item(itemName, itemPrice));
    }

    public void viewGame() {
        System.out.println("Nama Game: " + nameGame);
        System.out.println("Nama Currency Game: " + currencyName);
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - " + item.itemName + ": Rp" + item.itemPrice);
        }
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
