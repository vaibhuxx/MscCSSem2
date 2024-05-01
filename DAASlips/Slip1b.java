/* Write a program to sort a given set of elements using the Quick sort method and determine 
the time required to sort the elements. Repeat the experiment for different values of n, the 
number of elements in the list to be sorted. The elements can be read from a file or can be 
generated using the random number generator. */

import java.util.Arrays;
import java.util.Random;

public class Slip1b {
public static void main(String[] args) {
 // Experiment with different values of n (number of elements)
int[] nValues = {1000, 5000, 10000};
for (int n : nValues) {
int[] arr = generateRandomArray(n);
long startTime = System.nanoTime();
quickSort(arr, 0, arr.length - 1);
long endTime = System.nanoTime();
long duration = endTime - startTime;
System.out.println("Time taken to sort " + n + " elements: " + duration + " nanoseconds");
}
}

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000); // Adjust the range as needed
        }
        return arr;
    }

    private static void quickSort(int[] arr, int low, int high) {
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
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
