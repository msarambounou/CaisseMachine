package test;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductList extends ArrayList<Product> {
    //contrcuteur
    public void input() throws FileNotFoundException {

        String name;
        float price;
        String idCategory;
        File file = new File("FileCategory.txt");

        CategoryList categoryList = new CategoryList();
        categoryList.readFromFile(file);

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom du produit");
        name = sc.nextLine();

        System.out.println("Veuillez saisir le prix du produit");
        price = sc.nextFloat();

        categoryList.display();

        System.out.println("Veuillez saisir le numero de la categorie du produit");
        idCategory = sc1.nextLine();

        add(new Product(name, price, idCategory));

    }

    public void display(){
        int index = 0;
        for(Product product : this){
            System.out.println(String.format("PRODUIT N°%s\nNom: %s\nPrix:%s\nCategorie: %s\n", index+1, product.name, product.price, product.indexCategory));
            index +=1;
        }

    }

    public void writeToFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (Product product : this) {
            writer.write(product + System.lineSeparator());
        }
        writer.close();

    }

    public void readFromFile(File file) throws FileNotFoundException {
        if(file.length() == 0){

        } else {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                add(Product.parse(line));
            }

            scanner.close();
        }

    }

    public void filterProduct(String idCategory){

        /* Cette fonction permet de filtrer le produit par la categorie. L'id de le categorie est données en parametre */

        for(Product product : this){
            if (product.indexCategory.equals(idCategory)){
                System.out.println(String.format("N°%s: %s", indexOf(product)+1, product.name));
            }
        }
    }
}
