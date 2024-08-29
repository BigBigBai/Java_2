package bigbigbai._00_leetcode._04_tree.bt;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {

    // 非递归1
    // 有左一直压左，否则弹出栈顶元素判断当前节点是否有右，如果有右再压右
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                else {
                    node = stack.pop();
                    res.add(node.val);
                    node = node.right;
                }
            }
        }

        return res;
    }

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        inorderTraversal(root, res);

        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return;

        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
