//Given the roots of two binary trees p and q, write a function to check if 
//they are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical, 
//and the nodes have the same value. 
//
// 
// Example 1: 
// 
// 
//Input: p = [1,2,3], q = [1,2,3]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: p = [1,2], q = [1,null,2]
//Output: false
// 
//
// Example 3: 
// 
// 
//Input: p = [1,2,1], q = [1,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in both trees is in the range [0, 100]. 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 10
//550 👎 203

package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

class P100SameTree {
    public static void main(String[] args) {
        Solution solution = new P100SameTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return traversal(p, q);
        }

        public boolean traversal(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) return true;
            if (node1 == null && node2 != null) return false;
            if (node1 != null && node2 == null) return false;
            if (node1.val != node2.val) return false;
            return traversal(node1.left, node2.left) && traversal(node1.right, node2.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}