package test;

public class Customer {

    protected String firstname;
    protected String lastname;

    Customer() {
    }

    Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Customer parse(String textLine) {

        String[] array = textLine.split(",");
        String firstname = array[0];
        String lastname = array[1];

        return new Customer(firstname, lastname);
    }

    @Override
    public String toString() {

        return String.format("%s,%s", firstname, lastname);
    }

}
