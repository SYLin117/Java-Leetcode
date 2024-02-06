package leetcode.editor.en;

/**
 * House Robber
 *
 * @author DY
 * @date 2024-01-30 02:25:07
 */
public class P198HouseRobber {
    public static void main(String[] args) {

        Solution solution = new P198HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}