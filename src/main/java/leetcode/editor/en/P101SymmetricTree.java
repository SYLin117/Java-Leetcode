//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively?
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 14
//494 👎 341

package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return traversal(root.left, root.right);
        }

        private boolean traversal(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null && right != null) return false;
            if (left != null && right == null) return false;

            if (left.val != right.val) return false;
            return traversal(left.left, right.right) && traversal(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}