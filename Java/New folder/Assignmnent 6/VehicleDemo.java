class Vehicle {
    private String vehicleName = "Toyota";
    private int speed = 80;

    
    class VehicleDetails {
        void display() {
            System.out.println("Vehicle Name: " + vehicleName);
            System.out.println("Speed: " + speed + " km/h");
        }
    }
}

interface Action {
    void perform();
}

public class VehicleDemo {
    public static void main(String[] args) {

        
        Vehicle vehicle = new Vehicle();
        Vehicle.VehicleDetails details = vehicle.new VehicleDetails();
        details.display();

        
        Action action = new Action() {
            public void perform() {
                System.out.println("Vehicle is moving.");
            }
        };

        action.perform();
    }
}