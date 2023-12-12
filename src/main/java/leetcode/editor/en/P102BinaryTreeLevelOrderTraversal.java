//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Tree Breadth-First Search Binary Tree 👍 14472 👎 289

package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.levelOrder(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        private Queue<TreeNode> current = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return result;
            current.add(root);
            traversal();
            return result;
        }

        private void traversal() {
            while (!current.isEmpty()) {
                result.add(current.stream().map(TreeNode::getVal).collect(Collectors.toList()));
                int size = current.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = current.poll();

                    if (node.left != null) current.add(node.left);
                    if (node.right != null) current.add(node.right);

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}