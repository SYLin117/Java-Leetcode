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