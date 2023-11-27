package Code.Model;

import java.util.ArrayList;
import java.util.Scanner;

import Code.Node.NodeUser;
import Code.Controller.Controller;
// import Code.Model.ModelUser;

public class Login {
    ArrayList <NodeUser> dataUser;
    public boolean validAdmin, validUser;

    public Login () {
        validAdmin = false;
        validUser = false;
        this.dataUser = new ArrayList<NodeUser>();
        Controller temp = new Controller();
        ModelUser tempModelUser = new ModelUser();
        this.dataUser.add(temp.getEmailPass());
        for (int i = 1; i < tempModelUser.getListDataUser().size() + 1; i++) {
            this.dataUser.add(i, null);
        }
    }

    public void Validasi () {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("========================\nSilahkan Melakukan Login\n========================\n");
            System.out.print("Masukkan Id :");
            String email = input.nextLine();
            System.out.print("Masukkan Password : ");
            String pass = input.nextLine();
            
            for (int i=0;i<this.dataUser.size();i++) {
                if (email.equals(this.dataUser.get(i).getemail()) && pass.equals(this.dataUser.get(i).getPass()) && i == 0) {
                    this.validAdmin = true;
                }
                else if (email.equals(this.dataUser.get(i).getemail()) && pass.equals(this.dataUser.get(i).getPass()) && i > 0) {
                    this.validUser = true;
                }
            }

        } while (!validAdmin && !validUser);

        input.close();
    }
}