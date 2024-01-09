//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// 
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 11515 👎 364

package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

class P242ValidAnagram {
    public static void main(String[] args) {
        // Solution solution = new P242 Solution();
        Solution sol = new P242ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> dict = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (dict.containsKey(s.charAt(i))) {
                    dict.put(s.charAt(i), dict.get(s.charAt(i)) + 1);
                } else {
                    dict.put(s.charAt(i), 1);
                }
            }
            for (int i = 0; i < t.length(); i++) {
                if (dict.containsKey(t.charAt(i)) && dict.get(t.charAt(i)) > 0) {
                    dict.put(t.charAt(i), dict.get(t.charAt(i)) - 1);
                } else {
                    return false;
                }
            }
            for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
                if (entry.getValue() != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}