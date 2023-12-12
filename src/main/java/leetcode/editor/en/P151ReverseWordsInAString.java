//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 7488 👎 4920

package leetcode.editor.en;

class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        String test = "   hello world   ";
        System.out.println(solution.reverseWords(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder(s);
            reverse(sb, 0, s.length() - 1);
            int left = 0;
            int right = 0;
            int cnt = 0;
            while (right < s.length()) {
                if (left == right && sb.charAt(right) == ' ') {
                    right++;
                    left = right;
                } else if (sb.charAt(right) == ' ') {
                    reverse(sb, left, right - 1);
                    if (cnt > 0) result.append(" ");
                    result.append(sb.substring(left, right));
                    right++;
                    left = right;
                    cnt++;
                } else {
                    right++;
                }
            }
            if (left != right) {
                if(cnt>0) result.append(" ");
                reverse(sb, left, right - 1);
                result.append(sb.substring(left, right));
            }
            return result.toString();
        }

        private void reverse(StringBuilder sb, int left, int right) {
            while (left < right) {
                char tmp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, tmp);
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}