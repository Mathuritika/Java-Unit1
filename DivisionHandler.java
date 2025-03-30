import java.util.Scanner; // Importing Scanner for user input

public class DivisionHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creating Scanner object for input

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt(); //taking the numerator's input

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt(); //taking the denominator's input

            int result = numerator / denominator; 
            System.out.println("The result is: " + result); 
        } catch (ArithmeticException e) { 
            //catching the division by zero exception
            System.out.println("Error: Division by zero is not allowed."); 

        } finally {
            //this block executes even if there is an exception or not
            System.out.println("Operation completed.");
            scanner.close(); 
        }
    }
}
