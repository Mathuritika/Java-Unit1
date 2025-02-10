class NewProgram {
    // Attributes (Instance variables)
    String programTitle;
    String programCode;

    // Constructor using 'this' to differentiate between parameters and instance variables
    public NewProgram(String programTitle, String programCode) {
        this.programTitle = programTitle;
        this.programCode = programCode;
        System.out.println("------------------------------------------------------------------------------------ ");

    }

    // Method to display program details
    void displayProgramDetails() {
        System.out.println("Program Title: " + programTitle);
        System.out.println("Program Code: " + programCode);
    }
}
public class RegistrationSystem {
    public static void main(String[] args) {
        // Creating an object
        NewProgram course1 = new NewProgram("Artificial Intelligence & Machine Learning", "AIML_UPES302");

        // Displaying course details
        course1.displayProgramDetails();
        System.out.print("------------------------------------------------------------------------------------ ");

    }
}
