package leetcode.editor.en;

class P344ReverseString {
    public static void main(String[] args) {
        // Solution solution = new P344 Solution();
        Solution sol = new P344ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;

                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}