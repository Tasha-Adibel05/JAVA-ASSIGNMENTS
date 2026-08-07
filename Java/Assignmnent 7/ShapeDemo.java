class Shape {
    void area() {
        System.out.println("Calculating Area");
    }
}

class Circle extends Shape {
    double radius = 7;

    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle extends Shape {
    int length = 10;
    int breadth = 5;

    void area() {
        int area = length * breadth;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}