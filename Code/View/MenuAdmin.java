package Code.View;

import java.util.Scanner;

public class MenuAdmin {
    
    public MenuAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("MENU ADMIN");
        System.out.println("1. Tambah Game");
        System.out.println("2. Edit Game");
        System.out.println("3. Hapus Game");
        System.out.println("4. Lihat Game");
        System.out.println("5. Lihat User");
        System.out.println("6. Log Out");
        System.out.print("Pilih Menu : ");
        int pilih = input.nextInt();

        switch (pilih) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;
        }
        
    }
}
