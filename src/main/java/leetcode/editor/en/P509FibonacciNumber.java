package leetcode.editor.en;

/**
 * Fibonacci Number
 *
 * @author DY
 * @date 2024-01-27 17:52:16
 */
public class P509FibonacciNumber {
    public static void main(String[] args) {

        Solution solution = new P509FibonacciNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}