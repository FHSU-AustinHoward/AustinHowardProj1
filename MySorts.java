/**
 * CSCI251ProjOne. This is the class definition for Project One
 * This class is turned in for the assignment
 *
 * @author Austin Howard
 * @version Jun 9, 2023
 */

public class MySorts {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    // merge method
    // merge two sorted	portions of	given array	arr, namely, from start	to middle
    // and from	middle + 1 to end into one sorted portion, namely, from	start to end
    private static void merge(int[] arr, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(arr, start, leftArray, 0, leftSize);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightSize);

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;

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

        while (leftIndex < leftSize) {
            arr[currentIndex] = leftArray[leftIndex];
            leftIndex++;
            currentIndex++;
        }

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
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
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
