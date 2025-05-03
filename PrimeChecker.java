import java.util.ArrayList;

public class PrimeChecker {
    public static void main(String[] args) {
        // Storing a list of integers using autoboxing
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i); // autoboxing: int to Integer
        }

        // Iterating and checking for prime numbers
        for (Integer number : numbers) {
            int n = number; // unboxing: Integer to int
            if (isPrime(n)) {
                System.out.println(n + " is a prime number.");
            } else {
                System.out.println(n + " is not a prime number.");
            }
        }
    }

    // to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
