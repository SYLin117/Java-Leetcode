package leetcode.editor.en;

import java.util.Arrays;

class P1464MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        // Solution solution = new P1464 Solution();
        Solution sol = new P1464MaximumProductOfTwoElementsInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            Arrays.sort(nums);
            if (nums[nums.length - 2] - 1 <= 0) {
                return (nums[0]-1) * (nums[nums.length - 1]-1);
            } else {
                return (nums[nums.length - 1]-1) * (nums[nums.length - 2]-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}