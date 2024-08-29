package bigbigbai._00_leetcode._04_tree.bt;

import bigbigbai._00_leetcode._04_tree.TreeNode;

public class _104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

    }

    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
