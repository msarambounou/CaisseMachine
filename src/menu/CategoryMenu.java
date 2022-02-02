package menu;

import test.CategoryList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CategoryMenu {

    public void menu() throws IOException {

        MainMenu mainMenu = new MainMenu();
        CategoryList categoryList = new CategoryList();


        int reponse = 0;
        Scanner sc = new Scanner(System.in);
        File file = new File("FileCategory.txt");

        System.out.println("----- MENU PRODUIT ----- \n");

        System.out.println("1. AJOUTER UNE CATEGORIE \n");
        System.out.println("2. MODIFIER UNE CATEGORIE \n");
        System.out.println("3. SUPPRIMER UNE CATEGORIE \n");
        System.out.println("4. AFFICHER LES CATEGORIES \n");

        System.out.println("0. MENU PRINCIPAL \n");


        System.out.println("--------------------------- \n");
        System.out.println("Saisir une valeur : \n");

        reponse = sc.nextInt();

        switch (reponse) {

            case 0 :
                mainMenu.menu();
                break;

            case 1 :
                categoryList.readFromFile(file);
                categoryList.input();
                categoryList.writeToFile(file);
                mainMenu.menu();
                break;

            case 2:
                categoryList.readFromFile(file);
                categoryList.updateCaterory();
                categoryList.writeToFile(file);
                mainMenu.menu();

            case 3:
                categoryList.readFromFile(file);
                categoryList.deleteCategory();
                categoryList.writeToFile(file);
                mainMenu.menu();
                break;
            case 4:
                categoryList.readFromFile(file);
                categoryList.display();
                mainMenu.menu();
                break;
        }

    }
}
