//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 18007 👎 1033

package leetcode.editor.en;

class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        int[] test = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.canJump(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (i + nums[i] >= n - 1) {
                    dp[i] = 1;
                    continue;
                }
                for (int j = 1; j <= nums[i]; j++) {
                    if (dp[i + j] == 1) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
            return dp[0] == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}