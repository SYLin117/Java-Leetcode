
package leetcode.editor.en;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        // Solution solution = new P239 Solution();
        Solution sol = new P239SlidingWindowMaximum().new Solution();
        int[] testData = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Arrays.stream(sol.maxSlidingWindow(testData, 3)).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // make sure this deque is Monotonic Queue
        Deque<Integer> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n - k + 1];
            int idx = 0; // result index
            for (int i = 0; i < nums.length; i++) {
                // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
                // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }
                // 2.確保deque保持單調遞減
                while (!deque.isEmpty() && (nums[deque.peekLast()] < nums[i])) {
                    deque.pollLast();
                }

                deque.offer(i); // deque 存的是num的index

                // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
                // 队列队顶元素始终为最大值
                if (i >= k - 1) {
                    result[idx++] = nums[deque.peek()];
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}