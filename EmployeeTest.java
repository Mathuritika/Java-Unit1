// Employee class
class Employee {
    protected String name;
    protected int empid;
    protected double salary;

    // Default constructor
    public Employee() {
        this.name = "Default Name";
        this.empid = 0;
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    // Method to return name
    public String getName() {
        return name;
    }

    // Method to return salary
    public double getSalary() {
        return salary;
    }

    // Method to increase salary by a percentage
    public void increaseSalary(double percentage) {
        salary += salary * (percentage / 100);
    }
}

// Manager class (subclass of Employee)
class Manager extends Employee {
    private String department;

    // Constructor with department
    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary); // Call parent constructor
        this.department = department;
    }

    // Method to get department
    public String getDepartment() {
        return department;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {


        // Creating Employee object
        Employee emp = new Employee("Ritika", 101, 50000);
        System.out.println(emp.getName() + "'s Salary: Rs." + emp.getSalary());

        // increasing the salary
        emp.increaseSalary(10);
        System.out.println("After 10% increase, the salary becomes: Rs." + emp.getSalary());

        // creating Manager object
        Manager mgr = new Manager("Ananya", 102, 70000, "IT");
        System.out.println(mgr.getName() + " manages " + mgr.getDepartment() + " department.");
    }
}
