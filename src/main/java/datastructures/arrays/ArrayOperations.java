package datastructures.arrays;

/**
 * Basic Array Operations
 * Demonstrates fundamental array manipulations in Java
 */
public class ArrayOperations {
    
    /**
     * Find the maximum element in an array
     */
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Find the minimum element in an array
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Reverse an array in place
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    /**
     * Find sum of all elements in an array
     */
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    /**
     * Search for an element in an array (Linear Search)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3};
        
        System.out.println("Array Operations Demo");
        System.out.println("Original Array:");
        printArray(numbers);
        
        System.out.println("\nMax element: " + findMax(numbers));
        System.out.println("Min element: " + findMin(numbers));
        System.out.println("Sum of elements: " + sumArray(numbers));
        System.out.println("Search for 8: Index = " + linearSearch(numbers, 8));
        
        reverseArray(numbers);
        System.out.println("\nReversed Array:");
        printArray(numbers);
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
