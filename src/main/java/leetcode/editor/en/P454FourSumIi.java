package leetcode.editor.en;

import java.util.HashMap;

class P454FourSumIi {
    public static void main(String[] args) {
        // Solution solution = new P454 Solution();
        Solution sol = new P454FourSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            var fourSumCount = 0;
            var pairCountBySum = new HashMap<Integer, Integer>();

            for (var num1 : nums1)
                for (var num2 : nums2)
                    pairCountBySum.compute(num1 + num2, (key, value) -> value == null ? 1 : value++);


            for (var num3 : nums3)
                for (var num4 : nums4)
                    fourSumCount += pairCountBySum.getOrDefault(-(num3 + num4), 0);

            return fourSumCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}