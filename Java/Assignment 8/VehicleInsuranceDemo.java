class Vehicle {

    String vehicleName = "Toyota";
    int vehicleNumber = 12345;

    Vehicle() {
        System.out.println("Vehicle Details Created");
    }

    void showVehicle() {
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Vehicle Number: " + vehicleNumber);
    }
}

class Insurance extends Vehicle {

    String insuranceType = "Full Coverage";

    Insurance() {
        super(); 
        System.out.println("Insurance Details Created");
    }

    void showInsuranceDetails() {

        super.showVehicle(); 

        System.out.println("Insurance Type: " + insuranceType);
    }
}

public class VehicleInsuranceDemo {

    public static void main(String[] args) {

        Insurance i = new Insurance();

        i.showInsuranceDetails();
    }
}