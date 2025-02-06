public class FrequencyCount {
    public static int FrequencyCount(int[] arr, int target) {
        int count =0;
        System.out.println("--------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 2, 6};
        int target = 2;
        
        int result = FrequencyCount(arr, target);
        System.out.println("The number " + target + " comes " + result + " times in the array.");
        System.out.println("--------------------------------------------");

    }
}
