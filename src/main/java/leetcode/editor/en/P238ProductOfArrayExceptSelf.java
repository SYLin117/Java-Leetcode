//Given an integer array nums, return an array answer such that answer[i] is 
//equal to the product of all the elements of nums except nums[i]. 
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
//
// You must write an algorithm that runs in O(n) time and without using the 
//division operation. 
//
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// 
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The 
//output array does not count as extra space for space complexity analysis.) 
//
// Related Topics Array Prefix Sum 👍 20312 👎 1167

package leetcode.editor.en;

class P238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];
            // solution 1: use division
//            int zeroCnt = 0;
//            int product = 1;
//            for (int num : nums) {
//                if (num != 0) product *= num;
//                if (num == 0) zeroCnt++;
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if ((zeroCnt >= 1 && nums[i] != 0) || zeroCnt >= 2) {
//                    result[i] = 0;
//                } else if (nums[i] == 0) {
//                    result[i] = product;
//                } else {
//                    result[i] = product / nums[i];
//                }
//            }

            // solution 2: prefix sum
            int prefixProduct = 1;
            int suffixProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                // result[i] = nums[0]xnums[1]x...xnums[i-1]
                result[i] = prefixProduct;
                prefixProduct *= nums[i];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] *= suffixProduct; // IMPORTANT
                suffixProduct *= nums[i];
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}