package leetcode.editor.en;

class P91DecodeWays {
    public static void main(String[] args) {
        // Solution solution = new P91 Solution();
        Solution sol = new P91DecodeWays().new Solution();
        System.out.println(sol.numDecodings("12"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int result = 0;

        public int numDecodings(String s) {
            if (s == null || s.isEmpty() || s.charAt(0) == '0') {
                return 0;
            }
            int n = s.length();
            // dp[i] represents the number of ways to decode the substring s[:i]
            int[] dp = new int[n + 1];
            // there is one way to decode an empty string and a string of length 1.
            dp[0] = 1;
            dp[1] = 1;
            // dp[i] 相當於 dp[i-1] + (if applicable) dp[i-2]
            for (int i = 2; i <= n; i++) {
                int oneDigit = s.charAt(i - 1) - '0';
                int twoDigits = Integer.parseInt(s.substring(i - 2, i));
                if (oneDigit != 0) {
                    dp[i] += dp[i - 1];
                }

                if (10 <= twoDigits && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}