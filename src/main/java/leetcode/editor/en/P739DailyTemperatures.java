package leetcode.editor.en;

import javax.naming.NameClassPair;
import java.util.Arrays;
import java.util.Stack;

/**
 * Daily Temperatures
 *
 * @author DY
 * @date 2024-01-31 03:35:46
 */
public class P739DailyTemperatures {
    public static void main(String[] args) {

        Solution solution = new P739DailyTemperatures().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            int idx = 0;
            // store temperature index
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        int tmp = stack.pop();
                        result[tmp] = i - tmp;
                    }
                    stack.push(i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}