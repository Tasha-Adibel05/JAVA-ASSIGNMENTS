package student;

public class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void display() {
        System.out.println("Student Details");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}
