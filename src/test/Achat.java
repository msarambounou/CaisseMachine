package test;

public class Achat {

    String idProduct;
    String idCategory;
    String productPrice;
    Achat(){
    }

    Achat(String idProduct, String idCategory, String productPrice){
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.productPrice = productPrice;
    }


    public static Achat parse(String textLine) {

        String[] array = textLine.split(",");
        String idProduct = array[0];
        String idCategory = array[1];
        String productPrice = array[2];

        return new Achat(idProduct, idCategory, productPrice);
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s", idProduct, idCategory, productPrice);
    }
}
