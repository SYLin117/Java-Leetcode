//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path 
//from the root node down to the farthest leaf node. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12
//016 👎 197

package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int result = 0;

        public int maxDepth(TreeNode root) {
            return traversal(root, 0);
        }

        private int traversal(TreeNode node, int level) {
            if (node == null) return level;
            level++;
            return Math.max(traversal(node.left, level), traversal(node.right, level));
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}