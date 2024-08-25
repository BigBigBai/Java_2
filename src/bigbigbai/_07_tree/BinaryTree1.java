package bigbigbai._07_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree1<E> {
    private Node<E> root;

    // 先序递归版本：主人翁心态
    public void preOrderTraversal(Node<E> node) {
        if (node == null) return;

        System.out.print(node.element+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
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

        public Node() {}

        public Node(E element) {
            this.element = element;
        }
    }
}
