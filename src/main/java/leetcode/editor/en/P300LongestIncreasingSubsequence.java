package leetcode.editor.en;

import java.util.Arrays;

class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        // Solution solution = new P300 Solution();
        Solution sol = new P300LongestIncreasingSubsequence().new Solution();
//        System.out.println(sol.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
//        System.out.println(sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(sol.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println(sol.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int result = 0;
            int n = nums.length;
            if (n <= 1) return n;
            int[] dp = new int[n];
            // if there is no increase value then all element should start from 1
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}