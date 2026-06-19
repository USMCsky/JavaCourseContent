public class LargestSumSubarray {

    public static void main(String[] args) {
        // Test cases to check the largest sum subarray
        int[] array1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Largest Sum: " + findLargestSumSubarray(array1)); // Expected: 6

        int[] array2 = {1, 2, 3, -2, 5};
        System.out.println("Largest Sum: " + findLargestSumSubarray(array2)); // Expected: 9

        int[] array3 = {-3, -2, -1, -4};
        System.out.println("Largest Sum: " + findLargestSumSubarray(array3)); // Expected: -1
    }

    // Method to find the largest sum of a contiguous subarray
    public static int findLargestSumSubarray(int[] nums) {
        // Edge case: If the array is empty, return 0 (or any other appropriate value)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize maxSoFar and maxEndingHere with the first element of the array
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Update maxEndingHere to be the maximum of current number or maxEndingHere + current number
            maxEndingHere = Math.max(num, maxEndingHere + num);

            // Update maxSoFar to be the maximum of maxSoFar and maxEndingHere
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Return the largest sum of any contiguous subarray
        return maxSoFar;
    }
}
