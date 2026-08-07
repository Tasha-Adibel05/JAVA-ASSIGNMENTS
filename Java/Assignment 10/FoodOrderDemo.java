

abstract class FoodOrder {

    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    DineInOrder(double amount) {
        super(amount);
    }

    @Override
    void calculateBill() {
        double total = amount + (amount * 0.10); 
        System.out.println("Dine-In Order");
        System.out.println("Food Amount: ₹" + amount);
        System.out.println("Total Bill: ₹" + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double amount) {
        super(amount);
    }

    @Override
    void calculateBill() {
        double total = amount + 20; 
        System.out.println("Take Away Order");
        System.out.println("Food Amount: ₹" + amount);
        System.out.println("Total Bill: ₹" + total);
    }
}

public class FoodOrderDemo {

    public static void main(String[] args) {

        FoodOrder order1 = new DineInOrder(500);
        order1.calculateBill();

        System.out.println();

        FoodOrder order2 = new TakeAwayOrder(500);
        order2.calculateBill();
    }
}