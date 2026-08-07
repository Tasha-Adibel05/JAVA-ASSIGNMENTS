
abstract class Payment {

    abstract void makePayment(double amount);

    void display() {
        System.out.println("Payment Processing");
    }
}

class CreditCard extends Payment {

    @Override
    void makePayment(double amount) {
        System.out.println("Payment made using Credit Card.");
        System.out.println("Amount Paid: ₹" + amount);
    }
}

class UPI extends Payment {

    @Override
    void makePayment(double amount) {
        System.out.println("Payment made using UPI.");
        System.out.println("Amount Paid: ₹" + amount);
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        Payment p1 = new CreditCard();
        p1.display();
        p1.makePayment(2500);

        System.out.println();

        Payment p2 = new UPI();
        p2.display();
        p2.makePayment(1500);
    }
}