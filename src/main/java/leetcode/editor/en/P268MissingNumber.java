package leetcode.editor.en;

import java.util.Arrays;

class P268MissingNumber {
    public static void main(String[] args) {
        // Solution solution = new P268 Solution();
        Solution sol = new P268MissingNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            // method 1
//            Arrays.sort(nums);
//            if (nums[0] != 0) return 0;
//            int prev = 0;
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] != prev + 1) return prev + 1;
//                prev += 1;
//            }
//            return prev + 1;
            
            // method 2
            int sum = 0;
            sum = Arrays.stream(nums).sum();
            int n = nums.length;
            return (n + 1) * n / 2 - sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}