package algorithms.sorting;

/**
 * Common Sorting Algorithms Implementation
 */
public class SortingAlgorithms {
    
    /**
     * Bubble Sort - O(n^2)
     * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in wrong order
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is already sorted
            if (!swapped) break;
        }
    }
    
    /**
     * Selection Sort - O(n^2)
     * Repeatedly finds the minimum element and places it at the beginning
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Insertion Sort - O(n^2)
     * Builds the final sorted array one item at a time
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort - O(n log n)
     * Divide and conquer algorithm
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    /**
     * Quick Sort - O(n log n) average case
     * Divide and conquer algorithm using pivot
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("Sorting Algorithms Demo\n");
        
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        bubbleSort(arr1);
        System.out.println("After Bubble Sort:");
        printArray(arr1);
        
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array:");
        printArray(arr2);
        selectionSort(arr2);
        System.out.println("After Selection Sort:");
        printArray(arr2);
        
        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array:");
        printArray(arr3);
        insertionSort(arr3);
        System.out.println("After Insertion Sort:");
        printArray(arr3);
        
        int[] arr4 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array:");
        printArray(arr4);
        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("After Merge Sort:");
        printArray(arr4);
        
        int[] arr5 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nOriginal array:");
        printArray(arr5);
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("After Quick Sort:");
        printArray(arr5);
    }
}
