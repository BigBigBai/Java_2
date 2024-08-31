package bigbigbai._00_leetcode._04_tree.bt.p1;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BinaryTreePreorderTraversal {

    // 非递归2
    // 有右先压右，有左再压左
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return res;
    }

    // 非递归1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (true) {
            if (node != null) {
                res.add(node.val);
                stack.push(node.right);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                else node = stack.pop();
            }
        }

        return res;
    }


    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preorderTraversal(root, res);

        return res;
    }

    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}
