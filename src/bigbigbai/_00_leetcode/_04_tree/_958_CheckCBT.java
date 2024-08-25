package bigbigbai._00_leetcode._04_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _958_CheckCBT {
    public boolean isCBT(TreeNode root) {
        if (root == null) return false;
        boolean isLeaf = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isLeaf && !(node.left == null && node.right == null)) return false;

            // 1.If node.left!=null && node.right!=null, add node.left and node.right to the queue in sequence
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            // 2.
            else if (node.right != null) return false;
            // 3.
            else if (node.left != null) {
                queue.offer(node.left);
                isLeaf = true;
            }
            // 4.
            else isLeaf = true;
        }

        return true;
    }
}
