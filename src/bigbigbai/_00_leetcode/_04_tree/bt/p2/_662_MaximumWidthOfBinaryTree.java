package bigbigbai._00_leetcode._04_tree.bt.p2;

import bigbigbai._00_leetcode._04_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _662_MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        int res = 1;
        int left = 1;
        int right = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();

                if (pair.node.left != null) queue.offer(new Pair<>(pair.node.left, (pair.num << 1)));
                if (pair.node.right != null) queue.offer(new Pair<>(pair.node.right, (pair.num << 1) + 1));

                if (i == 0) left = pair.num;
                if (i == size - 1) right = pair.num;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    // 未完成
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int left = 1;
        int right = 1;
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                // 找到正确left：第一个有左/右子树的


                // 找到正确right：最后一个有左/右子树的

            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    private static class Pair<T, T1> {
        T node;
        T1 num;
        public Pair(T node, T1 num) {
            this.node = node;
            this.num = num;
        }
    }
}
