class Student {
    String name;
    int age;

    // default constructor
    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // method to display details
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an object using default constructor
        Student student1 = new Student();
        student1.display();

        // Creating an object using parameterized constructor
        Student student2 = new Student("Ritika", 20);
        student2.display();
    }
}
