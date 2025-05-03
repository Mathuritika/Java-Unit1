import java.util.ArrayList;
import java.util.HashSet;

public class UniqueSum {
    public static void main(String[] args) {
        // ArrayList with duplicate values
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(3);
        numbers.add(8);
        numbers.add(2);
        numbers.add(5);

        // converting to HashSet to eliminate duplicates
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        // Calculating the sum of unique values
        int sum = 0;
        for (int num : uniqueNumbers) {
            sum += num;
        }

        // Displaying the results
        System.out.println("Unique values: " + uniqueNumbers);
        System.out.println("Sum: " + sum);
    }
}
