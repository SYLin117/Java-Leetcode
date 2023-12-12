package leetcode.editor.en;


import leetcode.editor.en.ds.TreeNode;

class P530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(solution.getMinimumDifference(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        Integer min = Integer.MAX_VALUE;
        Integer prev = 0;
        Boolean first = true;

        public int getMinimumDifference(TreeNode root) {
            traversal(root);
            return min;
        }

        private void traversal(TreeNode node) {

            if (node.left != null) traversal(node.left);
            if (!first) {
                min = Math.min(node.val - prev, min);

            } else {
                first = false;
            }
            prev = node.val;
            if (node.right != null) traversal(node.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}