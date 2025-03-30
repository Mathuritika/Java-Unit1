import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentFileReader {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("student.txt"); //attempting to open the file student.txt for reading
            int character;
            
            System.out.println("Contents of student.txt:");
            while ((character = reader.read()) != -1) { //reading and displaying the file character by character
                System.out.print((char) character);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error - student.txt file was not found.");
        } catch (IOException e) {
            System.out.println("Error - unable to read the file.");
        }
    }
}
