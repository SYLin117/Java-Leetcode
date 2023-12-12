package leetcode.editor.en;

import leetcode.editor.en.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        // Solution solution = new P637 Solution();
        Solution sol = new P637AverageOfLevelsInBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        List<Double> result = new ArrayList<>();

        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) return result;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (queue.size() > 0) {
                int qSize = queue.size();
                double sum = 0;
                for (int i = 0; i < qSize; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                result.add(sum / qSize);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}