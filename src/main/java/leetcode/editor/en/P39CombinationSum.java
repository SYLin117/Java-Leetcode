package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P39CombinationSum {
    public static void main(String[] args) {
        // Solution solution = new P39 Solution();
        Solution sol = new P39CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(target, candidates, 0);
            return result;
        }

        private void backtracking(int target, int[] candidates, int start) {
            int sum = curr.stream().reduce(0, Integer::sum);
            if (sum == target) {
                result.add(new ArrayList<>(curr));
                return;
            }
            if (sum > target) {
                return;
            }
//            if (target - sum < candidates[start]) return;
            for (int i = start; i < candidates.length; i++) {
                curr.add(candidates[i]);
                backtracking(target, candidates, i);
                curr.remove(curr.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}