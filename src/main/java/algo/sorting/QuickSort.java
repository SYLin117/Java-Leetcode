package algo.sorting;

public class QuickSort extends Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int begin, int end) {
        // also divide-and-conqor
        if (begin < end) {
            // partitionIndex is the sorted index(only that exact single index)
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end]; // get pivot from last element
        // i start before the array
        int i = (begin - 1);

        // when we found element < pivot, swap it to left part
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // move pivot to arr[i+1]
        // so for now arr[begin..i] are all < pivot
        swap(arr, i + 1, end);

        return i + 1;
    }
}
