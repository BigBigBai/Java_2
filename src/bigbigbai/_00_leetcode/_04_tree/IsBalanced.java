package bigbigbai._00_leetcode._04_tree;

import org.w3c.dom.Node;

public class IsBalanced {

    /**
     * 实体类：domain, pojo (bean) --- Person,Order,Product（实体类） --- table
     * 另一种实体类：dto(data transfer object)
     */

    // 解法2: 递归 + memoization (dto对象)
    private static class ReturnData {
        public boolean isB;
        public int height;

        public ReturnData(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public boolean isBalanced1(TreeNode root) {
        return isB(root).isB;
    }

    private ReturnData isB(TreeNode root) {
        if (root == null) return new ReturnData(true, 0);

        ReturnData leftData = isB(root.left);
        if (!leftData.isB) return new ReturnData(false, 0);

        ReturnData rightData = isB(root.right);
        if (!rightData.isB) return new ReturnData(false, 0);

        if (Math.abs(leftData.height - rightData.height) > 1) return new ReturnData(false, 0);

        return new ReturnData(true, Math.max(leftData.height, rightData.height) + 1);
    }





    // 解法1: 递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return isBalanced(root.left) &&
        isBalanced(root.right) &&
        Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
