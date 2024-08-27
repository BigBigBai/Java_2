package bigbigbai._07_avltree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {
    protected int size;
    protected Node<E> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }


    public static abstract class Visitor<E> {
        boolean stop;

        public abstract boolean visit(E element);
    }

    public void preOrderTraversal() {
        preOrderTraversal1(root);
    }

    public void preOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        preOrderTraversal(root, visitor);
    }

    // 先序递归版本：主人翁心态
    public void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;

//        System.out.print(node.element+" ");
        visitor.stop = visitor.visit(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }





    // 先序非递归版本：用栈
    // 有右先压右，有左再压左
    public void preOrderTraversal1(Node<E> node) {
        if (node == null) return;

        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<E> tmp = stack.pop();
            System.out.print(tmp.element+" ");
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
        }
    }

    // 中序递归版本
    public void inOrderTraversal(Node<E> node) {
        if (node == null) return;

        inOrderTraversal(node.left);
        System.out.print(node.element+" ");
        inOrderTraversal(node.right);
    }

    // 中序非递归版本
    // 有左一直压左，否则弹出栈顶元素判断当前节点是否有右，如果有右再压右
    public void inOrderTraversal1(Node<E> node) {
        Stack<Node<E>> stack = new Stack<>();

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                System.out.print(node.element+" ");
                node = node.right;
            }
        }

    }

    // 后序递归版本
    public void postOrderTraversal(Node<E> node) {
        if (node == null) return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.element+" ");
    }

    // 后序非递归版本
    // 1.把先序遍历的顺序调整
    // 2.做个栈，收集结果
    // 3.把结果依次弹出
    public void postOrderTraversal1(Node<E> node) {
        if (node == null) return;

        Stack<Node<E>> res = new Stack<>();

        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> tmp = stack.pop();
            res.push(tmp);
            if (tmp.left != null) stack.push(tmp.left);
            if (tmp.right != null) stack.push(tmp.right);
        }

        while (!res.isEmpty()) {
            System.out.print(res.pop().element+" ");
        }
    }

    // 层序版本
    public void levelOrderTraversal(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<E> tmp = queue.poll();
            System.out.print(tmp.element+" ");
            if (tmp.left != null) queue.offer(tmp.left);
            if (tmp.right != null) queue.offer(tmp.right);
        }
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node() {}

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "element=" + element + ", parent=" + parent;
        }

        protected boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }

        protected boolean isLeafNode() {
            return this.left == null && this.right == null;
        }

        protected boolean isLeftChild() {
            return this.parent != null && this == this.parent.left;
        }

        protected boolean isRightChild() {
            return this.parent != null && this == this.parent.right;
        }
    }

    public int height() {
        return height1(root);
    }

    // 高度：非递归
    public int height1(Node<E> node) {
        if (node == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node<E> tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
        }

        return height;
    }

    // 高度：递归
    public int height(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isCBT() {
        return isCBT(root);
    }

    public boolean isCBT(Node<E> root) {
        if (root == null) return false;
        boolean isLeaf = false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (isLeaf && !(node.left == null && node.right == null)) return false;

            // 1.If node.left!=null && node.right!=null, add node.left and node.right to the queue in sequence
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
            // 2.
            else if (node.right != null) return false;
                // 3.
            else if (node.left != null) {
                queue.offer(node.left);
                isLeaf = true;
            }
            // 4.
            else isLeaf = true;
        }

        return true;
    }

    public Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        // 1. node.left != null
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }

            return p;
        }

        // 2. node.left == null && node.parent != null
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    public Node<E> successor(Node<E> node) {
        if (node == null) return null;

        // 1. node.right != null
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }

            return p;
        }

        // 2. node.right == null && node.parent != null
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }
}
