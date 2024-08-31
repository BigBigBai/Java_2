package bigbigbai._00_leetcode._04_tree.bt.p2;

import bigbigbai._00_leetcode._04_tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _590_NaryTreePostorderTraversal {
    // 非递归
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(0, node.val);

            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }

        return res;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        postorder(root, res);

        return res;
    }

    private void postorder(Node root, List<Integer> res) {
        if (root == null) return;

        for (Node child : root.children) {
            postorder(child, res);
        }
        res.add(root.val);
    }
}
