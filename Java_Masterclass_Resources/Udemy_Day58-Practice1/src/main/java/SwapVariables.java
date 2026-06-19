public class SwapVariables {

    public static void main(String[] args) {
        // Step 1: Initialize variables a and b with values
        int a = 5;
        int b = 10;

        // Print values before swapping
        System.out.println("Before swapping: a = " + a + ", b = " + b);

        // Call the method to swap variables
        swap(a, b);
    }

    // Method to swap two variables without using a third variable
    public static void swap(int a, int b) {
        // Step 1: Add a and b and store the result in a
        a = a + b;

        // Step 2: Subtract the new value of a from b and assign it to b
        b = a - b;

        // Step 3: Subtract the new value of b from a and assign it to a
        a = a - b;

        // Print values after swapping
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}