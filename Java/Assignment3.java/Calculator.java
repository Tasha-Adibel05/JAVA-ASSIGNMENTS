public class Calculator {

    
    static int calculationCount = 0;


    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    static void displayCount() {
        System.out.println("Total Calculations: " + calculationCount);
    }

    public static void main(String[] args) {

        Calculator obj = new Calculator();

        System.out.println("Addition of Integers: " + obj.add(10, 20));
        System.out.println("Addition of Decimals: " + obj.add(12.5, 7.5));

        displayCount();
    }
}