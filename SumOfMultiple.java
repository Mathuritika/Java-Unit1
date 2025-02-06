public class SumOfMultiple {

    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("For a number to be divisible by both 6 and 9, it should be divisible by 18 since the LCM of 6 and 9 is 18.");

        int sum = 0;

        for (int i = 10; i <= 950; i++) {
            if (i % 18 == 0) {
                sum += i;
            }
        }

        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("Hence, the sum of all integers between 10 and 950, divisible by both 6 and 9 is: " + sum);

        System.out.println("------------------------------------------------------------------------------------");

    }
}