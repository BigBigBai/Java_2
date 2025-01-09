package bigbigbai._00_assignment._02_stack.lc1;

import bigbigbai._00_assignment.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _590_NaryTreePostorderTraversal {
    // stack
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(0, node.val);

            for (Node child : node.children) {
                stack.push(child);
            }
        }

        return res;
    }
}
