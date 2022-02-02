package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerList extends ArrayList<Customer>{

    public CustomerList() {

    }

    public void inputCustomer(){
        String firstname;
        String lastname;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le prenom :");
        firstname = scanner.nextLine();

        System.out.println("Entrez le nom :");
        lastname = scanner.nextLine();

        //scanner.close();

        add(new Customer(firstname, lastname));
    }


    public void display() {
        int index = 1;
        for (Customer customer : this) {
            System.out.println(String.format("CLIENT N° %s\nPrenom: %s\nNom: %s\n", index, customer.firstname, customer.lastname));
            index +=1;
        }

    }

    public void writeToFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (Customer customer : this) {
            writer.write(customer + System.lineSeparator());
        }
        writer.close();
    }

    public void readFromFile(File file) throws FileNotFoundException {

        if(file.length() == 0){

        } else {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                add(Customer.parse(line));
            }

            scanner.close();
        }
    }

    public void modifyCustomer(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        display();

        System.out.println("Saisissez le numero du client à modifier");
        int NumCustomer = scanner.nextInt();

        System.out.println("Entrez le prenom :");
        String firstname = scanner1.nextLine();

        System.out.println("Entrez le nom :");
        String lastname = scanner1.nextLine();

        set(NumCustomer-1, new Customer(firstname, lastname));
    }

    public void deleteCustomer(){
        Scanner scanner = new Scanner(System.in);

        display();

        System.out.println("Saisissez le numero du client à supprimer");
        int NumCustomer = scanner.nextInt();

        remove(NumCustomer-1);
    }
}
