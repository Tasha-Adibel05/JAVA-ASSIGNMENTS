import faculty.Faculty;
import student.Student;

public class CollegeManagement {
    public static void main(String[] args) {

        Student s = new Student(101, "Alice");
        Faculty f = new Faculty(201, "Dr. Smith");

        s.display();
        f.display();
    }
}