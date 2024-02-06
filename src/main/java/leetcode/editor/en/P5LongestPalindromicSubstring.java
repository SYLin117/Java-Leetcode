package leetcode.editor.en;

/**
 * Longest Palindromic Substring
 *
 * @author DY
 * @date 2024-01-27 00:47:20
 */
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {

        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            int resultLen = 0;
            for (int i = 0; i < s.length(); i++) {
                // odd length(single center)
                int left = i, right = i;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > resultLen) {
                        result = s.substring(left, right + 1);
                        resultLen = right - left + 1;

                    }
                    left--;
                    right++;
                }
                //even length
                left = i;
                right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > resultLen) {
                        result = s.substring(left, right + 1);
                        resultLen = right - left + 1;

                    }
                    left--;
                    right++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}