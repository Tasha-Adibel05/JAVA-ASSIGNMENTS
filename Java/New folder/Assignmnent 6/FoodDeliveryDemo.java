class FoodDelivery {
    private String order = "Pizza";
    private int quantity = 2;

    class OrderDetails {
        void display() {
            System.out.println("Order: " + order);
            System.out.println("Quantity: " + quantity);
        }
    }
}

interface Delivery {
    void updateStatus();
}

public class FoodDeliveryDemo {
    public static void main(String[] args) {

        FoodDelivery fd = new FoodDelivery();
        FoodDelivery.OrderDetails details = fd.new OrderDetails();
        details.display();

        Delivery status = new Delivery() {
            public void updateStatus() {
                System.out.println("Delivery Status: Out for Delivery");
            }
        };

        status.updateStatus();
    }
}