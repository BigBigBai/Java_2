package bigbigbai._00_leetcode._04_tree.bst;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
 * @BigBigBai
 *
 * Same As LC783
 */
public class _530_MinimumAbsoluteDifferenceInBST {
    // 方法2: 递归 + 中序遍历
    int res;
    int prev;
    public int getMinimumDifference1(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = -1;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);

//        System.out.print(root.val+" ");
        if (prev == -1) {
            prev = root.val;
        }
        else {
            res = Math.min(res, Math.abs(root.val - prev));
            prev = root.val;
        }

        inOrder(root.right);
    }

    // 方法1: 非递归 + 中序遍历
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int res = Integer.MAX_VALUE;
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
                if (prev != null) {
                    res = Math.min(res, Math.abs(root.val - prev.val));
                }

                prev = root;
                root = root.right;
            }
        }

        return res;
    }
}
