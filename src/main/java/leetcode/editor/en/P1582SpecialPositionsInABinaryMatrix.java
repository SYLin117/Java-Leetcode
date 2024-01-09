package leetcode.editor.en;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class P1582SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        // Solution solution = new P1582 Solution();
        Solution sol = new P1582SpecialPositionsInABinaryMatrix().new Solution();
        int[][] test = new int[3][3];
        test[0] = new int[]{1, 0, 0};
        test[1] = new int[]{0, 0, 1};
        test[2] = new int[]{1, 0, 0};
        sol.numSpecial(test);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecial(int[][] mat) {
            int special = 0;

            for (int[] row : mat) {
                // if row sum == 1, then special possible
                if (getRowSum(row) == 1) {
                    int colIdx = getIndexOfOne(row); // find the index in row with 1
                    special += (getColumnSum(mat, colIdx) == 1) ? 1 : 0;
                }
            }

            return special;
        }

        private int getRowSum(int[] row) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            return sum;
        }

        private int getColumnSum(int[][] mat, int colIdx) {
            int sum = 0;
            for (int[] row : mat) {
                sum += row[colIdx];
            }
            return sum;
        }

        private int getIndexOfOne(int[] row) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    return i;
                }
            }
            return -1; // If 1 is not found, return -1 or handle accordingly
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}