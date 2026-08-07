
interface Printable {
    void printDetails();
}

class Student implements Printable {

    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Student Details");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}

class Employee implements Printable {

    int empId;
    String empName;

    Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public void printDetails() {
        System.out.println("Employee Details");
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
    }
}

public class PrintableDemo {

    public static void main(String[] args) {

        Student s = new Student(101, "Chioma");
        Employee e = new Employee(201, "Rahul");

        s.printDetails();
        System.out.println();
        e.printDetails();
    }
}