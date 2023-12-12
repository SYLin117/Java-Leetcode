//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 17610 👎 922

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution sol = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(sol.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        String[] dict = new String[]{
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return result;
            backtracking(digits, 0, new StringBuilder());
            return result;
        }

        private void backtracking(String digits, int index, StringBuilder tmp) {
            if (tmp.length() == digits.length()) result.add(tmp.toString());
            if (index >= digits.length()) return;

            int num = Character.getNumericValue(digits.charAt(index));
            String chars = dict[num - 2];
            for (int i = 0; i < chars.length(); i++) {
                tmp.append(chars.charAt(i));
                backtracking(digits, index + 1, tmp);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}