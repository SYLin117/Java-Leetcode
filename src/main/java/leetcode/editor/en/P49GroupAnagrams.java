//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// 
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// 
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 17498 👎 523

package leetcode.editor.en;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> dict = new HashMap<>();
            for (String str : strs) {
                char[] keyArr = str.toCharArray();
                Arrays.sort(keyArr);
                String key = new String(keyArr);
                if (dict.containsKey(key)) {
                    dict.get(key).add(str);
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(str);
                    dict.put(key, newList);
                }
            }
            return dict.values().stream().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}