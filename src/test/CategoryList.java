package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryList extends ArrayList<Category> {

    public CategoryList(){

    }

    public void input(){
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom de la catégorie");
        name = sc.nextLine();

        add(new Category(name));
    }

    public void display(){
        int index =1;
        for (Category categorie : this){
            System.out.println(String.format("N°%s : %s\n", index, categorie.name));
            index +=1;
        }

    }

    public void writeToFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);

        for (Category category : this){
            writer.write(category + System.lineSeparator());
        }

        writer.close();
    }

    public void readFromFile(File file) throws FileNotFoundException {
        if(file.length() == 0){

        } else {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                add(Category.parse(line));
            }

            scanner.close();
        }
    }

    public void updateCaterory(){
        int indexToUpdate;
        String name;

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        display();

        System.out.println("Veuillez saisir le numero de la catégorie à modifier");
        indexToUpdate = sc.nextInt();

        System.out.println("Veuillez saisir le nom de la catégorie");
        name = sc1.nextLine();

        set(indexToUpdate-1, new Category(name));
    }

    public void deleteCategory(){
        Scanner sc = new Scanner(System.in);

        display();

        System.out.println("Saisissez le numero de la catégorie à supprimer");
        int indexToDelete = sc.nextInt();

        remove(indexToDelete-1);

    }

    public String filterCategoryIndex() throws FileNotFoundException {
        File file = new File("FileCategory.txt");
        Scanner sc = new Scanner(System.in);

        readFromFile(file);
        display();

        System.out.println("Veuillez saisir le numero de la catégorie du produit");
        String categoryIndex = sc.nextLine();

        return categoryIndex;
    }
}
