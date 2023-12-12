package algo.sorting;

// Java program for implementation of Insertion Sort
public class InsertionSort extends Sort {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int fixed = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than fixed, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > fixed) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = fixed;
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
};
