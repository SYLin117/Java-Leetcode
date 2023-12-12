package algo.sorting;

public class MergeSort extends Sort {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // devide into two sub array
        // copy first half to left
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        // copy second half to left
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }
        sort(left);
        sort(right);

        merge(array, left, right, mid, n - mid);
    }

    private void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
