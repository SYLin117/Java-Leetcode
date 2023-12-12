//Given two integers n and k, return all possible combinations of k numbers 
//chosen from the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
//be the same combination.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics Backtracking 👍 7897 👎 206

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class P77Combinations {
    public static void main(String[] args) {
        // Solution solution = new P77 Solution();
        Solution sol = new P77Combinations().new Solution();
        System.out.println(sol.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> curr = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtracking(1, n, k);
            return result;
        }

        private void backtracking(int start, int n, int k) {
            if (curr.size() == k) result.add(new ArrayList<>(curr));
            if (start > n) return;
            for (int i = start; i <= n; i++) {
                curr.add(i);
                backtracking(i + 1, n, k);
                curr.remove(curr.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}