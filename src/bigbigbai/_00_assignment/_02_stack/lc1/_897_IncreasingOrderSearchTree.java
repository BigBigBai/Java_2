package bigbigbai._00_assignment._02_stack.lc1;

import bigbigbai._00_assignment.TreeNode;

public class _897_IncreasingOrderSearchTree {
    TreeNode dummyNode = new TreeNode(0);
    TreeNode newTail = dummyNode;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        // 注意
        newTail.left = null;
        newTail.right = null;
        return dummyNode.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        newTail.left = null;
        newTail.right = root;
        newTail = newTail.right;

        inorder(root.right);
    }
}
