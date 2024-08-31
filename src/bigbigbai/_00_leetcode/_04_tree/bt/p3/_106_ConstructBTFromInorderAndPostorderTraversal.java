package bigbigbai._00_leetcode._04_tree.bt.p3;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.Arrays;

public class _106_ConstructBTFromInorderAndPostorderTraversal {
    // 递归
    // HashMap + 不用Arrays.copyOfRange()


    // 递归
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;

        // 通过后序确定C
        int size = postorder.length;
        int ele = postorder[size - 1];

        // 通过中序定位C，确定L/R
        int index = findC(inorder, ele);

        // 递归左右子树，return子树的根节点
        TreeNode leftSubTree = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        TreeNode rightSubTree = buildTree(Arrays.copyOfRange(inorder, index+1, size), Arrays.copyOfRange(postorder, index, size-1));

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
