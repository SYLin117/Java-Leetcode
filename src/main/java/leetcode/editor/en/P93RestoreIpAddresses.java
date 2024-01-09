package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

class P93RestoreIpAddresses {
    public static void main(String[] args) {
        // Solution solution = new P93 Solution();
        Solution sol = new P93RestoreIpAddresses().new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            StringBuilder current = new StringBuilder();
            backtracking(s, 0, 0);
            return result;
        }

        private void backtracking(String s, int start, int cnt) {
            if (start == s.length() && cnt == 4) {
                result.add(String.join(".", current));
                return;
            }
            if (cnt >= 4) return;

            if (current.size() == 1) {
                System.out.println();
            }

            for (int i = 0; i < Math.min(3, s.length() - start); i++) {
                if (i == 1 && s.charAt(start + i - 1) == '0') break;
                int tmp = Integer.valueOf(s.substring(start, start + 1 + i));
                if (tmp > 255) break;
                current.add(s.substring(start, start + 1 + i));
                backtracking(s, start + 1 + i, cnt + 1);
                current.remove(current.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}