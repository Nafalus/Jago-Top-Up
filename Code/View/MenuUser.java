package Code.View;

import java.util.Scanner;

public class MenuUser {

    public static void  MenuUser() {
        Scanner input = new Scanner(System.in);
        int pilih;
        do{
        System.out.println("MENU USER");
        System.out.println("1. Cari Game");
        System.out.println("2. Isi Saldo");
        System.out.println("3. Setting Akun");
        System.out.println("4. Logout");
        System.out.print("\nPilih menu : ");
        
        pilih = input.nextInt();

        switch (pilih) {
            case 1:
                break;
            case 2:
                System.out.println("Isi Saldo");
                break;
            case 3:
                System.out.println("Setting Akun");
                break;
            case 4:
                System.out.println("Logout");
                break;
            default:
                System.out.println("Pilih menu yang tersedia");
                break;
            }
        }while(pilih != 6);
    }
}
