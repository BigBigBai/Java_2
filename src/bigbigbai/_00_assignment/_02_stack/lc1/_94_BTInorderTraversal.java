package bigbigbai._00_assignment._02_stack.lc1;

import bigbigbai._00_assignment.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BTInorderTraversal {
    // stack
    // 有左一直压左，没左再压右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                root = stack.pop();
                res.add(root.val);

                root = root.right;
            }
        }

        return res;
    }
}
