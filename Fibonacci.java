
import java.util.Scanner;
public class Fibonacci {

    public static void main(String[] args) {
        // Creating a scanner object for input
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Input the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();

        System.out.print("Fibonacci Series: ");

        // Loop to print the fibonacci series
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\n------------------------------------------------------------------------------------------");
        scanner.close();
    }

    // Recursive Fibonacci function
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        // Recursive call for fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);



        }


}
