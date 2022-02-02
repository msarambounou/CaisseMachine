package test;

public class Product {
    String name;
    float price;
    String indexCategory;
    //contrcuteur
    Product(){

    }

    Product(String name, float price, String indexCategory){
        this.name = name;
        this.price = price;
        this.indexCategory = indexCategory;
    }

    public static Product parse(String text){

        String[] array = text.split(",");
        String name = array[0];
        Float price = Float.valueOf(array[1]);
        String indexCategory = array[2];

        return (new Product(name, price, indexCategory));
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", name, price, indexCategory);
    }
}
