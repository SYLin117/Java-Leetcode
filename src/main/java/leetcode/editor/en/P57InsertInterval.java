//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics Array 👍 9167 👎 673

package leetcode.editor.en;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

class P57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new P57InsertInterval().new Solution();
        int[][] intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        int[] newInt = new int[]{4, 8};
        printArr(solution.insert(intervals, newInt));

    }

    public static void printArr(int[][] arrays) {
        // Iterate over the rows of the 2D array
        for (int i = 0; i < arrays.length; i++) {
            // Iterate over the columns in each row
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> intervalsList = Arrays.stream(intervals).collect(Collectors.toList());
            intervalsList.add(newInterval);
            Collections.sort(intervalsList, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // Compare based on the first element (index 0) of each subarray
                    return a[0] - b[0];
                }
            });
            List<int[]> result = new ArrayList<>();
            int pre = 0;
            int max = intervalsList.get(0)[1];
            for (int i = 1; i < intervalsList.size(); i++) {
                if (intervalsList.get(i)[0] > max) {
                    result.add(new int[]{intervalsList.get(pre)[0], max});
                    pre = i;
                }
                max = Math.max(max, intervalsList.get(i)[1]);
            }
            result.add(new int[]{intervalsList.get(pre)[0], max});
            // NOTE
            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}