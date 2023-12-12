package leetcode.editor.en;


import leetcode.editor.en.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

class P230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new P230KthSmallestElementInABst().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        List<Integer> list = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            traversal(root, k);
            return list.get(k - 1);
        }

        private void traversal(TreeNode node, int k) {
            if (list.size() == k) return;
            if (node.left != null) traversal(node.left, k);
            list.add(node.val);
            if (node.right != null) traversal(node.right, k);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}