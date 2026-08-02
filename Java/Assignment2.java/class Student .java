class Student {

    String name;
    int rollNo;


    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    Student(String n, int r) {
        name = n;
        rollNo = r;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
    }

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student("Chioma", 101);

        System.out.println("Default Constructor");
        s1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        s2.display();
    }
}