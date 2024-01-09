
package leetcode.editor.en;

import java.util.PriorityQueue;

class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        // Solution solution = new P215 Solution();
        Solution sol = new P215KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for (int num : nums) {
                pq.add(-1 * num);
            }
            int result = 0;
            for (int i = 0; i < k; i++) {
                result = pq.poll() * -1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}