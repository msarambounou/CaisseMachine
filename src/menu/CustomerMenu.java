package menu;

import test.CustomerList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CustomerMenu {

    public void menu() throws IOException {

        MainMenu mainMenu = new MainMenu();
        CustomerList customerList = new CustomerList();

        int reponse = 0;
        File file = new File("FileCustomer.txt");
        Scanner sc = new Scanner(System.in);

        customerList.readFromFile(file);

        System.out.println("----- MENU CLIENT ----- \n");
        System.out.println("1. AJOUTER UN CLIENT \n");
        System.out.println("2. MODIFIER UN CLIENT \n");
        System.out.println("3. SUPPRIMER UN CLIENT \n");
        System.out.println("4. AFFICHER LES CLIENT \n");
        System.out.println("0. MENU PRINCIPAL \n");

        System.out.println("--------------------------- \n");
        System.out.println("Saisir une valeur : \n");

        reponse = sc.nextInt();

        switch (reponse) {

            case 0:
                mainMenu.menu();
                break;

            case 1:
                //customerList.readFromFile(file);
                customerList.inputCustomer();
                customerList.writeToFile(file);
                mainMenu.menu();
                break;
            case 2:
                //customerList.readFromFile(file);
                customerList.modifyCustomer();
                customerList.writeToFile(file);
                mainMenu.menu();
                break;
            case 3:
                //customerList.readFromFile(file);
                customerList.deleteCustomer();
                customerList.writeToFile(file);
                mainMenu.menu();
                break;
            case 4:
                //customerList.readFromFile(file);
                customerList.display();
                mainMenu.menu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + reponse);
        }


    }
}
