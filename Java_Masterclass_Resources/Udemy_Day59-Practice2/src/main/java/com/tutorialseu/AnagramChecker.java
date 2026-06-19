package com.tutorialseu;

import java.util.HashMap;

public class AnagramChecker {

    public static boolean areAnagrams(String s1, String s2) {
        // Convert both strings to lowercase and remove non-alphabetic characters manually
        s1 = normalizeString(s1);
        s2 = normalizeString(s2);

        // Quick length check after normalization
        if (s1.length() != s2.length()) {
            return false;
        }

        // Map to store character counts from the first string
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Populate the map with character frequencies from the first string
        for (char c : s1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Check character frequencies against the second string
        for (char c : s2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;  // Character in s2 that doesn’t exist in s1
            }
            charCountMap.put(c, charCountMap.get(c) - 1);  // Decrement the count
            if (charCountMap.get(c) < 0) {
                return false;  // More occurrences of a character in s2 than in s1
            }
        }

        // All values should be zero if they are anagrams
        return true;
    }

    // Helper method to normalize the string by removing non-alphabetic characters and converting to lowercase
    private static String normalizeString(String s) {
        StringBuilder cleanedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) { // Check if character is alphabetic
                cleanedString.append(Character.toLowerCase(c));
            }
        }
        return cleanedString.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String str1 = "Listen";
        String str2 = "Silent";
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" anagrams? " + areAnagrams(str1, str2)); // Expected: true

        String str3 = "Astronomer";
        String str4 = "Moon starer";
        System.out.println("Are \"" + str3 + "\" and \"" + str4 + "\" anagrams? " + areAnagrams(str3, str4)); // Expected: true

        String str5 = "Hello";
        String str6 = "World";
        System.out.println("Are \"" + str5 + "\" and \"" + str6 + "\" anagrams? " + areAnagrams(str5, str6)); // Expected: false
    }
}
