package bigbigbai._00_leetcode._04_tree;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return isBalanced(root.left) &&
        isBalanced(root.right) &&
        Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
