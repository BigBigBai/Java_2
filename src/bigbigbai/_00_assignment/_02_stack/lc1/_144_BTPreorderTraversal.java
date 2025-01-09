package bigbigbai._00_assignment._02_stack.lc1;

import bigbigbai._00_assignment.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BTPreorderTraversal {
    // stack
    // 有右先压右，有左再压左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }

        return res;
    }
}
