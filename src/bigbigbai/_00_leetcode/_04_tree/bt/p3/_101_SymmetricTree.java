package bigbigbai._00_leetcode._04_tree.bt.p3;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _101_SymmetricTree {
    // 非递归
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left == null && root.right == null) return true;
        else if (root.left == null) return false;
        else if (root.right == null) return false;
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftSubTree = queue.poll();
            TreeNode rightSubTree = queue.poll();

            if (leftSubTree.val != rightSubTree.val) return false;

            if (leftSubTree.left != null && rightSubTree.right != null) {
                queue.add(leftSubTree.left);
                queue.add(rightSubTree.right);
            }
            else if (leftSubTree.left != null) return false;
            else if (rightSubTree.right != null) return false;

            if (leftSubTree.right != null && rightSubTree.left != null) {
                queue.add(leftSubTree.right);
                queue.add(rightSubTree.left);
            }
            else if (leftSubTree.right != null) return false;
            else if (rightSubTree.left != null) return false;
        }

        return true;
    }

    // 递归
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftSubTree, TreeNode rightSubTree) {
        if (leftSubTree == null && rightSubTree == null) return true;
        else if (leftSubTree == null) return false;
        else if (rightSubTree == null) return false;

        return
        isSymmetric(leftSubTree.left, rightSubTree.right) &&
        isSymmetric(leftSubTree.right, rightSubTree.left) &&
        leftSubTree.val == rightSubTree.val;
    }
}
