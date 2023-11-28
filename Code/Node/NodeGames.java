package Code.Node;

public class NodeGames {
    String nameGame, currencyName;
    
    public NodeGames (String nameGame, String currencyName) {
        this.nameGame = nameGame;
        this.currencyName = currencyName;
    }

    public String getNamegame () {
        return this.nameGame;
    }

    public String getcurrencyName () {
        return this.currencyName;
    }

    public void ViewGames(){
        System.out.println("Nama Game : "+nameGame);
        System.out.println("Nama Currency Game : "+currencyName);
    }
}
