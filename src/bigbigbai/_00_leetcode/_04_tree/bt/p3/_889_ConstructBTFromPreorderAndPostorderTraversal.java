package bigbigbai._00_leetcode._04_tree.bt.p3;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.Arrays;

public class _889_ConstructBTFromPreorderAndPostorderTraversal {
    // 递归
    // HashMap + 不用Arrays.copyOfRange()

    // 递归
    public TreeNode constructFromPrePost(int[] preorder, int[]postorder) {
        if (postorder.length == 0) return null;
        if (postorder.length == 1) return new TreeNode(postorder[0]);

        // 通过后序确定C
        int size = postorder.length;
        int ele = postorder[size - 1];
        int tmp = postorder[size - 2];

        // 通过前序定位C，确定L/R
        int index = findIndex(preorder, tmp);

        // 递归左右子树，return子树的根节点
        TreeNode leftSubTree = constructFromPrePost(Arrays.copyOfRange(preorder, 1, index), Arrays.copyOfRange(postorder, 0, index-1));
        TreeNode rightSubTree = constructFromPrePost(Arrays.copyOfRange(preorder, index, size), Arrays.copyOfRange(postorder, index-1, size-1));

        // 构建BT
        TreeNode root = new TreeNode(ele);
        root.left = leftSubTree;
        root.right = rightSubTree;

        return root;
    }

    private int findIndex(int[] preorder, int tmp) {
        for (int i = 0; i < preorder.length; i++) {
            if (tmp == preorder[i]) return i;
        }
        return -1;
    }
}
