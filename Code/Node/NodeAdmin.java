package Code.Node;

public class NodeAdmin {
    public String email, pass;
    
    public NodeAdmin (String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getemail () {
        return this.email;
    }

    public String getPass () {
        return this.pass;
    }

    public void ViewAdmin(){
        System.out.println("Email Admin : " + this.email);
        System.out.println("Password Admin : " + this.pass);

}
}
