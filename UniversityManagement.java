class Person {
    String name;
    int age;
    String address;

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class Staff extends Person {
    int staffId;
    String department;

    Staff(String name, int age, String address, int staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }
}

class Professor extends Staff {
    String specialization;

    Professor(String name, int age, String address, int staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    void conductLecture() {
        System.out.println(name + " is conducting a lecture on " + specialization);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
    }
}

class Student extends Person {
    int studentId;
    String course;

    Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class GraduateStudent extends Student {
    String researchTopic;

    GraduateStudent(String name, int age, String address, int studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    void submitThesis() {
        System.out.println(name + " has submitted a thesis on " + researchTopic);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Professor("Dr. Ram Sharma", 50, "Dehradun", 101, "Computer Science", "Big Data");
        people[1] = new GraduateStudent("Ritika Mathur", 20, "Jaipur", 202, "B.Tech", "Big Data Ingestion");

        for (Person p : people) {
            p.displayDetails();
            System.out.println();
            if (p instanceof Professor) {
                ((Professor) p).conductLecture();
            } else if (p instanceof GraduateStudent) {
                ((GraduateStudent) p).submitThesis();
            }
            System.out.println("-------------------------------------------------------------------------------");
        }
    }
}
