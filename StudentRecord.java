import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the SAP ID: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); //newline

            System.out.print("Enter the grade: ");
            String grade = scanner.nextLine();

            //writing data to the file in append mode
            FileWriter writer = new FileWriter("student.txt", true);
            writer.write("Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "\n");
            writer.close();

            System.out.println("Student information was saved.");
        } catch (IOException e) {
            System.out.println("Error - unable to write to the file.");
        } finally {
            scanner.close();
        }
    }
}
