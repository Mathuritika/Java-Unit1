import java.util.ArrayList;

class Employee {
    private String name;
    private int id;
    private double salary;

    // using constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // ToString method to print employee details
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Adding three employees
        employees.add(new Employee("Alice", 101, 90000));
        employees.add(new Employee("Bob", 102, 95000));
        employees.add(new Employee("Charlie", 103, 80000));

        // Updating salary of employee with ID 102
        for (Employee emp : employees) {
            if (emp.getId() == 102) {
                emp.setSalary(88000);
                break;
            }
        }

        // Removing employee with ID 101
        employees.removeIf(emp -> emp.getId() == 101);

        // Printing remaining employees
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
