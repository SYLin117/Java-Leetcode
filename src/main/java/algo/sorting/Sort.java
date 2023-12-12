package algo.sorting;

public abstract class Sort {
    public abstract void sort(int[] array);

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx2];
        array[idx2] = array[idx1];
        array[idx1] = tmp;
    }
}
