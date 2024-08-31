package bigbigbai._00_leetcode._04_tree.bt.p2;

import bigbigbai._00_leetcode._04_tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _589_NaryTreePreorderTraversal {
    // 非递归
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return res;
    }

    // 递归
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        preorder(root, res);

        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        for (Node child : root.children) {
            preorder(child, res);
        }
    }
}
