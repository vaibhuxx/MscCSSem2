/*Write a program to sort a list of n numbers in ascending order using Insertion sort and 
determine the time required to sort the elements */

import java.util.Arrays;

public class Slip14a {
    static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(arr));
        long startTime = System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(arr));
        long duration = (endTime - startTime);
        System.out.println("Time taken to sort (in nanoseconds): " + duration);
    }
}
