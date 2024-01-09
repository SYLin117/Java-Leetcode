
package leetcode.editor.en;

class P6ZigzagConversion {
    public static void main(String[] args) {
        // Solution solution = new P6 Solution();
        Solution sol = new P6ZigzagConversion().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            int n = s.length();
            StringBuilder[] arr = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) arr[i] = new StringBuilder();

            int i = 0;
            while (i < n) {
                /// verticaly downword
                for (int ind = 0; ind < numRows && i < n; ind++) {
                    arr[ind].append(s.charAt(i++));
                }
                /// bent upword
                // 注意是-2因為前面最後有一個++, 且條件是>0
                for (int ind = numRows - 2; ind > 0 && i < n; ind--) {
                    arr[ind].append(s.charAt(i++));
                }
            }
            StringBuilder ans = new StringBuilder();
            for (StringBuilder el : arr) {
                ans.append(el);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}