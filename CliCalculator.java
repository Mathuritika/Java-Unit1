public class CliCalculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Enter only two arguments separated by an operator.");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        String operator = args[1];
        int result = 0;

        System.out.println("Operator: " + operator);

        if (operator.equals("+")) {
            result = num1 + num2;
            System.out.println("Sum of " + num1 + " and " + num2 + " is " + result);
        } else if (operator.equals("-")) {
            result = num1 - num2;
            System.out.println("Difference of " + num1 + " and " + num2 + " is " + result);
        } /*else if (operator.equals("*")) {
            result = num1 * num2;
            
            System.out.println("Product of " + num1 + " and " + num2 + " is " + result); */
        else if (operator.equals("/")) {
            if (num2 != 0) {
                double divisionResult = (double) num1 / num2;
                System.out.println("Quotient of " + num1 + " and " + num2 + " is " + divisionResult);
            } else {
                System.out.println("Division by zero is not valid.");
            }
        } else {
            System.out.println("The used operator is not valid. Use any of these operators:  +, -, /.");
        }
    }
}
