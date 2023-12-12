//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics String Stack 👍 22415 👎 1520

package leetcode.editor.en;

import java.util.List;
import java.util.Stack;

class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')' || c == ']' || c == '}') {
                    if (stack.size() <= 0) return false;
                    char lastC = stack.pop();
                    if (c == ')') {
                        if (lastC != '(') return false;
                    } else if (c == ']') {
                        if (lastC != '[') return false;
                    } else {
                        if (lastC != '{') return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            if (stack.size() > 0) return false;
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}