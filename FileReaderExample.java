import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {
    //method to read the file contents - throws FileNotFoundException
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        System.out.println("File contents are:");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("-----------------------------------------------------------------------------------------------: ");
            System.out.println("Enter the file name: ");
            String fileName = scanner.nextLine(); 
            readFile(fileName); //trying to read the file
        } catch (FileNotFoundException e) {
            System.out.println("Error - the file was not found. Please check the file name once.");
        } finally {
            System.out.println("File operation attempted.");
            scanner.close();
        }
    }
}
