package leetcode.editor.en;

import java.util.Arrays;

class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        int[] test = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum < target) return 0;
            int result = nums.length;
            int left = 0;
            int right = 0;
            sum = 0;
            while (right < nums.length) {
                sum += nums[right];
                while (left <= right && sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            return result;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}