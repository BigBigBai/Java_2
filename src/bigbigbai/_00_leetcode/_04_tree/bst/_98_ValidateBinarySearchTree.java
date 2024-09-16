package bigbigbai._00_leetcode._04_tree.bst;

import bigbigbai._00_leetcode._04_tree.TreeNode;
import bigbigbai._07_tree.BinaryTree1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _98_ValidateBinarySearchTree {
    // 方法3: 非递归 + 中序遍历
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                root = stack.pop();
//                System.out.print(root.val+" ");
                if (prev != null && root.val <= prev.val) return false;

                prev = root;
                root = root.right;
            }
        }

        return true;
    }

    // 方法1: 递归
    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST1(root.left, min, root.val) && isValidBST1(root.right, root.val, max);
    }

    // 方法2: 递归 + 中序遍历
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }

        return true;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
