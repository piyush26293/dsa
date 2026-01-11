package leetcode.easy;

/**
 * LeetCode Problem: Palindrome Number
 * Problem: Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Example:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 */
public class PalindromeNumber {
    
    /**
     * Solution without converting to string - O(log n) time, O(1) space
     */
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        int original = x;
        
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        return original == reversed;
    }
    
    /**
     * Alternative solution - reverse half of the number
     */
    public static boolean isPalindromeOptimized(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // For odd length numbers, we can ignore the middle digit
        return x == reversedHalf || x == reversedHalf / 10;
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Palindrome Number Problem\n");
        
        int[] testCases = {121, -121, 10, 12321, 0, 1, 1221};
        
        for (int test : testCases) {
            boolean result = isPalindrome(test);
            System.out.println("Input: " + test + " | Is Palindrome: " + result);
        }
    }
}
