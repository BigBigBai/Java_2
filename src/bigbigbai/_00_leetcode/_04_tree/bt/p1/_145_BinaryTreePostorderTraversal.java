package bigbigbai._00_leetcode._04_tree.bt.p1;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_BinaryTreePostorderTraversal {
    // 非递归1
    // 1.把先序遍历的顺序调整, CLR -> CRL
    // 2.做个栈，收集结果
    // 3.把结果依次弹出
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tmp.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        while (!tmp.isEmpty()) {
            res.add(tmp.pop().val);
        }
        return res;
    }

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorderTraversal(root, res);

        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;

        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }
}
