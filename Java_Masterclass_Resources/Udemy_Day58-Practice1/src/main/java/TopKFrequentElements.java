import java.util.Arrays;

public class TopKFrequentElements {

    public static void main(String[] args) {
        // Test cases to check top K frequent elements
        int[] array1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Top K Frequent Elements: " + Arrays.toString(findTopKFrequent(array1, 2))); // Expected: [1, 2]

        int[] array2 = {4, 4, 4, 5, 5, 6};
        System.out.println("Top K Frequent Elements: " + Arrays.toString(findTopKFrequent(array2, 2))); // Expected: [4, 5]

        int[] array3 = {7, 8, 8, 9, 9, 9};
        System.out.println("Top K Frequent Elements: " + Arrays.toString(findTopKFrequent(array3, 1))); // Expected: [9]
    }

    // Method to find the top K frequent elements
    public static int[] findTopKFrequent(int[] nums, int k) {
        // Edge case: if k is greater than the number of unique elements
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // Step 1: Find the maximum value in the array to set up a frequency array
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // Step 2: Create a frequency array to count occurrences
        int[] frequency = new int[maxVal + 1];
        for (int num : nums) {
            frequency[num]++;
        }

        // Step 3: Create an array of elements and their frequencies
        int[][] elementsWithFrequency = new int[maxVal + 1][2];
        for (int i = 0; i <= maxVal; i++) {
            elementsWithFrequency[i][0] = i;        // Store the element
            elementsWithFrequency[i][1] = frequency[i]; // Store its frequency
        }

        // Step 4: Sort elements based on frequency in descending order
        Arrays.sort(elementsWithFrequency, (a, b) -> Integer.compare(b[1], a[1]));

        // Step 5: Collect the top k elements based on frequency
        int[] topKFrequent = new int[k];
        int count = 0;
        for (int i = 0; i < elementsWithFrequency.length && count < k; i++) {
            if (elementsWithFrequency[i][1] > 0) { // Only consider elements with non-zero frequency
                topKFrequent[count++] = elementsWithFrequency[i][0];
            }
        }

        return topKFrequent;
    }
}
