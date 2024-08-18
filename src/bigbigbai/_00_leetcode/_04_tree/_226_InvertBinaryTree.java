package bigbigbai._00_leetcode._04_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _226_InvertBinaryTree {
    // 非递归：层序
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return root;
    }

    // 递归：后序
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        invertTree3(root.left);
        invertTree3(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // 递归：中序
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        invertTree2(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree2(root.left);

        return root;
    }

    // 递归：先序
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;

//        System.out.print(root.val+" ");
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }

}
