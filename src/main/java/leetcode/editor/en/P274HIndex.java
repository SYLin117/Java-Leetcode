//Given an array of integers citations where citations[i] is the number of 
//citations a researcher received for their iᵗʰ paper, return the researcher's h-index.
// 
//
// According to the definition of h-index on Wikipedia: The h-index is defined 
//as the maximum value of h such that the given researcher has published at least 
//h papers that have each been cited at least h times. 
//
// 
// Example 1: 
//
// 
//Input: citations = [3,0,6,1,5]
//Output: 3
//Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each 
//of them had received 3, 0, 6, 1, 5 citations respectively.
//Since the researcher has 3 papers with at least 3 citations each and the 
//remaining two with no more than 3 citations each, their h-index is 3.
// 
//
// Example 2: 
//
// 
//Input: citations = [1,3,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
//
// Related Topics Array Sorting Counting Sort 👍 786 👎 275

package leetcode.editor.en;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class P274HIndex {
    public static void main(String[] args) {
        Solution solution = new P274HIndex().new Solution();
        int[] test = new int[]{1, 3, 1};
        System.out.println(solution.hIndex(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            Integer[] integerArr = Arrays.stream(citations)
                    .boxed()
                    .toArray(Integer[]::new);
            Arrays.sort(integerArr, (a, b) -> b - a);
            int idx = 0;
            while (idx < integerArr.length && idx+1 <= integerArr[idx]) {
                idx++;
            }
            return idx;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}