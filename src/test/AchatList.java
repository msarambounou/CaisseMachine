package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AchatList extends ArrayList<Achat> {

    public AchatList(){

    }

    public void input() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        File categoryFile = new File("FileCategory.txt");
        File productFile = new File("FileProduct.txt");

        CategoryList categoryList = new CategoryList();
        categoryList.readFromFile(categoryFile);

        ProductList productList = new ProductList();
        productList.readFromFile(productFile);
        
        categoryList.display();
        System.out.println("Veuillez choisir la categorie correspondante");
        String idCategory = sc.nextLine();

        productList.filterProduct(idCategory);
        System.out.println("Veuillez choisir le produit");
        String idProduct = sc.nextLine();

        System.out.println("Veuillez choisir la quantité");
        String productQuantity = sc.nextLine();

        add(new Achat(idProduct, idCategory, productQuantity));

        for (Achat achat : this){
            System.out.println(achat);
        }
    }

    public void writeToFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (Achat achat : this){
            writer.write(achat + System.lineSeparator());
        }

        writer.close();
    }

    public void readFromFile(File file) throws FileNotFoundException {
        if(file.length() == 0){

        } else {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                add(Achat.parse(line));
            }

            scanner.close();
        }
    }
}
