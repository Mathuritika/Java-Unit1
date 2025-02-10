public class ExperimentFourCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        ExperimentFourCalculator calc = new ExperimentFourCalculator();
        System.out.println("-------------------------------------------------------");
        System.out.println("Addition of two integers: " + calc.add(500, 250));
        System.out.println("Addition of two doubles: " + calc.add(5.525, 4.073));
        System.out.println("Addition of three integers: " + calc.add(2300, 200, 500));
        System.out.println("-------------------------------------------------------");

    }
   
}
