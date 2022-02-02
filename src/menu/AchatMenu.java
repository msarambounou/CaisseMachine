package menu;
import test.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AchatMenu {

    public void menu() throws IOException {

        Scanner sc = new Scanner(System.in);

        File file = new File("AchatFile.txt");

        MainMenu mainMenu = new MainMenu();


        AchatList achatList = new AchatList();
        CustomerList customerList = new CustomerList();
        ProductList productList = new ProductList();
        CategoryList categoryList = new CategoryList();

        System.out.println("----- MENU ACHAT ----- \n");

        System.out.println("1. AJOUTER UN ACHAT \n");
        System.out.println("2. MODIFIER UN ACHAT \n");
        System.out.println("3. SUPPRIMER UN ACHAT \n");
        System.out.println("4. AFFICHER LES ACHAT \n");

        System.out.println("--------------------------- \n");
        System.out.println("Saisir une valeur : \n");

        int reponse = sc.nextInt();

        switch (reponse){
            case 1:
                achatList.readFromFile(file);
                achatList.input();
                achatList.writeToFile(file);
                mainMenu.menu();
                break;
            case 2:System.out.println("En maintenance...");
                break;
            case 3:System.out.println("En maintenance...");
                break;
            case 4:System.out.println("En maintenance...");
                break;
        }

    }
}
