import java.util.Scanner;

public class OptimizedFibonacci {

    public static void main(String[] args) {
        // Creating a scanner object for input
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Input the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();

        int a = 0, b = 1;
        
        System.out.print("Fibonacci Series: ");
        
        // Loop to print the Fibonacci series
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b;  // Calculating the next term
            a = b;  // Updating a and b 
            b = nextTerm;
        }

        System.out.println("\n------------------------------------------------------------------------------------------");
        scanner.close();

    }
}
