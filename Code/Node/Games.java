package Code.Node;

public class Games {
    String Name, currencyName;
    
    public Games (String Name, String currencyName) {
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