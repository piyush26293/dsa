package algorithms.searching;

/**
 * Common Searching Algorithms Implementation
 */
public class SearchingAlgorithms {
    
    /**
     * Linear Search - O(n)
     * Sequentially checks each element until a match is found
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Binary Search - O(log n)
     * Efficiently searches in a sorted array by repeatedly dividing the search interval in half
     * Note: Array must be sorted for binary search to work
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * Binary Search (Recursive) - O(log n)
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        }
        
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Jump Search - O(√n)
     * Works on sorted arrays by jumping ahead by fixed steps and then doing linear search
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;
        
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;
            }
        }
        
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        
        if (arr[prev] == target) {
            return prev;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println("Searching Algorithms Demo\n");
        
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};
        int target = 23;
        
        System.out.println("Array:");
        printArray(arr);
        System.out.println("Target: " + target);
        
        // Linear Search
        int result = linearSearch(arr, target);
        System.out.println("\nLinear Search:");
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
        
        // Binary Search
        result = binarySearch(arr, target);
        System.out.println("\nBinary Search:");
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
        
        // Binary Search Recursive
        result = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("\nBinary Search (Recursive):");
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
        
        // Jump Search
        result = jumpSearch(arr, target);
        System.out.println("\nJump Search:");
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
        
        // Search for element not in array
        int notFound = 100;
        System.out.println("\n\nSearching for element not in array: " + notFound);
        result = binarySearch(arr, notFound);
        System.out.println("Result: " + (result == -1 ? "Not found" : "Found at index " + result));
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
