public class ArrayPermutations {

    public static void main(String[] args) {
        // Test array to generate permutations
        int[] array = {1, 2, 3};
        generatePermutations(array, 0);
    }

    // Recursive method to generate permutations of the array
    public static void generatePermutations(int[] array, int index) {
        // Base case: If we've reached the end of the array, print the permutation
        if (index == array.length) {
            printArray(array);
            return;
        }

        // Recursive case: Swap each element in the array with the element at the current index
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);             // Swap to create a new permutation
            generatePermutations(array, index + 1); // Recurse to generate permutations of the remaining elements
            swap(array, i, index);             // Backtrack to restore the array
        }
    }

    // Helper method to swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Helper method to print an array
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
