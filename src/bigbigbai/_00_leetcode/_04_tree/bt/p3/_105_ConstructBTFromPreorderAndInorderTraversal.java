package bigbigbai._00_leetcode._04_tree.bt.p3;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.Arrays;

public class _105_ConstructBTFromPreorderAndInorderTraversal {
    // 递归
    // HashMap + 不用Arrays.copyOfRange()


    // 递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        // 通过前序确定C
        int size = preorder.length;
        int ele = preorder[0];

        // 通过中序定位C，确定L/R
        int index = findC(inorder, ele);

        // 递归左右子树，return子树的根节点
        TreeNode leftSubTree = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        TreeNode rightSubTree = buildTree(Arrays.copyOfRange(preorder, index+1, size), Arrays.copyOfRange(inorder, index+1, size));

        // 构建BT
        TreeNode root = new TreeNode(ele);
        root.left = leftSubTree;
        root.right = rightSubTree;

        return root;
    }

    private int findC(int[] inorder, int ele) {
        for (int i = 0; i < inorder.length; i++) {
            if (ele == inorder[i]) return i;
        }
        return -1;
    }
}
