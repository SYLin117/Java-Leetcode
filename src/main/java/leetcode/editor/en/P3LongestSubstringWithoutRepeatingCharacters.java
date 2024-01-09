package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // Solution solution = new P3 Solution();
        Solution sol = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            if (s.length() <= 1) return s.length();
            Set<Character> set = new HashSet<>();
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                if (!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    result = Math.max(result, right - left + 1);
                    right++;
                } else {
                    while (set.contains(s.charAt(right))) {
                        int tmp = left;
                        set.removeIf(c -> c.equals(s.charAt(tmp)));
                        left++;
                    }
                }
            }
            result = Math.max(result, right - left);
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}