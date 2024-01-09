

package leetcode.editor.en;

class P796RotateString {
    public static void main(String[] args) {
        // Solution solution = new P796 Solution();
        Solution sol = new P796RotateString().new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab"));
        System.out.println(sol.rotateString("abcde", "abced"));
        System.out.println(sol.rotateString("bbbacddceeb", "ceebbbbacdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) return false;
            s = s + s;
            return (s.contains(goal));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}