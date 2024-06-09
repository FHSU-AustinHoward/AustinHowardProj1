/**
 * MySorts. This is the class definition for Project One.
 * This class is turned in for the assignment.
 * <p>
 * This class provides static methods for sorting arrays using different algorithms.
 *
 * @author Austin Howard
 * @version Jun 9, 2023
 */


public class MySorts {

    // Sorts array using Insertion Sort Algorithm
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than the key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element to the right
                j = j - 1; // Move to the previous element in the sorted region
            }

            // Insert key into correct position
            arr[j + 1] = key;
        }
    }

    // Sorts the array using Selection Sort Algorithm
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                // Update minIndex if element smaller than current minimum
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of unsorted array section
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Sorts the array using Quick Sort Algorithm
    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    // Sorts the array using Merge Sort Algorithm
    public static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    // merge method
    // merge two sorted portions of given array arr, namely, from start to middle
    // and from middle + 1 to end into one sorted portion, namely, from start to end
    private static void merge(int[] arr, int start, int middle, int end) {

        // Determine the sizes of the two subarrays to be merged
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        // Create temporary arrays to hold the elements of the subarrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data to temporary arrays
        System.arraycopy(arr, start, leftArray, 0, leftSize);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightSize);

        // Initial indexes
        int leftIndex = 0;
        int rightIndex = 0;
        int currentIndex = start;

        // Merge the temp arrays back into the array
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                arr[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                arr[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // Copy remaining elements of leftArray
        while (leftIndex < leftSize) {
            arr[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }

        // Copy remaining elements of rightArray
        while (rightIndex < rightSize) {
            arr[currentIndex] = rightArray[rightIndex];
            rightIndex++;
            currentIndex++;
        }
    }

    // merge sort recursive version
    // sort	the	portion	of giving array	arr, from begin	to end
    private static void mergeSortRecursive(int[] arr, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            mergeSortRecursive(arr, begin, middle);
            mergeSortRecursive(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }

    // find	pivot point	for	quick sort
    private static int pivot(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        // Swap arr[i + 1] and arr[end] (or pivot)
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }

    // quick sort recursive	version
    // sort	the	portion	of giving array	arr, from begin	to end
    private static void quickSortRecursive(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = pivot(arr, begin, end);
            quickSortRecursive(arr, begin, pivotIndex - 1);
            quickSortRecursive(arr, pivotIndex + 1, end);
        }
    }

}
