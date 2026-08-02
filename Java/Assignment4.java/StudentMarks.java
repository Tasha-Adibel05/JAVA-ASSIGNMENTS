public class StudentMarks {

    public static void main(String[] args) {

        String mark1 = "85";
        String mark2 = "90";
        String mark3 = "78";


        Integer m1 = Integer.valueOf(mark1);
        Integer m2 = Integer.valueOf(mark2);
        Integer m3 = Integer.valueOf(mark3);

    
        int total = m1 + m2 + m3;

        System.out.println("Student Marks");
        System.out.println("Mark 1: " + m1);
        System.out.println("Mark 2: " + m2);
        System.out.println("Mark 3: " + m3);
        System.out.println("Total Marks: " + total);
    }
}