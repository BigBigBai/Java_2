package bigbigbai._00_assignment._02_stack.lc1;

import bigbigbai._00_assignment.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_BTPostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(0, root.val);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);

        }

        return res;
    }
}
