//Given two strings ransomNote and magazine, return true if ransomNote can be 
//constructed by using the letters from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// 
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// 
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Counting 👍 4583 👎 463

package leetcode.editor.en;

import java.util.HashMap;

class P383RansomNote {
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            boolean result = true;
            HashMap<Character, Integer> dict = new HashMap<Character,Integer>();
            for (int i = 0; i < magazine.length(); i++) {
                if (dict.containsKey(magazine.charAt(i))) {
                    dict.put(magazine.charAt(i), dict.get(magazine.charAt(i)) + 1);
                } else {
                    dict.put(magazine.charAt(i), 1);
                }
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if (!dict.containsKey(ransomNote.charAt(i))) {
                    return false;
                } else {
                    if (dict.get(ransomNote.charAt(i)) <= 0) {
                        return false;
                    }
                    dict.put(ransomNote.charAt(i), dict.get(ransomNote.charAt(i)) - 1);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}