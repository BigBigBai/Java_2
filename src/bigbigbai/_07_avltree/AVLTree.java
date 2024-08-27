package bigbigbai._07_avltree;

import org.junit.Test;
import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {

    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    public void afterAdd(Node<E> node) {// Node == AVLNode
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance(node);
                break;
            }
        }
    }

    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();

        if (parent.isLeftChild()) {// L
            if (node.isLeftChild()) {// LL
                rightRotation(grand);
            } else {// LR
                leftRotation(parent);
                rightRotation(grand);
            }
        } else {// R
            if (node.isLeftChild()) {// RL
                rightRotation(parent);
                leftRotation(grand);
            } else {// RR
                leftRotation(grand);
            }
        }
    }

    private void leftRotation(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;// T1
        grand.right = child;
        parent.left = grand;

        afterRotation(grand, parent, child);
    }

    private void rightRotation(Node<E> grand)  {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;// T2
        grand.left = child;
        parent.right = grand;

        afterRotation(grand, parent, child);
    }

    private void afterRotation(Node<E> grand, Node<E> parent, Node<E> child) {
        //update parent of child, p, g
        //1.让parent成为子树的根节点（更新parent的父节点）
        parent.parent = grand.parent;
        if (grand.isLeftChild()) grand.parent.left = parent;
        else if (grand.isRightChild()) grand.parent.right = parent;
        else root = parent;
        //2.更新child的父节点
        if (child != null) child.parent = grand;
        //3.更新grand的父节点
        grand.parent = parent;

        calculateHeight(grand);
        calculateHeight(parent);
    }

    private void calculateHeight(Node<E> node) {// Node == AVLNode
        ((AVLNode<E>) node).calculateHeight();
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }

//    @Test
//    public void test() {
//        Node<Integer> node = new Node<>(10, null);
//
////        ((AVLNode<E>) node).calculateHeight();
//        System.out.println(((AVLNode<E>) node).height);
//    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = this.left == null ? 0 : ((AVLNode<E>) this.left).height;
            int rightHeight = this.right == null ? 0 : ((AVLNode<E>) this.right).height;
            return leftHeight - rightHeight;
        }

        public void calculateHeight() {
            int leftHeight = this.left == null ? 0 : ((AVLNode<E>) this.left).height;
            int rightHeight = this.right == null ? 0 : ((AVLNode<E>) this.right).height;
            height = Math.max(leftHeight, rightHeight) + 1;
        }

        public Node<E> tallerChild() {
            int leftHeight = this.left == null ? 0 : ((AVLNode<E>) this.left).height;
            int rightHeight = this.right == null ? 0 : ((AVLNode<E>) this.right).height;
            if (leftHeight > rightHeight) return this.left;
            if (rightHeight > leftHeight) return this.right;

            if (this.parent == null) return this.left;
            return this == this.parent.left ? this.left : this.right;
        }
    }
}
