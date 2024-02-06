package leetcode.editor.en;

/**
 * Climbing Stairs
 *
 * @author DY
 * @date 2024-01-27 17:46:26
 */
public class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}