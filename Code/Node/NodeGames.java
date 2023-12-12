package Code.Node;

import java.util.ArrayList;

public class NodeGames {
    public String nameGame;
    public String currencyName;
    // public ArrayList<Item> items;

    public NodeGames(String nameGame, String currencyName) {
        this.nameGame = nameGame;
        this.currencyName = currencyName;
        // this.items = new ArrayList<>();
    }

    public String getNameGame() {
        return nameGame;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    // public ArrayList <Item> getItems() {
    //     return items;
    // }

   

    // public void addItem(String itemName, double itemPrice) {
    //     this.items.add(new Item(itemName, itemPrice));
    // }

    
    // public static class Item {
    //     public String itemName;
    //     public double itemPrice;

    //     public Item(String itemName, double itemPrice) {
    //         this.itemName = itemName;
    //         this.itemPrice = itemPrice;
    //     }

    //     public void setItemName(String itemName) {
    //         this.itemName = itemName;
    //     }

    //     public void setItemPrice(double itemPrice) {
    //         this.itemPrice = itemPrice;
    //     }

    //     public String getItemName(){
    //         return itemName;
    //     }

    //     public double getItemPrice(){
    //         return itemPrice;
    //     }
    // }
}
