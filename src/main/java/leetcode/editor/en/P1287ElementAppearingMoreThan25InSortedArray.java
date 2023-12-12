
package leetcode.editor.en;

class P1287ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {
        // Solution solution = new P1287 Solution();
        Solution sol = new P1287ElementAppearingMoreThan25InSortedArray().new Solution();
        System.out.println(sol.findSpecialInteger(new int[]{1, 1, 2, 2, 3, 3, 3, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSpecialInteger(int[] arr) {
            if (arr.length <= 0) return arr[0];
            double n = (double) arr.length;
            int cnt = 1;
            int cur = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != cur) {
                    cnt = 1;
                    cur = arr[i];
                } else {
                    cnt++;
                    if (n % 4 == 0) {
                        if (cnt > n / 4) break;
                    } else {
                        if (cnt >= Math.ceil(n / 4)) break;
                    }
                }
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}