import java.util.Scanner;

public class SecondMaxFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------- ");


        // Taking array size input
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        // Taking array elements input
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int secondLargest = getSecondLargest(numbers);
        if (secondLargest == -1) {
            System.out.println("No second largest element found.");
        } else {
            System.out.println("Second Largest: " + secondLargest);
        }

        scanner.close();
    }

    public static int getSecondLargest(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
  
        }
        return secondMax;
        

    }
}
