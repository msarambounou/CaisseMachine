package test;

public class Category {
    String name;

    public Category(){

    }

    Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category parse(String text){

        return new Category(text);
    }

    public String toString(){
        return String.format("%s", name);
    }
}
