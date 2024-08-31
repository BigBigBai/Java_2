package bigbigbai._00_leetcode._04_tree.bt.p2;

import bigbigbai._00_leetcode._04_tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _559_MaximumDepthOfNaryTree {
    // 非递归
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            res++;
        }

        return res;
    }

    // 递归
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int res = 0;

        for (Node child : root.children) {
            res = Math.max(res, maxDepth(child));
        }

        return res + 1;
    }
}
