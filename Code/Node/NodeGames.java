package Code.Node;

public class NodeGames {
    String Name, currencyName;
    
    public NodeGames (String Name, String currencyName) {
        this.Name = Name;
        this.currencyName = currencyName;
    }

    public String getName () {
        return this.Name;
    }

    public String getcurrencyName () {
        return this.currencyName;
    }
}