package bigbigbai._00_leetcode._04_tree.bt.p3;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.Stack;

public class _114_FlattenBinaryTreeToLinkedList {

    // space complexity: O(logn)
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            if (!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}
