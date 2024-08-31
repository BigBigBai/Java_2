package bigbigbai._00_leetcode._04_tree.bt.p1;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _104_MaximumDepthOfBinaryTree {
    // 非递归
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }

        return depth;
    }

    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
