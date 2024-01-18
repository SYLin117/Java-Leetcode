package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P40CombinationSumIi {
    public static void main(String[] args) {
        // Solution solution = new P40 Solution();
        Solution sol = new P40CombinationSumIi().new Solution();
//        System.out.println(sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(sol.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result;
        List<Integer> curr;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            curr = new ArrayList<>();
            int n = candidates.length;
            int[] used = new int[n];
            Arrays.sort(candidates);
            backtracking(0, candidates, used, target);
            return result;
        }

        private void backtracking(int start, int[] candidates, int[] used, int target) {
            int sum = curr.stream().reduce(Integer::sum).orElse(0);
            if (sum == target) {
                result.add(new ArrayList<>(curr));
                return;
            }
            if (sum > target) return;
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] > target) return;
                if (i >= 1 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) continue;
                curr.add(candidates[i]);
                used[i] = 1;
                backtracking(i + 1, candidates, used, target);
                curr.remove(curr.size() - 1);
                used[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}