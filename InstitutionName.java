class Institution {

    // static variable which is shared by all instances
    static String instituteName = "University Of Petroleum and Energy Studies ";
    // non static variable whichis unique for all instances
    String learnerName;

    // constructor to initialize student's name
    public Institution(String name) {
        this.learnerName = name;
    }

    // Static method to display the institute's name
    static void showInstituteName() {
        System.out.println("Institute's Name: " + instituteName);
    }
    

    // Non-static method to display student details
    void showStudentDetails() {
        System.out.println("Student's name: " + learnerName);
    }
}
public class InstitutionName {
    public static void main(String[] args) {
        // Calling the static method
        Institution.showInstituteName();
        // Creating multiple student objects
        System.out.println("-------------------------------------------------------");

        Institution student1 = new Institution("Ritika");
        Institution student2 = new Institution("Ananya");
        Institution student3 = new Institution("Charvie");

        student1.showStudentDetails();
        student2.showStudentDetails();
        student3.showStudentDetails();
        System.out.println("-------------------------------------------------------");

    }
}
