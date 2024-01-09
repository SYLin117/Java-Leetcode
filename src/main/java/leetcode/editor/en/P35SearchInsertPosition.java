
package leetcode.editor.en;

class P35SearchInsertPosition {
    public static void main(String[] args) {
        // Solution solution = new P35 Solution();
        Solution sol = new P35SearchInsertPosition().new Solution();
        System.out.println(sol.searchInsert(new int[]{1, 3}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return search(0, nums.length - 1, nums, target);
        }

        private int search(int start, int end, int[] nums, int target) {
            if (start >= end) {
                if (nums[start] < target) return start + 1;
                if (nums[start] >= target) return start;
            }

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) return search(start, mid - 1, nums, target);
            else return search(mid + 1, end, nums, target);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}