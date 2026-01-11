package leetcode.easy;

/**
 * LeetCode Problem: Reverse Integer
 * Problem: Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
 * then return 0.
 * 
 * Example:
 * Input: x = 123
 * Output: 321
 * 
 * Input: x = -123
 * Output: -321
 * 
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger {
    
    /**
     * Solution - O(log n) time, O(1) space
     */
    public static int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            // Check for overflow before actually reversing
            if (reversed > Integer.MAX_VALUE / 10 || 
                (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || 
                (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            reversed = reversed * 10 + pop;
        }
        
        return reversed;
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Reverse Integer Problem\n");
        
        int[] testCases = {123, -123, 120, 0, 1534236469};
        
        for (int test : testCases) {
            int result = reverse(test);
            System.out.println("Input: " + test + " | Reversed: " + result);
        }
    }
}
