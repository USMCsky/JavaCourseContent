public class RotateArray {

    public static void main(String[] args) {
        // Test cases to check the rotate functionality
        int[] array1 = {1, 2, 3, 4, 5};
        rotate(array1, 2);
        printArray(array1); // Expected: [4, 5, 1, 2, 3]

        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        rotate(array2, 3);
        printArray(array2); // Expected: [5, 6, 7, 1, 2, 3, 4]

        int[] array3 = {-1, -100, 3, 99};
        rotate(array3, 2);
        printArray(array3); // Expected: [3, 99, -1, -100]
    }

    // Method to rotate the array to the right by k steps
    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        // Normalize k in case it's greater than the array length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a portion of the array from start to end
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Helper method to print the array
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
