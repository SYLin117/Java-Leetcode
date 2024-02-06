package leetcode.editor.en;

/**
 * Unique Paths
 *
 * @author DY
 * @date 2024-01-27 17:56:14
 */
public class P62UniquePaths {
    public static void main(String[] args) {

        Solution solution = new P62UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}