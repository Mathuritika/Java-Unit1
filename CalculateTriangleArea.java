import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the triangle's base length: ");
        double base =input.nextDouble();
        
        System.out.print("Enter the triangle's height: ");
        double height=input.nextDouble();
        
        double area =(base*height) / 2;
        System.out.println("The area of the triangle is: " + area);
        input.close();
    }
}
