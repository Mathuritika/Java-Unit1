import java.util.Scanner; 

public class ArrayAccess {
    public static void main(String[] args) {
        long[] numbers = {222, 733, 1111, 000, 444}; 
        Scanner scanner = new Scanner(System.in); 

        try {
            System.out.print("Enter an index from 0 to 4 - ");
            int index = scanner.nextInt(); 
            System.out.println("Element at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error - you have entered an invalid index. Please enter a number between 0 and 4.");
        } finally {
            System.out.println("Array access attempted.");
            scanner.close(); 
        }
    }
}
