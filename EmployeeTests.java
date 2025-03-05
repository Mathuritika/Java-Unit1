abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
    abstract void calculateSalary();
    abstract void displayDetails();
}

class Manager extends Employee {
    double salary;
    Manager(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    void calculateSalary() {
        System.out.println("Salary of a manager: " + salary);
    }
    void displayDetails() {
        System.out.println("Manager: " + name + ", salary: " + salary);
    }
}

class Developer extends Employee {
    double hourlyRate;
    int hoursWorked;
    Developer(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    void calculateSalary() {
        System.out.println("Salary of the developer: " + (hourlyRate * hoursWorked));
    }
    void displayDetails() {
        System.out.println("Developer: " + name + ", salary: " + (hourlyRate * hoursWorked));
    }
}

public class EmployeeTests {
    public static void main(String[] args) {
        Manager mgr = new Manager("Ritika", 50000);
        mgr.calculateSalary();
        mgr.displayDetails();
        
        Developer dev = new Developer("Mathur", 50, 160);
        dev.calculateSalary();
        dev.displayDetails();
    }
}