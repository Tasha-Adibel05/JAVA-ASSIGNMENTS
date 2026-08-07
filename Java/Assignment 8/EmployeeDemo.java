class Employee {

    String name = "John";
    int salary = 50000;

    Employee() {
        System.out.println("Employee Constructor Called");
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee {

    String department = "IT";

    Manager() {
        super();
        System.out.println("Manager Constructor Called");
    }

    void displayManagerDetails() {

        super.displayDetails(); 

        System.out.println("Department: " + department);
    }
}

public class EmployeeDemo {

    public static void main(String[] args) {

        Manager m = new Manager();

        m.displayManagerDetails();
    }
}