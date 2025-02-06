import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        // creating a scanner object for input
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int sum = 0;

        // Loop for calculating the sum of digits
        while (number != 0) {
            sum += number % 10;  // Adding the last digit to the sum
            number /= 10;         // removing the last digit
        }

        System.out.println("The sum of the digits of the entered number is: " + sum);
        System.out.println("------------------------------------------------------------------------------------------");
        scanner.close();
    }
}
