//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 18194 👎 294

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums);
            return result;
        }

        private void backtrack(int[] nums) {
            if (tmp.size() == nums.length) {
                result.add(tmp.stream().collect(Collectors.toList()));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                backtrack(nums);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}