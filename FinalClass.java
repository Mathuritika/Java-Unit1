class MathConstants {
    //final variable - cannot change its value
    public final double PI = 3.14159;
    
    //final method - cannot be overridden
    public final void showPI() {
        System.out.println("PI value: " + PI);
    }
}

class Circle extends MathConstants {
    
    public void calculateArea(double radius) {
        double area = PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }
    
    // Overriding showPI() gives an error
    // public void showPI() { 
    //     System.out.println("Trying to override final method"); 
    // }
}

public class FinalClass {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        myCircle.showPI(); 
        myCircle.calculateArea(27.0); 
        
        // Ifwe try to change Pi value, it will show an error
       
    }
}
