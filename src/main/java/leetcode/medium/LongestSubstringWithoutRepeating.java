package leetcode.medium;

/**
 * LeetCode Problem: Longest Substring Without Repeating Characters
 * Problem: Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 */
public class LongestSubstringWithoutRepeating {
    
    /**
     * Sliding Window Solution - O(n) time, O(min(m,n)) space
     * where n is the length of string and m is the charset size
     */
    public static int lengthOfLongestSubstring(String s) {
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the map and within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Alternative solution using HashSet
     */
    public static int lengthOfLongestSubstringSet(String s) {
        java.util.HashSet<Character> set = new java.util.HashSet<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Longest Substring Without Repeating Characters\n");
        
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "au", "dvdf"};
        
        for (String test : testCases) {
            int result = lengthOfLongestSubstring(test);
            System.out.println("Input: \"" + test + "\" | Length: " + result);
        }
    }
}
