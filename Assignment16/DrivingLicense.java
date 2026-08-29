import java.util.Scanner;

class InvalidDrivingAgeException extends Exception {
    public InvalidDrivingAgeException(String message) {
        super(message);
    }
}

public class DrivingLicense {

    static void checkEligibility(int age) throws InvalidDrivingAgeException {
        if (age < 18) {
            throw new InvalidDrivingAgeException(
                "You are not eligible for a driving license."
            );
        }

        System.out.println("You are eligible for a driving license.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkEligibility(age);
        } 
        catch (InvalidDrivingAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}