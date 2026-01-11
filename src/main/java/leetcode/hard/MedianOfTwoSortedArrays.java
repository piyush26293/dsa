package leetcode.hard;

/**
 * LeetCode Problem: Median of Two Sorted Arrays
 * Problem: Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Example:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.0
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.5
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {
    
    /**
     * Optimized Binary Search Solution - O(log(min(m,n))) time, O(1) space
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
    
    /**
     * Simple merge approach - O(m+n) time, O(m+n) space
     * Easier to understand but not optimal
     */
    public static double findMedianSimple(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        int total = m + n;
        if (total % 2 == 0) {
            return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
        } else {
            return merged[total / 2];
        }
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Median of Two Sorted Arrays\n");
        
        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Test Case 1:");
        System.out.println("nums1 = [1, 3], nums2 = [2]");
        System.out.println("Median (optimized): " + findMedianSortedArrays(nums1, nums2));
        System.out.println("Median (simple): " + findMedianSimple(nums1, nums2));
        
        // Test case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("\nTest Case 2:");
        System.out.println("nums1 = [1, 2], nums2 = [3, 4]");
        System.out.println("Median (optimized): " + findMedianSortedArrays(nums3, nums4));
        System.out.println("Median (simple): " + findMedianSimple(nums3, nums4));
        
        // Test case 3
        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        System.out.println("\nTest Case 3:");
        System.out.println("nums1 = [0, 0], nums2 = [0, 0]");
        System.out.println("Median (optimized): " + findMedianSortedArrays(nums5, nums6));
        
        // Test case 4
        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println("\nTest Case 4:");
        System.out.println("nums1 = [], nums2 = [1]");
        System.out.println("Median (optimized): " + findMedianSortedArrays(nums7, nums8));
        
        // Test case 5
        int[] nums9 = {2};
        int[] nums10 = {};
        System.out.println("\nTest Case 5:");
        System.out.println("nums1 = [2], nums2 = []");
        System.out.println("Median (optimized): " + findMedianSortedArrays(nums9, nums10));
    }
}
