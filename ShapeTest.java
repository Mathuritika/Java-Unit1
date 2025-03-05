// Program 1: Abstract Class - Shape
abstract class Shape {
    abstract void calculateArea();
}

class Rectangle extends Shape {
    double length, width;
    Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }
    void calculateArea() {
        System.out.println("Area of the rectangle: " + (length * width));
    }
}

class Circle extends Shape {
    double radius;
    Circle(double r) {
        this.radius = r;
    }
    void calculateArea() {
        System.out.println("Area of the circle : " + (3.14 * radius * radius));
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2, 3);
        rect.calculateArea();
        
        Circle circ = new Circle(12);
        circ.calculateArea();
    }
}