public class StringCompression {

    public static void main(String[] args) {
        // Test cases to check the string compression
        System.out.println(compressString("aabcccccaaa")); // Expected: a2b1c5a3
        System.out.println(compressString("abcd"));        // Expected: abcd
        System.out.println(compressString("aabbcc"));      // Expected: a2b2c2
        System.out.println(compressString("aaabbbccc"));   // Expected: a3b3c3
    }

    // Method to compress a string by counting consecutive characters
    public static String compressString(String str) {
        // If the string is empty or has only one character, return it as is
        if (str == null || str.length() <= 1) {
            return str;
        }

        // StringBuilder to build the compressed string
        StringBuilder compressed = new StringBuilder();

        // Initialize the first character and count
        char currentChar = str.charAt(0);
        int count = 1;

        // Loop through the string starting from the second character
        for (int i = 1; i < str.length(); i++) {
            // If the current character matches the next one, increase the count
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                // Append current character and count to the compressed result
                compressed.append(currentChar).append(count);

                // Update current character and reset count
                currentChar = str.charAt(i);
                count = 1;
            }
        }

        // Append the last character and its count
        compressed.append(currentChar).append(count);

        // Return the compressed string if it is shorter or equal in length; otherwise, return the original
        return compressed.length() <= str.length() ? compressed.toString() : str;
    }
}
