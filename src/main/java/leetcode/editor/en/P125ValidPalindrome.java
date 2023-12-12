//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 8351 👎 7952

package leetcode.editor.en;

class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        String test = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int left = 0;
            int right = s.length() - 1;
            boolean result = true;
            while (left < right) {
                while (left < right && !validChar(s.charAt(left))) {
                    left++;
                }
                while (left < right && !validChar(s.charAt(right))) {
                    right--;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    result = false;
                    break;
                } else {
                    left++;
                    right--;
                }

            }
            return result;
        }

        private boolean validChar(char c) {
            return (c >= 48 && c <= 57) || (c >= 97 && c <= 122);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}