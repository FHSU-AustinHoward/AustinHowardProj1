# Project	One:	Compare	Sorting	Algorithms
* Austin Howard
* 2024U_CSCI251_VA - Data Structures
* Jun 9, 2024
* Instructor: Leticia Rabor
  
## Project	Description
In this	project, students	are	required to	implement	the	following	algorithms:	Insert Sort, Select	Sort,	Quick	Sort,	and	Merge	Sort.  

You will find my implementation in MySort.java, which is being called by executing CSCI251ProjOne.java (which I did not modify) provided by the instructor.  

The goal of this project is to compare sorting algorithms to see how their algorithmic efficiency differs from eachother.  

## Project Requirements
1. Implement the file MySort.java using the following public interfaces:
   * ```public static void insertSort(int [] arr);```
   * ```public static void insertSort(int [] arr);```
   * ```public static void selectSort(int [] arr);```
   * ```public static void quickSort(int [] arr);```
   * ```public static void mergeSort(int [] arr);```
2. The quick sort and merge sort must be implemented by using	recursive	thinking.	So	the	
students	may	provide	the	following	private	static	methods:
    * ```
      // merge method  
      // merge two sorted portions of given array arr, namely, from start to middle  
      // and from middle + 1 to end into one sorted portion, namely, from start to end
      private static void merge(int[] arr, int start, int middle, int end);
      ```
    * ```
      // merge sort recursive version
      // sort the portion of giving array arr, from begin to end
      private static void mergeSortRecursive(int[] arr, int begin, int end);
      ```
    * ```
      // find pivot point for quick sort
      private static int pivot(int[] arr, int begin, int end);
      ```
    * ```
      // quick sort recursive version
      // sort the portion of giving array arr, from begin to end
      private static void quickSortRecursive(int[] arr, int begin, int end);
      ```
3. The student need to have and only have the above public and private static methods in his/her implementation of MySort class.

## License
Uses GNU GPL v3.0  
Please see license in main branch.
