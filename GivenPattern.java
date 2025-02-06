public class GivenPattern {
    public static void main(String[] args) {
        // number of rows for the given pattern
        int rows = 5;

        // Outer loop for iterating in the rows
        for (int i = 1; i <= rows; i++) {
            // To decide whether to print ? or #
            if (i % 2 != 0) {
               
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("? ");
                }
            } else {
                // printing # for even rows
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("# ");
                }
            }
            // Moving to the next line after each row
            System.out.println();
        }
    }
}
