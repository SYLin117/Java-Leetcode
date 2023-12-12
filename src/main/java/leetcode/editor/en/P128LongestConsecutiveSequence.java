//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array Hash Table Union Find 👍 18531 👎 842

package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;

class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            int result = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int max = 0;
            for (int num : nums) {
                // find number that is the leftest number in it's sequence
                // 1 4 3 100 2 101 --> 1 and 100
                if (!set.contains(num - 1)) {
                    int length = 0;
                    // because we only loop every number once in while loop
                    // so it's still O(n)
                    while (set.contains(num + length)) {
                        length++;
                    }
                    max = Math.max(max, length);

                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}