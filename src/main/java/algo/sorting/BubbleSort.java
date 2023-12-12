package algo.sorting;

public class BubbleSort extends Sort {
    @Override
    public void sort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    // if no swap happend then isSorted would be true;
                    isSorted = false;
                }

            }
        }
    }

}
