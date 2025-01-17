import java.util.Scanner;

public class GradeSheet {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter student name:");
        String studentName = input.nextLine();


        System.out.println("Enter SAP ID:");
        String sapId = input.nextLine(); 

        System.out.println("Enter marks for BData (out of 100):");
        int bdataMarks = input.nextInt();

        System.out.println("Enter marks for OOPS (out of 100):");
        int oopsMarks = input.nextInt();

        System.out.println("Enter marks for Maths (out of 100):");
        int mathsMarks = input.nextInt();

        char bdataGrade = calculateGrade(bdataMarks);
        char oopsGrade = calculateGrade(oopsMarks);
        char mathsGrade = calculateGrade(mathsMarks);

        System.out.println("\n           *** Grade Sheet ***");
        System.out.println("\n-----------------------------------------");
        System.out.println("Student Name: " + studentName);
        System.out.println("\n-----------------------------------------");
        System.out.println("SAP ID: " + sapId);
        System.out.println("\n-----------------------------------------");
        System.out.println("Subject\t\tMarks\t\tGrade");
        System.out.println("\n-----------------------------------------");
        System.out.println("BData\t\t" + bdataMarks + "\t\t" + bdataGrade);
        System.out.println("oops\t\t" + oopsMarks + "\t\t" + oopsGrade);
        System.out.println("Maths\t\t" + mathsMarks + "\t\t" + mathsGrade);
        System.out.println("\n-----------------------------------------");

        input.close(); 
    }

    public static char calculateGrade(int marks) {
        if (marks >= 90) {
            return 'O';
        } else if (marks >= 70) {
            return 'A';
        } else if (marks >= 50) {
            return 'B';
        } else if (marks >= 35) {
            return 'C';
        } else {
            return 'F';
        }
    }
}