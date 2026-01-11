package leetcode.easy;

/**
 * LeetCode Problem: Two Sum
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 */
public class TwoSum {
    
    /**
     * Brute Force Solution - O(n^2) time, O(1) space
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    /**
     * Optimized Solution using HashMap - O(n) time, O(n) space
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Two Sum Problem\n");
        
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        
        System.out.println("Test Case 1:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
            if (i < nums1.length - 1) System.out.print(", ");
        }
        System.out.println("], target = " + target1);
        
        int[] result1 = twoSumOptimized(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        
        System.out.println("\nTest Case 2:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            if (i < nums2.length - 1) System.out.print(", ");
        }
        System.out.println("], target = " + target2);
        
        int[] result2 = twoSumOptimized(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
        
        int[] nums3 = {3, 3};
        int target3 = 6;
        
        System.out.println("\nTest Case 3:");
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]);
            if (i < nums3.length - 1) System.out.print(", ");
        }
        System.out.println("], target = " + target3);
        
        int[] result3 = twoSumOptimized(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
    }
}
