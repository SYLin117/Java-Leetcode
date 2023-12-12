//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 14112 
//👎 432

package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

import java.util.Arrays;
import java.util.NoSuchElementException;

class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return traversal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        }

        private TreeNode traversal(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (inStart > inEnd) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int idx = findInorderIndex(root.val, inorder, inStart, inEnd);
            int leftSize = idx - inStart;
            int rightSize = inEnd - idx;

            root.left = traversal(preorder, preStart + 1, preStart + 1 + leftSize - 1, inorder, inStart, idx - 1);
            root.right = traversal(preorder, preStart + 1 + leftSize, preEnd, inorder, idx + 1, inEnd);
            return root;
        }

        private int findInorderIndex(int val, int[] inorder, int inStart, int inEnd) {
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == val) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}