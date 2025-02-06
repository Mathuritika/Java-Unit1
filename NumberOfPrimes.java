public class NumberOfPrimes {
    public static void main(String[] args) {
        int count = 0;

        // iterating from 2 to 1000
        for (int num = 2; num <= 1000; num++) {
            boolean isPrime = true;

            // Checking if number is divisible by any number
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;  // then num is not a prime number
                    break;
                }
            }

            // If num is a prime number, incrementing the count
            if (isPrime) {
                count++;
            }
        }
        System.out.println("Total prime numbers between 1 and 1000 are = " + count);
    }
}
