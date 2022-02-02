package menu;
import test.Achat;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public void menu() throws IOException {

        CustomerMenu customerMenu = new CustomerMenu();
        ProductMenu productMenu = new ProductMenu();
        CategoryMenu categoryMenu = new CategoryMenu();
        AchatMenu achatMenu = new AchatMenu();


        int reponse;

        System.out.println("----- MENU PRINCIPAL -----\n");
        System.out.println("1. CLIENT \n");
        System.out.println("2. PRODUIT \n");
        System.out.println("3. CATEGORIE \n");
        System.out.println("4. ACHAT \n");
        System.out.println("0. QUITTEZ LE PROGRAMME \n");

        System.out.println("--------------------------- \n");
        System.out.println("Saisir une valeur : \n");

        Scanner scanner = new Scanner(System.in);

        reponse = scanner.nextInt();

        switch (reponse) {
            case 1 : customerMenu.menu();break;
            case 2 : productMenu.menu();break;
            case 3 : categoryMenu.menu(); break;
            case 4 : achatMenu.menu(); break;

            default:
                throw new IllegalStateException("Unexpected value: " + reponse);
        }


    }
}
