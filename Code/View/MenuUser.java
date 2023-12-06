package Code.View;

import java.util.Scanner;


public class MenuUser {

    public void  menuUser() {
        Scanner input = new Scanner(System.in);
        int pilih;
        do{
        System.out.println("MENU USER");
        System.out.println("1. Cari Game");
        System.out.println("2. History Pembelian");
        System.out.println("3. Isi Saldo");
        System.out.println("4. Setting Akun");
        System.out.println("5. Logout");
        System.out.print("\nPilih menu : ");
        
        pilih = input.nextInt();

        switch (pilih) {
            case 1:
                break;
            case 2:
                System.out.println("History Pembelian");
                break;
            case 3:
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                break;
            default:
                System.out.println("Pilih menu yang tersedia");
                break;
            }
        }while(pilih != 5);
        
        input.close();
    }
}
