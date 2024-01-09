package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P18FourSum {
    public static void main(String[] args) {
        // Solution solution = new P18 Solution();
        Solution sol = new P18FourSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {

                // nums[i] > target 直接返回, 剪枝操作
                if (nums[i] > 0 && nums[i] > target) {
                    return result;
                }

                if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                    continue;
                }

                for (int j = i + 1; j < nums.length; j++) {

                    if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;
                    while (right > left) {
                        // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else { // sum == target
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            // 对nums[left]和nums[right]去重
                            while (right > left && nums[right] == nums[right - 1]) right--;
                            while (right > left && nums[left] == nums[left + 1]) left++;

                            left++;
                            right--;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}