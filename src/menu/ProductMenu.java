package menu;

import test.ProductList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProductMenu {

    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);

        MainMenu mainMenu = new MainMenu();
        ProductList productList = new ProductList();

        File file = new File("FileProduct.txt");

        System.out.println("----- MENU PRODUIT ----- \n");
        System.out.println("1. AJOUTER UN PRODUIT \n");
        System.out.println("2. MODIFIER UN PRODUIT \n");
        System.out.println("3. SUPPRIMER UN PRODUIT \n");
        System.out.println("4. AFFICHER LES PRODUITS \n");
        System.out.println("0. MENU PRINCIPAL \n");

        System.out.println("--------------------------- \n");
        System.out.println("Saisir une valeur : \n");

        int reponse = sc.nextInt();

        switch (reponse) {

            case 0:
                mainMenu.menu();
                break;

            case 1:
                productList.readFromFile(file);
                productList.input();
                productList.writeToFile(file);
                mainMenu.menu();
                break;
            case 2:
                System.out.println("En maintenance...");
                mainMenu.menu();
                break;
            case 3:
                System.out.println("En maintenance...");
                mainMenu.menu();
                break;
            case 4:
                productList.readFromFile(file);
                productList.display();
                mainMenu.menu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + reponse);
        }


    }
}
