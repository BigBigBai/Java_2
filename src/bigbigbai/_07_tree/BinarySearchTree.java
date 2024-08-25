package bigbigbai._07_tree;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BinarySearchTree() {}

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        if (element == null) throw new IllegalArgumentException("element cannot be null!");
        //1.添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //2.添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                node.element = element;
                return;
            }
        }

        //3.把待加入点添加到指定的位置上
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) parent.right = newNode;
        else parent.left = newNode;
        size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) return comparator.compare(e1, e2);
        return ((Comparable<E>)e1).compareTo(e2);
    }

    public void remove(E element) {
        remove(node(element));
    }

    //todo
    private void remove(Node<E> node) {

    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public Node<E> node(E element) {
        Node<E> node = root;

        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                return node;
            }
        }

        return null;
    }
}
