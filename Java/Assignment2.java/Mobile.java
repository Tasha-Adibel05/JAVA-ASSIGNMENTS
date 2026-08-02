public class Mobile {

    String brand;
    int price;

    Mobile() {
        brand = "Unknown";
        price = 0;
    }

    Mobile(String b, int p) {
        brand = b;
        price = p;
    }
    
    Mobile(Mobile m) {
        brand = m.brand;
        price = m.price;
    }

    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Price : " + price);
        System.out.println();
    }

    public static void main(String[] args) {

        Mobile m1 = new Mobile();

        Mobile m2 = new Mobile("Samsung", 75000);

        Mobile m3 = new Mobile(m2);

        System.out.println("Default Constructor");
        m1.display();

        System.out.println("Parameterized Constructor");
        m2.display();

        System.out.println("Copy Constructor");
        m3.display();
    }
}