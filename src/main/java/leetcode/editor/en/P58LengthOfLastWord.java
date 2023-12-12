//Given a string s consisting of words and spaces, return the length of the 
//last word in the string. 
//
// A word is a maximal substring consisting of non-space characters only. 
//
// 
// Example 1: 
//
// 
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
// 
//
// Example 2: 
//
// 
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
// 
//
// Example 3: 
//
// 
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only English letters and spaces ' '. 
// There will be at least one word in s. 
// 
//
// Related Topics String 👍 4176 👎 206

package leetcode.editor.en;

class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        String test = "   fly me   to   the moon  ";
        System.out.println(solution.lengthOfLastWord(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int left = 0;
            int right = 0;
            int result = 0;
            while (right < s.length()) {
                if (s.charAt(right) == ' ') {
                    if (s.charAt(left) != ' ') {
                        result = right - left;
                    }
                    right++;
                    left = right;
                } else {
                    right++;
                }
            }
            if (left<s.length() && s.charAt(left) != ' ') {
                result = right - left;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}