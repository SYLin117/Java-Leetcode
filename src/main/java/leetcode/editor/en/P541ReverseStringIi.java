package leetcode.editor.en;

class P541ReverseStringIi {
    public static void main(String[] args) {
        // Solution solution = new P541 Solution();
        Solution sol = new P541ReverseStringIi().new Solution();
//        System.out.println(sol.reverseStr("abcdefg", 2));
//        System.out.println(sol.reverseStr("abcd", 2));
        System.out.println(sol.reverseStr("abcdefg", 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            if (s.length() <= 1) return s;
            char[] chars = s.toCharArray();
            int i = 0;
            for (; i * 2 * k + (k - 1) < s.length(); i++) {
                int start = i * 2 * k;
                int end = start + k - 1;
                reverse(chars, start, end);
            }
            int lastPart = (s.length() - 1) - (i * 2 * k) + 1;
            if (lastPart <= 1) {
                // do nothing
            } else if (lastPart < k) {
                int start = i * 2 * k;
                int end = s.length()-1;
                reverse(chars, start, end);
            } else if (lastPart > k) {
                int start = i * 2 * k;
                int end = start + k - 1;
                reverse(chars, start, end);
            }
            return new String(chars);
        }

        private void reverse(char[] chars, int start, int end) {
            while (start < end) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }

        private void swap(char[] chars, int left, int right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}