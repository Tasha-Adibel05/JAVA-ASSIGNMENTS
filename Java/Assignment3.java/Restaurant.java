public class Restaurant {


    static int totalOrders = 0;

    double bill(double amount) {
        totalOrders++;
        return amount;
    }

    double bill(double amount, double packingCharge) {
        totalOrders++;
        return amount + packingCharge;
    }

    double bill(double amount, double packingCharge, double deliveryCharge) {
        totalOrders++;
        return amount + packingCharge + deliveryCharge;
    }

    static void displayOrders() {
        System.out.println("Total Orders: " + totalOrders);
    }

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        System.out.println("Dine-in Bill: " + r.bill(500));
        System.out.println("Takeaway Bill: " + r.bill(500, 30));
        System.out.println("Delivery Bill: " + r.bill(500, 30, 50));

        displayOrders();
    }
}