package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequential Digits
 *
 * @author DY
 * @date 2024-02-01 22:56:49
 */
public class P1291SequentialDigits {
    public static void main(String[] args) {

        Solution solution = new P1291SequentialDigits().new Solution();
//        System.out.println(solution.sequentialDigits(100, 300));
        System.out.println(solution.sequentialDigits(58, 155));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> result = new ArrayList<>();
            String minStr = String.valueOf(low);
            String maxStr = String.valueOf(high);
            int minDigits = minStr.length();
            int maxDigits = maxStr.length();

            StringBuilder sb = new StringBuilder();
            for (int digits = minDigits; digits <= maxDigits; digits++) {
                int start = (digits == minDigits) ? Character.getNumericValue(String.valueOf(low).charAt(0)) : 1;
                for (; start + digits - 1 <= 9; start++) {
                    for (int i = 0; i < digits; i++) {
                        sb.append(start + i);
                    }
                    int tmp = Integer.parseInt(sb.toString());
                    if (tmp >= low && tmp <= high) {
                        result.add(tmp);
                    }
                    sb.setLength(0);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}