interface Product {
    void displayDetails();
}

class ProductBase {
    String name;
    double price;

    ProductBase(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Electronic extends ProductBase implements Product {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: Rs." + price);
    }
}

class Clothing extends ProductBase implements Product {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Clothing Product");
        System.out.println("Name: " + name);
        System.out.println("Price: Rs." + price);
    }
}

class Grocery extends ProductBase implements Product {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayDetails() {
        System.out.println("Grocery Product");
        System.out.println("Name: " + name);
        System.out.println("Price: Rs." + price);
    }
}

public class EcommerceDemo {
    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 65000);
        Clothing c = new Clothing("T-Shirt", 1200);
        Grocery g = new Grocery("Rice", 900);

        e.displayDetails();
        System.out.println();

        c.displayDetails();
        System.out.println();

        g.displayDetails();
    }
}