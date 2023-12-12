//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 16199 👎 589

package leetcode.editor.en;

import java.util.*;

class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // IMPORTANT!!!
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            HashMap<Integer, Integer> dict = new HashMap<>();
            for (int num : nums) {
                if (dict.containsKey(num)) {
                    dict.put(num, dict.get(num) + 1);
                } else {
                    dict.put(num, 1);
                }
            }
            // IMPORTANT
            for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
                pq.add(entry);
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = Objects.requireNonNull(pq.poll()).getKey();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}