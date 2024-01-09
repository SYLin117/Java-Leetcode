
package leetcode.editor.en;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class P74SearchA2dMatrix {
    public static void main(String[] args) {
        // Solution solution = new P74 Solution();
        Solution sol = new P74SearchA2dMatrix().new Solution();
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 60};
        System.out.println(sol.searchMatrix(matrix, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = getRow(matrix, target);
            return findInRow(matrix[row], target, 0, matrix[row].length - 1);
        }

        private boolean findInRow(int[] arr, int target, int start, int end) {
            if (start >= end) {
                return arr[start] == target;
            }
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) return findInRow(arr, target, mid + 1, end);
            else return findInRow(arr, target, start, mid - 1);
        }

        private int getRow(int[][] matrix, int target) {
            List<Integer> firstCol = Arrays.stream(matrix)
                    .map(row -> row[0])
                    .collect(Collectors.toList());
            return getRowHelper(firstCol, target, 0, matrix.length - 1);
        }

        private int getRowHelper(List<Integer> arr, int target, int start, int end) {
            if (start >= end) {
                if (start == 0) return 0;
                if (arr.get(start) > target) return start - 1;
                return start;
            }
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target) return mid;
            else if (arr.get(mid) < target) return getRowHelper(arr, target, mid + 1, end);
            else return getRowHelper(arr, target, start, mid - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}