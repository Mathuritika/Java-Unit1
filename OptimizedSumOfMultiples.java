public class OptimizedSumOfMultiples {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Using AP formula to find the sum of multiples of 18 between 10 and 950 = S_n = (n/2)*[2a + (n-1)d].");

        int a = 18;  // First multiple of 18 in the given range. hence, the first term
        int l = 936; // Last multiple of 18 in the given range
        int d = 18;  // Common difference

        int n = ((l - a) / d) + 1; // here, n = Number of terms

        // sum of AP formula: S_n = (n/2)*[2a + (n-1)d]
        int sum = (n * (2 * a + (n - 1) * d)) / 2;

        System.out.println(" ");
        System.out.println("Hence, the sum of all integers between 10 and 950, divisible by both 6 and 9, is: " + sum);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}    

